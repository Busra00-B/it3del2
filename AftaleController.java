package Aftale;

import java.util.List;

public class AftaleController {

    private AftaleDAO aftaleDAO;

    public AftaleController(AftaleDAO aftaleDAO){
        this.aftaleDAO =  new AftaleDAO();
    }

    public AftaleDAO getAftaleDAO() {
        return aftaleDAO;
    }

    public void saveAftale(Aftale nyAftale) {
        aftaleDAO.addAftale(nyAftale);
    }

}

/*
public class AftaleController {
    private AftaleDAO aftaleDAO = new AftaleDAO();
    public List<Aftale> getAftale() {return aftaleDAO.getAftale();}

    public void saveAftale(Aftale nyAftale) {
        aftaleDAO.addAftale(nyAftale);
    }

}
 */
