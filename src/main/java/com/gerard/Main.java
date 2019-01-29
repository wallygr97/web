package com.gerard;

import java.util.Scanner;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException{

        System.out.println("introduzca la URL: "); // esta parte es para leer la url y conectarse con a la direccion de url introducida
        Scanner leer = new Scanner(System.in);
        String url = leer.next();
        Connection.Response lineasPagina = Jsoup.connect(url).execute();//conectarse a la pagina y ejecutar la conexion

        String cuerpo = lineasPagina.body();
        int cantLineas = cuerpo.split("\n").length;


        System.out.println("la cantidad de linea que tiene la url son: "+ cantLineas + "\n");

    }
}