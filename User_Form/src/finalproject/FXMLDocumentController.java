/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package finalproject;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;



/**
 *
 * @author Nowsin
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button login_btn;
    @FXML
    private Hyperlink create_acc;
    @FXML
    private Label m;
    @FXML
    private Label marco;

    private Connection connect;
    private PreparedStatement statement;
    private ResultSet result;
    @FXML
    private TextField su_username;
    @FXML
    private TextField su_email;
    @FXML
    private PasswordField su_password;
    @FXML
    private Button signup_btn;
    @FXML
    private Hyperlink login_acc;
    @FXML
    private Label m1;
    @FXML
    private Label marco1;
    @FXML
    private AnchorPane login_form;
    @FXML
    private AnchorPane signup_form;
    
    
    public Connection connectDb(){
        try{
             connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/finalproject", "root","root");
              
            return connect;
        }catch(Exception e){e.printStackTrace();}
        return null;
    }
   
    @FXML
    public void login(ActionEvent event)
    {
         connect = connectDb();
        
        try{
            
            String sql = "  SELECT * FROM store WHERE username = ? and password = ? ";
            
            
            statement = (PreparedStatement) connect.prepareStatement(sql);
            statement.setString(1,username.getText());
            statement.setString(2,password.getText());
            
             
            result = statement.executeQuery();
            
            
            if(result.next())
            {
                
                
                JOptionPane.showMessageDialog(null,"Successfully Login", "From Admin", JOptionPane.INFORMATION_MESSAGE);
                
                
                    login_btn.getScene().getWindow().hide();
                    Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.setTitle("Simple Dashboard");
                    stage.show();
                    
            }else{
                
                JOptionPane.showMessageDialog(null,"Wrong Username/Password","Nowsin Massage", JOptionPane.ERROR_MESSAGE);
            }
            
        
        }catch(Exception e){e.printStackTrace();}
    
    }
    
    
    public void signup(ActionEvent event)
    {
        connect = connectDb();
        
        try{
            
            String sql = "INSERT INTO store VALUES(?,?,?)";
            
            statement = (PreparedStatement) connect.prepareStatement(sql);
            statement.setString(1,su_username.getText());
            statement.setString(2,su_password.getText());
            statement.setString(3,su_email.getText());
            statement.execute();
            
            JOptionPane.showMessageDialog(null,"Successfully Create New Account!", "Nowsin Massage",JOptionPane.INFORMATION_MESSAGE);
            
        
        }catch(Exception e){e.printStackTrace();}
    }
    
    public void changeForm(ActionEvent event){
        if(event.getSource() == login_acc){
            
            signup_form.setVisible(false);
            login_form.setVisible(true);
            
        }else if(event.getSource() == create_acc)
        {
            signup_form.setVisible(true);
            login_form.setVisible(false);
        }
    }
    
    
    @FXML
    public void exit()
    {
        System.exit(0);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        DropShadow original = new DropShadow(80, Color.valueOf("#ebf5fb"));
         
        m.setEffect(original);
        marco.setEffect(original);
        
        m1.setEffect(original);
        marco1.setEffect(original);
        
        
        m.setOnMouseEntered((var event)->{
            
            DropShadow shadow = new DropShadow(80, Color.valueOf("#ebf5fb"));
            m.setStyle("-fx-text-fill:#ffff");
            m.setEffect(shadow);
            marco.setEffect(shadow);
        });
        
        m.setOnMouseExited((MouseEvent event) ->
        {
            DropShadow shadow = new DropShadow(80, Color.valueOf("#ebf5fb"));
            m.setStyle("-fx-text-fill:#ebf5fb");
            m.setEffect(shadow);
            marco.setEffect(shadow);
        });
        
        
        
         marco.setOnMouseEntered((var event)->{
            
            DropShadow shadow = new DropShadow(80, Color.valueOf("#ebf5fb"));
            m.setStyle("-fx-text-fill:#ffff");
            m.setEffect(shadow);
            marco.setEffect(shadow);
        });
        
        marco.setOnMouseExited((MouseEvent event) ->
        {
            DropShadow shadow = new DropShadow(80, Color.valueOf("#ebf5fb"));
            m.setStyle("-fx-text-fill:#ebf5fb");
            m.setEffect(shadow);
            marco.setEffect(shadow);
        });
        
        
        
        //--------------------
        
        
        
         m1.setOnMouseEntered((var event)->{
            
            DropShadow shadow = new DropShadow(80, Color.valueOf("#17202a"));
            m1.setStyle("-fx-text-fill:#fff");
            m1.setEffect(shadow);
            marco1.setEffect(shadow);
        });
        
        m1.setOnMouseExited((MouseEvent event) ->
        {
            DropShadow shadow = new DropShadow(80, Color.valueOf("#ffffff"));
            m1.setStyle("-fx-text-fill:#ffffff");
            m1.setEffect(shadow);
            marco1.setEffect(shadow);
        });
        
        
        
         marco1.setOnMouseEntered((var event)->{
            
            DropShadow shadow = new DropShadow(80, Color.valueOf("#17202a"));
            m1.setStyle("-fx-text-fill:#fff");
            m1.setEffect(shadow);
            marco1.setEffect(shadow);
        });
        
        marco1.setOnMouseExited((MouseEvent event) ->
        {
            DropShadow shadow = new DropShadow(80, Color.valueOf("#6a9ae7"));
            m1.setStyle("-fx-text-fill:#ffffff");
            m1.setEffect(shadow);
            marco1.setEffect(shadow);
        });
        
        
    }    

  
       
    
}
