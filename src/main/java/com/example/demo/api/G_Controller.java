package com.example.demo.api;
import com.example.demo.mongo.CharData;

import com.example.demo.mongo.GdataRepository;
import com.example.demo.user.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class G_Controller {

    @Autowired
    @Qualifier("MongoDB_Requests")
    CharData g_repo;

    @GetMapping("/character")
    public List<Character> GetCharacters(){
        return g_repo.getAll();
    }
    @GetMapping("/character/{time}")
    public List<Character> AllCharactersAtTime(int time){
        return g_repo.GetCharactersByTime(time);
    }

    @GetMapping("/character/{name}")
    public Character GetCharacter(String name){
        return g_repo.findCharacterByName(name);
    }

    @PostMapping("/character/new")
    public void NewCharacter(Character character){
        g_repo.insert(character);
    }

    @PutMapping("/character/update")
    public Optional<List<Character>> Update_Character(Character character){
        g_repo.save(character);

        /*BasicQuery query = new BasicQuery();
        query.addCriteria(Criteria.where("name").is(character.getName()));
        List<Character> chars = g_repo.findByName(query, Character.class);*/

        List<Character> chars = g_repo.findByName(character.getName());

        return Optional.ofNullable(chars);
    }
}
