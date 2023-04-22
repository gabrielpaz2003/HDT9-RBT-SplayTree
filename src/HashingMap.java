import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * UNIVERSIDAD DEL VALLE DE GUATEMALA
 * ALGORITMOS Y ESTRUCTURA DE DATOS
 * @author GABRIEL ALBERTO PAZ GONZALEZ 221087
 * @version 1.0
 * @date 20/04/2023
 * @source Clase HashingMap
 * 
 * @param <K> Tipo de dato a almacenar como llave
 * @param <V> Tipo de dato a almacenar como valor
 */
public class HashingMap<K,V>implements IMaping<K,V> , Map{
    
    public HashMap<Object, Object> almacen;

    
    public HashingMap(){
        almacen = new HashMap<>();
    }

    /**
     * Agrega un valor al almacen
     * @param <K> Tipo de dato a almacenar como llave
     * @param <V> Tipo de dato a almacenar como valor
     */
    public void add(K key, V value) {
        almacen.put(key, value);

    }

    /**
     * verifica si se encuentra un valor
     * @param key valor a buscar
     * @return true o false dependiendo el resultado
     */

    public boolean search(K key) {
        return almacen.containsKey(key);
    }

    /**
     * retornar el largo
     * @return largo
     */
    public int size() {
        return almacen.size();
    }

    /**
     * verifica si es empty
     * @return
     */
    public boolean isEmpty() {
        return almacen.isEmpty();
    }

    /**
     * verifica si contiene una llave
     * @param key llave a buscar
     * @return true or false
     */
    public boolean containsKey(Object key) {
        return almacen.containsKey(key);
    }

    /**
     * verifica si contiene un valor
     * @param value valor a buscar
     * @return true or false
     */
    public boolean containsValue(Object value) {
        return almacen.containsValue(value);
    }

    /**
     * busca
     * @param key objeto a buscar
     * @return el objeto encontrado
     */
    public Object get(Object key) {
        return almacen.get(key);
    }

    /**
     * Put
     * @param key llave
     * @param value valor
     * @return encontrado
     */
    public Object put(Object key, Object value) {
        return almacen.put(key,value);
    }

    /**
     * Remove
     * @param key llave a remover
     * @return quitar el objeto
     */
    @Override
    public Object remove(Object key) {
        return almacen.remove(key);
    }

    /**
     * sustituyepor un mapa
     * @param m mapa a susstituir
     */
    @Override
    public void putAll(Map m) {
        almacen.putAll(m);

    }

    /**
     * limpia Hashing map
     */
    @Override
    public void clear() {
        almacen.clear();
    }

    /**
     * Regresa todas las llaves
     * @return las llaves
     */
    @Override
    public Set keySet() {
        return almacen.keySet();
    }

    /**
     * regresa los valores
     * @return valores
     */
    @Override
    public Collection values() {
        return almacen.values();
    }

    /**
     * Almacena, cambia
     * @return almacenar el entry
     */
    @Override
    public Set<Entry<Object,Object>> entrySet() {
        return almacen.entrySet();
    }
}
