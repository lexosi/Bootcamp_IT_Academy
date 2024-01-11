package cat.itacademy.barcelonactiva.MorenoFort.Adolfo.s05.t01.n01.model.services;

import cat.itacademy.barcelonactiva.MorenoFort.Adolfo.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.MorenoFort.Adolfo.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.MorenoFort.Adolfo.s05.t01.n01.model.repository.SucursalRepository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SucursalService {
    @Autowired
    private SucursalRepository sucursalRepository;

    // Método para convertir de Sucursal a SucursalDTO
    private SucursalDTO convertToDTO(Sucursal sucursal) {
        SucursalDTO dto = new SucursalDTO();
        dto.setPk_SucursalID(sucursal.getPk_SucursalID());
        dto.setNombreSucursal(sucursal.getNombreSucursal());
        dto.setPaisSucursal(sucursal.getPaisSucursal());
        dto.setTipoSucursal(sucursal.getPaisSucursal().equals("España") ? "UE" : "Fuera UE");
        return dto;
    }

    // Método para convertir de SucursalDTO a Sucursal
    private Sucursal convertToEntity(SucursalDTO dto) {
        Sucursal sucursal = new Sucursal();
        sucursal.setPk_SucursalID(dto.getPk_SucursalID());
        sucursal.setNombreSucursal(dto.getNombreSucursal());
        sucursal.setPaisSucursal(dto.getPaisSucursal());
        return sucursal;
    }

     // Métodos CRUD
    public List<SucursalDTO> getAllSucursales() {
        return sucursalRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public SucursalDTO getSucursalById(Integer id) {
        Sucursal sucursal = sucursalRepository.findById(id).orElseThrow(() -> new RuntimeException("Sucursal no encontrada"));
        return convertToDTO(sucursal);
    }

    public SucursalDTO addSucursal(SucursalDTO dto) {
        Sucursal sucursal = convertToEntity(dto);
        Sucursal savedSucursal = sucursalRepository.save(sucursal);
        return convertToDTO(savedSucursal);
    }

    public SucursalDTO updateSucursal(SucursalDTO dto) {
        Sucursal sucursal = convertToEntity(dto);
        Sucursal updatedSucursal = sucursalRepository.save(sucursal);
        return convertToDTO(updatedSucursal);
    }

    public void deleteSucursal(Integer id) {
        sucursalRepository.deleteById(id);
    }
}