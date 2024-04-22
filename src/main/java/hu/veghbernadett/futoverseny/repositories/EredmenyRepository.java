package hu.veghbernadett.futoverseny.repositories;

import hu.veghbernadett.futoverseny.models.Eredmeny;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EredmenyRepository extends JpaRepository<Eredmeny, Integer> {

}
