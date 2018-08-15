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
@Table(name = "ADRESA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adresa.findAll", query = "SELECT a FROM Adresa a"),
    @NamedQuery(name = "Adresa.findByIdAdrese", query = "SELECT a FROM Adresa a WHERE a.idAdrese = :idAdrese"),
    @NamedQuery(name = "Adresa.findByBroj", query = "SELECT a FROM Adresa a WHERE a.broj = :broj"),
    @NamedQuery(name = "Adresa.findByGrad", query = "SELECT a FROM Adresa a WHERE a.grad = :grad"),
    @NamedQuery(name = "Adresa.findByOpstina", query = "SELECT a FROM Adresa a WHERE a.opstina = :opstina"),
    @NamedQuery(name = "Adresa.findByUlica", query = "SELECT a FROM Adresa a WHERE a.ulica = :ulica")})
//@JsonIdentityInfo(scope = Adresa.class, generator = ObjectIdGenerators.PropertyGenerator.class,property = "idAdrese")
public class Adresa implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_ADRESE")
    private BigDecimal idAdrese;
    @Basic(optional = false)
    @Column(name = "BROJ")
    private String broj;
    @Basic(optional = false)
    @Column(name = "GRAD")
    private String grad;
    @Column(name = "OPSTINA")
    private String opstina;
    @Basic(optional = false)
    @Column(name = "ULICA")
    private String ulica;
    @OneToMany(mappedBy = "idAdreseSr")
    @JsonBackReference(value="adresa-kupci")
    private Collection<Kupac> kupacCollection;
    @OneToMany(mappedBy = "idAdreseMm")
    @JsonBackReference(value="adresa-mestaMerenja")
    private Collection<MestoMerenja> mestoMerenjaCollection;
    @OneToMany(mappedBy = "idAdreseMm")
    @JsonBackReference(value="adresa-potrosaci")
    private Collection<Potrosac> potrosacCollection;

    public Adresa() {
    }

    public Adresa(BigDecimal idAdrese) {
        this.idAdrese = idAdrese;
    }

    public Adresa(BigDecimal idAdrese, String broj, String grad, String ulica) {
        this.idAdrese = idAdrese;
        this.broj = broj;
        this.grad = grad;
        this.ulica = ulica;
    }

    public BigDecimal getIdAdrese() {
        return idAdrese;
    }

    public void setIdAdrese(BigDecimal idAdrese) {
        this.idAdrese = idAdrese;
    }

    public String getBroj() {
        return broj;
    }

    public void setBroj(String broj) {
        this.broj = broj;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public String getOpstina() {
        return opstina;
    }

    public void setOpstina(String opstina) {
        this.opstina = opstina;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    @XmlTransient
    public Collection<Kupac> getKupacCollection() {
        return kupacCollection;
    }

    public void setKupacCollection(Collection<Kupac> kupacCollection) {
        this.kupacCollection = kupacCollection;
    }

    @XmlTransient
    public Collection<MestoMerenja> getMestoMerenjaCollection() {
        return mestoMerenjaCollection;
    }

    public void setMestoMerenjaCollection(Collection<MestoMerenja> mestoMerenjaCollection) {
        this.mestoMerenjaCollection = mestoMerenjaCollection;
    }

    @XmlTransient
    public Collection<Potrosac> getPotrosacCollection() {
        return potrosacCollection;
    }

    public void setPotrosacCollection(Collection<Potrosac> potrosacCollection) {
        this.potrosacCollection = potrosacCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAdrese != null ? idAdrese.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Adresa)) {
            return false;
        }
        Adresa other = (Adresa) object;
        if ((this.idAdrese == null && other.idAdrese != null) || (this.idAdrese != null && !this.idAdrese.equals(other.idAdrese))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.klase.Adresa[ idAdrese=" + idAdrese + " ]";
    }
    
}
