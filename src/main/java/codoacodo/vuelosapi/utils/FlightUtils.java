package codoacodo.vuelosapi.utils;

import codoacodo.vuelosapi.model.Dolar;
import codoacodo.vuelosapi.model.Flight;
import codoacodo.vuelosapi.model.FlightDto;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FlightUtils {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

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
    //Creacion de un FlightDto
    /*public FlightDto flightMapper(Flight flight, double price){
        return new FlightDto(
                flight.getId(),
                flight.getOrigen(),
                flight.getDestino(),
                flight.getFechaHoraSalida(),
                flight.getFechaHoraLlegada(),
                flight.getPrecio() * price);
    }*/

/*  //Creacion de listado de FlightDto
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

    public Dolar fetchDolar(){
        RestTemplate restTemplate = restTemplate();
        String apiUrl = "https://dolarapi.com/v1/dolares/tarjeta";
        return restTemplate.getForObject(apiUrl, Dolar.class);
    }

    public Dolar[] fetchAllDolars(){
        RestTemplate restTemplate = restTemplate();
        String apiUrl = "https://dolarapi.com/v1/dolares";
        return restTemplate.getForEntity(apiUrl,Dolar[].class).getBody();
    }


}
