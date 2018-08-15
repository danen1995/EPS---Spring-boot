package com.example.demo.repository;
import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.klase.*;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Integer> {
	
	@Query("SELECT k FROM Korisnik k WHERE k.korisnickoIme = ?1 AND k.lozinka = ?2")
	public Korisnik logovanje(String user, String pass);

	@Query("SELECT k FROM Korisnik k  INNER JOIN Kupac ku on k.idKupca = ku.idKupca INNER JOIN Potrosac p on p.idKupca = ku.idKupca INNER JOIN MestoMerenja m on m.idPotrosaca = p.idPotrosaca WHERE m.brBrojila = ?1 AND p.edBroj = ?2")
	public Korisnik registracijaBrojila(BigDecimal brojBrojila, String edBroj);

}