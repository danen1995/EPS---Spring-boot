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
@Table(name = "STAVKA_OCITAVANJA")
@XmlRootElement
@NamedQueries({
	
    @NamedQuery(name = "StavkaOcitavanja.findAll", query = "SELECT s FROM StavkaOcitavanja s"),
    @NamedQuery(name = "StavkaOcitavanja.vratiPotrosnjuZaTarifu", query = "SELECT SUM(s.utroseno*t.cena) FROM StavkaOcitavanja s INNER JOIN Tarifa t on s.idTarife = t.idTarife.idTarife INNER JOIN Ocitavanje o on s.stavkaOcitavanjaPK.idOcitavanja = o.idOcitavanja INNER JOIN Racun r on r.idOcitavanja.idOcitavanja = o.idOcitavanja WHERE r.idRacuna = ?1 and t.tip = ?2"),
    @NamedQuery(name = "StavkaOcitavanja.vratiPotrosnjuZaZonu", query = "SELECT SUM(s.utroseno*t.cena) FROM StavkaOcitavanja s INNER JOIN Tarifa t on s.idTarife = t.idTarife.idTarife INNER JOIN Ocitavanje o on s.stavkaOcitavanjaPK.idOcitavanja = o.idOcitavanja INNER JOIN Racun r on r.idOcitavanja.idOcitavanja = o.idOcitavanja WHERE r.idRacuna = ?1 and t.zona = ?2"),
    @NamedQuery(name = "StavkaOcitavanja.findByIdOcitavanja", query = "SELECT s FROM StavkaOcitavanja s WHERE s.stavkaOcitavanjaPK.idOcitavanja = :idOcitavanja"),
    @NamedQuery(name = "StavkaOcitavanja.findByIdStavkeOc", query = "SELECT s FROM StavkaOcitavanja s WHERE s.stavkaOcitavanjaPK.idStavkeOc = :idStavkeOc"),
    @NamedQuery(name = "StavkaOcitavanja.vratiStavkeZaRacun", query = "SELECT s FROM StavkaOcitavanja s INNER JOIN Ocitavanje o on s.stavkaOcitavanjaPK.idOcitavanja = o.idOcitavanja INNER JOIN Racun r on r.idOcitavanja.idOcitavanja = o.idOcitavanja WHERE r.idRacuna = ?1"),
    @NamedQuery(name = "StavkaOcitavanja.findByUtroseno", query = "SELECT s FROM StavkaOcitavanja s WHERE s.utroseno = :utroseno")})
//@JsonIdentityInfo(scope = StavkaOcitavanja.class, generator = ObjectIdGenerators.PropertyGenerator.class,property = "stavkaOcitavanjaPK")
public class StavkaOcitavanja implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StavkaOcitavanjaPK stavkaOcitavanjaPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "UTROSENO")
    private BigDecimal utroseno;
    @JoinColumn(name = "ID_OCITAVANJA", referencedColumnName = "ID_OCITAVANJA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    //@JsonManagedReference(value="stavkaOcitavanja-ocitavanje")
    private Ocitavanje ocitavanje;
    @JoinColumn(name = "ID_TARIFE", referencedColumnName = "ID_TARIFE")
    @ManyToOne
    //@JsonManagedReference(value="stavkaOcitavanja-tarifa")
    private Tarifa idTarife;

    public StavkaOcitavanja() {
    }

    public StavkaOcitavanja(StavkaOcitavanjaPK stavkaOcitavanjaPK) {
        this.stavkaOcitavanjaPK = stavkaOcitavanjaPK;
    }

    public StavkaOcitavanja(BigDecimal idOcitavanja, BigDecimal idStavkeOc) {
        this.stavkaOcitavanjaPK = new StavkaOcitavanjaPK(idOcitavanja, idStavkeOc);
    }

    public StavkaOcitavanjaPK getStavkaOcitavanjaPK() {
        return stavkaOcitavanjaPK;
    }

    public void setStavkaOcitavanjaPK(StavkaOcitavanjaPK stavkaOcitavanjaPK) {
        this.stavkaOcitavanjaPK = stavkaOcitavanjaPK;
    }

    public BigDecimal getUtroseno() {
        return utroseno;
    }

    public void setUtroseno(BigDecimal utroseno) {
        this.utroseno = utroseno;
    }

    public Ocitavanje getOcitavanje() {
        return ocitavanje;
    }

    public void setOcitavanje(Ocitavanje ocitavanje) {
        this.ocitavanje = ocitavanje;
    }

    public Tarifa getIdTarife() {
        return idTarife;
    }

    public void setIdTarife(Tarifa idTarife) {
        this.idTarife = idTarife;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stavkaOcitavanjaPK != null ? stavkaOcitavanjaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StavkaOcitavanja)) {
            return false;
        }
        StavkaOcitavanja other = (StavkaOcitavanja) object;
        if ((this.stavkaOcitavanjaPK == null && other.stavkaOcitavanjaPK != null) || (this.stavkaOcitavanjaPK != null && !this.stavkaOcitavanjaPK.equals(other.stavkaOcitavanjaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.klase.StavkaOcitavanja[ stavkaOcitavanjaPK=" + stavkaOcitavanjaPK + " ]";
    }
    
}
