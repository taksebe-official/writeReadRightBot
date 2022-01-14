package ru.taksebe.telegram.writeRead.api.dictionaries;

import org.springframework.stereotype.Component;
import ru.taksebe.telegram.writeRead.model.Dictionary;
import ru.taksebe.telegram.writeRead.model.Word;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class WordService {

    public List<Word> getDictionariesWordList(List<Dictionary> dictionaryList) {
        Set<Word> allWordSet = new HashSet<>();
        for (Dictionary dictionary : dictionaryList) {
            allWordSet.addAll(dictionary.getWordList());
        }
        return new ArrayList<>(allWordSet);
    }
}