package com.daniel.dev.fundaem.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "eventos")
public class Evento {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombreEvento;

    @Column(nullable = false, length = 2000)
    private String descripcion;

    @Column(nullable = false, length = 1000)
    private String urlVideo;

    private LocalDate fechaCreacion;

    @ElementCollection
    @CollectionTable(name = "evento_imagen", joinColumns = @JoinColumn(name = "id_evento"))
    @Column(name = "url_imagen")
    private List<String> imagenes = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "id_creador")
    private Usuario creador;
}
