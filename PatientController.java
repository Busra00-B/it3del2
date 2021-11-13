package Patient;

import java.util.List;
import java.util.ArrayList;

public class PatientController {

    private PatientDAO patientDAO;

    public PatientController(PatientDAO patientDAO){
        this.patientDAO = new PatientDAO();
    }

    public List<Patient> getPatients() {
        return patientDAO.getPatients();
    }

    public void addPatient(Patient patient){
        patientDAO.addPatient(patient);
    }
}



    /*
    private PatientDAO patientDAO = new PatientDAO();
    public List<Patient> getPatients() {
        return patientDAO.getPatients();
    }

    public void addPatient(Patient patient){
        patientDAO.addPatient(patient);
    }
}

     */
