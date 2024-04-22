package hu.veghbernadett.futoverseny.repositories;

import hu.veghbernadett.futoverseny.models.Futo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FutoRepository extends JpaRepository<Futo, Integer> {
    @Query("SELECT r.nev, er.idoeredmeny FROM Futo r " +
            "JOIN r.eredmeny er " +
            "WHERE r.azonosito = ?1")
    List<Object[]> findRunnerResultsById(Long runnerId);
}
