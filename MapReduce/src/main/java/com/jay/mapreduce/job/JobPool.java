package com.jay.mapreduce.job;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jay on 2017. 3. 29..
 */
public class JobPool {
    public ExecutorService mapExcutorService;
    public ExecutorService reduceExcutorService;

    public JobPool() {
        mapExcutorService = Executors.newFixedThreadPool(5);
        reduceExcutorService = Executors.newSingleThreadExecutor();
    }
}
