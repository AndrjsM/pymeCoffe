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
@Table(name = "Medidas", schema = "dbo")
public class Medidas implements Serializable { // Serializable: Guardar el estado de un objeto en un almacenamiento para recuperarlo posteriormente.
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medida")
    private Long idMedida;
    private String tipoMedida;
    private String descripcion;

    public Medidas() {
    }

    public Medidas(String tipoMedida, String descripcion) {
        this.tipoMedida = tipoMedida;
        this.descripcion = descripcion;
    }
}
