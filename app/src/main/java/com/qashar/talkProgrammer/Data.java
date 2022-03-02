package com.qashar.talkProgrammer;

public class Data {

    private Integer title,text;

    public Data(Integer title, Integer text) {
        this.title = title;
        this.text = text;
    }

    public Integer getText() {
        return text;
    }

    public Integer getTitle() {
        return title;
    }
}
