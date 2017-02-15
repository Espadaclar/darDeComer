import java.util.ArrayList;
import java.util.Random;
/**
 * Write a description of class Prueba here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Prueba
{
    private ArrayList<Integer> numeros;
    private ArrayList<Integer> numeros2;
    private ArrayList<Integer> numeros3;
    private int indiceDelMayor;
    private int valorDelMayor;
    private int valorDelMenor;

    public static final int CANTIDAD_NUMEROS = 13;
    public static final int NUMEROS_ALEATORIOS = 121;
    /**
     * Constructor for objects of class Prueba
     */
    public Prueba() {
        numeros = new ArrayList<>();
        numeros2 = new ArrayList<>();
        numeros3 = new ArrayList<>();
    }

    public void mostrarArrayList(){
        Random ale = new Random();
        for(int i = 0; i < CANTIDAD_NUMEROS; i ++){
            int  numAleatorio = ale.nextInt(NUMEROS_ALEATORIOS);
            numeros.add(numAleatorio);   
            numeros2.add(numAleatorio);
        }
        int indiceLento = numeros2.size();
        int cont = 0;   

        while(cont < indiceLento){             
            valorDelMayor = 0;
            indiceDelMayor = 0;
            valorDelMenor = 0;
            for(int i = 0; i < numeros2.size(); i ++){
                if(numeros2.get(i) > valorDelMayor){
                    indiceDelMayor = i;
                    valorDelMayor = numeros2.get(indiceDelMayor);
                }
            } 
            numeros3.add(valorDelMayor);
            numeros2.remove(indiceDelMayor);     

            valorDelMayor = numeros3.get(0);
            valorDelMenor = numeros3.get(numeros3.size() -1);
            cont ++;
        }
        System.out.println("Números dentro del ArrayList numeros.-");
        System.out.println(numeros);
        System.out.println("Dentro del ArrayList  numeros2, copiamos los numeros del"); 
        System.out.println("ArrayList numeros, selecionamos el mayor, lo paso al ArrayList");
        System.out.println("numeros3, y lo borro del numeros2, quedando éste vacío.-");

        System.out.println(numeros2);
        System.out.println("Números dentro del ArrayList  numeros3, ordenados descendentemente.-");
        System.out.println(numeros3);
        System.out.println("");
        System.out.println("Valor del mayor de los números ==========.- " +valorDelMayor);
        System.out.println("Valor del MENORRR de los números ========.- " +valorDelMenor  );
        System.out.println("__________________________________");
        System.out.println("");

        numeros.clear();
        numeros2.clear();
        numeros3.clear();
    }

    public void mostrarArrayListBurbuja(){
        Random ale = new Random();
        for(int i = 0; i < CANTIDAD_NUMEROS; i ++){
            int  numAleatorio = ale.nextInt(NUMEROS_ALEATORIOS);
            numeros.add(numAleatorio);   
            numeros2.add(numAleatorio);
        }

        boolean encontrado = false;

        while(!encontrado){
            encontrado = true;

            for(int i = 0; i < numeros2.size() -1; i ++){
                int valorMayor = 0;
                if(numeros2.get(i) < numeros2.get(i +1)){
                    encontrado = false;
                    Integer valorMenor = numeros2.get(i);
                    valorMayor = numeros2.get(i +1);
                    numeros2.set(i, valorMayor);
                    numeros2.set(i +1, valorMenor);
                }

            }

        }

        System.out.println("Números dentro del ArrayList numeros.-");
        System.out.println(numeros);
        System.out.println("Números ordenados descendentemente dentro del ArrayList numeros2.-");
        System.out.println(numeros2);
        System.out.println("__________________________________");
        System.out.println("");
        numeros.clear();
        numeros2.clear();
    }
}



