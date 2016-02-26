package com.daw.club.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

public class Cliente {
    private int id;
    @NotEmpty
    @Size(min=5,max=50)
    private String nombre;
    @Pattern(regexp="\\d{7,8}(-?[a-zA-Z])?")
    private String dni;
//    @Min(18)
//    private int edad;
    private boolean socio;


    public Cliente () {
        id=0;
        nombre="Desconocido";
        socio=false;
    }
    
    public Cliente(int id, String nombre, String dni, boolean socio) {
        this.id=id;
        this.nombre=nombre;
        this.dni=dni;
        this.socio=socio;
    }

    /**Copy constructor*/
    public Cliente(Cliente c) {
        this.id=c.id;
        this.nombre=c.nombre;
        this.dni=c.dni;
        this.socio=c.socio;
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * @return the socio
     */
    public boolean isSocio() {
        return socio;
    }

    /**
     * @param socio the socio to set
     */
    public void setSocio(boolean socio) {
        this.socio = socio;
    }

//    public int getEdad() {
//        return edad;
//    }
//
//    public void setEdad(int edad) {
//        this.edad = edad;
//    }
//    
}
