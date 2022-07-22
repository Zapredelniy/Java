//Перевод римских цифр в десятичные

import java.util.Map;
import java.util.HashMap;

public class First {
    public static void main(String[] args) {
        System.out.println(Solution.romanToInt("MCMXCIV"));
    }
}
class Solution {
    String s;
    public static int romanToInt(String s) {
        Map<String, Integer> date = new HashMap();
        int sum = 0;

        date.put("I", 1);
        date.put("V", 5);
        date.put("X", 10);
        date.put("L", 50);
        date.put("C", 100);
        date.put("D", 500);
        date.put("M", 1000);

        String[] alfa = s.split("(?!^)");

        for (int i = 0; i < alfa.length; i++){
            if ((date.get(alfa[i]) == 1) && (alfa.length > i+1)
                    && ((date.get(alfa[i+1]) == 5) || (date.get(alfa[i+1]) == 10))){
                sum -= date.get(alfa[i]);
            }
            else if ((date.get(alfa[i]) == 10) && (alfa.length > i+1)
                    && ((date.get(alfa[i+1]) == 50) || (date.get(alfa[i+1]) == 100))){
                sum -= date.get(alfa[i]);
            }
            else if ((date.get(alfa[i]) == 100) && (alfa.length > i+1)
                    && ((date.get(alfa[i+1]) == 500) || (date.get(alfa[i+1]) == 1000))){
                sum -= date.get(alfa[i]);
            }
            else{
                sum += date.get(alfa[i]);
            }
        }
        return(sum);
    }
}

