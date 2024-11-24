package apifestivo.apifestivo.core.interfaces.servicios;
import java.util.List;

import apifestivo.apifestivo.dominio.DTO.diaFestivo;

//Se definen las funcionalidades del programa
public interface IFestivoServicio {

    public String verificar(int año, int mes, int dia);

    public List<diaFestivo> listar (int año);
        
}