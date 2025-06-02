package com.fundaem.fundaem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "eventos")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Lob
    private String descripcion;


    @Temporal(TemporalType.DATE)
    private LocalDate fecha;

    @Column(nullable = false)
    private String imagenUrl;

    private Boolean activo = true;

    @ManyToOne
    @JoinColumn(name = "creador_id")
    private Usuario creador;


}
