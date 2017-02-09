
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

    public Persona(String name, boolean isHombre, int peso, int altura, int edad) {
        this.name = name;
        this.isHombre = true;
        this.peso = peso;
        this.altura = altura;
        this.edad = edad;
        caloriasTotales = 0;
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
        int caloriasInge = -1;
        if(comida != null && caloriasTotales < calculoMetabolismoBasal()){
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
        int totalDeLetras = 0; // almacenará el nº total de letras que tine la pregunta.
        if( pregunta.contains(this.name) ){
            respuesta = respuesta.toUpperCase();
            System.out.println(respuesta.toUpperCase());
        }
        else if( getCaloriasIngeridas() > calculoMetabolismoBasal() ){
            respuesta = respuesta.toUpperCase();
            System.out.println(respuesta.toUpperCase());
        }
        else if(getCaloriasIngeridas() < calculoMetabolismoBasal()){
            int cadena = pregunta.length();
            if(cadena % 3 == 0){
                respuesta = "SI";
            }
            else{
                respuesta = "NO";
            }
            
        }
        return respuesta;
    }
}

