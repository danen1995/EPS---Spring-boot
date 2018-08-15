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
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.data.jpa.repository.Query;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 *
 * @author Dane
 */
@Entity
@Table(name = "KUPAC")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Kupac.vratiKupcaZaEdBrojiBrojBrojila", query = "SELECT k from Kupac k INNER JOIN Potrosac p on p.idKupca = k.idKupca INNER JOIN MestoMerenja m on m.idPotrosaca = p.idPotrosaca WHERE p.edBroj =?1 AND m.brBrojila = ?2"),
    @NamedQuery(name = "Kupac.findAll", query = "SELECT k FROM Kupac k"),
    @NamedQuery(name = "Kupac.findByIdKupca", query = "SELECT k FROM Kupac k WHERE k.idKupca = :idKupca"),
    @NamedQuery(name = "Kupac.findByJmbg", query = "SELECT k FROM Kupac k WHERE k.jmbg = :jmbg"),
    @NamedQuery(name = "Kupac.findByMaticniBroj", query = "SELECT k FROM Kupac k WHERE k.maticniBroj = :maticniBroj"),
    @NamedQuery(name = "Kupac.vratiOsnovnePodatke", query = "SELECT k from Kupac k INNER JOIN Korisnik kor ON k.idKupca = kor.idKupca WHERE kor.idKorisnika =?1"),
    @NamedQuery(name = "Kupac.findByNaziv", query = "SELECT k FROM Kupac k WHERE k.naziv = :naziv"),
    @NamedQuery(name = "Kupac.findByPib", query = "SELECT k FROM Kupac k WHERE k.pib = :pib"),
    @NamedQuery(name = "Kupac.findByProsireniNaziv", query = "SELECT k FROM Kupac k WHERE k.prosireniNaziv = :prosireniNaziv"),
    @NamedQuery(name = "Kupac.findByTip", query = "SELECT k FROM Kupac k WHERE k.tip = :tip")})
//@JsonIdentityInfo(scope = Kupac.class, generator = ObjectIdGenerators.PropertyGenerator.class,property = "idKupca")
public class Kupac implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_KUPCA")
    private BigDecimal idKupca;
    @Column(name = "JMBG")
    private String jmbg;
    @Column(name = "MATICNI_BROJ")
    private String maticniBroj;
    @Basic(optional = false)
    @Column(name = "NAPLATNI_BROJ")
    private String naplatniBroj;
    @Basic(optional = false)
    @Column(name = "NAZIV")
    private String naziv;
    @Column(name = "PIB")
    private BigDecimal pib;
    @Column(name = "PROSIRENI_NAZIV")
    private String prosireniNaziv;
    @Basic(optional = false)
    @Column(name = "TIP")
    private String tip;
    @JoinColumn(name = "ID_ADRESE_SR", referencedColumnName = "ID_ADRESE")
    @ManyToOne
    //@JsonManagedReference(value="kupac-adresa")
    private Adresa idAdreseSr;
    @OneToMany(mappedBy = "idKupca")
    @JsonBackReference(value="kupac-korisnici")
    private Collection<Korisnik> korisnikCollection;
    @OneToMany(mappedBy = "idKupca")
    @JsonBackReference(value="kupac-potrosaci")
    private Collection<Potrosac> potrosacCollection;

    public Kupac() {
    }

    public Kupac(BigDecimal idKupca) {
        this.idKupca = idKupca;
    }

    public Kupac(BigDecimal idKupca, String naplatniBroj, String naziv, String tip) {
        this.idKupca = idKupca;
        this.naplatniBroj = naplatniBroj;
        this.naziv = naziv;
        this.tip = tip;
    }

    public BigDecimal getIdKupca() {
        return idKupca;
    }

    public void setIdKupca(BigDecimal idKupca) {
        this.idKupca = idKupca;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getMaticniBroj() {
        return maticniBroj;
    }

    public void setMaticniBroj(String maticniBroj) {
        this.maticniBroj = maticniBroj;
    }

    public String getNaplatniBroj() {
        return naplatniBroj;
    }

    public void setNaplatniBroj(String naplatniBroj) {
        this.naplatniBroj = naplatniBroj;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public BigDecimal getPib() {
        return pib;
    }

    public void setPib(BigDecimal pib) {
        this.pib = pib;
    }

    public String getProsireniNaziv() {
        return prosireniNaziv;
    }

    public void setProsireniNaziv(String prosireniNaziv) {
        this.prosireniNaziv = prosireniNaziv;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public Adresa getIdAdreseSr() {
        return idAdreseSr;
    }

    public void setIdAdreseSr(Adresa idAdreseSr) {
        this.idAdreseSr = idAdreseSr;
    }

    @XmlTransient
    public Collection<Korisnik> getKorisnikCollection() {
        return korisnikCollection;
    }

    public void setKorisnikCollection(Collection<Korisnik> korisnikCollection) {
        this.korisnikCollection = korisnikCollection;
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
        hash += (idKupca != null ? idKupca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kupac)) {
            return false;
        }
        Kupac other = (Kupac) object;
        if ((this.idKupca == null && other.idKupca != null) || (this.idKupca != null && !this.idKupca.equals(other.idKupca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.klase.Kupac[ idKupca=" + idKupca + " ]";
    }
    
}
