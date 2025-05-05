package com.unad.empleados.entrypoint.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class EmpleadoDto {

    @Pattern(regexp = "^\\d{3}$", message = "Debe ser tres digitos numericos")
    private String codigo;
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Debe ser alfabetico")
    @Size(max = 30)
    private String nombre;
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Debe ser alfabetico")
    @Size(max = 30)
    private String apellido;
    @Pattern(regexp = "^\\d{7,10}$", message = "Debe ser numerico y minimo de 7 digitos")
    private String documentoIdentidad;
    @Size(max = 100)
    private String direccion;
    @Pattern(regexp = "^\\d{10}$",  message = "Debe ser numerico y de 10 digitos")
    private String telefono;
    @Past
    @Nullable
    private LocalDateTime fechaNacimiento;

}
