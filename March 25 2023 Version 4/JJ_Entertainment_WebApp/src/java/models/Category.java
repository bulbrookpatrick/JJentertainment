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
public class Category {
    private int id;
    private String name;
    private String desc;
    private double rate;
    private int minNumPar;
    private int minNumPer;

    public Category() {
    }

    public Category(int id, String name, String desc, double rate, int minNumPar, int minNumPer) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.rate = rate;
        this.minNumPar = minNumPar;
        this.minNumPer = minNumPer;
    }
    
    public int getId(){
        return id;
    }
    public void setId(int id) {
        this.id = id;
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

    public int getMinNumPar() {
        return minNumPar;
    }

    public void setMinNumPar(int minNumPar) {
        this.minNumPar = minNumPar;
    }

    public int getMinNumPer() {
        return minNumPer;
    }

    public void setMinNumPer(int minNumPer) {
        this.minNumPer = minNumPer;
    }

}
