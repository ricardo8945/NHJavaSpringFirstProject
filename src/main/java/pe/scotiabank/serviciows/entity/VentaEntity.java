package pe.scotiabank.serviciows.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="VENTA")
@Getter
@Setter
public class VentaEntity {

    @Id
    @Column(name="ID_VENTA", nullable = false)

    private Integer idVenta;

    @Column(name="DIRECCION")
    private String direccion;

    @Column(name="TOTAL")
    private float total;
}
