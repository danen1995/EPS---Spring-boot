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
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "idObracunskeSnage")
public class StavkaRacunaPK implements Serializable {

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "ID_RACUNA")
    //@JsonManagedReference(value="stavkaRacunaPK-racun")
    private BigDecimal idRacuna;
    @Basic(optional = false)
    @Column(name = "ID_STAVKE_RACUNA")
    //@JsonManagedReference(value="stavkaRacunaPK-stavkaRacuna")
    private BigDecimal idStavkeRacuna;

    public StavkaRacunaPK() {
    }

    public StavkaRacunaPK(BigDecimal idRacuna, BigDecimal idStavkeRacuna) {
        this.idRacuna = idRacuna;
        this.idStavkeRacuna = idStavkeRacuna;
    }

    public BigDecimal getIdRacuna() {
        return idRacuna;
    }

    public void setIdRacuna(BigDecimal idRacuna) {
        this.idRacuna = idRacuna;
    }

    public BigDecimal getIdStavkeRacuna() {
        return idStavkeRacuna;
    }

    public void setIdStavkeRacuna(BigDecimal idStavkeRacuna) {
        this.idStavkeRacuna = idStavkeRacuna;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRacuna != null ? idRacuna.hashCode() : 0);
        hash += (idStavkeRacuna != null ? idStavkeRacuna.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StavkaRacunaPK)) {
            return false;
        }
        StavkaRacunaPK other = (StavkaRacunaPK) object;
        if ((this.idRacuna == null && other.idRacuna != null) || (this.idRacuna != null && !this.idRacuna.equals(other.idRacuna))) {
            return false;
        }
        if ((this.idStavkeRacuna == null && other.idStavkeRacuna != null) || (this.idStavkeRacuna != null && !this.idStavkeRacuna.equals(other.idStavkeRacuna))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.klase.StavkaRacunaPK[ idRacuna=" + idRacuna + ", idStavkeRacuna=" + idStavkeRacuna + " ]";
    }
    
}
