package pe.scotiabank.serviciows.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VentaDTO {

    private Integer idVenta;

    private String direccion;

    private float total;
}
