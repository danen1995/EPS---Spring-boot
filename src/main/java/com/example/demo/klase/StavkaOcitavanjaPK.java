/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.klase;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 *
 * @author Dane
 */
@Embeddable
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "idOcitavanja")
public class StavkaOcitavanjaPK implements Serializable {

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "ID_OCITAVANJA")
    //@JsonManagedReference(value="stavkaOcitavanjaPK-ocitavanje")
    private BigDecimal idOcitavanja;
    @Basic(optional = false)
    @Column(name = "ID_STAVKE_OC")
    //@JsonManagedReference(value="stavkaOcitavanjaPK-stavkaOcitavanja")
    private BigDecimal idStavkeOc;

    public StavkaOcitavanjaPK() {
    }

    public StavkaOcitavanjaPK(BigDecimal idOcitavanja, BigDecimal idStavkeOc) {
        this.idOcitavanja = idOcitavanja;
        this.idStavkeOc = idStavkeOc;
    }

    public BigDecimal getIdOcitavanja() {
        return idOcitavanja;
    }

    public void setIdOcitavanja(BigDecimal idOcitavanja) {
        this.idOcitavanja = idOcitavanja;
    }

    public BigDecimal getIdStavkeOc() {
        return idStavkeOc;
    }

    public void setIdStavkeOc(BigDecimal idStavkeOc) {
        this.idStavkeOc = idStavkeOc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOcitavanja != null ? idOcitavanja.hashCode() : 0);
        hash += (idStavkeOc != null ? idStavkeOc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StavkaOcitavanjaPK)) {
            return false;
        }
        StavkaOcitavanjaPK other = (StavkaOcitavanjaPK) object;
        if ((this.idOcitavanja == null && other.idOcitavanja != null) || (this.idOcitavanja != null && !this.idOcitavanja.equals(other.idOcitavanja))) {
            return false;
        }
        if ((this.idStavkeOc == null && other.idStavkeOc != null) || (this.idStavkeOc != null && !this.idStavkeOc.equals(other.idStavkeOc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.klase.StavkaOcitavanjaPK[ idOcitavanja=" + idOcitavanja + ", idStavkeOc=" + idStavkeOc + " ]";
    }
    
}
