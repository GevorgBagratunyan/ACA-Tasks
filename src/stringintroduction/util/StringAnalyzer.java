package stringintroduction.util;

public class StringAnalyzer {

    private StringAnalyzer(){}

    public static int sumOfLengths(String a, String b){
        return a.length()+b.length();
    }

    public static String isLarger(String a, String b){
        return a.compareTo(b)>0 ? "Yes":"No";
    }

    public static String capitalize(String a, String b){
        String aCap = a.substring(0,1).toUpperCase() + a.substring(1);
        String bCap = b.substring(0,1).toUpperCase() + b.substring(1);

        return (aCap + " " + bCap);
    }

}
