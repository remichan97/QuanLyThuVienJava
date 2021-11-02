package aptech.project2.nhom2.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateUtil {
    public static String convertDate(Date date) {
        return new SimpleDateFormat("dd/MM/yyyy").format(date);
    }

    public static long compareDate(Date day1, Date day2) {
        long diffInMillies = Math.abs(day2.getTime() - day1.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        return diff;
    }

}
