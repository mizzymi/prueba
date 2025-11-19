package com.reimii.prueba.Controller;

import com.reimii.prueba.Model.Mascota;
import com.reimii.prueba.Service.MascotaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class PetController {

    private final MascotaService mascotaService;

    public PetController(MascotaService mascotaService) {
        this.mascotaService = mascotaService;
    }

    @GetMapping("/")
    public String index() {
        return "Bienvenido a la API de Mascotas";
    }

    @GetMapping("/mascotas")
    public List<Mascota> getPets() {
        return mascotaService.findAll();
    }

    @GetMapping("/mascota/{nombre}")
    public Mascota getPetByName(@PathVariable("nombre") String nombre) {
        return mascotaService.findByNombre(nombre).orElse(null);
    }

    @PostMapping("/mascota/registrar")
    public Mascota registerPet(@RequestBody Mascota mascota) {
        return mascotaService.save(mascota);
    }

    @PutMapping("/mascota/{nombre}")
    public Mascota updatePet(
            @PathVariable("nombre") String nombre,
            @RequestBody Mascota mascotaActualizada) {

        return mascotaService.findByNombre(nombre)
                .map(m -> {
                    m.setAnimal(mascotaActualizada.getAnimal());
                    m.setRaza(mascotaActualizada.getRaza());
                    m.setEdadAnios(mascotaActualizada.getEdadAnios());
                    m.setPesoKg(mascotaActualizada.getPesoKg());
                    m.setVacunado(mascotaActualizada.isVacunado());
                    m.setColor(mascotaActualizada.getColor());
                    m.setNombreDueno(mascotaActualizada.getNombreDueno());
                    return mascotaService.save(m);
                })
                .orElse(null);
    }

    @DeleteMapping("/mascota/{nombre}")
    public boolean deletePet(@PathVariable("nombre") String nombre) {
        return mascotaService.deleteByNombre(nombre);
    }
}
