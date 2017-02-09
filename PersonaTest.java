

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

    
}