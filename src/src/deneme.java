import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class deneme {
    
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
        try {
            Date date = sdf.parse("01012015");
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            System.out.println(cal.get(Calendar.WEEK_OF_YEAR));
            String text = "Seher";
            String yaz = "";
            if(text.contains(".")){
                String[] textArr = text.split(".");
                yaz = textArr[0];
            }else{
                yaz = text;
            }
            System.out.println(yaz);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
