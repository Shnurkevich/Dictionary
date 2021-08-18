package com.alex.jwd.entity;

public class WordSet {
    private String enWord;
    private String ruWord;

    public WordSet() {
    }


    public WordSet(String enWord, String ruWord) {
        this.enWord = enWord;
        this.ruWord = ruWord;
    }


    public String getEnWord() {
        return enWord;
    }

    public String getRuWord() {
        return ruWord;
    }

    public void setEnWord(String enWord) {
        this.enWord = enWord;
    }

    public void setRuWord(String ruWord) {
        this.ruWord = ruWord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WordSet wordSet = (WordSet) o;

        if (enWord != null ? !enWord.equals(wordSet.enWord) : wordSet.enWord != null) return false;
        return ruWord != null ? ruWord.equals(wordSet.ruWord) : wordSet.ruWord == null;
    }

    @Override
    public int hashCode() {
        int result = enWord != null ? enWord.hashCode() : 0;
        result = 31 * result + (ruWord != null ? ruWord.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "WordSet{" +
                "enWord='" + enWord + '\'' +
                ", ruWord='" + ruWord + '\'' +
                '}';
    }
}
