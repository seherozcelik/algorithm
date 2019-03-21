import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class deneme4 {

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyy");
        try {
            Date date1 = deneme4.truncDate(new Date());
            Date date2 = sdf.parse("140317");
            if (!date2.after(date1)) {
                System.out.println("degilim");
            } else {
                System.out.println("after im");
            }
            System.out.println(date1);
            System.out.println(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    
    public static Date truncDate(Date dt) {
        if(dt == null) {
            return null;
        }
          return toTruncCalendar(dt).getTime();
      }
    
    public static Calendar toTruncCalendar(Date date){
        if(date == null){
            return null;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY,0);
        c.set(Calendar.SECOND,0);
        c.set(Calendar.MINUTE,0);
        c.set(Calendar.MILLISECOND,0);
        return c;
    }

}
