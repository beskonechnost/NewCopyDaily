package XMLparser;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * Created by Андрей on 22.01.2018.
 */
public class ParseDouble {
    public static Number parse(NumberFormat format, String value) {
        try {
            return format.parse(value);
        } catch (ParseException ex) {
            System.out.println("Unable to parse [" + value + "] with supplied formatter");
        }
        return null;
    }

    public static BigDecimal doubleForAccess(String string){

        NumberFormat germanFormat = NumberFormat.getNumberInstance(Locale.GERMANY);
        germanFormat.setParseIntegerOnly(false);

        Number number = ParseDouble.parse(germanFormat, string);
        double result = number.doubleValue();
        return new BigDecimal(result).setScale(2, RoundingMode.HALF_UP);
    }
}
