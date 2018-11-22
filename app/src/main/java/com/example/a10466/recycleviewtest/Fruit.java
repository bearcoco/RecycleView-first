package com.example.a10466.recycleviewtest;

/**
 * Created by 10466 on 2018/11/17.
 */

public class Fruit {
    private String name ;
    private int imageId;
    public Fruit(String name, int imageId){
        this.name=name;
        this.imageId=imageId;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }
}
