package com.synth3sisgame.synth3sisgame.utils;

import com.synth3sisgame.synth3sisgame.models.ItemTiming;

import java.util.ArrayList;
import java.util.List;

import top.defaults.view.PickerView;

public class Item implements PickerView.PickerItem {

    private String text;
    private String fullText;

    public Item(String s, String ft) {
        text = s;
        fullText = ft;
    }

    @Override
    public String getText() {
        return text;
    }
    public String getFullText() {
        return fullText;
    }

    public static List<Item> sampleItems() {
        List<Item> items = new ArrayList<>();
        for (int i = 1; i < 11; i++) {
            items.add(new Item(i+" random bell per hour", ""+i));
        }
        return items;
    }

    public static List<Item> freequancyItem() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Low", "1"));
        items.add(new Item("Normal", "2"));
        items.add(new Item("Medium", "3"));
        items.add(new Item("High", "4"));
        items.add(new Item("Ultra High", "5"));
        return items;
    }

    public static List<Item> timing() {
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            items.add(new Item(""+i, ""));
        }
        return items;
    }

    public static List<Item> mins() {
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < 60; i=i+5) {
            items.add(new Item(""+i, ""));
        }
        return items;
    }
}
