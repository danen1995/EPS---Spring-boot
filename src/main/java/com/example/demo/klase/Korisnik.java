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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.jpa.repository.Query;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 *
 * @author Dane
 */
@Entity
@Table(name = "KORISNIK")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Korisnik.findAll", query = "SELECT k FROM Korisnik k"),
		@NamedQuery(name = "Korisnik.logovanje", query = "SELECT k FROM Korisnik k WHERE k.korisnickoIme = ?1 AND k.lozinka = ?2"),
		@NamedQuery(name = "Korisnik.postoji", query = "SELECT k FROM Korisnik k WHERE k.korisnickoIme = ?1"),
		@NamedQuery(name = "Korisnik.findByIdKorisnika", query = "SELECT k FROM Korisnik k WHERE k.idKorisnika = :idKorisnika"),
		@NamedQuery(name = "Korisnik.registracijaBrojila", query = "SELECT k FROM Korisnik k  INNER JOIN Kupac ku on k.idKupca = ku.idKupca INNER JOIN Potrosac p on p.idKupca = ku.idKupca INNER JOIN MestoMerenja m on m.idPotrosaca = p.idPotrosaca WHERE m.brBrojila = ?1 AND p.edBroj = ?2"),
		@NamedQuery(name = "Korisnik.findByLozinka", query = "SELECT k FROM Korisnik k WHERE k.lozinka = :lozinka") })
//@JsonIdentityInfo(scope = Korisnik.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "idKorisnika")
public class Korisnik implements Serializable {

	private static final long serialVersionUID = 1L;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Id
	@Basic(optional = false)
	@Column(name = "ID_KORISNIKA")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigDecimal idKorisnika;
	@Basic(optional = false)
	@Column(name = "KORISNICKO_IME")
	private String korisnickoIme;
	@Basic(optional = false)
	@Column(name = "LOZINKA")
	private String lozinka;
	@JoinColumn(name = "ID_KUPCA", referencedColumnName = "ID_KUPCA")
	@ManyToOne
	// @JsonManagedReference(value="korisnik-kupac")
	private Kupac idKupca;

	public Korisnik() {
	}

	public Korisnik(BigDecimal idKorisnika) {
		this.idKorisnika = idKorisnika;
	}

	public Korisnik(BigDecimal idKorisnika, String korisnickoIme, String lozinka) {
		this.idKorisnika = idKorisnika;
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
	}

	public BigDecimal getIdKorisnika() {
		return idKorisnika;
	}

	public void setIdKorisnika(BigDecimal idKorisnika) {
		this.idKorisnika = idKorisnika;
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public Kupac getIdKupca() {
		return idKupca;
	}

	public void setIdKupca(Kupac idKupca) {
		this.idKupca = idKupca;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idKorisnika != null ? idKorisnika.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Korisnik)) {
			return false;
		}
		Korisnik other = (Korisnik) object;
		if ((this.idKorisnika == null && other.idKorisnika != null)
				|| (this.idKorisnika != null && !this.idKorisnika.equals(other.idKorisnika))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.example.demo.klase.Korisnik[ idKorisnika=" + idKorisnika + " ]";
	}

}
