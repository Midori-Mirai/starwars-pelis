package com.alura.cursos.modelos;

//importar JAR

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaPeliculaSwapi {
    int busqueda;
    //metodo para consultar la pelicula de star wars
    public PeliculaSW obtenerPelicula(int busqueda){
        this.busqueda = busqueda;
        //String direccion = "https://swapi.py4e.com/api/films/"+busqueda+"/";
        //otra forma de hacerlo es:
        URI direccion = URI.create("https://swapi.py4e.com/api/films/"+busqueda+"/");

        HttpClient client = HttpClient.newHttpClient();//crea el cliente
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion) //.uri(URI.create(direccion))
                .build();//Prepara el envio

         //envia con el request
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Código de estado: " + response.statusCode());
            String json = response.body();
            System.out.println("json: " + json);

            Gson gson = new GsonBuilder()
                    .create();
            PeliculaSW miPeliculaSW = gson.fromJson(json, PeliculaSW.class);
            //System.out.println("De consulta pelicula SW: " + miPeliculaSW);
            return miPeliculaSW;
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }



    }
}
