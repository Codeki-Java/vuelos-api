package codoacodo.vuelosapi.utils;

import codoacodo.vuelosapi.model.Flight;
import codoacodo.vuelosapi.model.FlightDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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

    /*public FlightDto flightMapper(Flight flight, double price){
        return new FlightDto(
                flight.getId(),
                flight.getOrigen(),
                flight.getDestino(),
                flight.getFechaHoraSalida(),
                flight.getFechaHoraLlegada(),
                flight.getPrecio() * price);
    }*/

   /* public List<FlightDto> flightMapper(List<Flight> flightList, double price) {

        List<FlightDto> flightDto = flightList.stream()
                .map(f -> new flightDto (
                        f.getId()
                )
                .collect(Collectors.toList());

        return flightDto;
    }*/
/*
   public List<FlightDto> flightMapper(List<Flight> flights, double price) {
        List<FlightDto> flightDto = new ArrayList<>();
        for(Flight flight : flights) {
            flightDto.add(new FlightDto(
                    flight.getId(),
                    flight.getOrigen(),
                    flight.getDestino(),
                    flight.getFechaHoraSalida(),
                    flight.getFechaHoraLlegada(),
                    flight.getPrecio() * price
            ));

        } return flightDto;
    }*/

    //Creacion de listado de FlightDto con stream
    public List<FlightDto> flightMapper(List<Flight> flights, double price) {
        return flights.stream()
                .map(f -> new FlightDto(
                        f.getId(),
                        f.getOrigen(),
                        f.getDestino(),
                        f.getFechaHoraSalida(),
                        f.getFechaHoraLlegada(),
                        f.getPrecio() * price))
                .collect(Collectors.toList());
    }
}
