package DB;

import javax.validation.constraints.Null;
import java.sql.*;
import Aftale.Aftale;
import Aftale.AftaleController;

public class ConnectionUser1 {

    private final Connection connection;

    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private double cprdata;
    private String CPRdata="";
    private Date datedata;
    private String DATEdata="";
    private AftaleController aftaleController;

    public ConnectionUser1(Connection connection) {
        this.connection = connection;

    }

}


    /*
    private final Connection connection;

    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private double cprdata;
    private String CPRdata="";
    private Date datedata;
    private String DATEdata="";

    public ConnectionUser1(Connection connection) {
        this.connection = connection;
    }

    public void addAftale(String value1, Date value2){
        String aftaler = "INSERT INTO aftale (CPR, date) VALUES (?,?);";
        try{
            preparedStatement = connection.prepareStatement(aftaler);
            preparedStatement.setString(1, value1);
            preparedStatement.setDate(2, value2);
            preparedStatement.execute();
        } catch (SQLException ex){
            System.out.println("fejl");
        }
    }

    public String hentAftale () throws NullPointerException {
        String patientcpr = "SELECT CPR from sundtek.aftale;";
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(patientcpr);
            while(resultSet.next()){
                cprdata = resultSet.getDouble(1);
                CPRdata = String.valueOf(cprdata);
            }
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("fejl2");
        } return CPRdata;
    }

    public String hentCPR() throws NullPointerException {
        String patientaftale = "SELECT date FROM sundtek.aftale;";
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(patientaftale);
            while(resultSet.next()){
                datedata = resultSet.getDate(2);
                DATEdata = String.valueOf(datedata);
            }
            }catch (SQLException g){
            g.printStackTrace();
            System.out.println("fejl3");
        }
        return DATEdata;
    }
}

     */