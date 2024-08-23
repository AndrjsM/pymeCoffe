/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.tienda.controller;

import com.tienda.domain.Inventario;
import com.tienda.domain.Medidas;
import com.tienda.domain.ProductoAccesorio;
import com.tienda.domain.Proveedor;
import com.tienda.service.InventarioService;
import com.tienda.service.MedidasService;
import com.tienda.service.ProductoAccesorioService;
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
@RequestMapping("/producto")
public class ProductoAccesorioController {

    @Autowired
    private ProductoAccesorioService productoAccesorioService;

    @Autowired
    private InventarioService inventarioService;

    @Autowired
    private ProveedorService proveedorService;
    
    @Autowired
    private MedidasService medidasService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        List<ProductoAccesorio> accesorios = productoAccesorioService.getProductoAccesorios();
        model.addAttribute("accesorios", accesorios);
        model.addAttribute("totalAccesorios", accesorios.size());
        
        List<Medidas> medidas = medidasService.getMedidas();

        List<Inventario> inventarios = inventarioService.getInventarios(true);
        model.addAttribute("inventarios", inventarios);

        List<Proveedor> proveedores = proveedorService.getProveedores();
        model.addAttribute("proveedores", proveedores);

        return "/producto/listado";
    }
    @GetMapping("/nuevo")
    public String accesorioNuevo(ProductoAccesorio productoAccesorio) {
        return "/inventario/modifica";
    }

    @PostMapping("/guardar")
    public String AccesorioGuardar(ProductoAccesorio productoAccesorio) {
        productoAccesorioService.save(productoAccesorio);
        return "redirect:/inventario/listado";
    }

    @GetMapping("/eliminar/{idAccesorio}") // revisar solo se puede eliminar si el inventario está en cero
    public String accesorioEliminar(ProductoAccesorio productoAccesorio) {
        productoAccesorioService.delete(productoAccesorio);
        return "redirect:/inventario/listado";
    }

    @GetMapping("/modificar/{idAccesorio}")
    public String accesorioModificar(ProductoAccesorio productoAccesorio, Model model) {
        productoAccesorio = productoAccesorioService.getProductoAccesorio(productoAccesorio);
        model.addAttribute("productoAccesorio", productoAccesorio);
        List<Proveedor> proveedor = proveedorService.getProveedores();
        model.addAttribute("proveedor", proveedor);
        List<Inventario> inventario = inventarioService.getInventarios(true);
        return "/inventario/modifica";
    }

}
