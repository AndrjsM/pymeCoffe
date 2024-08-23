package com.tienda.domain;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "Proveedor", schema = "dbo")
public class Proveedor implements Serializable { // Serializable: Guardar el estado de un objeto en un almacenamiento para recuperarlo posteriormente.
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor")
    private Long idProveedor;
    private String nombre;
    private String correo;
    private int telefono;
    private String provincia;
    private String canton;
    private String distrito;
    private String sennas;

    public Proveedor() {
    }

    public Proveedor(String nombre, String correo, int telefono, String provincia, String canton, String distrito, String sennas) {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.provincia = provincia;
        this.canton = canton;
        this.distrito = distrito;
        this.sennas = sennas;
    }
    
}
