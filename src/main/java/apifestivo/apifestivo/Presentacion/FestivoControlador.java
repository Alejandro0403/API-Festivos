package apifestivo.apifestivo.Presentacion;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import apifestivo.apifestivo.core.interfaces.servicios.IFestivoServicio;
import apifestivo.apifestivo.dominio.DTO.diaFestivo;


@RestController
@RequestMapping("/api/festivo")
@CrossOrigin (origins="http://localhost:4200/")
public class FestivoControlador {

    private IFestivoServicio servicio;

    public FestivoControlador(IFestivoServicio servicio){
        this.servicio = servicio;
    }
    
    @RequestMapping(value = "/verificar/{año}/{mes}/{dia}",method = RequestMethod.GET)
    public String verificar(@PathVariable int año, @PathVariable int mes, @PathVariable int dia){
        return servicio.verificar(año, mes, dia);
    }

    @RequestMapping(value="/obtener/{año}", method = RequestMethod.GET)
    public List<diaFestivo> listar(@PathVariable int año) {
        return servicio.listar(año);
    }

}
