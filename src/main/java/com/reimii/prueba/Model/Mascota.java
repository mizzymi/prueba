package com.reimii.prueba.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "mascotas")
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;   // PK en la tabla

    private String nombre;
    private String animal;
    private String raza;
    private int edadAnios;
    private double pesoKg;
    private boolean vacunado;
    private String color;
    private String nombreDueno;

    public Mascota() {
    }

    public Mascota(String nombre,
                   String animal,
                   String raza,
                   int edadAnios,
                   double pesoKg,
                   boolean vacunado,
                   String color,
                   String nombreDueno) {
        this.nombre = nombre;
        this.animal = animal;
        this.raza = raza;
        this.edadAnios = edadAnios;
        this.pesoKg = pesoKg;
        this.vacunado = vacunado;
        this.color = color;
        this.nombreDueno = nombreDueno;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getAnimal() { return animal; }
    public void setAnimal(String animal) { this.animal = animal; }

    public String getRaza() { return raza; }
    public void setRaza(String raza) { this.raza = raza; }

    public int getEdadAnios() { return edadAnios; }
    public void setEdadAnios(int edadAnios) { this.edadAnios = edadAnios; }

    public double getPesoKg() { return pesoKg; }
    public void setPesoKg(double pesoKg) { this.pesoKg = pesoKg; }

    public boolean isVacunado() { return vacunado; }
    public void setVacunado(boolean vacunado) { this.vacunado = vacunado; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public String getNombreDueno() { return nombreDueno; }
    public void setNombreDueno(String nombreDueno) { this.nombreDueno = nombreDueno; }

    public void cumplirAnio() { this.edadAnios++; }
    public void vacunar() { this.vacunado = true; }

    @Override
    public String toString() {
        return "Mascota{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", animal='" + animal + '\'' +
                ", raza='" + raza + '\'' +
                ", edadAnios=" + edadAnios +
                ", pesoKg=" + pesoKg +
                ", vacunado=" + vacunado +
                ", color='" + color + '\'' +
                ", nombreDueno='" + nombreDueno + '\'' +
                '}';
    }
}
