package com.jay.mapreduce.controller;

import com.jay.mapreduce.service.GithubService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by jay on 2017. 3. 27..
 */

@RestController
@RequestMapping(value = "github")
public class GithubController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private String uri = "https://api.github.com/users/";

    private GithubService githubService;


    @RequestMapping(value = "{search}")
    @ResponseBody
    public Object[] getGitData(@PathVariable("search") String data){
        logger.info("Search Data : {}", data);
        RestTemplate restTemplate = new RestTemplate();
        logger.info("URI : {}", uri+data+"/repos");
        ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity(uri+data+"/repos", Object[].class);

        if(githubService == null)
            githubService = new GithubService(responseEntity.getBody());
        else{
            githubService.setObjects(responseEntity.getBody());
        }

        Object[] ret = new Object[3];

        ret[0] = githubService.getUserData();
        ret[1] = githubService.getRepoListData();
        ret[2] = githubService.getPieChartData();
        logger.info("Search Result : {}", ret.toString());
        return ret;
    }
}
