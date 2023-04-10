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
public class PerformerCategory {
    private Performer performer;
    private Category category;
    
    public PerformerCategory() {
        
    }

    public PerformerCategory(Performer performer, Category category) {
        this.performer = performer;
        this.category = category;
    }

    public Performer getPerformer() {
        return performer;
    }

    public void setPerformer(Performer performer) {
        this.performer = performer;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    
    
}
