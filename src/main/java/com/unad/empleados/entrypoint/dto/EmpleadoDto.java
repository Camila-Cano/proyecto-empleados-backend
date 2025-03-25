package com.unad.empleados.entrypoint.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class EmpleadoDto {

    @Pattern(regexp = "^\\d{3}$", message = "El campo codigo debe ser tres digitos numericos")
    private String codigo;
    @Pattern(regexp = "^[A-Za-z ]+$")
    @Size(max = 30)
    private String nombre;
    @Pattern(regexp = "^[A-Za-z ]+$")
    @Size(max = 30)
    private String apellido;
    @Pattern(regexp = "^\\d{7,10}$")
    private String documentoIdentidad;
    @Size(max = 100)
    private String direccion;
    @Pattern(regexp = "^\\d{10}$")
    private String telefono;
    private String foto;

}
