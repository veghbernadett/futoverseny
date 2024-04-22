package hu.veghbernadett.futoverseny.repositories;

import hu.veghbernadett.futoverseny.models.Verseny;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VersenyRepository extends JpaRepository<Verseny, Integer> {
}
