/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 * Category model
 * @author Patrick
 */
public class category {
    private String name;
    private String desc;
    private double rate;
    private int min;
    private int max;

    public category() {
    }

    public category(String name, String desc, double rate, int min, int max) {
        
        this.name = name;
        this.desc = desc;
        this.rate = rate;
        this.min = min;
        this.max = max;
    }

   

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
    
    
}
