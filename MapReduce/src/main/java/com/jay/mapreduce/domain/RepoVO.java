package com.jay.mapreduce.domain;

/**
 * Created by jay on 2017. 3. 29..
 */
public class RepoVO {
    private String name;
    private int stars;
    private int fork;
    private int watches;

    public RepoVO(String name, int stars, int fork, int watches) {
        this.name = name;
        this.stars = stars;
        this.fork = fork;
        this.watches = watches;
    }

    @Override
    public String toString() {
        return "RepoVO{" +
                "name='" + name + '\'' +
                ", stars=" + stars +
                ", fork=" + fork +
                ", watches=" + watches +
                '}';
    }

    public int getFork() {
        return fork;
    }

    public void setFork(int fork) {
        this.fork = fork;
    }

    public int getWatches() {
        return watches;
    }

    public void setWatches(int watches) {
        this.watches = watches;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}
