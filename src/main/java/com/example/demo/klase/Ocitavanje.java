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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "OCITAVANJE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ocitavanje.findAll", query = "SELECT o FROM Ocitavanje o"),
    @NamedQuery(name = "Ocitavanje.findByIdOcitavanja", query = "SELECT o FROM Ocitavanje o WHERE o.idOcitavanja = :idOcitavanja"),
    @NamedQuery(name = "Ocitavanje.findByNovoMt", query = "SELECT o FROM Ocitavanje o WHERE o.novoMt = :novoMt"),
    @NamedQuery(name = "Ocitavanje.findByNovoVt", query = "SELECT o FROM Ocitavanje o WHERE o.novoVt = :novoVt"),
    @NamedQuery(name = "Ocitavanje.findByPrethodnoMt", query = "SELECT o FROM Ocitavanje o WHERE o.prethodnoMt = :prethodnoMt"),
    @NamedQuery(name = "Ocitavanje.findByPrethodnoVt", query = "SELECT o FROM Ocitavanje o WHERE o.prethodnoVt = :prethodnoVt")})
//@JsonIdentityInfo(scope = Ocitavanje.class,generator = ObjectIdGenerators.PropertyGenerator.class,property = "idOcitavanja")
public class Ocitavanje implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_OCITAVANJA")
    private BigDecimal idOcitavanja;
    @Column(name = "NOVO_MT")
    private BigDecimal novoMt;
    @Column(name = "NOVO_VT")
    private BigDecimal novoVt;
    @Column(name = "PRETHODNO_MT")
    private BigDecimal prethodnoMt;
    @Column(name = "PRETHODNO_VT")
    private BigDecimal prethodnoVt;
    @JoinColumn(name = "ID_MM", referencedColumnName = "ID_MM")
    @ManyToOne
    //@JsonManagedReference(value="ocitavanje-mernoMesto")
    private MestoMerenja idMm;
    @OneToMany(mappedBy = "idOcitavanja")
    @JsonBackReference(value="ocitavanje-racuni")
    private Collection<Racun> racunCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ocitavanje")
    @JsonBackReference(value="ocitavanje-stavkeOcitavanja")
    private Collection<StavkaOcitavanja> stavkaOcitavanjaCollection;

    public Ocitavanje() {
    }

    public Ocitavanje(BigDecimal idOcitavanja) {
        this.idOcitavanja = idOcitavanja;
    }

    public BigDecimal getIdOcitavanja() {
        return idOcitavanja;
    }

    public void setIdOcitavanja(BigDecimal idOcitavanja) {
        this.idOcitavanja = idOcitavanja;
    }

    public BigDecimal getNovoMt() {
        return novoMt;
    }

    public void setNovoMt(BigDecimal novoMt) {
        this.novoMt = novoMt;
    }

    public BigDecimal getNovoVt() {
        return novoVt;
    }

    public void setNovoVt(BigDecimal novoVt) {
        this.novoVt = novoVt;
    }

    public BigDecimal getPrethodnoMt() {
        return prethodnoMt;
    }

    public void setPrethodnoMt(BigDecimal prethodnoMt) {
        this.prethodnoMt = prethodnoMt;
    }

    public BigDecimal getPrethodnoVt() {
        return prethodnoVt;
    }

    public void setPrethodnoVt(BigDecimal prethodnoVt) {
        this.prethodnoVt = prethodnoVt;
    }

    public MestoMerenja getIdMm() {
        return idMm;
    }

    public void setIdMm(MestoMerenja idMm) {
        this.idMm = idMm;
    }

    @XmlTransient
    public Collection<Racun> getRacunCollection() {
        return racunCollection;
    }

    public void setRacunCollection(Collection<Racun> racunCollection) {
        this.racunCollection = racunCollection;
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
        hash += (idOcitavanja != null ? idOcitavanja.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ocitavanje)) {
            return false;
        }
        Ocitavanje other = (Ocitavanje) object;
        if ((this.idOcitavanja == null && other.idOcitavanja != null) || (this.idOcitavanja != null && !this.idOcitavanja.equals(other.idOcitavanja))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.klase.Ocitavanje[ idOcitavanja=" + idOcitavanja + " ]";
    }
    
}
