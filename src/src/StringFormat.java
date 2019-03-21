import java.math.BigDecimal;
import java.math.RoundingMode;

public class StringFormat {

    public static void main(String[] args) {

        BigDecimal amount = new BigDecimal(28894.42);
        //        amount = amount.setScale(2, RoundingMode.HALF_UP);
        //        System.out.println(amount);
        //        String amountStr = String.format("%.2f", amount);//.replace(".", "");
        //        System.out.println(String.format("%17s", amountStr).replace(" ", "0"));
        //        System.out.println(String.format("%4s", 234).replace(" ", "0"));

        String dd = formatCurrency(amount);
        System.out.println(dd);

    }

    private static String formatCurrency(BigDecimal tutar) {
        if (tutar == null)
            tutar = BigDecimal.ZERO;
        tutar = tutar.setScale(2, RoundingMode.HALF_UP);
        String tutarStr = tutar.toString();
        String tutarFirstPart = tutarStr.substring(0, tutarStr.length() - 3);
        String[] dizi = new String[tutarFirstPart.length()];
        for (int i = 0; i < dizi.length; i++) {
            dizi[i] = tutarFirstPart.substring(i, i + 1);
        }
        int k = 0;
        String firstPart = "";
        for (int i = dizi.length - 1; i >= 0; i--) {
            if (k != 0 && k % 3 == 0)
                firstPart = "." + firstPart;
            firstPart = dizi[i] + firstPart;
            k++;
        }
        return firstPart + "," + tutarStr.substring(tutarStr.length() - 2, tutarStr.length());
    }

}
