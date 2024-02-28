package codoacodo.vuelosapi.service;

import codoacodo.vuelosapi.model.Vuelo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VueloService {

    Vuelo vuelo1 = new Vuelo(1L,"EZE","MDQ", LocalDateTime.of(2024, 3, 2, 10, 0, 0), LocalDateTime.of(2024, 3, 14, 10, 0, 0),48000, "diario");

    Vuelo vuelo2 = new Vuelo(2L,"BUE","COR", LocalDateTime.of(2024, 2, 28, 10, 0, 0),LocalDateTime.of(2024, 3, 2, 10, 0, 0),50000,"semanal");

    public List<Vuelo> listarVuelos(){
       return List.of(vuelo1, vuelo2);
   }

}
