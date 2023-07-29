package com.example.laneclosurereporting.object;

public class ItemData {
    private String name;
    private int imageSrc;

    public ItemData(String name, int imageSrc) {
        this.name = name;
        this.imageSrc = imageSrc;
    }

    public String getName() {
        return name;
    }

    public int getImageSrc() {
        return imageSrc;
    }
}
