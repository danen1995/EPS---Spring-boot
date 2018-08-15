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
@Table(name = "MESTO_MERENJA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MestoMerenja.findAll", query = "SELECT m FROM MestoMerenja m"),
    @NamedQuery(name = "MestoMerenja.findByIdMm", query = "SELECT m FROM MestoMerenja m WHERE m.idMm = :idMm"),
    @NamedQuery(name = "MestoMerenja.findByBrBrojila", query = "SELECT m FROM MestoMerenja m WHERE m.brBrojila = :brBrojila")})
//@JsonIdentityInfo(scope = MestoMerenja.class, generator = ObjectIdGenerators.PropertyGenerator.class,property = "idMm")
public class MestoMerenja implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_MM")
    private BigDecimal idMm;
    @Basic(optional = false)
    @Column(name = "BR_BROJILA")
    private BigDecimal brBrojila;
    @OneToMany(mappedBy = "idMm")
    @JsonBackReference(value="mestoMerenja-ocitavanja")
    private Collection<Ocitavanje> ocitavanjeCollection;
    @JoinColumn(name = "ID_ADRESE_MM", referencedColumnName = "ID_ADRESE")
    @ManyToOne
    //@JsonManagedReference(value="mestoMerenja-adresa")
    private Adresa idAdreseMm;
    @JoinColumn(name = "ID_OBRACUNSKE_SNAGE", referencedColumnName = "ID_OBRACUNSKE_SNAGE")
    @ManyToOne
    //@JsonManagedReference(value="mestoMerenja-obracunskaSnaga")
    private ObracunskaSnaga idObracunskeSnage;
    @JoinColumn(name = "ID_POTROSACA", referencedColumnName = "ID_POTROSACA")
    @ManyToOne
    //@JsonManagedReference(value="mestoMerenja-potrosac")
    private Potrosac idPotrosaca;

    public MestoMerenja() {
    }

    public MestoMerenja(BigDecimal idMm) {
        this.idMm = idMm;
    }

    public MestoMerenja(BigDecimal idMm, BigDecimal brBrojila) {
        this.idMm = idMm;
        this.brBrojila = brBrojila;
    }

    public BigDecimal getIdMm() {
        return idMm;
    }

    public void setIdMm(BigDecimal idMm) {
        this.idMm = idMm;
    }

    public BigDecimal getBrBrojila() {
        return brBrojila;
    }

    public void setBrBrojila(BigDecimal brBrojila) {
        this.brBrojila = brBrojila;
    }

    @XmlTransient
    public Collection<Ocitavanje> getOcitavanjeCollection() {
        return ocitavanjeCollection;
    }

    public void setOcitavanjeCollection(Collection<Ocitavanje> ocitavanjeCollection) {
        this.ocitavanjeCollection = ocitavanjeCollection;
    }

    public Adresa getIdAdreseMm() {
        return idAdreseMm;
    }

    public void setIdAdreseMm(Adresa idAdreseMm) {
        this.idAdreseMm = idAdreseMm;
    }

    public ObracunskaSnaga getIdObracunskeSnage() {
        return idObracunskeSnage;
    }

    public void setIdObracunskeSnage(ObracunskaSnaga idObracunskeSnage) {
        this.idObracunskeSnage = idObracunskeSnage;
    }

    public Potrosac getIdPotrosaca() {
        return idPotrosaca;
    }

    public void setIdPotrosaca(Potrosac idPotrosaca) {
        this.idPotrosaca = idPotrosaca;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMm != null ? idMm.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MestoMerenja)) {
            return false;
        }
        MestoMerenja other = (MestoMerenja) object;
        if ((this.idMm == null && other.idMm != null) || (this.idMm != null && !this.idMm.equals(other.idMm))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.klase.MestoMerenja[ idMm=" + idMm + " ]";
    }
    
}
