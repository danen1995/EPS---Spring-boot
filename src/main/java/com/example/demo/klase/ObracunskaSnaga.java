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
@Table(name = "OBRACUNSKA_SNAGA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ObracunskaSnaga.findAll", query = "SELECT o FROM ObracunskaSnaga o"),
    @NamedQuery(name = "ObracunskaSnaga.findByIdObracunskeSnage", query = "SELECT o FROM ObracunskaSnaga o WHERE o.idObracunskeSnage = :idObracunskeSnage"),
    @NamedQuery(name = "ObracunskaSnaga.findByUtroseno", query = "SELECT o FROM ObracunskaSnaga o WHERE o.utroseno = :utroseno"),
    @NamedQuery(name = "ObracunskaSnaga.vratiObracunskuSnagu", query = "SELECT o FROM ObracunskaSnaga o INNER JOIN MestoMerenja m on o.idObracunskeSnage = m.idObracunskeSnage.idObracunskeSnage INNER JOIN Potrosac p on p.idPotrosaca = m.idPotrosaca.idPotrosaca INNER JOIN Racun r on r.idPotrosaca.idPotrosaca = p.idPotrosaca WHERE r.idRacuna = ?1"),
    @NamedQuery(name = "ObracunskaSnaga.findByCenaPoJedinici", query = "SELECT o FROM ObracunskaSnaga o WHERE o.cenaPoJedinici = :cenaPoJedinici")})
//@JsonIdentityInfo(scope = ObracunskaSnaga.class, generator = ObjectIdGenerators.PropertyGenerator.class,property = "idObracunskeSnage")
public class ObracunskaSnaga implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_OBRACUNSKE_SNAGE")
    private BigDecimal idObracunskeSnage;
    @Column(name = "UTROSENO")
    private BigDecimal utroseno;
    @Column(name = "CENA_PO_JEDINICI")
    private BigDecimal cenaPoJedinici;
    @OneToMany(mappedBy = "idObracunskeSnage")
    @JsonBackReference(value="obracunskaSnaga-mestaMerenja")
    private Collection<MestoMerenja> mestoMerenjaCollection;

    public ObracunskaSnaga() {
    }

    public ObracunskaSnaga(BigDecimal idObracunskeSnage) {
        this.idObracunskeSnage = idObracunskeSnage;
    }

    public BigDecimal getIdObracunskeSnage() {
        return idObracunskeSnage;
    }

    public void setIdObracunskeSnage(BigDecimal idObracunskeSnage) {
        this.idObracunskeSnage = idObracunskeSnage;
    }

    public BigDecimal getUtroseno() {
        return utroseno;
    }

    public void setUtroseno(BigDecimal utroseno) {
        this.utroseno = utroseno;
    }

    public BigDecimal getCenaPoJedinici() {
        return cenaPoJedinici;
    }

    public void setCenaPoJedinici(BigDecimal cenaPoJedinici) {
        this.cenaPoJedinici = cenaPoJedinici;
    }

    @XmlTransient
    public Collection<MestoMerenja> getMestoMerenjaCollection() {
        return mestoMerenjaCollection;
    }

    public void setMestoMerenjaCollection(Collection<MestoMerenja> mestoMerenjaCollection) {
        this.mestoMerenjaCollection = mestoMerenjaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idObracunskeSnage != null ? idObracunskeSnage.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ObracunskaSnaga)) {
            return false;
        }
        ObracunskaSnaga other = (ObracunskaSnaga) object;
        if ((this.idObracunskeSnage == null && other.idObracunskeSnage != null) || (this.idObracunskeSnage != null && !this.idObracunskeSnage.equals(other.idObracunskeSnage))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.klase.ObracunskaSnaga[ idObracunskeSnage=" + idObracunskeSnage + " ]";
    }
    
}
