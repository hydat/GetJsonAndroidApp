package com.example.json;

import java.io.Serializable;
import java.util.List;

public class AllJsonData implements Serializable {
    private String name;
    private List<ListImage> images;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ListImage> getImages() {
        return images;
    }

    public void setImages(List<ListImage> images) {
        this.images = images;
    }
}
