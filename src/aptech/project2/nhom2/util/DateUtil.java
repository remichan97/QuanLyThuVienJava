package aptech.project2.nhom2.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DateUtil {
    public static String convertDate(Date date) {
        return new SimpleDateFormat("dd/MM/yyyy").format(date);
    }

    public static int compareDate(Date day1, Date day2) {
        LocalDate date1 = day1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate date2 = day2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int daysBetween = (int) ChronoUnit.DAYS.between(date1, date2);
        return daysBetween;
    }
}
