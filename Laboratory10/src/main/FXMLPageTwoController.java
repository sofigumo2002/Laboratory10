package main;

import domain.AVL;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;

/**
 * FXML Controller class
 *
 * @author wandagranados
 */
public class FXMLPageTwoController implements Initializable {

    @FXML
    private Button btnRandomize;

    @FXML
    private AnchorPane anchorPaneTree;
    @FXML
    private TextField root;
    @FXML
    private Line line0;
    @FXML
    private Line lineTwo;
    @FXML
    private Line lineThree;
    @FXML
    private Line lineFour;

    private TextField text2;
    private TextField text1;
    private Line line1;
    private Line line2;
    
    private boolean levels = true;

    @FXML
    private Label labelRoot;
    @FXML
    private TextArea textArea;
    
    @FXML
    private Button btnBalanced;
    private Button btnHeight;

    AVL tree = new AVL();

    SinglyLinkedList list = new SinglyLinkedList();
    @FXML
    private Button btnLevels;
    @FXML
    private Label cero;
    @FXML
    private Label uno;
    @FXML
    private Label dos;
    @FXML
    private Label tres;
    @FXML
    private Label cuatro;
    @FXML
    private Label cinco;
    @FXML
    private Line line01;
    @FXML
    private Line lineTwo1;
    @FXML
    private Line lineThree1;
    @FXML
    private Line lineFour1;
    @FXML
    private Line lineFive;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void btnRandomize(ActionEvent event) throws TreeException, ListException {
        tree = new AVL();
        textArea.setText("");
        list.clear();
        fillTree(tree);
        this.root.setVisible(true);
        fillArea();
        showTree();
        btnBalanced.setDisable(false);
        this.btnLevels.setDisable(false);
        this.btnHeight.setDisable(false);
        this.anchorPaneTree.getChildren().add(textArea);
    }

    public void showTree() throws TreeException {
        if (tree.isEmpty()) {
            throw new TreeException("Binary Tree is empty");
        }
        this.anchorPaneTree.getChildren().clear();
        this.anchorPaneTree.getChildren().add(root);
        root.setText(String.valueOf(tree.getRoot().data));
        showTree(tree.getRoot(), root, 300);
    }

    private void showTree(BTreeNode node, TextField label, int posX) {
//        if (node != null) {
//            if (node.left != null) {
//                text2 = new TextField(String.valueOf(node.left.data));//instancio un nuevo textfiel
//                text2.setEditable(false);
//                line2 = new Line();
//                line2.setStartX((label.getLayoutX() + 25) - posX);
//                line2.setStartY(label.getLayoutY() + 100);
//
//                text2.setAlignment(Pos.CENTER);
//
//                anchorPaneTree.getChildren().add(text2);
//                anchorPaneTree.getChildren().add(line2);
//                line2.toBack();
//                text2.setLayoutX(label.getLayoutX() - posX);
//                text2.setLayoutY(label.getLayoutY() + 100);
//                text2.setPrefWidth(53);
//                text2.setPrefHeight(51);
//
//                line2.setEndX(label.getLayoutX() + 25);
//                line2.setEndY(label.getLayoutY());
//
//                showTree(node.left, text2, posX / 2);
//            }
//            if (node.right != null) {
//                text1 = new TextField(String.valueOf(node.right.data));//instancio un nuevo textfiel
//                text1.setEditable(false);
//                line1 = new Line();
//                line1.setStartX((label.getLayoutX() + 25) + posX);
//                line1.setStartY(label.getLayoutY() + 100);
//
//                text1.setAlignment(Pos.CENTER);
//
//                anchorPaneTree.getChildren().add(text1);
//                anchorPaneTree.getChildren().add(line1);
//                line1.toBack();
//                text1.setLayoutX(label.getLayoutX() + posX);
//                text1.setLayoutY(label.getLayoutY() + 100);
//                text1.setPrefWidth(53);
//                text1.setPrefHeight(51);
//
//                line1.setEndX(label.getLayoutX() + 25);
//                line1.setEndY(label.getLayoutY());
//
//                showTree(node.right, text1, posX / 2);
//            }
//        }
//    }

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
                text2.setPrefWidth(53);
                text2.setPrefHeight(51);

                line2.setEndX(label.getLayoutX() + 25);
                line2.setEndY(label.getLayoutY());

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
                text1.setPrefWidth(53);
                text1.setPrefHeight(51);

                line1.setEndX(label.getLayoutX() + 25);
                line1.setEndY(label.getLayoutY());

                showTree(node.right, text1, posX / 2);
            }
        }
    }

    @FXML
    private void btnBalanced(ActionEvent event) throws TreeException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Is Balanced?");
        alert.setHeaderText(null);
        if (tree.isBalanced()) {
            alert.setContentText("El arbol esta balanceado");
        } else {
            alert.setContentText("El arbol no esta balanceado");
        }

        alert.showAndWait();
    }

    
    private void fillTree(AVL tree) throws ListException {
        
        tree.add(77);
        tree.add(1);
        tree.add(53);
        tree.add(42);
        tree.add(68);
        tree.add(93);
        tree.add(89);
        tree.add(12);
        
        
//        boolean flag = false;
//        for (int i = 0; i < 15; i++) {
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

    private void fillArea() throws TreeException {
        String string = "Height: " + tree.height() + "\n";
        string += tree.toString();
        this.textArea.setText(string);
    }

    @FXML
    private void btnLevels(ActionEvent event) {
        
        if (levels) {
            this.anchorPaneTree.getChildren().add(line0);
            this.anchorPaneTree.getChildren().add(lineTwo);
            this.anchorPaneTree.getChildren().add(lineThree);
            this.anchorPaneTree.getChildren().add(lineFour);
            this.anchorPaneTree.getChildren().add(lineFive);
            line0.setVisible(true);
            lineTwo.setVisible(true);
            lineThree.setVisible(true);
            lineFour.setVisible(true);
            lineFive.setVisible(true);
            cero.setVisible(true);
            uno.setVisible(true);
            dos.setVisible(true);
            tres.setVisible(true);
            cuatro.setVisible(true);
            cinco.setVisible(true);
            levels = false;
        } else {
            this.anchorPaneTree.getChildren().remove(line0);
            this.anchorPaneTree.getChildren().remove(lineTwo);
            this.anchorPaneTree.getChildren().remove(lineThree);
            this.anchorPaneTree.getChildren().remove(lineFour);
            this.anchorPaneTree.getChildren().remove(lineFive);
            line0.setVisible(false);
            lineTwo.setVisible(false);
            lineThree.setVisible(false);
            lineFour.setVisible(false);
            lineFive.setVisible(false);
            cero.setVisible(false);
            uno.setVisible(false);
            dos.setVisible(false);
            tres.setVisible(false);
            cuatro.setVisible(false);
            cinco.setVisible(false);
            levels = true;
        }
    }


}//end class
