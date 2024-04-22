package hu.veghbernadett.futoverseny.repositories;

import hu.veghbernadett.futoverseny.models.Verseny;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VersenyRepository extends JpaRepository<Verseny, Integer> {
    Optional<Verseny> findByAzonosito(int azonosito);
    @Query("SELECT r.nev, er.idoeredmeny FROM Futo r " +
            "JOIN r.eredmeny er " +
            "JOIN er.verseny v " +
            "WHERE v.azonosito = ?1" )
    List<Object[]> findRaceResultsById(int versenyAzonosito);
}
