package Konsultation;
import Aftale.AftaleService;
import DB.ConnectionUser1;
import DB.DBConnector;
import Patient.PatientService;

import java.sql.Connection;

public class Konsultation {

        private static AftaleService aftaleService;
        private static PatientService patientService;
        private static final Connection connection = new DBConnector().getMYSQLConnection("pauline", "Pauline1234", "sundtek");


        public Konsultation(){
            aftaleService = new AftaleService(connection);
            patientService = new PatientService(connection);

        }

        public static AftaleService getAftaleService(){
            return aftaleService;
        }

        public static PatientService getPatientService(){
            return patientService;
        }


    }


