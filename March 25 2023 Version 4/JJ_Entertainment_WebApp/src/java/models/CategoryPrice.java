/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author kurtm
 */
public class CategoryPrice {
    private String catName;
    private double totalPrice;

    public CategoryPrice(String catName, double totalPrice) {
        this.catName = catName;
        this.totalPrice = totalPrice;
    }
    
    public CategoryPrice() {
        
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    
}
