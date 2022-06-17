/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author sofia
 */
public class AVLNGTest {

    public AVLNGTest() {
    }

    @Test
    public void testSomeMethod() throws TreeException {

        //Instancio
        AVL avl = new AVL();
        fill(avl);//Leno con numeros

        //Se muestra
        System.out.println(" ");
        System.out.println(avl.toString());

        //Size
        System.out.println(" ");
        System.out.println("Size:" + avl.size());

        //Min
        System.out.println(" ");
        System.out.println("Minimo: " + avl.min());

        //Max
        System.out.println(" ");
        System.out.println("Maximo: " + avl.max());

        //isBalanced
        System.out.println(" ");
        if (avl.isBalanced()) {
            System.out.println("El arbol esta balanceado");
        } else {
            System.out.println("El arbol no esta balanceado");
        }

        //Obtener secuencia por consola
        System.out.println(" ");
        System.out.println(avl.sequence());

        //remove
        System.out.println(" ");
        System.out.println("DELETING ELEMENTS...");
        int counter = 0;
        do {
            int value = util.Utility.random(99);
            if (avl.contains(value)) {
                System.out.println("AVL item [" + value + "] has been deleted");
                avl.remove(value);
                counter++;
            }

        } while (counter < 2);

        //se muestra
        System.out.println(" ");
        System.out.println(avl.toString());
        
        //Size
        System.out.println(" ");
        System.out.println("Size:" + avl.size());

        //isBalanced
        System.out.println(" ");
        if (avl.isBalanced()) {
            System.out.println("El arbol esta balanceado");
        } else {
            System.out.println("El arbol no esta balanceado");
        }

    }

    private void fill(AVL avl) {
        for (int i = 1; i <= 7; i++) {
            avl.add(i);
        }
        for (int j = 15; j >= 8; j--) {
            avl.add(j);
        }
    }

}
