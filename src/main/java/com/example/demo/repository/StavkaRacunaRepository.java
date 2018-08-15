package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.klase.StavkaRacuna;
import com.example.demo.klase.StavkaRacunaPK;

@Repository
public interface StavkaRacunaRepository extends JpaRepository<StavkaRacuna, Integer> {
	
	@Query("SELECT s FROM StavkaRacuna s WHERE s.stavkaRacunaPK.idRacuna = ?1")
	public List<StavkaRacuna> vratiStavkeRacuna(BigDecimal idRacuna);

}
