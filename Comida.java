
/**
 * Write a description of class Comida here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
class Comida {
    private String nameComida;
    private int caloriasPorComida;

    public Comida(String nameComida, int caloriasPorComida) {
        this.nameComida = nameComida;
        this.caloriasPorComida = caloriasPorComida;
    }

    public String getNameComida() {
        return nameComida;
    }

    public int getCaloriasPorComida() {
        return caloriasPorComida;
    }
    
    
}