package com.test.model;

import org.springframework.beans.factory.annotation.Autowired;

public class BingoEntity {

    @Autowired
    private String word;

    @Autowired
    private boolean checked;

    public BingoEntity(String word){
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
