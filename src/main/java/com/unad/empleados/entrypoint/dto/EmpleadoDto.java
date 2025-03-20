package com.unad.empleados.entrypoint.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class EmpleadoDto {

    private String codigo;
    private String nombre;
    private String apellido;
    private String documentoIdentidad;
    private String direccion;
    private String telefono;
    private String foto;

}
