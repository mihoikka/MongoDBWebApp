package com.example.demo.user;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;

@Document
public class Character {
    @Id
    private String name;
    private String Ability;
    private String role;
    private String description;
    private int curr_time;
    private String[] items;
    private String[] relations;

    public Character(String name, String Ability, String role, String description, int curr_time, String[] items, String[] relations){
        super();
        this.name = name;
        this.Ability = Ability;
        this.role = role;
        this.description = description;
        this.curr_time = curr_time;
        this.items = items;
        this.relations = relations;
    }
    public String toString(){
        return "Name: " + name + "\n"  +
                "Ability: " + Ability + "\n" +
                "Role: " + role + "\n" +
                "Description: " + description + "\n" +
                "Current Time: " + Integer.toString(curr_time) + "\n" +
                "Items: " + Arrays.toString(items) + "\n" +
                "Relations: " + Arrays.toString(relations);
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getAbility(){
        return Ability;
    }
    public void setAbility(String Ability){
        this.Ability = Ability;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCurr_time() {
        return curr_time;
    }

    public void setCurr_time(int curr_time) {
        this.curr_time = curr_time;
    }

    public String[] getItems() {
        return items;
    }

    public void setItems(String[] items) {
        this.items = items;
    }

    public String[] getRelations() {
        return relations;
    }

    public void setRelations(String[] relations) {
        this.relations = relations;
    }
}
