


import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PersonaTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PersonaTest
{
    private Persona persona1;
    private Persona persona2;    
    private Comida comida1;
    private Comida comida2;
    private Comida comida3;
    private Comida comida4;
    private Comida comida5;
    
    private Comida comida6;
    private Comida comida7;
    /**
     * Default constructor for test class PersonaTest
     */
    public PersonaTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        persona1 = new Persona("Ana", false, 55, 160, 24);
        persona2 = new Persona("Luis", true, 92, 193, 37);
        comida1 = new Comida("Paella", 800);
        comida2 = new Comida("Pizza", 1200);
        comida3 = new Comida("Lentejas", 600);
        comida4 = new Comida("Cocido", 2000);
        comida5 = new Comida("Ensalada", 269);
        
        comida6 = new Comida("Pollo", 1200);
        comida7 = new Comida("Acelgas", 50);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }


    @Test
    public void TestCommit01()
    {
        // Ana...
        assertEquals(0, persona1.getCaloriasIngeridas());        
        // Come una pizza
        assertEquals(1200, persona1.comer(comida2));            
        assertEquals(1200, persona1.getCaloriasIngeridas());
        // Come una ensalada
        assertEquals(269, persona1.comer(comida5));              
        assertEquals(1469, persona1.getCaloriasIngeridas());    
        // Come una paella
        assertEquals(800, persona1.comer(comida1));             
        assertEquals(2269, persona1.getCaloriasIngeridas()); 
        // Come unas lentejas
        assertEquals(-1, persona1.comer(comida5));             
        assertEquals(2269, persona1.getCaloriasIngeridas()); 
        
        
        // Luis...
        assertEquals(0, persona2.getCaloriasIngeridas());
        // Come un cocido
        assertEquals(2000, persona2.comer(comida4));
        assertEquals(2000, persona2.getCaloriasIngeridas());
        // Come una ensalada
        assertEquals(269, persona2.comer(comida5));
        assertEquals(2269, persona2.getCaloriasIngeridas());
        // Come una pizza
        assertEquals(-1, persona2.comer(comida2));
        assertEquals(2269, persona2.getCaloriasIngeridas());
    }

    @Test
    public void TestCommit02()
    {
        assertEquals(0, persona1.getCaloriasIngeridas());
        assertEquals("NO", persona1.contestar("¿Te sientes bien?"));
        assertEquals("SI", persona1.contestar("¿Quieres comer?"));
        assertEquals("SI", persona1.contestar("¿Todo ok?"));  
        assertEquals("¿TE LLAMAS ANA?", persona1.contestar("¿Te llamas Ana?")); 
        assertEquals("NO", persona1.contestar("¿Te llamas Luis?"));         
        assertEquals(800, persona1.comer(comida1));
        assertEquals(800, persona1.getCaloriasIngeridas());        
        assertEquals("NO", persona1.contestar("¿Te sientes bien?"));
        assertEquals("SI", persona1.contestar("¿Quieres comer?"));  
        assertEquals("SI", persona1.contestar("¿Todo ok?"));   
        assertEquals("¿TE LLAMAS ANA?", persona1.contestar("¿Te llamas Ana?"));   
        assertEquals("NO", persona1.contestar("¿Te llamas Luis?"));          
        assertEquals(600, persona1.comer(comida3)); 
        assertEquals(1400, persona1.getCaloriasIngeridas());        
        assertEquals("NO", persona1.contestar("¿Te sientes bien?"));
        assertEquals("SI", persona1.contestar("¿Quieres comer?"));  
        assertEquals("SI", persona1.contestar("¿Todo ok?"));  
        assertEquals("¿TE LLAMAS ANA?", persona1.contestar("¿Te llamas Ana?"));         
        assertEquals("NO", persona1.contestar("¿Te llamas Luis?"));          
        assertEquals(1200, persona1.comer(comida2));  
        assertEquals(2600, persona1.getCaloriasIngeridas());        
        assertEquals("¿TE SIENTES BIEN?", persona1.contestar("¿Te sientes bien?"));
        assertEquals("¿QUIERES COMER?", persona1.contestar("¿Quieres comer?"));  
        assertEquals("¿TODO OK?", persona1.contestar("¿Todo ok?")); 
        assertEquals("¿TE LLAMAS ANA?", persona1.contestar("¿Te llamas Ana?"));        
        assertEquals("¿TE LLAMAS LUIS?", persona1.contestar("¿Te llamas Luis?"));          
        
        assertEquals(0, persona2.getCaloriasIngeridas());
        assertEquals("NO", persona2.contestar("¿Te sientes bien?"));
        assertEquals("SI", persona2.contestar("¿Quieres comer?"));
        assertEquals("SI", persona2.contestar("¿Todo ok?"));    
        assertEquals("NO", persona2.contestar("¿Te llamas Maria?")); 
        assertEquals("¿TE LLAMAS LUIS?", persona2.contestar("¿Te llamas Luis?"));           
        assertEquals(800, persona2.comer(comida1));
        assertEquals(800, persona2.getCaloriasIngeridas());        
        assertEquals("NO", persona2.contestar("¿Te sientes bien?"));
        assertEquals("SI", persona2.contestar("¿Quieres comer?"));  
        assertEquals("SI", persona2.contestar("¿Todo ok?"));  
        assertEquals("NO", persona2.contestar("¿Te llamas Maria?"));   
        assertEquals("¿TE LLAMAS LUIS?", persona2.contestar("¿Te llamas Luis?"));          
        assertEquals(600, persona2.comer(comida3)); 
        assertEquals(1400, persona2.getCaloriasIngeridas());        
        assertEquals("NO", persona2.contestar("¿Te sientes bien?"));
        assertEquals("SI", persona2.contestar("¿Quieres comer?"));  
        assertEquals("SI", persona2.contestar("¿Todo ok?"));  
        assertEquals("NO", persona2.contestar("¿Te llamas Maria?"));   
        assertEquals("¿TE LLAMAS LUIS?", persona2.contestar("¿Te llamas Luis?"));          
        assertEquals(600, persona2.comer(comida3));  
        assertEquals(2000, persona2.getCaloriasIngeridas());        
        assertEquals("NO", persona2.contestar("¿Te sientes bien?"));
        assertEquals("SI", persona2.contestar("¿Quieres comer?"));  
        assertEquals("SI", persona2.contestar("¿Todo ok?"));  
        assertEquals("NO", persona2.contestar("¿Te llamas Maria?"));   
        assertEquals("¿TE LLAMAS LUIS?", persona2.contestar("¿Te llamas Luis?"));          
        
    }
    
    @Test
     public void TestCommit03()
    {
        Persona persona3 = new Persona("Luisa", false, 57, 160, 24);
        Persona persona4 = new Persona("Jose", true, 70, 178, 24);
        Persona persona5 = new Persona("Juan", true, 77, 190, 38);


        // Luisa, antes de comer.
        assertEquals(0, persona3.getCaloriasIngeridas());
        assertEquals(null, persona3.getAlimentoMasCaloricoConsumido());
        // Come una ensalad.
        assertEquals(269, persona3.comer(comida5));            
        assertEquals("Ensalada", persona3.getAlimentoMasCaloricoConsumido());
        // Come acelgas.
        assertEquals(50, persona3.comer(comida7));            
        assertEquals("Acelgas", persona3.getAlimentoMasCaloricoConsumido());
        // Come un nuevo plato de Pizza
        assertEquals(1200, persona3.comer(comida2));            
        assertEquals("Pizza", persona3.getAlimentoMasCaloricoConsumido());
        // Come otro plato de pollo 
        assertEquals(1200, persona3.comer(comida6));            
        assertEquals("Pollo", persona3.getAlimentoMasCaloricoConsumido());
        // Para terminar se toma un cocido.
        assertEquals(2000, persona3.comer(comida4));            
        assertEquals("Cocido", persona3.getAlimentoMasCaloricoConsumido());

        //Jose, antes de comer.
        assertEquals(0, persona4.getCaloriasIngeridas());
        assertEquals(null, persona4.getAlimentoMasCaloricoConsumido());
        // Come una ensalad.
        assertEquals(269, persona4.comer(comida5));            
        assertEquals("Ensalada", persona4.getAlimentoMasCaloricoConsumido());
         // Come acelgas.
        assertEquals(50, persona4.comer(comida7));            
        assertEquals("Acelgas", persona4.getAlimentoMasCaloricoConsumido());
        // Come un nuevo plato de Pizza
        assertEquals(1200, persona4.comer(comida2));            
        assertEquals("Pizza", persona4.getAlimentoMasCaloricoConsumido());
        // Come otro plato de pollo Pizza
        assertEquals(1200, persona4.comer(comida6));            
        assertEquals("Pollo", persona4.getAlimentoMasCaloricoConsumido());
        // Para terminar se toma un cocido.
        assertEquals(2000, persona4.comer(comida4));            
        assertEquals("Cocido", persona4.getAlimentoMasCaloricoConsumido());

        //Juan, antes de comer.
        assertEquals(0, persona5.getCaloriasIngeridas());
        assertEquals(null, persona5.getAlimentoMasCaloricoConsumido());
        // Come una ensalad.
        assertEquals(269, persona5.comer(comida5));            
        assertEquals("Ensalada", persona5.getAlimentoMasCaloricoConsumido());
         // Come acelgas.
        assertEquals(50, persona5.comer(comida7));            
        assertEquals("Acelgas", persona5.getAlimentoMasCaloricoConsumido());
        // Come un nuevo plato de Pizza
        assertEquals(1200, persona5.comer(comida2));            
        assertEquals("Pizza", persona5.getAlimentoMasCaloricoConsumido());
        // Come otro plato de pollo Pizza
        assertEquals(1200, persona5.comer(comida6));            
        assertEquals("Pollo", persona5.getAlimentoMasCaloricoConsumido());
        // Para terminar se toma un cocido.
        assertEquals(2000, persona5.comer(comida4));            
        assertEquals("Cocido", persona5.getAlimentoMasCaloricoConsumido());

    }
}

