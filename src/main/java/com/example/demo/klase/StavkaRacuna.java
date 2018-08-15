/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.klase;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 *
 * @author Dane
 */
@Entity
@Table(name = "STAVKA_RACUNA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StavkaRacuna.findAll", query = "SELECT s FROM StavkaRacuna s"),
    @NamedQuery(name = "StavkaRacuna.vratiStavkeRacuna", query = "SELECT s FROM StavkaRacuna s WHERE s.stavkaRacunaPK.idRacuna = ?1"),
    @NamedQuery(name = "StavkaRacuna.findByIdStavkeRacuna", query = "SELECT s FROM StavkaRacuna s WHERE s.stavkaRacunaPK.idStavkeRacuna = :idStavkeRacuna"),
    @NamedQuery(name = "StavkaRacuna.findByIznos", query = "SELECT s FROM StavkaRacuna s WHERE s.iznos = :iznos")})
//@JsonIdentityInfo(scope = StavkaRacuna.class, generator = ObjectIdGenerators.PropertyGenerator.class,property = "stavkaRacunaPK")
public class StavkaRacuna implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StavkaRacunaPK stavkaRacunaPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "IZNOS")
    private BigDecimal iznos;
    @JoinColumn(name = "ID_RACUNA", referencedColumnName = "ID_RACUNA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    //@JsonManagedReference(value="stavkaRacuna-racun")
    private Racun racun;
    @JoinColumn(name = "ID_TIPA", referencedColumnName = "ID_TIPA_STAVKE_RACUNA")
    @ManyToOne
    //@JsonManagedReference(value = "stavkaRacuna-tip")
    private TipStavkeRacuna idTipa;

    public StavkaRacuna() {
    }

    public StavkaRacuna(StavkaRacunaPK stavkaRacunaPK) {
        this.stavkaRacunaPK = stavkaRacunaPK;
    }

    public StavkaRacuna(BigDecimal idRacuna, BigDecimal idStavkeRacuna) {
        this.stavkaRacunaPK = new StavkaRacunaPK(idRacuna, idStavkeRacuna);
    }

    public StavkaRacunaPK getStavkaRacunaPK() {
        return stavkaRacunaPK;
    }

    public void setStavkaRacunaPK(StavkaRacunaPK stavkaRacunaPK) {
        this.stavkaRacunaPK = stavkaRacunaPK;
    }

    public BigDecimal getIznos() {
        return iznos;
    }

    public void setIznos(BigDecimal iznos) {
        this.iznos = iznos;
    }

    public Racun getRacun() {
        return racun;
    }

    public void setRacun(Racun racun) {
        this.racun = racun;
    }

    public TipStavkeRacuna getIdTipa() {
        return idTipa;
    }

    public void setIdTipa(TipStavkeRacuna idTipa) {
        this.idTipa = idTipa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stavkaRacunaPK != null ? stavkaRacunaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StavkaRacuna)) {
            return false;
        }
        StavkaRacuna other = (StavkaRacuna) object;
        if ((this.stavkaRacunaPK == null && other.stavkaRacunaPK != null) || (this.stavkaRacunaPK != null && !this.stavkaRacunaPK.equals(other.stavkaRacunaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.klase.StavkaRacuna[ stavkaRacunaPK=" + stavkaRacunaPK + " ]";
    }
    
}
