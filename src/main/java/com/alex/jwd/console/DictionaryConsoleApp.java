package com.alex.jwd.console;

import rep.entity.WordSet;
import rep.service.impl.DictionaryImpl;

import java.util.HashMap;
import java.util.Scanner;

public class DictionaryConsoleApp {

    private final Scanner scanner = new Scanner(System.in);
    private final DictionaryImpl dictionary = new DictionaryImpl();
    private final HashMap<String, String> storage = dictionary.getStorage();

    public static final String WELCOME_MESSAGE = "Press:" +
            "\n 0 - Выход" +
            "\n 1 - Перевод с английского на русский" +
            "\n 2 - Перевод с русского на английский" +
            "\n 3 - Добавить слово+перевод в словарь" +
            "\n 4 - Узнать количество пар слов в словаре" +
            "\n 5 - Показать все пары слов в словаре";

    public static final int EXIT = 0, EN_RU = 1, RU_EN = 2, ADD_WORD = 3, COUNT_OF_WORDS = 4,
            VIEW_WORDS = 5, RESTART_VALUE = 999;
    public static final String DELIMITER = "\n==============================================\n";

    public void start(){
        dictionary.initializeDictionary();

        boolean isRunning = true;
        while (isRunning) {
            printConsole(WELCOME_MESSAGE);
            printConsole(DELIMITER);
            int consoleChoice = getConsoleChoice();
            switch (consoleChoice) {
                case EXIT:
                    isRunning = false;
                    printConsole("Приложение закрывается.");
                    break;
                case EN_RU:
                    findEnRuTranslate();
                    break;
                case RU_EN:
                    findRuEnTranslate();
                    break;
                case ADD_WORD:
                    addWordsToDictionary();
                    break;
                case COUNT_OF_WORDS:
                    findCountOfWords();
                    break;
                case VIEW_WORDS:
                    showAllPairsOfWords();
                    break;
                default:
                    printConsole("Неверный ввод" + DELIMITER);
            }
        }
    }


    private void findEnRuTranslate(){
        printConsole("Вы выбрали перевод с английского на русский.");
        WordSet wordSet = prepareEngWord();
        printConsole("Результат перевода - [" +
                dictionary.enRuTranslate(storage, prepareEngWord()) +
                "]." + DELIMITER);
    }

    private void findRuEnTranslate(){
        printConsole("Вы выбрали перевод с русского на английский.");
        WordSet wordSet = prepareRuWord();
        printConsole("Результат перевода - [" +
                dictionary.ruEnTranslate(storage, prepareRuWord()) +
                "]." + DELIMITER);
    }
    private void addWordsToDictionary(){
        printConsole("Вы выбрали добавление в словарь");
        WordSet wordSet = prepareWordsToAdd();
        dictionary.addPairOfWords(storage, wordSet);
        printConsole("Слова добавлены" + DELIMITER);
    }

    private void findCountOfWords(){
        int count;
        count = dictionary.viewCountOfWords(storage);
        printConsole("Количество пар слов в словаре равняется [" + count +"]" + DELIMITER);
    }


    private void showAllPairsOfWords(){
        dictionary.veiwAllWords(storage);
    }

    private WordSet prepareWordsToAdd(){
        Scanner sc = new Scanner(System.in);
        printConsole("Введите слово на английском");
        String enWord = sc.nextLine();
        printConsole("Введите слово на русском");
        String ruWord = sc.nextLine();
        return new WordSet(enWord, ruWord);
    }


    private WordSet prepareEngWord(){
        printConsole("Введите слово");
        String word = scanner.nextLine();
        WordSet wordSet = new WordSet();
        wordSet.setEnWord(word);
        return wordSet;
    }


    private WordSet prepareRuWord(){
        printConsole("Введите слово");
        String word = scanner.nextLine();
        WordSet wordSet = new WordSet();
        wordSet.setRuWord(word);
        return wordSet;
    }


    private int getConsoleChoice() {
        int choice;
        if (scanner.hasNextInt()) {
            choice = scanner.nextInt();
        } else {
            choice = RESTART_VALUE;
        }
        return choice;
    }

    private void printConsole(String message) {
        System.out.println(message);
    }

}
