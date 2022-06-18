package ControllerClasses;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class OutgoingControl {
    public JFXButton viewports;
    public JFXButton incstocksbtn;
    public JFXButton outgostocksbtn;
    public JFXButton logoutbtn;
    public JFXButton swuserbtn;
    public TextField qttf;
    public TextField pctf;
    public JFXButton rem2;
    public TextField pctf2;
    public JFXButton rem1;
    public Label greenlbl;
    public Label redlbl;
    public Label greenlbl2;

    @FXML
    public void ViewStockOpenAction(ActionEvent evt) throws IOException {
        Parent AdminBoard = FXMLLoader.load((getClass().getResource("/pageDesigns/ViewStock.fxml")));
        Scene AdminBoardScene = new Scene(AdminBoard);
        Stage userStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        userStage.setScene(AdminBoardScene);
        userStage.setTitle("Welcome to LoggIt");
        userStage.show();
    }

    @FXML
    public void IncomingOpen(ActionEvent evt) throws IOException {
        Parent AdminBoard = FXMLLoader.load((getClass().getResource("/pageDesigns/Incoming.fxml")));
        Scene AdminBoardScene = new Scene(AdminBoard);
        Stage userStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        userStage.setScene(AdminBoardScene);
        userStage.setTitle("Welcome to LoggIt");
        userStage.show();
    }

    @FXML
    public void RemoveProd(ActionEvent evt) throws IOException{
        int pcode;
        pcode=Integer.parseInt(pctf.getText());

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logit", "root", "tanisha0714");
            Statement stmt = con.createStatement();
            stmt.executeUpdate("delete from logit.stocks where Prodcode="+pcode);
            greenlbl.setText("Product removed Successfully");
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    @FXML
    public void RemoveUnit(ActionEvent evt) throws IOException{
        int pcode2,qt2;
        pcode2=Integer.parseInt(pctf2.getText());
        qt2=Integer.parseInt(qttf.getText());
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logit", "root", "tanisha0714");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select Qty from stocks where Prodcode="+pcode2);
            if(rs.next()){
                int x=rs.getInt("Qty");
                if(x>qt2){
                    stmt.executeUpdate("update stocks set Qty="+(x-qt2)+" where Prodcode="+pcode2);
                    greenlbl2.setText("Unit removed successfully!");
                    redlbl.setText("");

                }
                else{
                    redlbl.setText("ERROR");
                    greenlbl2.setText("");
                }
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void LogOut(ActionEvent evt) throws IOException {
        Parent AdminBoard = FXMLLoader.load((getClass().getResource("/pageDesigns/Login.fxml")));
        Scene AdminBoardScene = new Scene(AdminBoard);
        Stage userStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        userStage.setScene(AdminBoardScene);
        userStage.setTitle("Log In");
        userStage.show();
    }
}
