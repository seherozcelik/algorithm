package codewars;

import java.util.List;

public class BinaryArrayToNumber {

    public static int ConvertBinaryArrayToInt(List<Integer> binary) {
        Integer sum = 0;
        int j = 0;
        for(int i = binary.size()-1; i>=0; i--){
            sum = (int)(sum + binary.get(i) * Math.pow(2, j));
            j++;
        }
        return sum;
    }
}