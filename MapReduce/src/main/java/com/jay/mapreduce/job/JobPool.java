package com.jay.mapreduce.job;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jay on 2017. 3. 29..
 */
public class JobPool {

    public static ExecutorService executorService = Executors.newFixedThreadPool(5);




}
