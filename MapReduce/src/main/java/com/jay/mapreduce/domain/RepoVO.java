package com.jay.mapreduce.domain;

/**
 * Created by jay on 2017. 3. 29..
 */
public class RepoVO {
    private String name;
    private int stars;

    public RepoVO(String name, int stars) {
        this.name = name;
        this.stars = stars;
    }

    @Override
    public String toString() {
        return "RepoVO{" +
                "name='" + name + '\'' +
                ", stars=" + stars +
                '}';
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
