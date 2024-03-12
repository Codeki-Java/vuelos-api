package codoacodo.vuelosapi.controller;

import codoacodo.vuelosapi.model.Flight;
import codoacodo.vuelosapi.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vuelos")
public class FlightController {

    @Autowired
    FlightService flightService;

    @GetMapping("")
    public List<Flight> getAllFlights() {
        return flightService.traerTodosLosVuelos();
    }

    @GetMapping("/{id}")
    public Optional<Flight> findFlightById(@PathVariable Long id) {
        return flightService.buscarVueloPorId(id);
    }

    @PostMapping("/agregar")
    public void createFlight(@RequestBody Flight flight) {
        flightService.crearVuelo(flight);
    }

    @DeleteMapping("/eliminar/{id}")
    public void deleteFlight(@PathVariable Long id) {
        flightService.borrarVueloPorId(id);
    }

    @PutMapping("/actualizar")
    public Optional<Flight> updateFlight(@RequestBody Flight flight) {
        return flightService.actualizarVuelo(flight);
    }

    /*
    Generar endpoint llamado ofertas a traves de @RequestParam, recibe un valor
    numerico y debemos retornar los vuelos con precio menor o igual a ese valor

     */

    @GetMapping("/ofertas")
    public List<Flight> getOffers() {
        int offerPrice = 200000;

        return flightService.getOffers(offerPrice);
    }

}
