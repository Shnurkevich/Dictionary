package com.alex.jwd.service.impl;

import rep.dao.DictionaryStorage;
import rep.dao.impl.DictionaryStorageImpl;
import rep.entity.WordSet;
import com.alex.jwd.service.Dictionary;

import java.util.HashMap;
import java.util.Map;

public class DictionaryImpl implements Dictionary {

    private DictionaryStorage storage = new DictionaryStorageImpl();

    public HashMap<String, String> getStorage() {
        return storage.getDictionary();
    }

    @Override
    public String enRuTranslate(HashMap<String, String> storage, WordSet wordSet) {
        if(storage.containsKey(wordSet.getEnWord())){
            return storage.get(wordSet.getEnWord());
        }
       else
           return "Нет такого английского слова в словаре";
    }

    @Override
    public String ruEnTranslate(HashMap<String, String> storage, WordSet wordSet) {
        for (Map.Entry<String, String> entry : storage.entrySet()) {
            if (entry.getValue().equals(wordSet.getRuWord())) {
                return entry.getKey();
            }
        }
        return "В словаре нет такого слова";
    }

    @Override
    public void addPairOfWords(HashMap<String, String> storage, WordSet wordSet) {
        storage.put(wordSet.getEnWord(), wordSet.getRuWord());
    }

    @Override
    public void veiwAllWords(HashMap<String, String> storage) {
        for (Map.Entry entry : storage.entrySet()) {
            System.out.println("[" + entry.getKey() + "] - перевод [" + entry.getValue() + "]");
        }
    }

    @Override
    public int viewCountOfWords(HashMap<String, String> storage) {
        return storage.size();
    }

    @Override
    public void initializeDictionary() {
        storage.getDictionary().put("wasted", "потрачено");
        storage.getDictionary().put("tree", "дерево");
        storage.getDictionary().put("house", "дом");
        storage.getDictionary().put("bird", "птица");
        storage.getDictionary().put("java", "джава");
        storage.getDictionary().put("laptop", "ноутбук");
        storage.getDictionary().put("light", "свет");
        storage.getDictionary().put("chair", "кресло");
        storage.getDictionary().put("smile", "улыбка");
        storage.getDictionary().put("car", "машина");
        storage.getDictionary().put("mouse", "мышь");
        storage.getDictionary().put("cat", "кот");

    }

}
