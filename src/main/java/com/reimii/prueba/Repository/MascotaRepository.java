package com.reimii.prueba.Repository;

import com.reimii.prueba.Model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MascotaRepository extends JpaRepository<Mascota, Long> {

    Optional<Mascota> findByNombreIgnoreCase(String nombre);

    boolean existsByNombreIgnoreCase(String nombre);

    void deleteByNombreIgnoreCase(String nombre);
}