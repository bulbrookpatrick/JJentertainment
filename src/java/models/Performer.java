/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kurtm
 */
@Entity
@Table(name = "performer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Performer.findAll", query = "SELECT p FROM Performer p")
    , @NamedQuery(name = "Performer.findByPerformerUsername", query = "SELECT p FROM Performer p WHERE p.performerUsername = :performerUsername")
    , @NamedQuery(name = "Performer.findByPerformerEmail", query = "SELECT p FROM Performer p WHERE p.performerEmail = :performerEmail")
    , @NamedQuery(name = "Performer.findByPerformerPassword", query = "SELECT p FROM Performer p WHERE p.performerPassword = :performerPassword")
    , @NamedQuery(name = "Performer.findByPerformerFirstName", query = "SELECT p FROM Performer p WHERE p.performerFirstName = :performerFirstName")
    , @NamedQuery(name = "Performer.findByPerformerLastName", query = "SELECT p FROM Performer p WHERE p.performerLastName = :performerLastName")
    , @NamedQuery(name = "Performer.findByPerformerPhoneNumber", query = "SELECT p FROM Performer p WHERE p.performerPhoneNumber = :performerPhoneNumber")})
public class Performer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "performer_username")
    private String performerUsername;
    @Basic(optional = false)
    @Column(name = "performer_email")
    private String performerEmail;
    @Basic(optional = false)
    @Column(name = "performer_password")
    private String performerPassword;
    @Basic(optional = false)
    @Column(name = "performer_first_name")
    private String performerFirstName;
    @Basic(optional = false)
    @Column(name = "performer_last_name")
    private String performerLastName;
    @Basic(optional = false)
    @Column(name = "performer_phone_number")
    private int performerPhoneNumber;
    @ManyToMany(mappedBy = "performerList", fetch = FetchType.EAGER)
    private List<Category> categoryList;
    @JoinTable(name = "service_assign", joinColumns = {
        @JoinColumn(name = "PERFORMER_performer_username", referencedColumnName = "performer_username")}, inverseJoinColumns = {
        @JoinColumn(name = "SERVICE_service_id", referencedColumnName = "service_id")})
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Service> serviceList;
    @JoinColumn(name = "MANAGER_manager_username", referencedColumnName = "manager_username")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Manager mANAGERmanagerusername;

    public Performer() {
    }

    public Performer(String performerUsername) {
        this.performerUsername = performerUsername;
    }

    public Performer(String performerUsername, String performerEmail, String performerPassword, String performerFirstName, String performerLastName, int performerPhoneNumber) {
        this.performerUsername = performerUsername;
        this.performerEmail = performerEmail;
        this.performerPassword = performerPassword;
        this.performerFirstName = performerFirstName;
        this.performerLastName = performerLastName;
        this.performerPhoneNumber = performerPhoneNumber;
    }

    public String getPerformerUsername() {
        return performerUsername;
    }

    public void setPerformerUsername(String performerUsername) {
        this.performerUsername = performerUsername;
    }

    public String getPerformerEmail() {
        return performerEmail;
    }

    public void setPerformerEmail(String performerEmail) {
        this.performerEmail = performerEmail;
    }

    public String getPerformerPassword() {
        return performerPassword;
    }

    public void setPerformerPassword(String performerPassword) {
        this.performerPassword = performerPassword;
    }

    public String getPerformerFirstName() {
        return performerFirstName;
    }

    public void setPerformerFirstName(String performerFirstName) {
        this.performerFirstName = performerFirstName;
    }

    public String getPerformerLastName() {
        return performerLastName;
    }

    public void setPerformerLastName(String performerLastName) {
        this.performerLastName = performerLastName;
    }

    public int getPerformerPhoneNumber() {
        return performerPhoneNumber;
    }

    public void setPerformerPhoneNumber(int performerPhoneNumber) {
        this.performerPhoneNumber = performerPhoneNumber;
    }

    @XmlTransient
    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    @XmlTransient
    public List<Service> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
    }

    public Manager getMANAGERmanagerusername() {
        return mANAGERmanagerusername;
    }

    public void setMANAGERmanagerusername(Manager mANAGERmanagerusername) {
        this.mANAGERmanagerusername = mANAGERmanagerusername;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (performerUsername != null ? performerUsername.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Performer)) {
            return false;
        }
        Performer other = (Performer) object;
        if ((this.performerUsername == null && other.performerUsername != null) || (this.performerUsername != null && !this.performerUsername.equals(other.performerUsername))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Performer[ performerUsername=" + performerUsername + " ]";
    }
    
}
