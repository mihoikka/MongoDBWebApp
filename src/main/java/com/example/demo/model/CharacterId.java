package com.example.demo.model;

public class CharacterId{
    private String name;
    private int curr_time;
    public  CharacterId(String name, int curr_time){
        this.name = name;
        this.curr_time = curr_time;
    }
    public String getName(){
        return name;
    }
    public int getCurr_time(){
        return curr_time;
    }
}
