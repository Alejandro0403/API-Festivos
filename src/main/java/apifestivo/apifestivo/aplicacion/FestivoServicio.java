
package apifestivo.apifestivo.aplicacion;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import apifestivo.apifestivo.core.interfaces.repositorios.IFestivoRepositorio;
import apifestivo.apifestivo.core.interfaces.servicios.IFestivoServicio;
import apifestivo.apifestivo.dominio.DTO.diaFestivo;
import apifestivo.apifestivo.dominio.entidades.festivo;

//Se programan las funcionalidades
@Service
public class FestivoServicio implements IFestivoServicio{
    private IFestivoRepositorio repositorio;

    public FestivoServicio(IFestivoRepositorio repositorio){
        this.repositorio = repositorio;
    }
//Se calcula la fecha domingo de pascua a partir del año dado y se retorna la fecha
    public LocalDate pascua(int año){
        int a = año % 19;
        int b = año % 4;
        int c = año % 7;
        int d = (19*a + 24 ) % 30;
        long dias = (d + (2*b + 4*c + 6*d + 5) % 7) + 7;
        LocalDate Pascua = LocalDate.of(año,3,15);
        Pascua = Pascua.plusDays(dias);                    
        return Pascua;
    }
//Se ajusta una fecha al próximo lunes correspondiente sumando un día hasta que lo sea
    public LocalDate lunes(LocalDate lunes){
        while (lunes.getDayOfWeek() != DayOfWeek.MONDAY){
            lunes = lunes.plusDays(1);
        }
        return lunes;
    }

//Se recorre cada festivo de la base de datos, se genera la fecha del festivo
//Se compara la fecha dada con el festivo hasta dar con el festivo que es o al final de los posibles festivos y determinar si es o no un festivo
    @Override
    public String verificar(int año, int mes, int dia) {
        try{
            LocalDate.of(año,mes,dia);
        } catch (java.time.DateTimeException e){
            return "Fecha invalida";
        }
        LocalDate pascua = pascua(año);
        for (festivo festivo:repositorio.findAll()){
            
            if (festivo.getTipo().getId() == 1){
                if ((mes == festivo.getMes()) && (dia == festivo.getDia())){
                    return "Es festivo";
                }
            }
            if (festivo.getTipo().getId() == 2){
                LocalDate lunes = lunes(LocalDate.of(año, festivo.getMes(), festivo.getDia()));
                if ((dia == lunes.getDayOfMonth()) && (mes == (lunes.getMonthValue()))){
                    return "Es festivo";               }
            }           
            if (festivo.getTipo().getId() == 3){
                LocalDate basadoPascua = pascua.plusDays(festivo.getDiaspascua());
                if ((dia == basadoPascua.getDayOfMonth()) && (mes == (basadoPascua.getMonthValue()))){
                    return "Es festivo";                }
            }
            if (festivo.getTipo().getId() == 4){
                LocalDate basadoPascuaLunes = lunes(pascua.plusDays(festivo.getDiaspascua()));
                if ((dia == basadoPascuaLunes.getDayOfMonth()) && (mes == (basadoPascuaLunes.getMonthValue()))){
                    return "Es festivo";               }
            }
        }
        return "No es festivo";
    }

    @Override
    public List<diaFestivo> listar(int año) {
        List<diaFestivo> festivosAño = new ArrayList<>();
        diaFestivo festivoAño;
        LocalDate fecha;
        LocalDate pascua = pascua(año);
        for (festivo festivo:repositorio.findAll()){
            switch(festivo.getTipo().getId()){
                case 1:
                     fecha = LocalDate.of(año,festivo.getMes(),festivo.getDia());
                     festivoAño = new diaFestivo(festivo.getNombre(),fecha.toString());
                     festivosAño.add(festivoAño);
                    break;
                case 2:
                    fecha = lunes(LocalDate.of(año,festivo.getMes(), festivo.getDia()));
                    festivoAño = new diaFestivo(festivo.getNombre(),fecha.toString());
                    festivosAño.add(festivoAño);
                    break;
                case 3:
                    fecha = pascua.plusDays(festivo.getDiaspascua());
                    festivoAño = new diaFestivo(festivo.getNombre(),fecha.toString());
                    festivosAño.add(festivoAño);
                    break;
                case 4:
                    fecha = lunes(pascua.plusDays(festivo.getDiaspascua()));
                    festivoAño = new diaFestivo(festivo.getNombre(),fecha.toString());
                    festivosAño.add(festivoAño);
                    break;
            }
        }
        return festivosAño;
    }
}