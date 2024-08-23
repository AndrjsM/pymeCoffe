package com.tienda.controller;

import com.tienda.domain.Inventario;
import com.tienda.domain.Proveedor;
import com.tienda.service.InventarioService;
import com.tienda.service.ProveedorService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@Slf4j
@RequestMapping("/inventario")
public class InventarioController {
    @Autowired
    private InventarioService inventarioService;
    
     @Autowired
    private ProveedorService proveedorService;
    
    @GetMapping("/listado")
    public String inicio(Model model) {
        List<Inventario> Inventarios = inventarioService.getInventarios(true);
        model.addAttribute("Inventarios", Inventarios);
        model.addAttribute("totalInventarios", Inventarios.size());
        List<Proveedor> proveedor = proveedorService.getProveedores();
        model.addAttribute("proveedor", proveedor);
        return "/inventario/listado";
    }
    
    @GetMapping("/nuevo")
    public String inventarioNuevo(Inventario inventario) {
        return "/prueba/modifica";
    }
    
    @PostMapping("/guardar")
    public String inventarioGuardar(Inventario inventario) {
        inventarioService.save(inventario);
        return "redirect:/prueba/listado";
    }
    
     @GetMapping("/eliminar/{idInventario}")
    public String inventarioEliminar(Inventario inventario) {
        inventarioService.delete(inventario);
        return "redirect:/prueba/listado";
    }

    @GetMapping("/modificar/{idInventario}")
    public String inventarioModificar(Inventario inventario, Model model) {
        inventario = inventarioService.getInventario(inventario);
        model.addAttribute("inventario", inventario);
        List<Proveedor> proveedor = proveedorService.getProveedores();
        model.addAttribute("proveedor", proveedor);
        return "/prueba/modifica";
    }
}
