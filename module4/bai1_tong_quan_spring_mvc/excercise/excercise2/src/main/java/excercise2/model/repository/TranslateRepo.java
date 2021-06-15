package excercise2.model.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class TranslateRepo {
   static Map<String,String> translate;
    static {
        translate=new HashMap<>();
        translate.put("go","di");
        translate.put("name","ten");
        translate.put("class","lop");
    }
    public String translateWord(String word){
        return translate.get(word);
    }
}
