package com.fundaem.fundaem.repository;

import com.fundaem.fundaem.model.Evento;
import com.fundaem.fundaem.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventoRepository extends JpaRepository<Evento, Long> {

    List<Evento> findByCreador(Usuario creador);

    List<Evento> findByActivoTrue();
}
