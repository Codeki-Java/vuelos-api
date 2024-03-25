package codoacodo.vuelosapi.utils;

import codoacodo.vuelosapi.model.Flight;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FlightUtilsTest {
    private FlightUtils flightUtils;

    @BeforeEach
    void setUp(){
        flightUtils = new FlightUtils(); // Asignar una instancia en setUp()
    }

    @AfterEach
    void tearDown() {
        // Limpiar datos creados durante la prueba, si es necesario
    }

    @Test
    void detectOffersTest() {

        //Creo 5 vuelos
        Flight flight1 = new Flight("BUE","MDZ", "4/5/24 10hs","4/5/24 11hs",32000,"semanal");
        Flight flight2 = new Flight("EZE","MDZ", "4/5/24 10hs","4/5/24 11hs",31000,"semanal");
        Flight flight3 = new Flight("COR","MDZ", "4/5/24 10hs","4/5/24 11hs",22000,"semanal");
        Flight flight4 = new Flight("ROS","BUE", "4/5/24 10hs","4/5/24 11hs",12000,"semanal");
        Flight flight5 = new Flight("COR","TUC", "4/5/24 10hs","4/5/24 11hs",15000,"semanal");


        //armo lista con los 5 vuelos
        List<Flight> longFlightList = new ArrayList<>();
        longFlightList.add(flight1);
        longFlightList.add(flight2);
        longFlightList.add(flight3);
        longFlightList.add(flight4);
        longFlightList.add(flight5);

        //llamo a la funcionalidad filtrando los vuelos <=20000
        List<Flight> listaFiltrada = flightUtils.detectOffers(longFlightList, 20000);

        //verifico
        assertEquals(listaFiltrada.size(),2);
    }
}