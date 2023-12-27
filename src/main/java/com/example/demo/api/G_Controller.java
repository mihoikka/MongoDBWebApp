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

//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class G_Controller {

    @Autowired
    @Qualifier("MongoDB_Requests")
    GdataRepository g_repo;

    /*@GetMapping("/character")
    public List<Character> GetCharacters(){
        return g_repo.getAll();
    }*/
    @GetMapping("/character/time/{time}")
    public List<Character> AllCharactersAtTime(@PathVariable String time){
        int time_int = Integer.parseInt(time);
        return g_repo.GetCharactersByTime(time_int);
    }

    @GetMapping("/character/{name}")
    public Character GetCharacter(@PathVariable String name){
        return g_repo.findCharacterByName(name);
    }

    @PostMapping("/character/new")
    public void NewCharacter(@RequestBody Character character){
        g_repo.insert(character);
    }

    @PutMapping("/character/update")
    public Optional<List<Character>> Update_Character(Character character){
        g_repo.save(character);

        List<Character> chars = g_repo.findByName(character.getName());

        return Optional.ofNullable(chars);
    }
}
