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
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 *
 * @author Dane
 */
@Entity
@Table(name = "TIP_STAVKE_RACUNA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipStavkeRacuna.findAll", query = "SELECT t FROM TipStavkeRacuna t"),
    @NamedQuery(name = "TipStavkeRacuna.findByIdTipaStavkeRacuna", query = "SELECT t FROM TipStavkeRacuna t WHERE t.idTipaStavkeRacuna = :idTipaStavkeRacuna"),
    @NamedQuery(name = "TipStavkeRacuna.findByNaziv", query = "SELECT t FROM TipStavkeRacuna t WHERE t.naziv = :naziv")})
//@JsonIdentityInfo(scope = TipStavkeRacuna.class, generator = ObjectIdGenerators.PropertyGenerator.class,property = "idTipaStavkeRacuna")
public class TipStavkeRacuna implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_TIPA_STAVKE_RACUNA")
    private BigDecimal idTipaStavkeRacuna;
    @Column(name = "NAZIV")
    private String naziv;
    @OneToMany(mappedBy = "idTipa")
    @JsonBackReference(value="tipStavkeRacuna-stavkeRacuna")
    private Collection<StavkaRacuna> stavkaRacunaCollection;

    public TipStavkeRacuna() {
    }

    public TipStavkeRacuna(BigDecimal idTipaStavkeRacuna) {
        this.idTipaStavkeRacuna = idTipaStavkeRacuna;
    }

    public BigDecimal getIdTipaStavkeRacuna() {
        return idTipaStavkeRacuna;
    }

    public void setIdTipaStavkeRacuna(BigDecimal idTipaStavkeRacuna) {
        this.idTipaStavkeRacuna = idTipaStavkeRacuna;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @XmlTransient
    public Collection<StavkaRacuna> getStavkaRacunaCollection() {
        return stavkaRacunaCollection;
    }

    public void setStavkaRacunaCollection(Collection<StavkaRacuna> stavkaRacunaCollection) {
        this.stavkaRacunaCollection = stavkaRacunaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipaStavkeRacuna != null ? idTipaStavkeRacuna.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipStavkeRacuna)) {
            return false;
        }
        TipStavkeRacuna other = (TipStavkeRacuna) object;
        if ((this.idTipaStavkeRacuna == null && other.idTipaStavkeRacuna != null) || (this.idTipaStavkeRacuna != null && !this.idTipaStavkeRacuna.equals(other.idTipaStavkeRacuna))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.klase.TipStavkeRacuna[ idTipaStavkeRacuna=" + idTipaStavkeRacuna + " ]";
    }
    
}
