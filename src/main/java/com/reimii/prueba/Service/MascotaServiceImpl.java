package com.reimii.prueba.Service;

import com.reimii.prueba.Model.Mascota;
import com.reimii.prueba.Repository.MascotaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MascotaServiceImpl implements MascotaService {

    private final MascotaRepository mascotaRepository;

    public MascotaServiceImpl(MascotaRepository mascotaRepository) {
        this.mascotaRepository = mascotaRepository;
    }

    @Override
    public List<Mascota> findAll() {
        return mascotaRepository.findAll();
    }

    @Override
    public Optional<Mascota> findByNombre(String nombre) {
        return mascotaRepository.findByNombreIgnoreCase(nombre);
    }

    @Override
    public Mascota save(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    @Override
    public boolean deleteByNombre(String nombre) {
        if (!mascotaRepository.existsByNombreIgnoreCase(nombre)) {
            return false;
        }
        mascotaRepository.deleteByNombreIgnoreCase(nombre);
        return true;
    }
}