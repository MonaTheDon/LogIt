package ControllerClasses;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class UserRegisControl {
    public TextField fname;
    public TextField lname;
    public TextField usname;
    public TextField ogname;
    public PasswordField pass;
    public PasswordField pass2;
    public ComboBox busCB;
    public JFXButton createBTN;
    public JFXButton logBTN;

    @FXML
    public void RegisterAction(ActionEvent evt) {
        String first=fname.getText();
        String last = lname.getText();
        String user = usname.getText();
        String passw = pass.getText();
        String passw2 = pass2.getText();
        String busstype = (busCB.getValue()).toString();
        String bussname = ogname.getText();

        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logit","root","tanisha0714");
            Statement stmt = con.createStatement();
            if(passw.equals(passw2)) {
                stmt.executeUpdate("insert into userdetails values('" + first + "','" + last + "','" + user + "','" + passw + "','" + busstype + "','" + bussname + "')");
                stmt.executeUpdate("insert into logindetails values('"+user+"','"+passw+"')");

            }

        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    @FXML
    public void ClearAction(ActionEvent evt){
        fname.setText("");
        lname.setText("");
        pass.setText("");
        pass2.setText("");
        usname.setText("");
        busCB.setValue("");
        ogname.setText("");

    }
}
