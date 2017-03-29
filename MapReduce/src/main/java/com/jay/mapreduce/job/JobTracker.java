package com.jay.mapreduce.job;

import org.json.JSONObject;

/**
 * Created by jay on 2017. 3. 29..
 */
public class JobTracker extends Thread {

    private Object[] works;

    public JobTracker(Object[] works) {
        this.works = works;
    }

    @Override
    public void run() {
        int leng = works.length;

        for(int i = 0 ;i < 5; i++){

            JobPool.executorService.submit(()->{
                JSONObject json = new JSONObject();
            });
        }



    }

    public Object[] getWorks() {
        return works;
    }
}
