package com.epam.task3.bean;

import java.io.Serializable;

/**
 * javabean for New entities.
 */
public class News implements Serializable{

    private Category category;
    private String itemName;
    private String itemTitle;

    public News() {
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    @Override
    public String toString() {
        return "News{" +
                "category=" + category +
                ", itemName='" + itemName + '\'' +
                ", itemTitle='" + itemTitle + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        News news = (News) o;

        if (category != news.category) return false;
        if (itemName != null ? !itemName.equals(news.itemName) : news.itemName != null) return false;
        return itemTitle != null ? itemTitle.equals(news.itemTitle) : news.itemTitle == null;

    }

    @Override
    public int hashCode() {
        int result = category != null ? category.hashCode() : 0;
        result = 31 * result + (itemName != null ? itemName.hashCode() : 0);
        result = 31 * result + (itemTitle != null ? itemTitle.hashCode() : 0);
        return result;
    }
}
