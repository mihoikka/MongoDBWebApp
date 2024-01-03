package com.example.demo.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;

@Document
public class Character {
    @Id
    private CharacterId charId;
    private String firstName;
    private String lastName;
    private String name;
    private String Ability;
    private String role;
    private String description;
    private int curr_time;
    private String[] items;
    private String[] relations;

    public Character(CharacterId charId, String Ability, String role, String description, String[] items, String[] relations){
        super();
        this.charId = charId;
        this.firstName = charId.getfirstName();
        this.lastName = charId.getlastName();
        this.name = firstName + " " + lastName;
        this.Ability = Ability;
        this.role = role;
        this.description = description;
        this.curr_time = charId.getCurr_time();
        this.items = items;
        this.relations = relations;
    }
    public String toString(){
        return "First Name: " + firstName + "\n"  +
                "Last Name: " + lastName + "\n"  +
                "Ability: " + Ability + "\n" +
                "Role: " + role + "\n" +
                "Description: " + description + "\n" +
                "Current Time: " + Integer.toString(curr_time) + "\n" +
                "Items: " + Arrays.toString(items) + "\n" +
                "Relations: " + Arrays.toString(relations);
    }
    //  Getters and Setters
    public String getName(){
        return name;
    }
    public String getfirstName(){
        return firstName;
    }
    public void setfirstName(String last){
        this.firstName = firstName;
        // update name variable as well with new firstname
        this.name = firstName + " " + lastName;
    }
    public String getlastName(){
        return lastName;
    }
    public void setlastName(String lastName){
        this.lastName = lastName;
        // update name variable as well with new lastname
        this.name = firstName + " " + lastName;
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
