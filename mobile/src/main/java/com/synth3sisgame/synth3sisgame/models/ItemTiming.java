package com.synth3sisgame.synth3sisgame.models;

public class ItemTiming {
    private String name;
    private String time;

    public ItemTiming(String n, String t) {
        name = n;
        time = t;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
