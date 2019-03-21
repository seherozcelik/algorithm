import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class deneme5 {

    public static void main(String[] args) {
//        BigDecimal ss = new BigDecimal("0.001");
//        if (BigDecimal.ZERO.compareTo(ss) >= 0) {
//            System.out.println("hey");
//        }
//        System.out.println(ss);
        
//        System.out.println("kdfjgldgj\nlkshhf");
//        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
//        try {
//            Date date1 = sdf.parse("22092017");
//            Date date2 = sdf.parse("29092017");
//            System.out.println(date2.compareTo(date1));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        
//        int m = 0;
//        m = 5-8;
//        
//        System.out.println(m);
        
        try {
            Date dd = deneme5.getBitTarih(2017, 4);
            System.out.println(dd);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
    }

    private static Date getBitTarih(Integer year, Integer period) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyHHmm");
        Date bitTarih;
        if (period.equals(1))
            bitTarih = sdf.parse("0104" + year + "0050");
        else if (period.equals(2))
            bitTarih = sdf.parse("0107" + year + "0050");
        else if (period.equals(3))
            bitTarih = sdf.parse("0110" + year + "0050");
        else {
            int yearNext = year + 1;
            bitTarih = sdf.parse("0101" + yearNext + "0050");
        }
        return bitTarih;
    }

}
