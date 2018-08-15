/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.klase;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 *
 * @author Dane
 */
@Entity
@Table(name = "OBRACUNSKI_PERIOD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ObracunskiPeriod.findAll", query = "SELECT o FROM ObracunskiPeriod o"),
    @NamedQuery(name = "ObracunskiPeriod.findByIdOp", query = "SELECT o FROM ObracunskiPeriod o WHERE o.idOp = :idOp"),
    @NamedQuery(name = "ObracunskiPeriod.findByBrojDana", query = "SELECT o FROM ObracunskiPeriod o WHERE o.brojDana = :brojDana"),
    @NamedQuery(name = "ObracunskiPeriod.findByDatumDo", query = "SELECT o FROM ObracunskiPeriod o WHERE o.datumDo = :datumDo"),
    @NamedQuery(name = "ObracunskiPeriod.findByDatumOd", query = "SELECT o FROM ObracunskiPeriod o WHERE o.datumOd = :datumOd"),
    @NamedQuery(name = "ObracunskiPeriod.findByGodina", query = "SELECT o FROM ObracunskiPeriod o WHERE o.godina = :godina"),
    @NamedQuery(name = "ObracunskiPeriod.findByMesec", query = "SELECT o FROM ObracunskiPeriod o WHERE o.mesec = :mesec"),
    @NamedQuery(name = "ObracunskiPeriod.findByNazivPerioda", query = "SELECT o FROM ObracunskiPeriod o WHERE o.nazivPerioda = :nazivPerioda")})
//@JsonIdentityInfo(scope = ObracunskiPeriod.class, generator = ObjectIdGenerators.PropertyGenerator.class,property = "idOp")
public class ObracunskiPeriod implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_OP")
    private BigDecimal idOp;
    @Basic(optional = false)
    @Column(name = "BROJ_DANA")
    private int brojDana;
    @Basic(optional = false)
    @Column(name = "DATUM_DO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datumDo;
    @Basic(optional = false)
    @Column(name = "DATUM_OD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datumOd;
    @Basic(optional = false)
    @Column(name = "GODINA")
    private int godina;
    @Basic(optional = false)
    @Column(name = "MESEC")
    private String mesec;
    @Column(name = "NAZIV_PERIODA")
    private String nazivPerioda;
    @OneToMany(mappedBy = "idOp")
    @JsonBackReference(value="obracunskiPeriod-racuni")
    private Collection<Racun> racunCollection;

    public ObracunskiPeriod() {
    }

    public ObracunskiPeriod(BigDecimal idOp) {
        this.idOp = idOp;
    }

    public ObracunskiPeriod(BigDecimal idOp, int brojDana, Date datumDo, Date datumOd, int godina, String mesec) {
        this.idOp = idOp;
        this.brojDana = brojDana;
        this.datumDo = datumDo;
        this.datumOd = datumOd;
        this.godina = godina;
        this.mesec = mesec;
    }

    public BigDecimal getIdOp() {
        return idOp;
    }

    public void setIdOp(BigDecimal idOp) {
        this.idOp = idOp;
    }

    public int getBrojDana() {
        return brojDana;
    }

    public void setBrojDana(int brojDana) {
        this.brojDana = brojDana;
    }

    public Date getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(Date datumDo) {
        this.datumDo = datumDo;
    }

    public Date getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(Date datumOd) {
        this.datumOd = datumOd;
    }

    public int getGodina() {
        return godina;
    }

    public void setGodina(int godina) {
        this.godina = godina;
    }

    public String getMesec() {
        return mesec;
    }

    public void setMesec(String mesec) {
        this.mesec = mesec;
    }

    public String getNazivPerioda() {
        return nazivPerioda;
    }

    public void setNazivPerioda(String nazivPerioda) {
        this.nazivPerioda = nazivPerioda;
    }

    @XmlTransient
    public Collection<Racun> getRacunCollection() {
        return racunCollection;
    }

    public void setRacunCollection(Collection<Racun> racunCollection) {
        this.racunCollection = racunCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOp != null ? idOp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ObracunskiPeriod)) {
            return false;
        }
        ObracunskiPeriod other = (ObracunskiPeriod) object;
        if ((this.idOp == null && other.idOp != null) || (this.idOp != null && !this.idOp.equals(other.idOp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.klase.ObracunskiPeriod[ idOp=" + idOp + " ]";
    }
    
}
