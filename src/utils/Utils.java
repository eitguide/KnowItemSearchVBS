package utils;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.Locale;
/**
 * Created by nguyennghia on 2/15/17.
 */
public class Utils {
    public static String getDateFromMillis(long seconds) {

        LocalTime timeOfDay = LocalTime.ofSecondOfDay(seconds);
        String time = timeOfDay.toString();

        return time;
    }
}
