package pe.scotiabank.serviciows.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.scotiabank.serviciows.entity.VentaEntity;

@Repository
public interface VentaRepository extends JpaRepository<VentaEntity, Integer> {



}
