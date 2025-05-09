package com.alura.cursos.modelos.principal;

import com.alura.cursos.modelos.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner entrada = new Scanner(System.in);
        String busqueda;
        String nombreArchivo;
        ConsultaPeliculaSwapi consultar = new ConsultaPeliculaSwapi();
        AdaptadorSwapiPelicula adaptador = new AdaptadorSwapiPelicula();
        GuardarPelicula guardar = new GuardarPelicula();
        List<Pelicula> miListaStarWars = new ArrayList<>();

        while(true){
            System.out.println("Escribe el número de pelicula de Star Wars " +
                    "que quieres consultar (1 - 7), escribe 0, para salir: ");
            busqueda = entrada.nextLine();

            if(busqueda.equalsIgnoreCase("bye")){
                break;
            }
            try {
                PeliculaSW miPeliculaSW = consultar.obtenerPelicula(Integer.valueOf(busqueda));
                //System.out.println("Datos de la pelicula: " + miPelicula);
                Pelicula miPelicula = adaptador.adaptadorSwapiAPelicula(miPeliculaSW);
                System.out.println("Pelicula convertida: " + miPelicula);
                miListaStarWars.add(miPelicula);
            } catch (NumberFormatException e){
                System.out.println("ocurrio un error de número: " + e.getMessage());
                System.out.println("+++++++++++++++La aplicación finalizó+++++++++++++++");
            } catch (IllegalArgumentException e) {
                System.out.println("Ocurrrio un error argumento: " + e.getMessage());
                System.out.println("+++++++++++++++La aplicación finalizó+++++++++++++++");
            }catch (NullPointerException e){
                System.out.println("Error la pelicula no existe: " + e.getMessage());
                System.out.println("+++++++++++++++La aplicación finalizó+++++++++++++++");
            }

        }
        //entrada.nextLine();
        System.out.println(miListaStarWars);
        System.out.println("Como quieres que tu archivo se llame: ");
        nombreArchivo = entrada.nextLine();
        guardar.guardarPeliculaJson(miListaStarWars,nombreArchivo);
    }
}
