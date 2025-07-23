package com.daniel.dev.fundaem.repository;

import com.daniel.dev.fundaem.model.Evento;
import com.daniel.dev.fundaem.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventoRepository extends JpaRepository<Evento, Long> {

    List<Evento> findByCreador (Usuario creador);

}
