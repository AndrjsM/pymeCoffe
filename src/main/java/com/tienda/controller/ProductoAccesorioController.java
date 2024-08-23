package com.tienda.controller;

import com.tienda.domain.Inventario;
import com.tienda.domain.Medidas;
import com.tienda.domain.ProductoAccesorio;
import com.tienda.domain.Proveedor;
import com.tienda.service.InventarioService;
import com.tienda.service.MedidasService;
import com.tienda.service.ProductoAccesorioService;
import com.tienda.service.ProveedorService;
import com.tienda.service.impl.FirebaseStorageServiceImpl;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        List<ProductoAccesorio> accesorios = productoAccesorioService.getProductoAccesorios();
        model.addAttribute("accesorios", accesorios);

        // Limitar a los primeros 6 productos
        /*
        if (accesorios.size() > 6) {
            accesorios = accesorios.subList(0, 6);
        }*/
        List<Medidas> medidas = medidasService.getMedidas();
        model.addAttribute("medidas", medidas);

        List<Inventario> inventarios = inventarioService.getInventarios(true);
        model.addAttribute("inventarios", inventarios);

        List<Proveedor> proveedores = proveedorService.getProveedores();
        model.addAttribute("proveedores", proveedores);

        return "/producto/listado";
    }

    @PostMapping("/guardar")
    public String AccesorioGuardar(ProductoAccesorio productoAccesorio,
            @RequestParam("imagenFile") MultipartFile imagenFile,
            @RequestParam("cantidad") int cantidad,
            @RequestParam("idProveedor") Long idProveedor) {

        // Buscar el proveedor por ID
        Proveedor proveedor = proveedorService.getProveedorById(idProveedor);
        if (proveedor == null) {
            // Manejar el caso donde el proveedor no se encuentra
            throw new IllegalArgumentException("Proveedor no encontrado");
        }

        // Crear y guardar el nuevo inventario
        Inventario nuevoInventario = new Inventario();
        nuevoInventario.setCantidad(cantidad);
        nuevoInventario.setEstatus(true); // Asigna el estado por defecto
        nuevoInventario.setProveedor(proveedor); // Asocia el proveedor al inventario
        inventarioService.save(nuevoInventario);

        // Asociar el inventario al producto accesorio
        productoAccesorio.setInventario(nuevoInventario);

        // Guardar el accesorio para generar el ID
        productoAccesorioService.save(productoAccesorio);

        // Guardar la imagen si existe
        if (!imagenFile.isEmpty()) {
            String imageUrl = firebaseStorageService.cargaImagen(
                    imagenFile,
                    "productoAccesorio",
                    productoAccesorio.getIdAccesorio());

            productoAccesorio.setUrlImagen(imageUrl);

            // Guardar nuevamente el producto accesorio con la URL de la imagen
            productoAccesorioService.save(productoAccesorio);
        }

        return "redirect:/producto/listado";
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
