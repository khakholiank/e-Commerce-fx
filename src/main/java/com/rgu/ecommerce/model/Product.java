
package com.rgu.ecommerce.model;

/**
 *
 * @author Nikit Khakholia
 */
public class Product {
    private int id;
    private String nameOfItem;
    private String description;
    private String tags;
    private int imgMediaId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfItem() {
        return nameOfItem;
    }

    public void setNameOfItem(String nameOfItem) {
        this.nameOfItem = nameOfItem;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public int getImgMediaId() {
        return imgMediaId;
    }

    public void setImgMediaId(int imgMediaId) {
        this.imgMediaId = imgMediaId;
    }

    @Override
    public String toString() {
        return getNameOfItem(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}
