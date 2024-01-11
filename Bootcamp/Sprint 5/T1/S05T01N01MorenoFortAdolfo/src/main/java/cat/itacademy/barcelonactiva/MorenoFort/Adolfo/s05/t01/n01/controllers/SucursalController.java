package cat.itacademy.barcelonactiva.MorenoFort.Adolfo.s05.t01.n01.controllers;

import cat.itacademy.barcelonactiva.MorenoFort.Adolfo.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.MorenoFort.Adolfo.s05.t01.n01.model.services.SucursalService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sucursal")
public class SucursalController {
    @Autowired
    private SucursalService sucursalService;

    @PostMapping("/add")
public SucursalDTO addSucursal(@RequestBody SucursalDTO sucursalDTO) {
    return sucursalService.addSucursal(sucursalDTO);
}

@PutMapping("/update")
public SucursalDTO updateSucursal(@RequestBody SucursalDTO sucursalDTO) {
    return sucursalService.updateSucursal(sucursalDTO);
}

@DeleteMapping("/delete/{id}")
public void deleteSucursal(@PathVariable Integer id) {
    sucursalService.deleteSucursal(id);
}

@GetMapping("/getOne/{id}")
public SucursalDTO getSucursalById(@PathVariable Integer id) {
    return sucursalService.getSucursalById(id);
}

@GetMapping("/getAll")
public List<SucursalDTO> getAllSucursales() {
    return sucursalService.getAllSucursales();
}
}