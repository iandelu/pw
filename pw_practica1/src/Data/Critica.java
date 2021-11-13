package Data;

import java.io.Serializable;
import java.util.ArrayList;

public class Critica implements Serializable {

    private int idCritica;
    private String titulo;
    private Usuario autor;
    private int puntuacion;
    private Espectaculo espectaculo;
    private String texto;
    private ArrayList<Valoracion> valoraciones;
    
    
    public Critica(int idCritica, String titulo, Usuario autor, Espectaculo espectaculo, String texto, int puntuacion) {
        super();
        this.idCritica = idCritica;
        this.titulo=titulo;
        this.autor = autor;
        this.espectaculo = espectaculo;
        this.texto = texto;
    }
    public int getIdCritica() {
        return idCritica;
    }
    public void setIdCritica(int idCritica) {
        this.idCritica = idCritica;
    }
    public String getTituloCritica() {
        return titulo;
    }
    public void setTituloCritica(String titulo) {
        this.titulo = titulo;
    }
    public Usuario getAutor() {
        return autor;
    }
    public void setAutor(Usuario autor) {
        this.autor = autor;
    }
    public Espectaculo getEspectaculo() {
        return espectaculo;
    }
    public void setEspectaculo(Espectaculo espectaculo) {
        this.espectaculo = espectaculo;
    }
    public String getTexto() {
        return texto;
    }
    public void setTexto(String texto) {
        this.texto = texto;
    }
    public ArrayList<Valoracion> getValoraciones() {
        return valoraciones;
    }
    public void setValoraciones(ArrayList<Valoracion> valoraciones) {
        this.valoraciones = valoraciones;
    }
    
    public void adirValoracion(Valoracion nuevaValoracion) {
        valoraciones.add(nuevaValoracion);
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
    
    @Override
    public String toString() {
        return "Critica [idCritica=" + idCritica + ", autor=" + autor + ", puntuacion=" + puntuacion + ", espectaculo="
                + espectaculo + ", texto=" + texto + ", valoraciones=" + valoraciones + "]";
    }
    
    
    
    
}
