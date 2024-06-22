package pe.scotiabank.serviciows.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.scotiabank.serviciows.entity.VentaEntity;

@Repository
public interface VentaRepository extends JpaRepository<VentaEntity, Integer> {

    @Query(value = "SELECT direccion from Venta WHERE id_venta = :id_venta",nativeQuery = true)
    String getDireccion(@Param("id_venta") Integer idVenta);

}
