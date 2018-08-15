package com.example.demo.repository;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.klase.*;



@Repository
public interface KupacRepository extends JpaRepository<Kupac, Integer> {
	
	
	 @Query("SELECT k from Kupac k INNER JOIN Korisnik kor ON k.idKupca = kor.idKupca WHERE kor.idKorisnika =?1")
	 public Kupac vratiOsnovnePodatke(BigDecimal idKorisnika);
	 

@Query("SELECT k from Kupac k INNER JOIN Potrosac p on p.idKupca = k.idKupca INNER JOIN MestoMerenja m on m.idPotrosaca = p.idPotrosaca WHERE p.edBroj =?1 AND m.brBrojila = ?2")
	public Kupac vratiKupcaZaEdBrojiBrojBrojila(String edBroj,BigDecimal brojBrojila);
	 

}