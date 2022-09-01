package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Sellwindow implements Initializable {


    private Stage stage;
    private Scene scene;
    private Parent root;

    public TableView<Player> tableview;
    public TableColumn<Player,String> name;
    public TableColumn<Player, String> country;
    public TableColumn<Player, String> position;
    public TableColumn<Player, String> club;
    public TableColumn<Player, String> age;
    public TableColumn<Player, String> height;
    public TableColumn<Player, String> salary;
    @FXML
    private ImageView backgroundimage;


    ObservableList<Player> list= FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        list.clear();
        for(Club C: Server.clubs){
            if(LoginController.cname.equals(C.getName())){
                for(Player p: C.players){
                    list.add(p);
                }
            }
        }

        name.setCellValueFactory(new PropertyValueFactory<Player, String>("name"));
        country.setCellValueFactory(new PropertyValueFactory<Player, String>("Country"));
        position.setCellValueFactory(new PropertyValueFactory<Player, String>("position"));
        club.setCellValueFactory(new PropertyValueFactory<Player, String>("club"));
        age.setCellValueFactory(new PropertyValueFactory<Player, String>("age"));
        height.setCellValueFactory(new PropertyValueFactory<Player, String>("height"));
        salary.setCellValueFactory(new PropertyValueFactory<Player, String>("weeklysalary"));


        tableview.setItems(list);
        Image img1=new Image(getClass().getResourceAsStream("countrysearchbg.jpg"));
        backgroundimage.setImage(img1);

    }
    public void sellplayer(ActionEvent actionEvent) throws IOException {

     Player p=tableview.getSelectionModel().getSelectedItem();
     // System.out.println(p.getHeight());
        for(Club C: Server.clubs){
            if(LoginController.cname.equals(C.getName())){
                C.networkutil.write(p);
            }

        }
        for (Player pp : Server.auctionedplayers) {
            System.out.println(pp.getName());
        }

    }
    public void Back(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("clubmainpage.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add("sample/Loginpage.css");
        stage.setScene(scene);
        stage.show();
    }

}
