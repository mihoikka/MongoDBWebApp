package com.example.demo.mongo;
import com.example.demo.model.Character;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


//spring.data.mongodb.host=localhost
//spring.data.mongodb.port=27017
//spring.data.mongodb.database=userDatabase

@Repository("MongoDB_Requests")
public interface GdataRepository extends MongoRepository<Character, String>{ //, CharData
    @Query("{name:'?0'}")
    Character findCharacterByName(String name);

    @Query(value = "{curr_time: ?0}", fields = "{'name':1, 'curr_time':1}") //TODO make this a time range
    List<Character> GetCharactersByTime(int time);

    /*
    @Query("{'name':?0}")
    @Update("{'name':?0, '$set':DOCUMENT LOGIC}")
    int updateCharacterByName(String name,String Ability,String role,String description,int curr_time,String[] items,String[] relations){

    }*/
    //@Query(value="{Ability:'?0'}", fields="{'name' : 1, 'quantity' : 1}")

//    /*@NotNull
//    List<Character> findAll(Example<Character> chars); //find(String Ability);*/

    /*public long count();

    @Override
    @NonNull
    @SuppressWarnings("unchecked")
    public <Character extends T> Character insert(@NonNull Character character);

    @Override
    @NonNull
    @SuppressWarnings("unchecked")
    public <Character extends T>  Character save(@NonNull Character character);*/


    public List<Character> findByName(String name);

}
