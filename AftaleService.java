package Aftale;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.StreamingOutput;
import java.util.List;
import java.sql.*;
import java.util.Date;


@Path("aftaler")
public class AftaleService {
    private final AftaleController aftaleController = new AftaleController(new AftaleDAO());
    private PreparedStatement preparedStatement;
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;


    public AftaleService(Connection connection){
        this.connection = connection;
    }

    public AftaleController getAftaleController(){
        return aftaleController;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void opretAftale(Aftale nyAftale){
        aftaleController.saveAftale(nyAftale);
        addAftale(nyAftale);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Aftale getAftale(int index) {
        return aftaleController.getAftaleDAO().getAftaler().get(index);
    }


    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void ændreAftale(int index, Date nyDate){
        Aftale aftale = aftaleController.getAftaleDAO().getAftaler().get(index);
        Date beforeDate = aftale.getDate();
        aftale.setDate(nyDate);
        System.out.println("Aftale " + index + " has been changed from: " + beforeDate + " to: " + nyDate);
    }

    public void addAftale(Aftale aftale){
        String insertAftale = "INSERT INTO aftale (CPR, date)" + " VALUES ("+aftale.getCpr()+ ", " + aftale.getDate()+");";
        System.out.println(insertAftale);

        try{
            preparedStatement = connection.prepareStatement(insertAftale);
            preparedStatement.setString(1, aftale.getCpr());
            preparedStatement.setDate(2, (java.sql.Date) aftale.getDate());
            preparedStatement.execute();
        } catch (SQLException ex){
            System.out.println("Ups.. Der opstod en fejl under oprettelsen af aftalen. Prøv igen eller kontakt udviklerne!");
        }
    }

    public String hentAftale() throws NullPointerException {
        String patientcpr = "SELECT CPR from sundtek.aftale;";
        String CPRnr = "";
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(patientcpr);
            while(resultSet.next()){
                double cprNr = resultSet.getDouble(1);
                CPRnr = String.valueOf(cprNr);
            }
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("Wooops.. Kunne ikke hente aftalen. ");
        } return CPRnr;
    }

    public String hentCPR() throws NullPointerException {
        String patientaftale = "SELECT date FROM sundtek.aftale;";
        String date = "";
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(patientaftale);
            while (resultSet.next()) {
                Date datedata = resultSet.getDate(2);
                date = String.valueOf(datedata);
            }
        } catch (SQLException g) {
            g.printStackTrace();
            System.out.println("Ups.. Kunne ikke hente patientaftalen.. :(");
        }
        return date;
    }

}




    /*
    static AftaleController aftaleController = new AftaleController();
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void opretAftale(Aftale nyAftale){
        //System.out.println(nyAftale.getDate());
        //System.out.println(nyAftale.getCpr());
        aftaleController.saveAftale(nyAftale);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Aftale> getAftale() {
        return aftaleController.getAftale();
    }


            //public void hentAftale(Aftale nyAftale){
        //System.out.println(nyAftale.getDate());
        //System.out.println(nyAftale.getCpr());
        //aftaleController.saveAftale(nyAftale);
    //}
}

     */
