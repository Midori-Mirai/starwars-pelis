package com.alura.cursos.modelos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GuardarPelicula {
    //Metodo para guardar las peliculas
    public void guardarPeliculaJson(List<Pelicula> miListaStarWars, String nombre) throws IOException {
//vamos a generar un objeto de la clase Gson con formato pretty para poder ver el archivo en formato bonito
// luego generamos un FileWriter para guardar el archivo
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        //Creo el archivo con extensión json
        FileWriter archivo = new FileWriter(nombre + ".json");
        //Convierto a json la lista de peliculas y coloco el nombre
        //archivo.write(gson.toJson(miListaStarWars, archivo));
        //gson.toJson(miListaStarWars, archivo);
        archivo.write(gson.toJson(miListaStarWars));
        //cierro la instacia de archivo (FileWriter)
        archivo.close();

        System.out.println("Las peliculas de star wars se guardaron en el archivo: " + nombre + ".json");


    }
}
