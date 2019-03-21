import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

public class deneme2 {

    public static void main(String[] args) {
        BigDecimal dd = new BigDecimal(12.123);
        dd = dd.setScale(2, RoundingMode.HALF_UP);
        System.out.println(dd.toString());
        
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyHHmm");
        String ddd = sdf.format(new Date());
        System.out.println(ddd);
        
        
        String cc = "sehre";
        String ccc = "sheer";
        
        System.out.println(cc.hashCode());
        System.out.println(ccc.hashCode());
        
        String ss = "seher";
        String sss = "sheer";
        
              System.out.println(ss.hashCode());
              System.out.println(sss.hashCode());
        
        HashSet<String> dhfgdj = new HashSet<String>();
        dhfgdj.add(ccc);
        dhfgdj.add(cc);
        dhfgdj.add(ss);
        dhfgdj.add(sss);
        
        System.out.println(dhfgdj);
    }

}
