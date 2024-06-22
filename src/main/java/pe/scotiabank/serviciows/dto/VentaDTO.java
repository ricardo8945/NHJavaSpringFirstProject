package pe.scotiabank.serviciows.dto;

import jakarta.annotation.Nullable;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VentaDTO {
    @Nullable
    private Integer idVenta;
    @Nullable
    private String direccion;
    @Nullable
    private float total;
}
