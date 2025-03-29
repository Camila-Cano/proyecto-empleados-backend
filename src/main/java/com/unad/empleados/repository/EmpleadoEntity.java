package com.unad.empleados.repository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Document(collection = "empleados")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoEntity {

    @Id
    private String documentoIdentidad;
    @Field("codigo")
    private String codigo;
    @Field("nombre")
    private String nombre;
    @Field("apellido")
    private String apellido;
    @Field("direccion")
    private String direccion;
    @Field("telefono")
    private String telefono;
    @Field("fechaNacimiento")
    private LocalDateTime fechaNacimiento;
}
