package com.example.demo.model;

public class CharacterId{
    private String firstName;
    private String lastName;
    private int curr_time;
    public  CharacterId(String firstName, String lastName, int curr_time){
        this.firstName = firstName;
        this.lastName = lastName;
        this.curr_time = curr_time;
    }
    public String getfirstName(){
        return firstName;
    }
    public String getlastName(){
        return lastName;
    }
    public int getCurr_time(){
        return curr_time;
    }
}
