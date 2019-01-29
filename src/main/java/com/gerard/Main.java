package com.gerard;

import java.util.Scanner;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{

        System.out.println("introduzca la URL: "); // esta parte es para leer la url y conectarse con a la direccion de url introducida
        Scanner leer = new Scanner(System.in);
        String url = leer.next();
        Connection.Response lineasPagina = Jsoup.connect(url).execute();//conectarse a la pagina y ejecutar la conexion

        String cuerpo = lineasPagina.body();
        int cantLineas = cuerpo.split("\n").length;

        Document doc = Jsoup.connect(url).get();//consigue el documento html de la pagina y se conecta a ella
        int cant_Parrafos = doc.getElementsByTag("p").size();// te da el size de la cantidad de parrafos que tiene
        int cantImgParrafos = doc.select("p img").size();// busca dentro de los parrafos todas las imagenes y nos da los size

         //punto 1
        System.out.println("la cantidad de linea que tiene la url son: "+ cantLineas + "\n");
        //punto 2
        System.out.println("la cantidad de parrafos que tiene son: "+ cant_Parrafos +"\n");
        //punto 3
        System.out.println("la cantidad de imagen en los parrafos son: "+ cantImgParrafos + "\n");

    }
}