/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.tienda.controller;

import com.tienda.domain.Proveedor;
import com.tienda.service.ProveedorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/proveedor")
public class ProveedorController {
    @Autowired
    private ProveedorService proveedorService; 
    
    @GetMapping
    public String inicio(Model model) {
        var proveedores = proveedorService.getProveedores();
        model.addAttribute("proveddores", proveedores);
        model.addAttribute("totalProveedores", proveedores.size());
        return "/proveedor/listado";
    }
    
    @GetMapping("/nuevo")
    public String proveedorNuevo(Proveedor proveedor) {
        return "/proveedor/modifica";
    }
    
    @PostMapping("/guardar")
    public String proveedorGuardar(Proveedor proveedor) {
        proveedorService.save(proveedor);
        return "redirect:/proveedor/listado";
    }
    
}
