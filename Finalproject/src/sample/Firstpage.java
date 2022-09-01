package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Firstpage implements Initializable {
    @FXML
    public Button Loginbtn;
    @FXML
    public Button Registerbtn;
    @FXML
    private ImageView Backgroundimage;
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void Loginpage(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Loginpage.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add("sample/Loginpage.css");
        stage.setScene(scene);
        stage.show();
    }

    public void Registerpage(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Registerpage.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add("sample/Loginpage.css");
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image img1=new Image(getClass().getResourceAsStream("frontbg.jpg"));
        Backgroundimage.setImage(img1);
    }
}
