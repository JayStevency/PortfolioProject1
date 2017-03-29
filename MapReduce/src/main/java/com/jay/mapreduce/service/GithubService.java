package com.jay.mapreduce.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jay.mapreduce.domain.PieVO;
import com.jay.mapreduce.util.DataRender;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.jay.mapreduce.job.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jay on 2017. 3. 29..
 */
@Service
public class GithubService {

    private Object[] objects;

    public GithubService(Object[] objects) {
        this.objects = objects;
    }

    public void setObjects(Object[] objects) {
        this.objects = objects;
    }

    public Object[] getRepoListData(){

         /*
        JobTracker jobTracker = new JobTracker(input);

        while(jobTracker.getState() == Thread.State.RUNNABLE){
            jobTracker.run();
        }

        return jobTracker.getWorks();
        */

        return DataRender.getRepoList(objects);
    }



    public Object[] getPieChartData(){
        Object[] result = DataRender.getPieChart(objects);
        Map<String, Integer> list = new HashMap<>();
        Gson gson = new GsonBuilder().create();

        for(Object obj : result){
            JSONObject jsonObject = new JSONObject(gson.toJson(obj));
            String key = jsonObject.getString("language");
            if(key.equals("empty")) continue;

            if(!list.containsKey(key)){
                list.put(key, 1);
            }else{
                list.compute(key, (k,v)->
                    v = Integer.sum(v.intValue(), 1)
                );
            }
        }

        List<PieVO> resList = new ArrayList<>();
        Object[] ret = new Object[list.size()];
        list.forEach((k,v)->{
            resList.add(new PieVO(k,v));
        });
        int i = 0;
        for(PieVO pieVO : resList){
            ret[i++] = (Object) pieVO;
        }
        return ret;
    }

}
