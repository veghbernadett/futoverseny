package hu.veghbernadett.futoverseny.repositories;

import hu.veghbernadett.futoverseny.domain.models.Futo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FutoRepository extends JpaRepository<Futo, Integer> {
}
