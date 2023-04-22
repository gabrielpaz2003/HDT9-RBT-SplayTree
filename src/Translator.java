import java.util.ArrayList;

/**
 * UNIVERSIDAD DEL VALLE DE GUATEMALA
 * ALGORITMOS Y ESTRUCTURA DE DATOS
 * @author GABRIEL ALBERTO PAZ GONZALEZ 221087
 * @version 1.0
 * @date 20/04/2023
 * @source Clase Translator
 * 
 */

public class Translator {
    /***
     * Traductor para el texto que se reciba del archivo
     * @param stock almacen de palabras
     * @param text traduccion a realizar
     * @return traduccion
     */
    public String Calculo(String text,IMaping stock){
        
        String[] textSplit = text.replace(".","").toLowerCase().split(" ");
        ArrayList<String> Sequence = new ArrayList<String>();
        String translation = "";

        for (int n = 0; n <textSplit.length; n++) {

            Sequence.add(String.valueOf(textSplit[n]));
        }

        for (int i = 0; i < Sequence.size(); i++){
            if(Sequence.get(i).equals(" ")){
                Sequence.remove(i);
            }
        }
        for (int j =0;j<Sequence.size();j++){
            if (stock.search(Sequence.get(j))==true){
                String prueba = (String) (stock.get(Sequence.get(j)));
                translation = translation + prueba+" ";
            }else{
                translation = translation +"*"+Sequence.get(j)+"*"+" ";
            }
        }
        return translation;
    }
}
