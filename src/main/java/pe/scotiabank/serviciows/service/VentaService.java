package pe.scotiabank.serviciows.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pe.scotiabank.serviciows.dto.PedidoDTO;
import pe.scotiabank.serviciows.dto.VentaDTO;
import pe.scotiabank.serviciows.entity.VentaEntity;
import pe.scotiabank.serviciows.repository.VentaRepository;

import java.util.List;

@Service
public class VentaService {

    private final VentaRepository ventaRepository;

    private final ModelMapper modelMapper;

    public VentaService(VentaRepository ventaRepository, ModelMapper modelMapper) {
        this.ventaRepository = ventaRepository;
        this.modelMapper = modelMapper;
    }

    public float calculoImpuesto(PedidoDTO pedidoDTO){
        float impuesto = 0.18F;
        float calculoImpuesto = 0.0F;
        if(pedidoDTO.isAfectacion()){
            calculoImpuesto= pedidoDTO.getCantidad()* pedidoDTO.getCostoUnitario()*impuesto;
        }
        return calculoImpuesto;
    }

    public float calculoImpuestoTotal(List<PedidoDTO> pedidoDTOList){
        float impuesto = 0.18F;
        float calculoImpuesto = 0.0F;
        /*
        for(PedidoDTO pedidoDTO: pedidoDTOList) {
            if (pedidoDTO.isAfectacion()) {
                calculoImpuesto += pedidoDTO.getCantidad() * pedidoDTO.getCostoUnitario() * impuesto;
            }
        }
        */
        calculoImpuesto = (float) pedidoDTOList.stream()
                .filter(PedidoDTO::isAfectacion)
                .mapToDouble(x-> x.getCantidad()*x.getCostoUnitario()*impuesto).sum();
        return calculoImpuesto;
    }

    public List<VentaDTO> retrieveVentas (){

        List<VentaEntity> ventaEntityList =ventaRepository.findAll();
        List<VentaDTO> ventaDTOList = modelMapper.map(ventaEntityList, List.class).stream().toList();
        return ventaDTOList;
    }

    public VentaDTO addVenta(VentaDTO ventaDTO) {
        VentaEntity ventaEntity = modelMapper.map(ventaDTO, VentaEntity.class);
        
        ventaEntity = ventaRepository.save(ventaEntity);

        return  modelMapper.map(ventaEntity,VentaDTO.class);
    }

    public VentaDTO deleteVenta(Integer idVenta) {
        VentaEntity ventaEntity = ventaRepository.getReferenceById(idVenta);
        ventaRepository.delete(ventaEntity);
        return modelMapper.map(ventaEntity,VentaDTO.class);
    }

    public VentaDTO getDireccion(Integer idVenta){
        String direccion = ventaRepository.getDireccion(idVenta);
        return VentaDTO.builder().direccion(direccion).build();
    }

}
