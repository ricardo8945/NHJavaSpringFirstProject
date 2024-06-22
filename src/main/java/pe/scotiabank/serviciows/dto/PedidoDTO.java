package pe.scotiabank.serviciows.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PedidoDTO implements Serializable {

    private String nombreArticulo;

    private int cantidad;

    private float costoUnitario;

    private boolean afectacion;



}
