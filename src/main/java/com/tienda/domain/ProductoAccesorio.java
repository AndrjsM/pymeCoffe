package com.tienda.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "Producto", schema = "dbo")
public class ProductoAccesorio implements Serializable { // Serializable: Guardar el estado de un objeto en un almacenamiento para recuperarlo posteriormente.
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long idAccesorio;
    private String nombre;
    private int sku;
    private double capacidad;
    
    @ManyToOne // de muchos a uno 
    @JoinColumn(name="id_medida") // se indica la columan del FK
    Medidas medida; //Se crea un objeto de la clase medida.
    
    private String descripcion;
    private String urlImagen;
    
    @OneToOne
    @JoinColumn(name="id_inventario")
    Inventario inventario;
    
    private double precioUnitario;
    
    public ProductoAccesorio() {
    }

    public ProductoAccesorio(String nombre, int sku, double capacidad, Medidas medida, String descripcion, String urlImagen, Inventario inventario, double precioUnitario) {
        this.nombre = nombre;
        this.sku = sku;
        this.capacidad = capacidad;
        this.medida = medida;
        this.descripcion = descripcion;
        this.urlImagen = urlImagen;
        this.inventario = inventario;
        this.precioUnitario = precioUnitario;
    }


    
}
