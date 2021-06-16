package excercise1.model.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class SpiceRepo {
    static List<String> spice;
    static {
        spice=new ArrayList<>();
        spice.add("lettuce");
        spice.add("tomato");
        spice.add("mustard");
        spice.add("sprouts");
    }
    public List<String> getAll(){
        List<String> stringList=new ArrayList<>();
        return stringList=spice;
    }


}
