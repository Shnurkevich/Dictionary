package com.jwd.service;

import com.jwd.entity.WordSet;

import java.util.HashMap;

public interface Dictionary {

        String enRuTranslate(HashMap<String, String> storage, WordSet wordSet);     //Перевести с английского на русский
        String ruEnTranslate(HashMap<String, String> storage, WordSet wordSet);     //Перевести с русского на английский
        void veiwAllWords(HashMap<String, String> storage);                         //Посмотреть все слова в словаре
        int viewCountOfWords(HashMap<String, String> storage);                      //Посмотреть количество слов в словаре
        void addPairOfWords(HashMap<String, String> storage, WordSet wordSet);      //Добавить пару слов в словарь
        void initializeDictionary();                                                //Заполняем словарь некоторыми значениями

}
