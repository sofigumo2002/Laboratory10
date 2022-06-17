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
public class BST implements Tree {
    private BTreeNode root; //representa la unica entrada al arbol

    //Constructor
    public BST(){
        this.root = null;
    }
    
    public BTreeNode getRoot(){
        return root;
    }
    
    @Override
    public int size() throws TreeException {
        if(isEmpty()){
            throw new TreeException("Binary Search Tree is empty");
        }
        return size(root);
    }
    
    private int size(BTreeNode node){
        if(node==null){
            return 0;
        }else
            return 1+size(node.left)+size(node.right);
    }

    @Override
    public void clear() {
        this.root = null;
    }

    @Override
    public boolean isEmpty() {
        return root==null;
    }

    @Override
    public boolean contains(Object element) throws TreeException {
        if(isEmpty())
            throw new TreeException("Binary Tree is empty");
        return binarySearch(root, element);
    }
    
    private boolean binarySearch(BTreeNode node, Object element){
        if(node==null){
            return false;
        }else
            if(util.Utility.equals(node.data, element)){
                return true;
            }else
                if(util.Utility.lessT(element, node.data))
                    return binarySearch(node.left, element);
                else binarySearch(node.right, element);
        return false;
    }

    @Override
    public void add(Object element) {
        this.root = add(this.root, element);
    }
    
    private BTreeNode add(BTreeNode node, Object element){
        if(node==null){
            node = new BTreeNode(element);
        }else
            if(util.Utility.lessT(element, node.data))
                node.left = add(node.left, element);
            else
            if(util.Utility.greaterT(element, node.data))  
                    node.right = add(node.right, element);
        return node;
    }

    @Override
    public void remove(Object element) throws TreeException {
        if(isEmpty())
            throw new TreeException("Binary Tree is empty");
        root = remove(root, element);
    }
    
    private BTreeNode remove(BTreeNode node, Object element){
        if(node!=null){
            if(util.Utility.lessT(element, node.data))
                node.left = remove(node.left, element);
            else
            if(util.Utility.greaterT(element, node.data))
                node.right = remove(node.right, element);
            else
            if(util.Utility.equals(node.data, element)){
                //Caso 1. El nodo a suprimir no tiene hijos
                if(node.left==null && node.right==null){
                   return null;
                }else
                //Caso 2. El nodo a suprimir solo tiene un hijo
                if(node.left!=null && node.right==null){
                    return node.left;
                }else
                if(node.left==null && node.right!=null){
                    return node.right;
                }else
                //Caso 3. El nodo a suprimir tiene dos hijos
                if(node.left!=null && node.right!=null){
                    Object min = min(node.right);
                    node.data = min;
                    node.right = remove(node.right, min);
                }
            } 
        }
        return node;
    }
    
   /**
     * Obtiene hoja
     * @param node
     * @return 
     */
    private Object getLeaf(BTreeNode node) {
        Object aux;
        if(node==null)
            return null;
	else
            //si es una hoja
            if(node.left==null && node.right==null){
		return node.data; //es una hoja
            }else{
                aux = getLeaf(node.left);
                if(aux==null){
                    aux = getLeaf(node.right);
                }
            }
        return aux;
    }

    @Override
    public int height(Object element) throws TreeException {
        if(isEmpty())
            throw new TreeException("Binary Search Tree is empty");
        return height(this.root, element, 0);
    }
    
    private int height(BTreeNode node, Object element, int counter){
        if(node==null){
            return 0;
        }else
            if(util.Utility.equals(node.data, element)){
                return counter;
            }else
            if(util.Utility.lessT(element, node.data)){
                return height(node.left, element, ++counter);
            }
               return height(node.right, element, ++counter);
    }

    @Override
    public int height() throws TreeException {
        if(isEmpty())
            throw new TreeException("Binary Search Tree is empty");
        return height(root)-1;
    }
    
