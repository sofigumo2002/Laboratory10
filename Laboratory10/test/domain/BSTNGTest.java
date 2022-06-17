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
public class BSTNGTest {

    public BSTNGTest() {
    }

    @Test
    public void testSomeMethod() throws TreeException {
        BST bst = new BST();
        for (int i = 0; i < 10; i++) {
            int value = util.Utility.random(200);
            bst.add(value);
        }
        System.out.println(" ");
        System.out.println(bst.toString());

        //Size
        System.out.println(" ");
        System.out.println("Size: " + bst.size());

        //Min
        System.out.println(" ");
        System.out.println("Minimo: " + bst.min());

        //Max
        System.out.println(" ");
        System.out.println("Maximo: " + bst.max());

        //Balanced
        System.out.println(" ");
        System.out.println("BST Tree is balanced? " + bst.isBalanced());

        //Delete
        System.out.println(" ");
        System.out.println("DELETING ELEMENTS...");
        int counter = 0;
        do {
            int value = util.Utility.random(200);
            if (bst.contains(value)) {
                System.out.println("BST item [" + value + "] has been deleted");
                bst.remove(value);
                counter++;
            }

        } while (counter < 2);
        //Se muestra
        System.out.println(bst.toString());

        //Balanced
        System.out.println(" ");
        System.out.println("BST Tree is balanced? " + bst.isBalanced());
        
        //altura
        System.out.println(" ");
        System.out.println("BST Tree height: "+bst.height()); 
        
        //Modify
        System.out.println(" ");
        bst.modify(util.Utility.random(200), util.Utility.random(200));
        
        //Muestra
        System.out.println(" ");
        System.out.println(bst.toString());
    }

}
