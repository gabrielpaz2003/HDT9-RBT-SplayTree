/***
 * UNIVERSIDAD DEL VALLE DE GUATEMALA
 * ALGORITMOS Y ESTRUCTURA DE DATOS
 * @author GABRIEL ALBERTO PAZ GONZALEZ 221087
 * @version 1.0
 * @date 21/04/2023
 * @source Interfaz IMaping
 */
public interface IMaping <K,V> {
    /**
     * agregar add
     * @param <K> Tipo de dato a almacenar como llave
     * @param <V> Tipo de dato a almacenar como valor
     */
    void add(K key, V value);

    /**
     * obtener get
     * @param key llave con valor a obtener
     * @return llave y valor
     */
    V get(K key);

    /**
     * buscar search
     * @param key llave a buscar
     * @return true or false
     */
    boolean search (K key);
}
