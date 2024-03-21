package codoacodo.vuelosapi.service;

import codoacodo.vuelosapi.model.Flight;
import codoacodo.vuelosapi.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    public List<Flight> traerTodosLosVuelos() {
        return flightRepository.findAll();

    }

    public void crearVuelo(Flight flight) {
        flightRepository.save(flight);
    }

    public Optional<Flight> buscarVueloPorId(Long id) {
        return flightRepository.findById(id);
    }

    public void borrarVueloPorId(Long id) {
        flightRepository.deleteById(id);
    }

    public Optional<Flight> actualizarVuelo(Flight flight) {
        flightRepository.save(flight);
        return flightRepository.findById(flight.getId());
    }


    public List<Flight> getOffers(Integer offerPrice) {
        //Traigo todos los vuelos
        List<Flight> flights= flightRepository.findAll();

        //Armo una lista de ofertas
        List<Flight> offerFlights = new ArrayList<>();

        //recorro los vuelos que traje y agrego los que son oferta
        for(Flight flight : flights){
            if(flight.getPrecio() <= offerPrice) {
                offerFlights.add(flight);
            }
        }
        return offerFlights;
    }

    //Version simple
    /*public List<Flight> getByOrigen(String origen){
        return flightRepository.findByOrigen(origen);
    }*/


    //Version usando .stream()
    public List<Flight> getByOrigen(String origen) {
        //Traigo todos los vuelos
        List<Flight> flights = flightRepository.findAll();

        //recorro los vuelos que traje y agrego los que tienen ese origen
        List<Flight> flightByOrigen = flights.stream()
                .filter(f -> f.getOrigen().equals(origen))
                .collect(Collectors.toList());

        return flightByOrigen;
    }
}
