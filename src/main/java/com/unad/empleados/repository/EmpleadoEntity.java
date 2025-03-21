package com.unad.empleados.repository;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "empleados")
public class EmpleadoEntity {

    private String codigo;
    private String nombre;
    private String apellido;
    private String documentoIdentidad;
    private String direccion;
    private String telefono;
    private String foto;
}
