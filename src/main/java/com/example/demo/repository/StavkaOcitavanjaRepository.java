package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.klase.StavkaOcitavanja;

public interface StavkaOcitavanjaRepository extends JpaRepository<StavkaOcitavanja, Integer>{

	@Query("SELECT s FROM StavkaOcitavanja s INNER JOIN Ocitavanje o on s.stavkaOcitavanjaPK.idOcitavanja = o.idOcitavanja INNER JOIN Racun r on r.idOcitavanja.idOcitavanja = o.idOcitavanja WHERE r.idRacuna = ?1")
	public List<StavkaOcitavanja> vratiStavkeOcitavanja(BigDecimal idRacuna);
	
	@Query("SELECT SUM(s.utroseno*t.cena) FROM StavkaOcitavanja s INNER JOIN Tarifa t on s.idTarife = t.idTarife.idTarife INNER JOIN Ocitavanje o on s.stavkaOcitavanjaPK.idOcitavanja = o.idOcitavanja INNER JOIN Racun r on r.idOcitavanja.idOcitavanja = o.idOcitavanja WHERE r.idRacuna = ?1 and t.zona = ?2 ")
	public Double vratiPotrosnjuZaZonu(BigDecimal idRacuna, String zona);
	
	@Query("SELECT SUM(s.utroseno*t.cena) FROM StavkaOcitavanja s INNER JOIN Tarifa t on s.idTarife = t.idTarife.idTarife INNER JOIN Ocitavanje o on s.stavkaOcitavanjaPK.idOcitavanja = o.idOcitavanja INNER JOIN Racun r on r.idOcitavanja.idOcitavanja = o.idOcitavanja WHERE r.idRacuna = ?1 and t.tip = ?2 ")
	public Double vratiPotrosnjuZaTarifu(BigDecimal idRacuna, String tarifa);
}
