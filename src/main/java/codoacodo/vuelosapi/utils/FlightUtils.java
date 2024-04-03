package codoacodo.vuelosapi.utils;

import codoacodo.vuelosapi.model.Flight;
import codoacodo.vuelosapi.model.FlightDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FlightUtils {
    public List<Flight> detectOffers(List<Flight> flights, Integer offerPrice){
        /*List<Flight> offers = new ArrayList<>();

        for(Flight flight : flights){
            if(flight.getPrecio() <= offerPrice) {
                offers.add(flight);
            }
        }
        return offers;*/

        //Usando programacion funcional
        return flights.stream()
                .filter(f ->f.getPrecio()<=offerPrice)
                .collect(Collectors.toList());
    }

    public FlightDto flightMapper(Flight flight, double price){
        return new FlightDto(
                flight.getId(),
                flight.getOrigen(),
                flight.getDestino(),
                flight.getFechaHoraSalida(),
                flight.getFechaHoraLlegada(),
                flight.getPrecio() * price);
    }
}
