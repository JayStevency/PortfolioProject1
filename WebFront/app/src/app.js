/**
 * Created by jay on 2016. 12. 30..
 */

function bar_chart_render(x) {
    var ret = [];
    var title = ['x'];
    var val = ['Star'];


    for(var i = 0; i < x.length; i++){
        if(x[i].stars > 0){
            title.push(x[i].name);
            val.push(x[i].stars);
        }
    }
    ret.push(title);
    ret.push(val);

    console.log('bar_char_data', ret);
    return ret;
}

function pie_chart_render(x) {
    var ret = [];
    for(var i = 0; i < x.length; i++){
        var tmp = [];
        tmp.push(x[i].language);
        tmp.push(x[i].frequency);
        ret.push(tmp);
    }

    console.log('pie_chart_data',ret);
    return ret;
}


var myApp = angular.module('myApp',['ngRoute'])
    .run(function ($rootScope) {
      $rootScope.GitHubID = {};
      $rootScope.repoList = [];
      $rootScope.barchartData = [];
      $rootScope.piechartData = [];
    })
    .config(function($routeProvider, $locationProvider, $provide) {
        $locationProvider.html5Mode(true)
        $routeProvider
            .when('/search',{
                templateUrl : "search/search.html",
                controller : "searchCtrl"
            })
    })
    .controller('searchCtrl', function($rootScope, $scope,$http,$location) {
        $scope.submitTheForm = function(id) {
            console.log(id);
            $location.path('/search');
            $http({
                url: 'http://localhost:8080/search',
                method: "GET",
                params : {search : id}
            }).then(function successCallback(response) {
                // this callback will be called asynchronously
                // when the response is available

                var result = response.data;
                $rootScope.GitHubID = id;
                $rootScope.repoList = result[0];
                var barChart = bar_chart_render(result[0]);
                var pieChart = pie_chart_render(result[1]);
                $rootScope.barchartData = barChart;
                $rootScope.piechartData = pieChart;

            }, function errorCallback(response) {
                // called asynchronously if an error occurs
                // or server returns response with an error status.
                console.log(response.status);
                console.log(response.data);
            });
        }
        })
    .controller('chartCtrl',function ($rootScope,$scope) {
        $scope.drawChart = function(){
            var chart = c3.generate({
                bindto:'#chart',
                data : {
                    x : 'x',
                    columns :
                        $rootScope.barchartData,
                    type : 'bar'
                },
                axis:{
                    x: {
                        type: 'category'
                    }
                }
            });
            console.log('chart.elemtne',chart.element);
            $('#chart').append(chart.element);

            var pie = c3.generate({
                bindto : '#pie',
                data :{
                    columns :
                        $rootScope.piechartData,
                    type :'pie'
                }
            });
            console.log('pie.element',pie.element);
            $('#pie').append(pie.element);
        }
    });
