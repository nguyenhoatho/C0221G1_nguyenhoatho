package excercise2.model.service.impl;

import excercise2.model.repository.TranslateRepo;
import excercise2.model.service.ITranslate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class TranslateService implements ITranslate {
    @Autowired
    private TranslateRepo translateRepo;
    @Override
    public String translate(String word) {
        return translateRepo.translateWord(word);
    }
}
