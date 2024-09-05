package com.api.SpTest.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Random;

@Data
@Entity
@Table(name = "noticias")
public class Noticia {

    @Id
    private String id;



    private String titulo;

    @CreationTimestamp
    @Column(name = "fecha_publicacion", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fechaPublicacion;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonIgnoreProperties(value = "noticias")
    private Usuario usuario;

    // Constructor para generar el ID alfanumérico de 7 caracteres
    public Noticia() {
        this.id = generarIdAleatorio(7);
    }

    // Método para general un ID aleatory de 7 caracteres alfanuméricos
    private String generarIdAleatorio(int longitud) {
        String caracteres = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz0123456789";
        StringBuilder idAleatorio = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < longitud; i++) {
            int indiceAleatorio = random.nextInt(caracteres.length());
            idAleatorio.append(caracteres.charAt(indiceAleatorio));
        }


        return idAleatorio.toString();
    }
}
