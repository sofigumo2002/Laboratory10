package main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author wandagranados
 */
public class FXMLMenuController implements Initializable {

    @FXML
    private Button home;
    @FXML
    private Button btnExit;
    @FXML
    private BorderPane borderPane;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button btnBST;
    @FXML
    private Button btnAVL;
    @FXML
    private Button btnTour;
    @FXML
    private Button btnBSTOperations;
    @FXML
    private Button btnAVLOperations;

    @Override
    public void initialize(URL url, ResourceBundle rb) {//Constructor

    }

    @FXML
    private void home(ActionEvent event) {
        this.borderPane.setCenter(anchorPane);
    }

    @FXML
    private void btnExit(ActionEvent event) {
        Stage stage = (Stage) this.btnExit.getScene().getWindow();
        stage.close();
    }

    private void loadPage(String page) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(page + ".fxml"));
        } catch (IOException ex) {
            Logger.getLogger(FXMLMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.borderPane.setCenter(root);
    }

    @FXML
    private void btnBST(ActionEvent event) {
        this.loadPage("FXMLPageOne");//carga el ejercicio 1
    }

    @FXML
    private void btnAVL(ActionEvent event) {
        this.loadPage("FXMLPageTwo");//carga el ejercicio 2
    }

    @FXML
    private void btnTour(ActionEvent event) {
        this.loadPage("FXMLPageThree");//carga el ejercicio 3
    }


    @FXML
    private void btnBSTOperations(ActionEvent event) {
    }

    @FXML
    private void btnAVLOperations(ActionEvent event) {
    }

}//end class
