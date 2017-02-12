import java.util.ArrayList;
import java.util.Random;
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

    private int numMaxCalorias; //--------------------------------------------para hacer una comprobación.

    private String nameComidaMasCalorica; // nombre de la comida con más calorias.
    private Comida comidaCalorica;

    private ArrayList<Comida> comidas;//almacena todas las comidas en el mt comer().

    public static String[] COMENSALES = {"Juán", "Francisco Javier", "Lorenzo", "Israel", "Cristian", "Ricardo", "Emilio", "José Ricardo",
            "Luis Enrique", "Luis Federico", "Mario", "Nasrrudín", "José Manuel", "Aquiles", "Merquiades", "Francisco José",
            "Narciso", "Gregorio", "Isidoro", "Blas", "Fulgencio",
            "Salusitano", "Fermín", "Amancio"};
    public static String[] COMENSALAS = {   "Raquel", "María", "Milagros", "Eva Carmina", "Jacinta", "Esther", "Ángela", "Elena",
            "Gemma", "María de las Mercedes", "María Angeles", "Rafaela"};

    public static String[] NOMBRES_COMIDAS = {"Cocido", "Langostinos", "Paella", "Espaguetis", "Pollo", "Ensalada", "Sardinas",
            "Estofado", "Chuletas", "Patatas con carne", "Pulpo al ajillo", "Lacón", "Jamón"};

    public Persona(String name, boolean isHombre, int peso, int altura, int edad) {
        this.name = name;
        this.isHombre = isHombre;
        this.peso = peso;
        this.altura = altura;
        this.edad = edad;
        caloriasTotales = 0;

        nameComidaMasCalorica = "";
        comidaCalorica = new Comida("  ", -1); // para comparar con la comida más calórica.

        comidas = new ArrayList<>();

    }

    /////////////////////////////////////////////// *******************************  /////////////////////////////////////////
    /**
     * Constructor. Dá valor de forma aleatoria a los atributos, (...).
     */
    public Persona() {
        Random ale = new Random();
        int valor = ale.nextInt();
        boolean siOno = ale.nextBoolean();

        isHombre = siOno;        
        name = Aleatorio();

        peso = ale.nextInt(123) +59;
        altura = ale.nextInt(80) +123;
        edad = ale.nextInt(50) +13;
        caloriasTotales = 0;

        nameComidaMasCalorica = "";
        comidaCalorica = new Comida("  ", -1); // para comparar con la comida más calórica.

        comidas = new ArrayList<>();
        numMaxCalorias = 0;//--------------------------------------------para hacer una comprobación.
    }
    ////////////////////////////////////////////////////// **************************** //////////////////////////////////////

    /**
     * Serie de mt geters, devuelven el valor actual de los atributos.
     */
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

        if( comida.getCaloriasPorComida() >= comidaCalorica.getCaloriasPorComida()){
            comidaCalorica = comida; // de esta manera el atributo 'Comida comidaCalorica' almacena siempre la comida con más calorías;
            nameComidaMasCalorica = comidaCalorica.getNameComida();// útil para poder ejecutar el mt getAlimentoMasCaloricoConsumido();
        }

        comidas.add(comida);
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

    /**
     * imprime por pantalla la lista de comidas ingeridas ordenadas de mayor a menor valor calórico
     */
    public void verListadoComidasIngeridas() {
        System.out.println(" ************ COMIDAS POR ORDEN DE CALORIAS ************** ");
        System.out.println(" ");
        String nombre = name;
        System.out.println("Nombre del cliente.- " +nombre);
        /////////////////////*************************************BUCLE BURBUJA.
        boolean encontrado = false;
        while( !encontrado ){
            encontrado = true;
            int cont = 0;
            while( cont <  (comidas.size() -1) ){
                if( comidas.get(cont).getCaloriasPorComida() < comidas.get(cont +1).getCaloriasPorComida() ){
                    encontrado = false;
                    Comida aux =  comidas.get(cont);
                    comidas.set(cont, comidas.get(cont +1));
                    comidas.set(cont +1, aux);
                }
                cont ++;
            }
        }
        for(Comida comidas: comidas){
            System.out.println(" " +comidas);            
        }
        System.out.println("=============================");
        System.out.println(" ");
    }

    /**
     * imprime por pantalla la lista de comidas ingeridas ordenadas de mayor a menor valor calórico
     */
    public Comida[] verListadoComidasIngeridas2() {
        Comida[] comidaArray = new Comida[comidas.size()];//---VL para devolver

        if(caloriasTotales > 0){
            System.out.println(" ************ COMIDAS POR ORDEN DE CALORIAS ************** ");
            System.out.println(" ");
            String nombre = name;
            System.out.println("Nombre del cliente.- " +nombre);
            /////////////////////*************************************BUCLE BURBUJA.
            boolean encontrado = false;
            while( !encontrado ){
                encontrado = true;
                int cont = 0;
                while( cont <  (comidas.size() -1) ){
                    if( comidas.get(cont).getCaloriasPorComida() < comidas.get(cont +1).getCaloriasPorComida() ){
                        encontrado = false;
                        Comida aux =  comidas.get(cont);
                        comidas.set(cont, comidas.get(cont +1));
                        comidas.set(cont +1, aux);
                    }
                    cont ++;
                }
            }
            for(int i = 0; i < comidas.size(); i ++){
                comidaArray[i] = comidas.get(i);; 
                System.out.println(i+ " " +comidas.get(i));            
            }
            System.out.println("=============================");
            System.out.println(" ");
        }
        else{
            System.out.println( name+ " ________ está esperando por la 1º comida!!!");
            System.out.println("=============================");
        }
        return comidaArray;
    }

    ////////////////////////// **************************************************************** //////////////////////////////
    //--------- MÉTODOS PARA FACILITAR EL DESARROLLO DE LA CODIFICACIÓN, ¡¡¡NADA QUE VER CON LO QUE SE PIDE. 
    ////////////////////////// **************************************************************** //////////////////////////////

    public void yVerComidas() {
        if(caloriasTotales > 0){
            String nombre = name;
            System.out.println(" ************ COMIDAS ************** ");
            System.out.println(" ");
            System.out.println("Nombre del cliente.- " +nombre);
            int cont = 1;
            for(Comida comidas: comidas){
                System.out.println(cont+ " .-  " +comidas);
                cont ++;
            }
            System.out.println(" " );
            System.out.println("Total de calorias tomadas.-  ________________ " +caloriasTotales+ " calorías.");
            System.out.println("=============================");
            System.out.println(" " );
        }
        else{
            System.out.println("No se ha comido!!! " );
            System.out.println(" " );
        }

        System.out.println("");
        System.out.println("Datoe de " +name+ ".-\n " + yToString());
        System.out.println("_____________________________________________");
    }

    /**
     * mt para asignar un nombre al comensal, de forma
     * aleatoria.------------------------------------------------- 11
     */
    private String Aleatorio() {
        Random ale = new Random();
        boolean encontrado = false;

        int caloriasInge = -1;
        while (!encontrado) {
            if(isHombre == true){
                // VL almacena un nº aletorio entre 0 y el nº de elementos de Array.
                int aux = ale.nextInt(COMENSALES.length);
                if (COMENSALES[aux] != null) {
                    name = COMENSALES[aux];
                    COMENSALES[aux] = null;
                    encontrado = true;
                }
            }
            else{
                // VL almacena un nº aletorio entre 0 y el nº de elementos de Array.
                int auxMujer = ale.nextInt(COMENSALAS.length);
                if (COMENSALES[auxMujer] != null) {
                    name = COMENSALAS[auxMujer];
                    COMENSALAS[auxMujer] = null;
                    encontrado = true;
                }
            }
        }
        return name;
    }

    /**
     * crea de forma aleatoria el nº de comidas pasadas por parámetro. Indique por parámetro el nº de comidas.
     */
    public int yComer2(int numComidas){
        if(numComidas > NOMBRES_COMIDAS.length){
            numComidas = NOMBRES_COMIDAS.length -1;
        }
        int caloriasInge = -1;
        int cont = 0;
        while(cont < numComidas){
            Random ale = new Random();
            String nameComida = creaNombreAleatorioDeComida();
            int calorias = ale.nextInt(352) + 76;

            Comida comida = new Comida(nameComida, calorias);
            comidas.add(comida);

            if( comida.getCaloriasPorComida() >= comidaCalorica.getCaloriasPorComida()){
                comidaCalorica = comida; // de esta manera el atributo 'Comida comidaCalorica' almacena siempre la comida con más calorías;
                nameComidaMasCalorica = comidaCalorica.getNameComida();// útil para poder ejecutar el mt getAlimentoMasCaloricoConsumido();
            }                           

            if(caloriasTotales <= calculoMetabolismoBasal()){
                caloriasInge = comida.getCaloriasPorComida();
                caloriasTotales = caloriasTotales + caloriasInge; // suma las calorias de varias comidas.
            }
            else{
                System.out.println("No quiero comer más gracias.");
            }
            cont ++;
        }

        return caloriasInge;
    }

    /**
     * mt para asignar un nombre a la comida, de forma
     * aleatoria.-----------------------------------------------
     */
    private String creaNombreAleatorioDeComida() {
        Random ale = new Random();
        String nameComida = "";
        boolean encontrado = false;
        while (!encontrado) {
            // VL almacena un nº aletorio entre 0 y el nº de elementos de Array.
            int aux = ale.nextInt(NOMBRES_COMIDAS.length);
            if (NOMBRES_COMIDAS[aux] != null) {
                nameComida = NOMBRES_COMIDAS[aux];
                encontrado = true;
                NOMBRES_COMIDAS[aux] = null;
            }
        }
        return nameComida;
    }

    public String yToString(){
        String sexo = "varón.";
        if(isHombre == false){
            sexo = "femenino.";
        }
        return "sexo.-" +sexo+  ", peso.- " +peso+ ", estatura.- " +altura+ " cm, edad.- " +edad+ 
        " años.\n Calorías totales comidas.- " +caloriasTotales+ ", Comida más calórica.- " +nameComidaMasCalorica+
        ".\n metabolismo basal.- " +calculoMetabolismoBasal()+ " caclorías. " ;

    }

    public int yCaloriasDelMasCalorico(){
        int valor = 0;
        if(comidaCalorica != null){
            valor = comidaCalorica.getCaloriasPorComida();
        }
        return valor;
    }

    public String yNombreDelMasCalorico(){
        String valor = "";
        if(comidaCalorica != null){
            valor = comidaCalorica.getNameComida();
        }
        return valor;
    }
}

