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
import javax.persistence.Id;
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
@Table(name = "manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Manager.findAll", query = "SELECT m FROM Manager m")
    , @NamedQuery(name = "Manager.findByManagerUsername", query = "SELECT m FROM Manager m WHERE m.managerUsername = :managerUsername")
    , @NamedQuery(name = "Manager.findByManagerEmail", query = "SELECT m FROM Manager m WHERE m.managerEmail = :managerEmail")
    , @NamedQuery(name = "Manager.findByManagerPassword", query = "SELECT m FROM Manager m WHERE m.managerPassword = :managerPassword")
    , @NamedQuery(name = "Manager.findByManagerFirstName", query = "SELECT m FROM Manager m WHERE m.managerFirstName = :managerFirstName")
    , @NamedQuery(name = "Manager.findByManagerLastName", query = "SELECT m FROM Manager m WHERE m.managerLastName = :managerLastName")
    , @NamedQuery(name = "Manager.findByManagerPhoneNumber", query = "SELECT m FROM Manager m WHERE m.managerPhoneNumber = :managerPhoneNumber")})
public class Manager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "manager_username")
    private String managerUsername;
    @Basic(optional = false)
    @Column(name = "manager_email")
    private String managerEmail;
    @Basic(optional = false)
    @Column(name = "manager_password")
    private String managerPassword;
    @Basic(optional = false)
    @Column(name = "manager_first_name")
    private String managerFirstName;
    @Basic(optional = false)
    @Column(name = "manager_last_name")
    private String managerLastName;
    @Basic(optional = false)
    @Column(name = "manager_phone_number")
    private int managerPhoneNumber;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mANAGERmanagerusername", fetch = FetchType.EAGER)
    private List<Performer> performerList;


    public Manager() {
    }


    public Manager(String managerUsername) {
        this.managerUsername = managerUsername;

    }

    public Manager(String managerUsername, String managerEmail, String managerPassword, String managerFirstName, String managerLastName, int managerPhoneNumber) {
        this.managerUsername = managerUsername;
        this.managerEmail = managerEmail;
        this.managerPassword = managerPassword;
        this.managerFirstName = managerFirstName;
        this.managerLastName = managerLastName;
        this.managerPhoneNumber = managerPhoneNumber;
    }

    public String getManagerUsername() {
        return managerUsername;
    }

    public void setManagerUsername(String managerUsername) {
        this.managerUsername = managerUsername;
    }

    public String getManagerEmail() {
        return managerEmail;
    }

    public void setManagerEmail(String managerEmail) {
        this.managerEmail = managerEmail;
    }

    public String getManagerPassword() {
        return managerPassword;
    }

    public void setManagerPassword(String managerPassword) {
        this.managerPassword = managerPassword;
    }

    public String getManagerFirstName() {
        return managerFirstName;
    }

    public void setManagerFirstName(String managerFirstName) {
        this.managerFirstName = managerFirstName;
    }

    public String getManagerLastName() {
        return managerLastName;
    }

    public void setManagerLastName(String managerLastName) {
        this.managerLastName = managerLastName;
    }

    public int getManagerPhoneNumber() {
        return managerPhoneNumber;
    }

    public void setManagerPhoneNumber(int managerPhoneNumber) {
        this.managerPhoneNumber = managerPhoneNumber;
    }

    @XmlTransient
    public List<Performer> getPerformerList() {
        return performerList;
    }

    public void setPerformerList(List<Performer> performerList) {
        this.performerList = performerList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (managerUsername != null ? managerUsername.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Manager)) {
            return false;
        }
        Manager other = (Manager) object;
        if ((this.managerUsername == null && other.managerUsername != null) || (this.managerUsername != null && !this.managerUsername.equals(other.managerUsername))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Manager[ managerUsername=" + managerUsername + " ]";

    }
    
}
