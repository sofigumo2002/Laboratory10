/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author sofia
 */
public class BTreeNode {
    public Object data;
    public BTreeNode left, right;
    public String sequence; //representa la ruta donde agrego el elemento
    public String label;
    
    //Constructor
    public BTreeNode(Object data){
        this.data = data;
        this.left=this.right=null;
    }
    
    //Constructor 2
    public BTreeNode(Object data, String sequence){
        this.data = data;
        this.sequence = sequence;
        this.left=this.right=null;
    }
}