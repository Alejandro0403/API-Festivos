package apifestivo.apifestivo.dominio.DTO;

public class diaFestivo {
    private String nombre;
    private String fecha;

    public diaFestivo(String nombre, String fecha) {
        this.nombre = nombre;
        this.fecha = fecha;
    }

    public diaFestivo() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}

