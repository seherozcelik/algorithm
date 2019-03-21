import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class deneme3 {

    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
        Date gfgf;
        try {
            gfgf = sdf.parse("32022017");
            System.out.println(gfgf);
            System.out.println(sdf.format(gfgf));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}
