import ar.com.ada.api.aladas.entities.Aeropuerto;
import ar.com.ada.api.aladas.entities.Vuelo;
import ar.com.ada.api.aladas.repos.VueloRepository;

@Service
public class VueloService{

    @Autowired
    private VueloRepository repo;

    @Autowired
    private AeropuertoService aeropService;


    public void crear(Vuelo vuelvo){
        
    }

    public void crear(Date fecha, Integer capacidad, String aeropuertOrigen, String aeropuertoDestinoIATA, ){

        Vuelo vuelo = new vuelo();
        vuelo.setFecha(fecha);
        vuelo.setCapacidad(capacidad);
        Aeropuerto aeropuertoOrigen = aeropService.buscarPorCodigoIata(aeropuerto)
        Aeropuerto aeropuertoDestino = aeropService.buscarPorCodigoIata(aeropuerto)
        vuelo.setAeropuertoOrigen(aeropuertoOrigen.getAeropuertoId());
        vuelo.setAeropuestoDestino(aeropuertoDestino.getAeropuertoId());
        vuelo.setPrecio(precio);
        
        
    }








}