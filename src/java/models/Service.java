/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kurtm
 */
@Entity
@Table(name = "service")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Service.findAll", query = "SELECT s FROM Service s")
    , @NamedQuery(name = "Service.findByServiceId", query = "SELECT s FROM Service s WHERE s.serviceId = :serviceId")
    , @NamedQuery(name = "Service.findByServiceStartDate", query = "SELECT s FROM Service s WHERE s.serviceStartDate = :serviceStartDate")
    , @NamedQuery(name = "Service.findByServiceEndDate", query = "SELECT s FROM Service s WHERE s.serviceEndDate = :serviceEndDate")
    , @NamedQuery(name = "Service.findByServiceDuration", query = "SELECT s FROM Service s WHERE s.serviceDuration = :serviceDuration")
    , @NamedQuery(name = "Service.findByServicePrice", query = "SELECT s FROM Service s WHERE s.servicePrice = :servicePrice")
    , @NamedQuery(name = "Service.findByNumberOfParticipants", query = "SELECT s FROM Service s WHERE s.numberOfParticipants = :numberOfParticipants")
    , @NamedQuery(name = "Service.findByNumberOfPerformersToBeAssigned", query = "SELECT s FROM Service s WHERE s.numberOfPerformersToBeAssigned = :numberOfPerformersToBeAssigned")})
public class Service implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "service_id")
    private Integer serviceId;
    @Basic(optional = false)
    @Column(name = "service_start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date serviceStartDate;
    @Basic(optional = false)
    @Column(name = "service_end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date serviceEndDate;
    @Column(name = "service_duration")
    private Integer serviceDuration;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "service_price")
    private Double servicePrice;
    @Basic(optional = false)
    @Column(name = "number_of_participants")
    private int numberOfParticipants;
    @Column(name = "number_of_performers_to_be_assigned")
    private Integer numberOfPerformersToBeAssigned;
    @ManyToMany(mappedBy = "serviceList", fetch = FetchType.EAGER)
    private List<Performer> performerList;
    @JoinColumn(name = "CATEGORY_category_id", referencedColumnName = "category_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Category cATEGORYcategoryid;
    @JoinColumn(name = "EVENT_event_id", referencedColumnName = "event_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Event eVENTeventid;

    public Service() {
    }

    public Service(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Service(Integer serviceId, Date serviceStartDate, Date serviceEndDate, int numberOfParticipants) {
        this.serviceId = serviceId;
        this.serviceStartDate = serviceStartDate;
        this.serviceEndDate = serviceEndDate;
        this.numberOfParticipants = numberOfParticipants;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Date getServiceStartDate() {
        return serviceStartDate;
    }

    public void setServiceStartDate(Date serviceStartDate) {
        this.serviceStartDate = serviceStartDate;
    }

    public Date getServiceEndDate() {
        return serviceEndDate;
    }

    public void setServiceEndDate(Date serviceEndDate) {
        this.serviceEndDate = serviceEndDate;
    }

    public Integer getServiceDuration() {
        return serviceDuration;
    }

    public void setServiceDuration(Integer serviceDuration) {
        this.serviceDuration = serviceDuration;
    }

    public Double getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(Double servicePrice) {
        this.servicePrice = servicePrice;
    }

    public int getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public void setNumberOfParticipants(int numberOfParticipants) {
        this.numberOfParticipants = numberOfParticipants;
    }

    public Integer getNumberOfPerformersToBeAssigned() {
        return numberOfPerformersToBeAssigned;
    }

    public void setNumberOfPerformersToBeAssigned(Integer numberOfPerformersToBeAssigned) {
        this.numberOfPerformersToBeAssigned = numberOfPerformersToBeAssigned;
    }

    @XmlTransient
    public List<Performer> getPerformerList() {
        return performerList;
    }

    public void setPerformerList(List<Performer> performerList) {
        this.performerList = performerList;
    }

    public Category getCATEGORYcategoryid() {
        return cATEGORYcategoryid;
    }

    public void setCATEGORYcategoryid(Category cATEGORYcategoryid) {
        this.cATEGORYcategoryid = cATEGORYcategoryid;
    }

    public Event getEVENTeventid() {
        return eVENTeventid;
    }

    public void setEVENTeventid(Event eVENTeventid) {
        this.eVENTeventid = eVENTeventid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serviceId != null ? serviceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Service)) {
            return false;
        }
        Service other = (Service) object;
        if ((this.serviceId == null && other.serviceId != null) || (this.serviceId != null && !this.serviceId.equals(other.serviceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Service[ serviceId=" + serviceId + " ]";
    }
    
}
