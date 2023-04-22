import structure5.*;
/***
 * UNIVERSIDAD DEL VALLE DE GUATEMALA
 * ALGORITMOS Y ESTRUCTURA DE DATOS
 * @author GABRIEL ALBERTO PAZ GONZALEZ 221087
 * @version 1.0
 * @date 21/04/2023
 * @source Clase Factory
 * 
 * @param <K> Tipo de dato a almacenar como llave
 * @param <V> Tipo de dato a almacenar como valor
 */


public class Factory <K,V>{
    /**
     * Devuelve la implementacion seleccionada
     * @param option seleccion de la implementacion
     * @return IMaping implementacion seleccionada
     */
    public IMaping<K,V> getStack(int option){
        if(option==1){
            System.out.println("Se selecciono HashMap");
            return new HashingMap();
            

        }else if(option==2){
            System.out.println("Se selecciono Red Black Tree");
            return new RedBlackTree();
        }
        else if(option==3){
            System.out.println("Se selecciono Splay Tree");
            return new SplayTree();
        }
        return null;
    }
}