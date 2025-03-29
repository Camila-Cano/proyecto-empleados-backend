package com.unad.empleados.entrypoint;

import com.unad.empleados.entrypoint.dto.EmpleadoDto;
import com.unad.empleados.services.EmpleadosService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class EmpleadosController {

    private final EmpleadosService service;

    @GetMapping("/{documentoIdentidad}")
    @ResponseStatus(HttpStatus.OK)
    public EmpleadoDto buscarEmpleado(@PathVariable("documentoIdentidad") String documentoIdentidad)  {
        return service.buscarEmpleado(documentoIdentidad);
    }

    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public EmpleadoDto crearEmpleado(@RequestBody @Valid EmpleadoDto request)  {
        return service.crearEmpleado(request);
    }

    @PutMapping("/actualizar")
    @ResponseStatus(HttpStatus.OK)
    public EmpleadoDto actualizarEmpleado(@RequestBody @Valid EmpleadoDto request)  {
        return service.actualizarEmpleado(request);
    }

    @DeleteMapping("/{documentoIdentidad}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, String> eliminarEmpleado(@PathVariable("documentoIdentidad") String documentoIdentidad)  {
        return service.eliminarEmpleado(documentoIdentidad);
    }

}
