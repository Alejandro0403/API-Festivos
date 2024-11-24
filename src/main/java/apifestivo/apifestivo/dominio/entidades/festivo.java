package apifestivo.apifestivo.dominio.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="festivo")

public class festivo {

    @Id
    @Column(name="id")
    private int id;
    @Column(name="nombre", length= 100, unique = true)
    private String nombre;
    @Column(name="dia")
    private int dia;
    @Column(name="mes")
    private int mes;
    @Column(name="diaspascua")
    private int diaspascua;

    @ManyToOne
    @JoinColumn(name="idtipo",referencedColumnName="id", nullable=false)
    private tipo tipo;

    public festivo() {
    }

    public festivo(int dia, int diaspascua, int id, int mes, String nombre, tipo tipo) {
        this.dia = dia;
        this.diaspascua = diaspascua;
        this.id = id;
        this.mes = mes;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setTipo(String nombre) {
        this.nombre = nombre;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getDiaspascua() {
        return diaspascua;
    }

    public void setDiaspascua(int diaspascua) {
        this.diaspascua = diaspascua;
    }

    public tipo getTipo() {
        return tipo;
    }

    public void setTipo(tipo tipo) {
        this.tipo = tipo;
    }
    

}
