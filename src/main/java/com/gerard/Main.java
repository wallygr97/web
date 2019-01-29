package com.gerard;

import java.util.ArrayList;
import java.util.Scanner;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


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
        int cantGET = doc.select("form[method='GET']").size();
        int canPOST = doc.select("form[method='POST']").size();


        Elements Form = doc.select("form");

        ArrayList<Elements> inputs = new ArrayList<Elements>();

        for (Element form : Form) {
            inputs.add(form.getElementsByTag("input"));
        }


         //punto 1
        System.out.println("la cantidad de linea que tiene la url son: "+ cantLineas + "\n");
        //punto 2
        System.out.println("la cantidad de parrafos que tiene son: "+ cant_Parrafos +"\n");
        //punto 3
        System.out.println("la cantidad de imagen en los parrafos son: "+ cantImgParrafos + "\n");
        //punto 4
        System.out.println("la cantidad de metodo GET que tiene el doc HTML son: "+ cantGET);
        System.out.println("la cantidad de metodo POST que tiene el doc HTML son: "+ canPOST);
        //punto 5
        System.out.println("la cantidad de elemento de tipo input que tiene el doc HTML son: "+ inputs.size() +"\n");



    }
}