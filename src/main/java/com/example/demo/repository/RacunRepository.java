package com.example.demo.repository;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.klase.Racun;

@Repository
public interface RacunRepository extends JpaRepository<Racun, Integer> {
	
	@Query("SELECT r FROM Racun r WHERE r.idPotrosaca.idPotrosaca = ?1")
	public List<Racun> vratiRacuneZaPotrosaca(BigDecimal idPotrosaca);
	
	@Query("SELECT r.racunPdf FROM Racun r WHERE r.idRacuna = ?1")
	public Blob vratiPdf(BigDecimal idRacuna);
	
	@Query("SELECT r FROM Racun r WHERE r.idRacuna = ?1")
	public Racun vratiRacun(BigDecimal idRacuna);
}
