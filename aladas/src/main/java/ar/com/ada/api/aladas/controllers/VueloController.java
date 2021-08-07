package ar.com.ada.api.aladas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ar.com.ada.api.aladas.entities.Aeropuerto;
import ar.com.ada.api.aladas.entities.Vuelo;
import ar.com.ada.api.aladas.entities.Vuelo.EstadoVueloEnum;
import ar.com.ada.api.aladas.models.request.EstadoVueloRequest;
import ar.com.ada.api.aladas.models.response.GenericResponse;
import ar.com.ada.api.aladas.services.AeropuertoService;
import ar.com.ada.api.aladas.services.VueloService;

import static ar.com.ada.api.aladas.services.VueloService.ValidacionVueloDataEnum;

import java.util.List;

@RestController
public class VueloController {

    /*
     * @Autowired //Version simple VueloService service;
     */

    // Version mas "pro"// ¿por qué?
    private VueloService service;

    private AeropuertoService aeropuertoService;

    public VueloController(VueloService service, AeropuertoService aeropuertoService) {
        this.service = service;
        this.aeropuertoService = aeropuertoService;
    }

    @PostMapping("/api/vuelos")
    public ResponseEntity<GenericResponse> postCrearVuelo(@RequestBody Vuelo vuelo) {
        GenericResponse respuesta = new GenericResponse();

        ValidacionVueloDataEnum resultadoValidacion = service.validar(vuelo);
        if (resultadoValidacion == ValidacionVueloDataEnum.OK) {
            service.crear(vuelo);

            respuesta.isOk = true;
            respuesta.id = vuelo.getVueloId();
            respuesta.message = "El vuelo ha sido creado correctamente.";

            return ResponseEntity.ok(respuesta);
        } else {

            respuesta.isOk = false;
            respuesta.message = "Error(" + resultadoValidacion.toString() + ")";

            return ResponseEntity.badRequest().body(respuesta);
        }

    }

    @PutMapping("/api/vuelos/{id}/estados")
    public ResponseEntity<GenericResponse> putActualizarEstadoVuelo (@PathVariable Integer id, @RequestBody EstadoVueloRequest estadoVuelo){
        
        GenericResponse r = new GenericResponse();
        r.isOk = true;
        Vuelo vuelo = service.buscarPorId(id);
        vuelo.setEstadoVueloId(estadoVuelo.estado);
        service.actualizar(vuelo);
        r.message = "Vuelo actualizado.";
        return ResponseEntity.ok(r);  
 
        }


    @GetMapping("/api/vuelos/abiertos")
    public ResponseEntity<List<Vuelo>> getVuelosAbiertos(){
                
        return ResponseEntity.ok(service.traerVuelosAbiertos());
    }


    }









    /*
     * @PostMapping("/api/v2/vuelos") public ResponseEntity<GenericResponse>
     * postCrearVueloV2(@RequestBody Vuelo vuelo) { GenericResponse respuesta = new
     * GenericResponse();
     * 
     * Aeropuerto ao = aeropuertoService.b
     * 
     * Vuelo vueloCreado = service.crear(vuelo.getFecha(), vuelo.getCapacidad(),
     * vuelo.getAeropuertoOrigen(), vuelo.getAeropuertoDestino(), vuelo.getPrecio(),
     * vuelo.getCodigoMoneda());
     * 
     * respuesta.isOk = true; respuesta.id = vueloCreado.getVueloId();
     * respuesta.message = "Vuelo creado correctamente";
     * 
     * return ResponseEntity.ok(respuesta); }
     */
