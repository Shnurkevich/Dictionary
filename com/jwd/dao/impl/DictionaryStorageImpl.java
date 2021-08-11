package com.jwd.dao.impl;

import com.jwd.dao.DictionaryStorage;

import java.util.Arrays;
import java.util.HashMap;

public class DictionaryStorageImpl implements DictionaryStorage {

    private HashMap<String, String> dictionary = new HashMap<>();


    @Override
    public HashMap<String, String> getDictionary() {
        return dictionary;
    }


}
