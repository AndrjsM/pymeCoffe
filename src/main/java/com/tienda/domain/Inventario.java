package com.tienda.domain;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "Inventario", schema = "dbo")
public class Inventario implements Serializable { // Serializable: Guardar el estado de un objeto en un almacenamiento para recuperarlo posteriormente.
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inventario")
    private Long idInventario;
    
    @OneToOne
    @JoinColumn(name="id_proveedor")
    Proveedor proveedor;
    
    private int cantidad;
    private boolean estatus;

    public Inventario() {
    }

    public Inventario(int cantidad, boolean estatus) {
        this.cantidad = cantidad;
        this.estatus = estatus;
    }
    
    
    
}
