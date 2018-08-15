/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.klase;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 *
 * @author Dane
 */
@Entity
@Table(name = "UPLATA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Uplata.findAll", query = "SELECT u FROM Uplata u"),
    @NamedQuery(name = "Uplata.findByIdUplate", query = "SELECT u FROM Uplata u WHERE u.idUplate = :idUplate"),
    @NamedQuery(name = "Uplata.findByDatum", query = "SELECT u FROM Uplata u WHERE u.datum = :datum"),
    @NamedQuery(name = "Uplata.findByIznos", query = "SELECT u FROM Uplata u WHERE u.iznos = :iznos")})
//@JsonIdentityInfo(scope = Uplata.class, generator = ObjectIdGenerators.PropertyGenerator.class,property = "idUplate")
public class Uplata implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_UPLATE")
    private BigDecimal idUplate;
    @Column(name = "DATUM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datum;
    @Column(name = "IZNOS")
    private BigDecimal iznos;
    @JoinColumn(name = "ID_RACUNA", referencedColumnName = "ID_RACUNA")
    @ManyToOne
    //@JsonManagedReference(value="uplata-racun")
    private Racun idRacuna;

    public Uplata() {
    }

    public Uplata(BigDecimal idUplate) {
        this.idUplate = idUplate;
    }

    public BigDecimal getIdUplate() {
        return idUplate;
    }

    public void setIdUplate(BigDecimal idUplate) {
        this.idUplate = idUplate;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public BigDecimal getIznos() {
        return iznos;
    }

    public void setIznos(BigDecimal iznos) {
        this.iznos = iznos;
    }

    public Racun getIdRacuna() {
        return idRacuna;
    }

    public void setIdRacuna(Racun idRacuna) {
        this.idRacuna = idRacuna;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUplate != null ? idUplate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Uplata)) {
            return false;
        }
        Uplata other = (Uplata) object;
        if ((this.idUplate == null && other.idUplate != null) || (this.idUplate != null && !this.idUplate.equals(other.idUplate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.klase.Uplata[ idUplate=" + idUplate + " ]";
    }
    
}
