package com.alura.cursos.modelos;

public class AdaptadorSwapiPelicula {
    String nombre;
    int episodio;
    String descripcion;
    String director;
    String productor;
    int fechaDeLanzamiento;

    public Pelicula adaptadorSwapiAPelicula(PeliculaSW miPeliculaSW){
        this.nombre = miPeliculaSW.title();
        this.episodio = miPeliculaSW.episode_id();
        this.descripcion = miPeliculaSW.opening_crawl().substring(0,50);//190
        this.director  = miPeliculaSW.director();
        this.productor = miPeliculaSW.producer();
        this.fechaDeLanzamiento = Integer.valueOf(miPeliculaSW.release_date().substring(0,4));

        return new Pelicula(nombre, episodio, descripcion, director, productor, fechaDeLanzamiento);

    }

}
