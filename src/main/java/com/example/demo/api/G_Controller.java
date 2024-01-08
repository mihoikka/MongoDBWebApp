package com.example.demo.api;

import com.example.demo.mongo.GdataRepository;
import com.example.demo.model.Character;
//import jakarta.validation.Valid;
import com.mongodb.DuplicateKeyException;
import com.mongodb.MongoWriteException;
import com.mongodb.WriteError;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "http://localhost:8081")
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class G_Controller {

    @Autowired
    @Qualifier("MongoDB_Requests")
    GdataRepository g_repo;

    @GetMapping("/character")
    public List<Character> GetCharacters(){
        return g_repo.findAll();
    }

    @GetMapping("/character/time/{time}")
    public List<Character> AllCharactersAtTime(@PathVariable String time){
        int time_int = Integer.parseInt(time);
        return g_repo.GetCharactersByTime(time_int);
    }

    @GetMapping("/character/{name}")
    public List<Character> GetCharacter(@PathVariable String name){
        return g_repo.findCharacterByName(name);
    }

    @PostMapping("/character/new")
    public void NewCharacter(@RequestBody Character character){

        List<Character> chars = g_repo.findByName(character.getName());
        if (chars.isEmpty()){
            g_repo.insert(character);
        }
    }

    // Careful with this one, it nukes the database
    @DeleteMapping("/character/delete")
    public void deleteAllChars(){ g_repo.deleteAll();}

    @DeleteMapping("/character/delete/{name}")
    public void deleteNamedChar(@PathVariable String name){
        List<Character> chars = g_repo.findByName(name);
        if (!chars.isEmpty()) {
            g_repo.deleteAll(chars);
        }
        else{
            //TODO send warning about failed delete of non-existent character
            //informOfCharacterDeletionFailure()
        }
    }

    @PostMapping("/character/update")
    public Optional<List<Character>> Update_Character(@RequestBody Character character){

        List<Character> chars = g_repo.findByName(character.getName());
        if (chars.isEmpty()){
            NewCharacter(character);
        }
        else{
            g_repo.save(character);
        }

        return Optional.ofNullable(chars);
    }

    // This is a copy of the other Update Character method, used when the character's name is included in the URL
    @PostMapping("/character/update/{name}")
    public Optional<List<Character>> Update_Character(@RequestBody Character character, @PathVariable String name){


        List<Character> chars = g_repo.findByName(name);
        if (chars.isEmpty()){
            NewCharacter(character);
        }else{
            g_repo.save(character);
        }

        return Optional.ofNullable(chars);
    }
}
