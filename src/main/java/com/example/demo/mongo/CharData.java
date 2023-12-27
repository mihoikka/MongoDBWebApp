package com.example.demo.mongo;
import com.example.demo.user.Character;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


//spring.data.mongodb.host=localhost
//spring.data.mongodb.port=27017
//spring.data.mongodb.database=userDatabase

public interface CharData{

    Character findCharacterByName(String name);
    int updateCharacterByName(String name,String Ability,String role,String description,int curr_time,String[] items,String[] relations);

    List<Character> GetCharactersByTime(int time);

    List<Character> getAll();

    //List<Character> find(String category);

    /*public long count();

    public Character insert(Character character);

    public Character save(Character character);

    public List<Character> findByName(String name);*/
}