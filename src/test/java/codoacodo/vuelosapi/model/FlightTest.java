package codoacodo.vuelosapi.model;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FlightTest {
    private static Flight flight;



    @Test
    public void setAndGetOriginTest(){
        String testedOrigin = "COR";
        flight.setOrigen(testedOrigin);
        System.out.println("Se le asigna el origen : " + testedOrigin);
        assertEquals(testedOrigin, flight.getOrigen());

    }

    @Test public void setAndGetDestinyTest(){
        String testedDestiny = "MDZ";
        flight.setDestino(testedDestiny);
        assertEquals(testedDestiny, flight.getDestino());
    }

    @BeforeAll
    public static void setUp(){
        System.out.println("Se esta creando el vuelo");
        flight = new Flight();

    }

    /*
    Assertions.assertEquals(2, offers.size());
    Assertions.assertEquals("1", offers.get(0).getId());
     */

}