package excercise2.model.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class TranslateRepo {
   static Map<String,String> translate;
    static {
        translate=new HashMap<>();
        translate.put("go","đi");
        translate.put("name","tên");
        translate.put("class","lớp");
    }
    public String translateWord(String word){
        return translate.get(word);
    }
}
