/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kurtm
 */
@Entity
@Table(name = "category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c")
    , @NamedQuery(name = "Category.findByCategoryId", query = "SELECT c FROM Category c WHERE c.categoryId = :categoryId")
    , @NamedQuery(name = "Category.findByCategoryName", query = "SELECT c FROM Category c WHERE c.categoryName = :categoryName")
    , @NamedQuery(name = "Category.findByCategoryDescription", query = "SELECT c FROM Category c WHERE c.categoryDescription = :categoryDescription")
    , @NamedQuery(name = "Category.findByCategoryRate", query = "SELECT c FROM Category c WHERE c.categoryRate = :categoryRate")
    , @NamedQuery(name = "Category.findByMinNumberOfParticipants", query = "SELECT c FROM Category c WHERE c.minNumberOfParticipants = :minNumberOfParticipants")
    , @NamedQuery(name = "Category.findByMinNumberOfPerformers", query = "SELECT c FROM Category c WHERE c.minNumberOfPerformers = :minNumberOfPerformers")})
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "category_id")
    private Integer categoryId;
    @Basic(optional = false)
    @Column(name = "category_name")
    private String categoryName;
    @Basic(optional = false)
    @Column(name = "category_description")
    private String categoryDescription;
    @Basic(optional = false)
    @Column(name = "category_rate")
    private double categoryRate;
    @Basic(optional = false)
    @Column(name = "min_number_of_participants")
    private int minNumberOfParticipants;
    @Basic(optional = false)
    @Column(name = "min_number_of_performers")
    private int minNumberOfPerformers;
    @JoinTable(name = "performer_specialty", joinColumns = {
        @JoinColumn(name = "CATEGORY_category_id", referencedColumnName = "category_id")}, inverseJoinColumns = {
        @JoinColumn(name = "PERFORMER_performer_username", referencedColumnName = "performer_username")})
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Performer> performerList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cATEGORYcategoryid", fetch = FetchType.EAGER)
    private List<Service> serviceList;

    public Category() {
    }

    public Category(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Category(Integer categoryId, String categoryName, String categoryDescription, double categoryRate, int minNumberOfParticipants, int minNumberOfPerformers) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
        this.categoryRate = categoryRate;
        this.minNumberOfParticipants = minNumberOfParticipants;
        this.minNumberOfPerformers = minNumberOfPerformers;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public double getCategoryRate() {
        return categoryRate;
    }

    public void setCategoryRate(double categoryRate) {
        this.categoryRate = categoryRate;
    }

    public int getMinNumberOfParticipants() {
        return minNumberOfParticipants;
    }

    public void setMinNumberOfParticipants(int minNumberOfParticipants) {
        this.minNumberOfParticipants = minNumberOfParticipants;
    }

    public int getMinNumberOfPerformers() {
        return minNumberOfPerformers;
    }

    public void setMinNumberOfPerformers(int minNumberOfPerformers) {
        this.minNumberOfPerformers = minNumberOfPerformers;
    }

    @XmlTransient
    public List<Performer> getPerformerList() {
        return performerList;
    }

    public void setPerformerList(List<Performer> performerList) {
        this.performerList = performerList;
    }

    @XmlTransient
    public List<Service> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categoryId != null ? categoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Category)) {
            return false;
        }
        Category other = (Category) object;
        if ((this.categoryId == null && other.categoryId != null) || (this.categoryId != null && !this.categoryId.equals(other.categoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Category[ categoryId=" + categoryId + " ]";
    }
    
}
