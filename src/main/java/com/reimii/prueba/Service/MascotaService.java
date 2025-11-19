package com.reimii.prueba.Service;

import com.reimii.prueba.Model.Mascota;

import java.util.List;
import java.util.Optional;

public interface MascotaService {

    List<Mascota> findAll();

    Optional<Mascota> findByNombre(String nombre);

    Mascota save(Mascota mascota);

    boolean deleteByNombre(String nombre);
}