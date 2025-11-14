package com.reimii.prueba.Controller;

import com.reimii.prueba.Model.Mascota;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class PetController {

    private List<Mascota> pets = new ArrayList<>(Arrays.asList(
        new Mascota(
                "Leia",
                "Perro",
                "Labrador",
                11,
                19.95,
                true,
                "marrón, blanco y negro",
                "Marta y Jordi"
        ),
        new Mascota(
                "Kyra",
                "Perro",
                "Labrador",
                15,
                22.3,
                true,
                "blanco y negro",
                "Marta y Jordi"
        ),
        new Mascota(
                "Ania",
                "Gato",
                "Carey",
                1,
                3.2,
                false,
                "naranja y negro",
                "Mizzy"
        )
    ));

    @GetMapping("/")
    public String index() {
        return "Bienvenido a la API de Mascotas";
    }

    @GetMapping("/mascotas")
    public List<Mascota> getPets() {
        return pets;
    }

    @GetMapping("/mascota/{nombre}")
    public Mascota getPetByName(@PathVariable("nombre") String nombre) {
        return pets.stream()
                .filter(p -> p.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }

    @PostMapping("/mascota/registrar")
    public Mascota registerPet(@RequestBody Mascota mascota) {
        pets.add(mascota);
        return mascota;
    }
}
