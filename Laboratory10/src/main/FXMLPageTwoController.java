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

    @FXML
    private Label labelRoot;
    @FXML
    private TextArea textArea;
    
    @FXML
    private Button btnBalanced;
    @FXML
    private Button btnHeight;

    AVL tree = new AVL();

    SinglyLinkedList list = new SinglyLinkedList();

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

    @FXML
    private void btnHeight(ActionEvent event) throws ListException, TreeException {
        int element = (int) list.getNode(util.Utility.random(list.size() - 1)).data;

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Height");
        alert.setHeaderText(null);
        alert.setContentText(("El Height del valor: " + element + " es : " + String.valueOf(tree.height(element))));
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


}//end class
