package com.diana;

import java.awt.*;
import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*Cambiar el nombre de la carpeta ‘Documentos’ a ‘DOCS’, el de la carpeta ‘Fotografias’ a
          ‘FOTOS’ y el de la carpeta ‘Libros’ a ‘LECTURAS’*/


        //Ruta y nombre inicial
        File documentos = new File("C:\\Users\\DAW\\Desktop\\Ejercicio3_Ficheros\\Documentos");
        //La misma ruta (porque no lo queremos cambiar de sitio) pero con un nuevo nombre
        File DOCS = new File("C:\\Users\\DAW\\Desktop\\Ejercicio3_Ficheros\\DOCS");

        File fotografias = new File("C:\\Users\\DAW\\Desktop\\Ejercicio3_Ficheros\\DOCS\\Fotografias");
        File FOTOS = new File("C:\\Users\\DAW\\Desktop\\Ejercicio3_Ficheros\\DOCS\\FOTOS");

        File libros = new File("C:\\Users\\DAW\\Desktop\\Ejercicio3_Ficheros\\DOCS\\Libros");
        File LECTURAS = new File("C:\\Users\\DAW\\Desktop\\Ejercicio3_Ficheros\\DOCS\\LECTURAS");


        //Utilizo un boolean renameTo para cambiar los nombres de las carpetas

        boolean renombrar = documentos.renameTo(DOCS);
        System.out.println("Se ha renombrado la carpeta Documentos? " + renombrar);

        renombrar = fotografias.renameTo(FOTOS);
        System.out.println("Se ha renombrado la carpeta Fotografias?" + renombrar);

        renombrar = libros.renameTo(LECTURAS);
        System.out.println("Se ha renombrado la carpeta Libros? " + renombrar);


        /*Cambiar el nombre de todos los archivos de las carpetas FOTOS y LECTURAS quitándole la
        extensión. Por ejemplo, ‘astronauta.jpg’ pasará a llamarse ‘astronauta’.*/

        //Consultar el contenido de las carpetas con un vector de tipo File
        File[] archivosFOTOS = FOTOS.listFiles();
        File[] archivosLECTURAS = LECTURAS.listFiles();

        //-------------------------------------------
        //----------QUITAR EXTENSION-----------------
        System.out.println(" ");
        System.out.println("Borramos la extension: ");
        System.out.println(" ");
        deleteExtension(archivosFOTOS);
        deleteExtension(archivosLECTURAS);

        System.out.println(" ");
        System.out.println("-------------------------------");
        System.out.println(" ");


        //-------------------------------------------
        //----------ANADIR EXTENSION-----------------
        File[] archivosFOTOS2 = FOTOS.listFiles();
        File[] archivosLECTURAS2 = LECTURAS.listFiles();

        System.out.println("Volvemos a anadir la extension: ");
        System.out.println(" ");
        addExtension(archivosFOTOS2, ".jpg");
        addExtension(archivosLECTURAS2, ".txt");

        System.out.println(" ");
        System.out.println("That's all folks!");
    } //--------FIN MAIN---------------------


    //---------------------------------------------
    //-----------METODO REMOVE EXTENSION-----------
    public static String helpRemoveExtension(String fileName) {
        if (fileName.indexOf(".") > 0) {
            return fileName.substring(0, fileName.lastIndexOf("."));
        } else {
            return fileName;
        }
    }
    //-------------------------------------------
    //----------METODO QUITAR EXTENSION-----------------

    public static void deleteExtension(File[] archivos) {

        for (int i = 0; i < archivos.length; i++) {
            File f = archivos[i];

            String noExtension = helpRemoveExtension(f.getAbsolutePath());
            File nuevoNombre = new File(noExtension);

            if (f.isFile()) {
                boolean renombrar = f.renameTo(nuevoNombre);
                System.out.println("Nombre de archivo SIN EXTENSION: " + nuevoNombre.getName());
            }
        }
    }


    //---------------------------------------------
    //-----------METODO ANADIR EXTENSION-----------

    public static void addExtension(File[] archivos, String extension) {

        for (int i = 0; i < archivos.length; i++) {
            File l = archivos[i];

            String newName = l.getAbsolutePath() + extension;
            File nuevoNombre = new File(newName);

            if (l.isFile()) {
                boolean renombrar = l.renameTo(nuevoNombre);
                System.out.println("Nombre de archivo CON EXTENSION: " + nuevoNombre.getName());
            }
        }
    }
}
