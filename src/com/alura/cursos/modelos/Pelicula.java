package com.alura.cursos.modelos;

public class Pelicula {
    private String nombre;
    private int episodio;
    private String descripcion;
    private String director;
    private String productor;
    private int fechaDeLanzamiento;

    public Pelicula(String nombre, int episodio, String descripcion,
                    String director, String productor, int fechaDeLanzamiento) {
        this.nombre = nombre;
        this.episodio = episodio;
        this.descripcion = descripcion;
        this.director = director;
        this.productor  = productor;
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    public String getDirector() {
        return director;
    }

    public String getProductor() {
        return productor;
    }

    public void setEpisodio(int episodio) {
        this.episodio = episodio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEpisodio() {
        return episodio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getFechaDeLanzamiento() {
        return fechaDeLanzamiento;
    }

    @Override
    public String toString() {
        return "PeliculaSW{" +
                "nombre='" + nombre + '\'' +
                ", episodio=" + episodio +
                ", descripcion='" + descripcion + '\'' +
                ", director= " + director +
                ", productor= " + productor +
                ", fechaDeLanzamiento=" + fechaDeLanzamiento +
                '}';
    }
}
