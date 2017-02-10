import java.util.ArrayList;
/**
 * Write a description of class Persona here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
class Persona {
    private String name;
    private boolean isHombre;
    private int peso;
    private int altura;
    private int edad;
    private int caloriasTotales;// suma las calorias de varias comidas.

    private String nameComidaMasCalorica; // nombre de la comida con más calorias.
    private Comida comidaCalorica;

    private ArrayList<Comida> comidas;//almacena todas las comidas en el mt comer().

    public Persona(String name, boolean isHombre, int peso, int altura, int edad) {
        this.name = name;
        this.isHombre = isHombre;
        this.peso = peso;
        this.altura = altura;
        this.edad = edad;
        caloriasTotales = 0;

        nameComidaMasCalorica = "";
        comidaCalorica = null; // la doy valor en  el mt comer().

        comidas = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public boolean isIsHombre() {
        return isHombre;
    }

    public int getPeso() {
        return peso;
    }

    public int getAltura() {
        return altura;
    }

    public int getEdad() {
        return edad;
    }

    /**
     *El metódo que se utiliza para dar de comer a la persona debe denominarse comer,
     *debe permitir 1 único parámetro de tipo comida y debe devolver un entero consistente
     *en las calorias ingeridas en esa comida en caso de que la persona la coma o -1
     *en caso de que no la coma.
     */
    public int comer(Comida comida){
        comidas.add(comida);

        comidaCalorica = new Comida(comida.getNameComida(), comida.getCaloriasPorComida());        
        if(comida.getCaloriasPorComida() >= comidaCalorica.getCaloriasPorComida()){
            comidaCalorica = comida; // de esta manera el atributo 'Comida comidaCalorica' almacena siempre la comida con más calorías;
            nameComidaMasCalorica = comidaCalorica.getNameComida();// útil para poder ejecutar el mt getAlimentoMasCaloricoConsumido();
        }                           

        int caloriasInge = -1;
        if(caloriasTotales <= calculoMetabolismoBasal()){
            caloriasInge = comida.getCaloriasPorComida();
            caloriasTotales = caloriasTotales + caloriasInge; // suma las calorias de varias comidas.
        }
        else{
            System.out.println("No quiero comer más gracias.");
        }
        return caloriasInge;
    }

    /**
     * El método que permite saber la cantidad de calorias que lleva ingerida una persona 
     * se denomina getCaloriasIngeridas, no admite parámetros y devuelve un entero
     */
    public int getCaloriasIngeridas(){       
        return caloriasTotales;
    }

    /**
     *
     */
    public int calculoMetabolismoBasal(){
        int total = 0;
        if(isHombre == true){
            total = (10 * peso) + (6 * altura) + (5 * edad) + 5;
        }
        else{
            total = (10 * peso) + (6 * altura) + (5 * edad) - 161;
        }
        return total;
    }

    /**
     * Ahora queremos que sea posible preguntarle cosas a la persona. Si no ha sobrepasado 
     * su metabolismo basal, te contestará "SI" o "NO" (¡en mayúsculas!) dependiendo de si 
     * la pregunta tiene una longitud (es decir, el número de letras de la misma) 
     * divisible por 3 o no, respectivamente.

     *En caso de que la persona ya haya sobrepasado el metabolismo basal o en el caso de 
     *que tu pregunta contenga el nombre de la persona, responderá con la misma pregunta 
     *que le has hecho pero gritando (es decir, el mismo texto de la pregunta pero
     *en mayúsculas) indiferentemente de la longitud de a pregunta.
     *
     * El método que se utiliza para preguntar cosas a la persona debe llamarse 
     * contestar, admite un único parámetro y debe devolver la respuesta además
     * de imprimirla por pantalla.
     */
    public String contestar(String pregunta){
        String respuesta = pregunta;

        if (pregunta.contains(this.name) || ( getCaloriasIngeridas() > calculoMetabolismoBasal())){
            respuesta = respuesta.toUpperCase();
        }
        else {

            if(pregunta.length() % 3 == 0){
                respuesta = "SI";
            }
            else{
                respuesta = "NO";
            }

        }
        System.out.println(respuesta);    
        return respuesta;
    }

    /**
     * Se pide que implementes el código necesario para disponer de un método llamado getAlimentoMasCaloricoConsumido
     * que imprima por pantalla y que devuelva el nombre de la comida más calórico ingerida hasta ahora por un usuario.

     *En caso de que la persona no haya comido nada el método infoma por pantalla de tal situación y devuelve null. 
     * En caso de que haya empate entre dos o más comidas, imprime y devuelve la última de ellas.
     */
    public String getAlimentoMasCaloricoConsumido() {
        caloriasTotales = 0;// ponemos las calorías acumuladas a 0, para que funcione la clase test.
        String nameComida = null;
        if (comidaCalorica != null) {
            //nameComidaMasCalorica, es un atributo que va almacenando el nombre de la comida más calórica dentro del mt comer().
            nameComida = nameComidaMasCalorica;
            System.out.println("Alimento más calórico.- " + nameComida);
        }
        else{
            System.out.println("No ha tomado ninguna comida.");
        }
        return nameComida;
    }

    //     /**
    //      * imprime por pantalla la lista de comidas ingeridas ordenadas de mayor a menor valor calórico
    //      */
    //         public void verListadoComidasIngeridas() {
    //         if (caloriasTotales > 0) {
    //             int cont = 0;
    //             while (cont < comidas.size()) {
    //                
    //                 boolean encontrado = false;
    //                 int totalComidas = 0;
    //                  //Comida aux = new Comida("frejoles", 0);
    //                 while ( totalComidas < comidas.size() && !encontrado) {
    //                     if(comidas.get(totalComidas).getCaloriasPorComida() >= aux.getCaloriasPorComida()){
    //                         aux = comidas.get(totalComidas);
    //                         indiceMasCalorias = aux.getCaloriasPorComida();
    //                     }
    //                     totalComidas ++;
    //                 }
    //                 
    //                 //comidas.remove( indiceMasCalorias);
    //                 System.out.println( (cont +1)+ " " +aux);
    //                 indiceMasCalorico2();
    //                 cont ++;
    //             }           
    //         } else {
    //             System.out.println("No ha tomado ninguna comida.");
    //         }
    //         System.out.println("");
    //     }
}





