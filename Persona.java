
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
}











