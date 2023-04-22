import java.util.Scanner;
import java.util.Vector;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/***
 * UNIVERSIDAD DEL VALLE DE GUATEMALA
 * ALGORITMOS Y ESTRUCTURA DE DATOS
 * @author GABRIEL ALBERTO PAZ GONZALEZ 221087
 * @version 1.0
 * @date 21/04/2023
 * @source Clase Main
 */

public class Main {
    public static void main(String[]args){

        /**
         * Se crea un Factory para seleccionar la implementación y se crea un stock para las palabras
         */

        Scanner scanner = new Scanner(System.in);
        Factory<String,String> factory = new Factory<String,String>();
        IMaping stack;

        /**
         * Se crea un vector para almacenar las palabras a traducir y se crea un traductor
         */
        
        Translator translate = new Translator();
        Vector <String> mixed = new Vector<String>();

        /**
         * Muestra el menu de opciones para el usuario donde puede seleccionar la implementación
         */

        System.out.println("---------------------------------------- ");
        System.out.println("------- DEL VALLE TRANSLATOR ----------- ");
        System.out.println("---------------------------------------- ");
        System.out.println("Seleccione la implementacion que desea utizar para el stack: ");
        System.out.println("- 1 HashMap. -");
        System.out.println("- 2 Red Black Tree RBT. -");
        System.out.println("- 3 Splay Tree. -");
        System.out.println("---------------------------------------- ");

        int option = 0;
        while(true){
            try{
                option = scanner.nextInt();

                if(option>=1 && option<=3){
                    break;
                }else{
                    System.out.println("Porfavor ingrese opciones que se encuentren en el menu.");
                }
            }catch(Exception e){
                System.out.println("Porfavor ingrese unicamente numeros del 1-3.");
            }
        }

        /**
         * Se crea el stack dependiendo de la implementación seleccionada
         */


        stack = factory.getStack(option);

        /**
         * Se lee el archivo Spanish.txt y se almacena en el stack
         */

        try{
            File file = new File("Spanish.txt");
            Scanner input = new Scanner (file);
            while(input.hasNextLine()){
                String dato = input.nextLine();
                String[] parts = dato.split("\\s+");
                String key = "";
                String value = "";
                if(parts.length<=2){
                    key = parts[0];
                    value = parts[1];
                }else{
                    key = parts[0];
                    value = parts[2];
                }

                stack.add(key,value);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }

        /***
         * Se lee el archivo texto.txt y se almacena en un vector (mixed)
         * Se lee linea por linea y se almacena en el vector
         */

        try{
            FileReader reader = new FileReader("texto.txt");
            BufferedReader buffer = new BufferedReader(reader);

            String temp ="";

            while(temp!=null){
                temp = buffer.readLine();
                if(temp == null){
                    break;
                }
                mixed.add(temp);

            }
        }catch(Exception e){
            System.out.println("File not found.");
        }

        /**
         * Se muestra el texto original y el texto traducido
         * Se traduce cada palabra del archivo .txt
         */

        int i = 0;
        while(i<mixed.size()){
            try{
                System.out.println(" - ORIGINAL: "+mixed.get(i) +" ");
                System.out.println(" - TRANSLATED: "+translate.Calculo(mixed.get(i),stack) +" ");
                System.out.println();

            }catch(Exception e){
                System.out.println("Error, no se pudo traducir la oracion.");
                System.out.println();

            }
            i++;
        }
    }
}