    private int height(BTreeNode node){
        if(node==null){
            return 0;
        }else
            //debemos buscar por el subarbol izq y der
            return Math.max(height(node.left), height(node.right))+1;
    }

    @Override
    public Object min() throws TreeException {
        if(isEmpty())
            throw new TreeException("Binary Search Tree is empty");
        return min(root);
    }
    
    private Object min(BTreeNode node){
        if(node.left!=null)
            return min(node.left);
        return node.data; //ya estamos en la hoja q represeta el min
    }

    @Override
    public Object max() throws TreeException {
        if(isEmpty())
            throw new TreeException("Binary Search Tree is empty");
        return max(root);
    }
    
     private Object max(BTreeNode node){
        if(node.right!=null)
            return max(node.right);
        return node.data; //ya estamos en la hoja q represeta el max
    }

    @Override
    public String preOrder() throws TreeException {
        if(isEmpty())
            throw new TreeException("Binary Search Tree is empty");
        return "PreOrder Transversal Tour: "+preOrder(this.root);
    }
    
    //Transversal Tour: N-L-R
    private String preOrder(BTreeNode node){
        String result="";
        if(node!=null){
            result=node.data+", ";
            result+=preOrder(node.left);
            result+=preOrder(node.right);
        }
        return result;
    }

    @Override
    public String inOrder() throws TreeException {
        if(isEmpty())
            throw new TreeException("Binary Search Tree is empty");
        return "InOrder Transversal Tour: "+InOrder(this.root);
    }
    
    //Transversal Tour: L-N-R
    private String InOrder(BTreeNode node){
        String result="";
        if(node!=null){
            result=InOrder(node.left);
            result+=node.data+", ";
            result+=InOrder(node.right);
        }
        return result;
    }

    @Override
    public String postOrder() throws TreeException {
        if(isEmpty())
            throw new TreeException("Binary Search Tree is empty");
        return "PostOrder Transversal Tour: "+postOrder(this.root);
    }
    
    //Transversal Tour: L-R-N
    private String postOrder(BTreeNode node){
        String result="";
        if(node!=null){
            result=postOrder(node.left);
            result+=postOrder(node.right);
            result+=node.data+", ";  
        }
        return result;
    }
    
    
    
    //inOrden: recorre el árbol de la forma: izq-nodo-der
    //postOrden: recorre el árbol de la forma: izq-der-nodo
    @Override
    public String toString() {
        if(isEmpty())
            return "Binary Search Tree is empty";
        String result = "BST TREE TRANSVERSAL TOUR...\n";
        result+="PreOrder: "+preOrder(root)+"\n";
        result+="InOrder: "+InOrder(root)+"\n";
        result+="PostOrder: "+postOrder(root)+"\n";
        return result;
    }
    
    private int getBalanceFactor(BTreeNode node){
        if(node==null){
            return 0;
        }else
            return height(node.left) - height(node.right);
    }
    
    public boolean isBalanced() throws TreeException{
         if(isEmpty())
            throw new TreeException("Binary Search Tree is empty");
         return isBalanced(root);
    }

    private boolean isBalanced(BTreeNode node) {
        if(node==null){
            return true;
        }else
            return (getBalanceFactor(node)<2||getBalanceFactor(node)>-2)
                 &&isBalanced(node.left)&&isBalanced(node.right);
    }

    public void modify(Object a, Object b) throws TreeException {
        if (isEmpty()) {
            throw new TreeException("Binary Search Tree is empty");
        }
        root = modify(a, b, root);
    }

    private BTreeNode modify(Object a, Object b, BTreeNode node) {
        if (node == null) {
            return null;
        }
        if (util.Utility.equals(a, node.data)/*a == node.data*/) {
            node.data = b;
        } else if (util.Utility.lessT(a, node.data)) {
            node.left = modify(a, b, node.left);
        } else {
            node.right = modify(a, b, node.right);
        }
        return node;
    }
    
}
