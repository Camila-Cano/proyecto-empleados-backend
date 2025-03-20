package com.unad.empleados.entrypoint;

import com.unad.empleados.entrypoint.dto.EmpleadoDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping
@Slf4j
public class EmpleadosController {

    @GetMapping("/{documentoIdentidad}")
    @ResponseStatus(HttpStatus.OK)
    public EmpleadoDto buscarEmpleado(@PathVariable("documentoIdentidad") String documentoIdentidad)  {
        System.out.println("ID: " + documentoIdentidad);
        return new EmpleadoDto();
    }

    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public EmpleadoDto crearEmpleado(@RequestBody EmpleadoDto request)  {
        System.out.println("request: " + request);
        return request;
    }

    @PutMapping("/actualizar")
    @ResponseStatus(HttpStatus.OK)
    public EmpleadoDto actualizarEmpleado(@RequestBody EmpleadoDto request)  {
        System.out.println("request: " + request);
        return request;
    }

    @DeleteMapping("/{documentoIdentidad}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, String> eliminarEmpleado(@PathVariable("documentoIdentidad") String documentoIdentidad)  {
        System.out.println("ID: " + documentoIdentidad);
        return Map.of("estado", "eliminado");
    }

}
