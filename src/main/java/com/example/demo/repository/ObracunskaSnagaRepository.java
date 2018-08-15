package com.example.demo.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.klase.ObracunskaSnaga;

public interface ObracunskaSnagaRepository extends JpaRepository<ObracunskaSnaga, Integer>{

	@Query("SELECT o FROM ObracunskaSnaga o INNER JOIN MestoMerenja m on o.idObracunskeSnage = m.idObracunskeSnage.idObracunskeSnage INNER JOIN Potrosac p on p.idPotrosaca = m.idPotrosaca.idPotrosaca INNER JOIN Racun r on r.idPotrosaca.idPotrosaca = p.idPotrosaca WHERE r.idRacuna = ?1")
	public ObracunskaSnaga vratiObracunskuSnagu(BigDecimal idRacuna);
}
