package com.jay.mapreduce.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jay.mapreduce.domain.RepoVO;
import com.jay.mapreduce.domain.LangVO;


import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by jay on 2017. 3. 29..
 */
public class DataRender {
    private static Gson gson = new GsonBuilder().create();

    private static Logger logger = LoggerFactory.getLogger(DataRender.class);

    public static Object[] getRepoList(Object[] input){
        int i = 0;
        Object[] ret = new Object[input.length];

        for(Object obj : input){
            JSONObject jsonObject = new JSONObject(gson.toJson(obj));
            ret[i++] = (Object) new RepoVO(jsonObject.getString("name"),jsonObject.getInt("stargazers_count"));
        }
        return ret;

    }


    public static Object[] getPieChart(Object[] input){
        int i = 0 ;
        Object[] ret = new Object[input.length];

        for(Object obj : input){
            JSONObject jsonObject = new JSONObject(gson.toJson(obj));
            String name = jsonObject.getString("name");
            String language = (jsonObject.has("language") ? jsonObject.getString("language") : "empty");
            ret[i++] = (Object) new LangVO(name, language);
        }

        return ret;
    }

}
