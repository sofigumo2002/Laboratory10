package main;

import domain.AVL;
import domain.BST;
import domain.BTreeNode;
import domain.ListException;
import domain.SinglyLinkedList;
import domain.TreeException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author juanp
 */
public class FXMLPageThreeController implements Initializable {

    @FXML
    private Button btnRandomize;
    @FXML
    private AnchorPane anchorPaneTree;
    @FXML
    private TextField root;

    private TextField text2;
    private TextField text1;
    private Line line1;
    private Line line2;

    @FXML
    private Button btnPreOrder;
    @FXML
    private RadioButton radioAVL;
    @FXML
    private RadioButton radioBST;
    @FXML
    private Button btnInOrder;
    @FXML
    private Button btnPostOrder;

    BST tree;
    SinglyLinkedList list = new SinglyLinkedList();

    AVL tree2 = new AVL();
    SinglyLinkedList list2 = new SinglyLinkedList();

    Text txtR;
    Text txtL;

    boolean option;

    int counter;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnRandomize.setDisable(true);
    }

    @FXML
    private void btnRandomize(ActionEvent event) throws TreeException, ListException {
        if (option) {//bst
            tree = new BST();list.clear();
            fillTree(tree);
            
            showTree();
        } else {//avl
            tree2 = new AVL();list2.clear();
            fillTree(tree2);
            
            showTree2();
        }
        this.root.setVisible(true);
        btnPostOrder.setDisable(false);
        btnPreOrder.setDisable(false);
        btnInOrder.setDisable(false);
    }

    public void showTree() {
        try {
            if (!tree.isEmpty()) {
                this.anchorPaneTree.getChildren().clear();
                this.anchorPaneTree.getChildren().add(root);
                root.setText(String.valueOf(tree.getRoot().data));
                showTree(tree.getRoot(), root, 300);
            } else {
                this.anchorPaneTree.getChildren().clear();
                root.setVisible(false);
            }
        } catch (Exception e) {
        }
    }

    public void showTree2() {
        try {
            if (!tree2.isEmpty()) {
                this.anchorPaneTree.getChildren().clear();
                this.anchorPaneTree.getChildren().add(root);
                root.setText(String.valueOf(tree2.getRoot().data));
                treeAVLShow(tree2.getRoot(), root, 300);
            } else {
                this.anchorPaneTree.getChildren().clear();
                root.setVisible(false);
            }
        } catch (Exception e) {
        }
    }

    private void showTree(BTreeNode node, TextField label, int posX) {
        if (node != null) {
            if (node.left != null) {
                text2 = new TextField(String.valueOf(node.left.data));//instancio un nuevo textfiel
                text2.setEditable(false);
                line2 = new Line();
                line2.setStartX((label.getLayoutX() + 25) - posX);
                line2.setStartY(label.getLayoutY() + 100);

                text2.setAlignment(Pos.CENTER);

                anchorPaneTree.getChildren().add(text2);
                anchorPaneTree.getChildren().add(line2);
                line2.toBack();
                text2.setLayoutX(label.getLayoutX() - posX);
                text2.setLayoutY(label.getLayoutY() + 100);
                text2.setPrefWidth(40);
                text2.setPrefHeight(26);

                line2.setEndX(label.getLayoutX() + 25);
                line2.setEndY(label.getLayoutY());

                //Text
                txtR = new Text(node.left.label);
                anchorPaneTree.getChildren().add(txtR);
                txtR.setLayoutX(text2.getLayoutX() + 7);
                txtR.setLayoutY(text2.getLayoutY() + 50);
                txtR.setFill(Color.WHITE);
                showTree(node.left, text2, posX / 2);
            }
            if (node.right != null) {
                text1 = new TextField(String.valueOf(node.right.data));//instancio un nuevo textfiel
                text1.setEditable(false);
                line1 = new Line();
                line1.setStartX((label.getLayoutX() + 25) + posX);
                line1.setStartY(label.getLayoutY() + 100);

                text1.setAlignment(Pos.CENTER);

                anchorPaneTree.getChildren().add(text1);
                anchorPaneTree.getChildren().add(line1);
                line1.toBack();
                text1.setLayoutX(label.getLayoutX() + posX);
                text1.setLayoutY(label.getLayoutY() + 100);
                text1.setPrefWidth(40);
                text1.setPrefHeight(26);

                line1.setEndX(label.getLayoutX() + 25);
                line1.setEndY(label.getLayoutY());

                //Text
                txtL = new Text(node.right.label);
                anchorPaneTree.getChildren().add(txtL);
                txtL.setLayoutX(text1.getLayoutX() + 7);
                txtL.setLayoutY(text1.getLayoutY() + 50);
                txtL.setFill(Color.WHITE);

                showTree(node.right, text1, posX / 2);
            }
        }
    }

    private void treeAVLShow(BTreeNode node, TextField label, int posX) {
        if (node != null) {
            if (node.left != null) {
                text2 = new TextField(String.valueOf(node.left.data));//instancio un nuevo textfiel
                text2.setEditable(false);
                line2 = new Line();
                line2.setStartX((label.getLayoutX() + 25) - posX);
                line2.setStartY(label.getLayoutY() + 100);

                text2.setAlignment(Pos.CENTER);

                anchorPaneTree.getChildren().add(text2);
                anchorPaneTree.getChildren().add(line2);
                line2.toBack();
                text2.setLayoutX(label.getLayoutX() - posX);
                text2.setLayoutY(label.getLayoutY() + 100);
                text2.setPrefWidth(40);
                text2.setPrefHeight(26);

                line2.setEndX(label.getLayoutX() + 25);
                line2.setEndY(label.getLayoutY());

                treeAVLShow(node.left, text2, posX / 2);
            }
            if (node.right != null) {
                text1 = new TextField(String.valueOf(node.right.data));//instancio un nuevo textfiel
                text1.setEditable(false);
                line1 = new Line();
                line1.setStartX((label.getLayoutX() + 25) + posX);
                line1.setStartY(label.getLayoutY() + 100);

                text1.setAlignment(Pos.CENTER);

                anchorPaneTree.getChildren().add(text1);
                anchorPaneTree.getChildren().add(line1);
                line1.toBack();
                text1.setLayoutX(label.getLayoutX() + posX);
                text1.setLayoutY(label.getLayoutY() + 100);
                text1.setPrefWidth(40);
                text1.setPrefHeight(26);

                line1.setEndX(label.getLayoutX() + 25);
                line1.setEndY(label.getLayoutY());

                treeAVLShow(node.right, text1, posX / 2);
            }
        }
    }

    private void fillTree(BST tree) throws ListException {
        
        tree.add(25);
        tree.add(76);
        tree.add(98);
        tree.add(17);
        tree.add(48);
        tree.add(33);
        tree.add(85);
        tree.add(11);
        
        
        
//        boolean flag = false;
//        for (int i = 0; i <= 10; i++) {
//            int random = util.Utility.random(30);
//            if (!list.contains(random)) {
//                list.add(random);
//                tree.add(random);
//            } else {
//                int random2 = util.Utility.random(30);
//
//                do {
//                    random2 = util.Utility.random(30);
//                    if (!list.contains(random2)) {
//                        list.add(random2);
//                        tree.add(random2);
//                        flag = true;
//                    }
//                } while (!flag);
//
//            }
//        }
    }

    private void fillTree(AVL tree) throws ListException {
        
        tree.add(56);
        tree.add(26);
        tree.add(48);
        tree.add(87);
        tree.add(38);
        tree.add(13);
        tree.add(89);
        tree.add(12);
        
        
        
        
//        boolean flag = false;
//        for (int i = 0; i <= 10; i++) {
//            int random = util.Utility.random(30);
//            if (!list2.contains(random)) {
//                list2.add(random);
//                tree.add(random);
//            } else {
//                int random2 = util.Utility.random(30);
//
//                do {
//                    random2 = util.Utility.random(30);
//                    if (!list2.contains(random2)) {
//                        list2.add(random2);
//                        tree.add(random2);
//                        flag = true;
//                    }
//                } while (!flag);
//
//            }
//        }
    }

    public void preOrder() throws TreeException {
        if (option) {//bst
            if (tree.isEmpty()) {
                throw new TreeException("Bst Tree is empty");
            }
            counter = 0;
            preOrder(tree.getRoot());
        } else {//avl
            if (tree2.isEmpty()) {
                throw new TreeException("AVL Tree is empty");
            }
            counter = 0;
            preOrder(tree2.getRoot());
        }
    }

    //Tranversal tour: N-L-R
    private void preOrder(BTreeNode node) {
        if (node != null) {
            node.label = String.valueOf(++counter);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    @FXML
    private void btnPreOrder(ActionEvent event) throws TreeException {
        if (option) {//bst
            anchorPaneTree.getChildren().clear();
            this.anchorPaneTree.getChildren().add(root);
            preOrder();
            Text txt = new Text(tree.getRoot().label);
            anchorPaneTree.getChildren().add(txt);
            txt.setLayoutX(root.getLayoutX() + 7);
            txt.setLayoutY(root.getLayoutY() + 50);
            txt.setFill(Color.WHITE);
            root.setText(String.valueOf(tree.getRoot().data));
            showTree(tree.getRoot(), root, 300);

        } else {//avl

            anchorPaneTree.getChildren().clear();
            this.anchorPaneTree.getChildren().add(root);
            preOrder();
            Text txt = new Text(tree2.getRoot().label);
            anchorPaneTree.getChildren().add(txt);
            txt.setLayoutX(root.getLayoutX() + 7);
            txt.setLayoutY(root.getLayoutY() + 50);
            txt.setFill(Color.WHITE);
            root.setText(String.valueOf(tree2.getRoot().data));
            showTree(tree2.getRoot(), root, 300);
        }
    }

    public void InOrder() throws TreeException {
        if (option) {//bst
            if (tree.isEmpty()) {
                throw new TreeException("Bst Tree is empty");
            }
            counter = 0;
            InOrder(tree.getRoot());
        } else {//avl
            if (tree2.isEmpty()) {
                throw new TreeException("AVL Tree is empty");
            }
            counter = 0;
            InOrder(tree2.getRoot());
        }
    }

    //Tranversal tour: L-N-R
    private void InOrder(BTreeNode node) {
        if (node != null) {
            InOrder(node.left);
            node.label = String.valueOf(++counter);
            InOrder(node.right);
        }
    }

    @FXML
    private void btnInOrder(ActionEvent event) throws TreeException {
        if (option) {//bst
            anchorPaneTree.getChildren().clear();
            this.anchorPaneTree.getChildren().add(root);
            InOrder();
            Text txt = new Text(tree.getRoot().label);
            anchorPaneTree.getChildren().add(txt);
            txt.setLayoutX(root.getLayoutX() + 7);
            txt.setLayoutY(root.getLayoutY() + 50);
            txt.setFill(Color.WHITE);
            root.setText(String.valueOf(tree.getRoot().data));
            showTree(tree.getRoot(), root, 300);
        } else {//avl
            anchorPaneTree.getChildren().clear();
            this.anchorPaneTree.getChildren().add(root);
            InOrder();
            Text txt = new Text(tree2.getRoot().label);
            anchorPaneTree.getChildren().add(txt);
            txt.setLayoutX(root.getLayoutX() + 7);
            txt.setLayoutY(root.getLayoutY() + 50);
            txt.setFill(Color.WHITE);
            root.setText(String.valueOf(tree2.getRoot().data));
            showTree(tree2.getRoot(), root, 300);
        }

    }

    public void postOrder() throws TreeException {
        if (option) {//bst
            if (tree.isEmpty()) {
                throw new TreeException("Bst Tree is empty");
            }
            counter = 0;
            postOrder(tree.getRoot());
        } else {//avl
            if (tree2.isEmpty()) {
                throw new TreeException("AVL Tree is empty");
            }
            counter = 0;
            postOrder(tree2.getRoot());
        }
    }

    //Tranversal tour: L-R-N
    private void postOrder(BTreeNode node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            node.label = String.valueOf(++counter);
        }

    }

    @FXML
    private void btnPostOrder(ActionEvent event) throws TreeException {
        if (option) {//bst
            anchorPaneTree.getChildren().clear();
            this.anchorPaneTree.getChildren().add(root);
            postOrder();
            Text txt = new Text(tree.getRoot().label);
            anchorPaneTree.getChildren().add(txt);
            txt.setLayoutX(root.getLayoutX() + 7);
            txt.setLayoutY(root.getLayoutY() + 50);
            txt.setFill(Color.WHITE);
            root.setText(String.valueOf(tree.getRoot().data));
            showTree(tree.getRoot(), root, 300);
        } else {//avl
            anchorPaneTree.getChildren().clear();
            this.anchorPaneTree.getChildren().add(root);
            postOrder();
            Text txt = new Text(tree2.getRoot().label);
            anchorPaneTree.getChildren().add(txt);
            txt.setLayoutX(root.getLayoutX() + 7);
            txt.setLayoutY(root.getLayoutY() + 50);
            txt.setFill(Color.WHITE);
            root.setText(String.valueOf(tree2.getRoot().data));
            showTree(tree2.getRoot(), root, 300);
        }

    }

    @FXML
    private void radioBST(ActionEvent event) {
        radioAVL.setSelected(false);
        option = true;
        showTree();
        btnRandomize.setDisable(false);
    }

    @FXML
    private void radioAVL(ActionEvent event) {
        radioBST.setSelected(false);
        option = false;
        showTree2();
        btnRandomize.setDisable(false);
    }

}//end class
