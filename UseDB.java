package DB;

import Aftale.Aftale;
import Aftale.AftaleController;
import Konsultation.Konsultation;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class UseDB {
        public static void main(String[] args) {
new Konsultation();

Aftale secondAftale = new Aftale(new Date(2021-1900, Calendar.NOVEMBER, 10), "10-12-1999-6767");

                Konsultation.getAftaleService().opretAftale(secondAftale);
                Konsultation.getAftaleService().ændreAftale(0, new Date(2021-1900, Calendar.JUNE, 20));
                System.out.println(Konsultation.getAftaleService().getAftale(0));
        }
}

    /*
        public static void main(String[] args) throws InterruptedException {
            DBConnector dbc = new DBConnector();
            Connection conn = dbc.getMYSQLConnection("pauline", "Pauline1234", "sundtek");
            ConnectionUser1 cu = new ConnectionUser1(conn);
            String dato;
        }
}
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import Aftale.AftaleController;

import java.sql.Connection;
import java.sql.Connection;
import java.lang.Thread;
import java.sql.Connection;

import java.sql.Date;
import Aftale.Aftale;
import Konsultation.Konsultation;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
     */