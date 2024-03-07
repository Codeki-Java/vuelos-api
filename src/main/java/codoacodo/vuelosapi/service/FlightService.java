package codoacodo.vuelosapi.service;

import codoacodo.vuelosapi.model.Flight;
import codoacodo.vuelosapi.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    public List<Flight> traerTodosLosVuelos(){
        return flightRepository.findAll();

   }

   public void crearVuelo(Flight flight){
        flightRepository.save(flight);
   }

    public Flight buscarVueloPorId(Long id) {
        return flightRepository.findById(id).orElse(null);
    }

    public void borrarVueloPorId(Long id) {
        flightRepository.deleteById(id);
    }

    public Flight actualizarVuelo(Flight flight) {
        flightRepository.save(flight);
        return flightRepository.findById(flight.getId()).orElse(null);
    }
}
