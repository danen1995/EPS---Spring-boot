/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.klase;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
@Table(name = "TARIFA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tarifa.findAll", query = "SELECT t FROM Tarifa t"),
    @NamedQuery(name = "Tarifa.findByIdTarife", query = "SELECT t FROM Tarifa t WHERE t.idTarife = :idTarife"),
    @NamedQuery(name = "Tarifa.findByCena", query = "SELECT t FROM Tarifa t WHERE t.cena = :cena"),
    @NamedQuery(name = "Tarifa.findByTip", query = "SELECT t FROM Tarifa t WHERE t.tip = :tip"),
    @NamedQuery(name = "Tarifa.findByZona", query = "SELECT t FROM Tarifa t WHERE t.zona = :zona")})
//@JsonIdentityInfo(scope = Tarifa.class, generator = ObjectIdGenerators.PropertyGenerator.class,property = "idTarife")
public class Tarifa implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_TARIFE")
    private BigDecimal idTarife;
    @Column(name = "CENA")
    private BigDecimal cena;
    @Column(name = "TIP")
    private String tip;
    @Column(name = "ZONA")
    private String zona;
    @OneToMany(mappedBy = "idTarife")
    @JsonBackReference(value="tarifa-stavkeOcitavanja")
    private Collection<StavkaOcitavanja> stavkaOcitavanjaCollection;

    public Tarifa() {
    }

    public Tarifa(BigDecimal idTarife) {
        this.idTarife = idTarife;
    }

    public BigDecimal getIdTarife() {
        return idTarife;
    }

    public void setIdTarife(BigDecimal idTarife) {
        this.idTarife = idTarife;
    }

    public BigDecimal getCena() {
        return cena;
    }

    public void setCena(BigDecimal cena) {
        this.cena = cena;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    @XmlTransient
    public Collection<StavkaOcitavanja> getStavkaOcitavanjaCollection() {
        return stavkaOcitavanjaCollection;
    }

    public void setStavkaOcitavanjaCollection(Collection<StavkaOcitavanja> stavkaOcitavanjaCollection) {
        this.stavkaOcitavanjaCollection = stavkaOcitavanjaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTarife != null ? idTarife.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tarifa)) {
            return false;
        }
        Tarifa other = (Tarifa) object;
        if ((this.idTarife == null && other.idTarife != null) || (this.idTarife != null && !this.idTarife.equals(other.idTarife))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.klase.Tarifa[ idTarife=" + idTarife + " ]";
    }
    
}
