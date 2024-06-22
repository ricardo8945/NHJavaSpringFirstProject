package pe.scotiabank.serviciows.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.scotiabank.serviciows.dto.PedidoDTO;
import pe.scotiabank.serviciows.dto.VentaDTO;
import pe.scotiabank.serviciows.service.VentaService;

import java.util.List;

@RestController
@RequestMapping("api/v1/venta")
public class VentaController {

    @Autowired
    VentaService ventaService;

    @PostMapping("/calculoImpuesto")
    public ResponseEntity<Float> calculoImpuesto(@RequestBody PedidoDTO pedidoDTO){

        return new ResponseEntity<>(ventaService.calculoImpuesto(pedidoDTO), HttpStatus.OK);

    }

    @PostMapping("/calculoImpuestoTotal")
    public ResponseEntity<Float> calculoImpuesto(@RequestBody List<PedidoDTO> pedidoDTOList){

        return new ResponseEntity<>(ventaService.calculoImpuestoTotal(pedidoDTOList), HttpStatus.OK);

    }

    @GetMapping()
    public ResponseEntity<List<VentaDTO>> getVenta(){

        return new ResponseEntity<>(ventaService.retrieveVentas(), HttpStatus.OK);

    }

    @PostMapping()
    public ResponseEntity<VentaDTO> addVenta(@RequestBody VentaDTO ventaDTO){

        return new ResponseEntity<>(ventaService.addVenta(ventaDTO), HttpStatus.OK);

    }

    @DeleteMapping("/{idVenta}")
    public ResponseEntity<VentaDTO> deleteVenta(@PathVariable Integer idVenta){
        return new ResponseEntity<>(ventaService.deleteVenta(idVenta), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{idVenta}")
    public ResponseEntity<VentaDTO> getDireccionVenta(@PathVariable Integer idVenta){
        return new ResponseEntity<>(ventaService.getDireccion(idVenta), HttpStatus.ACCEPTED);
    }
}
