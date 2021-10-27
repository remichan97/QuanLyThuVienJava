package aptech.project2.nhom2.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {
    public static String convertDate(Date date) {
        return new SimpleDateFormat("dd/MM/yyyy").format(date);
    }
}
