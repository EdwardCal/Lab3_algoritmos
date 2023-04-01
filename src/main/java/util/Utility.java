package util;

import domain.Vector;
import domain.VectorE;

import java.text.DecimalFormat;
import java.util.Random;

public class Utility {
    private static Random random;
    private static long seed; //semilla para el random
    //static initializer
    static {
        seed = System.currentTimeMillis();
        random = new Random(seed);
    }
    public static int random(int bound){
        //return 1+(int)Math.floor(Math.random()*bound);
        return 1+random.nextInt(bound);
    }

    public static String format(double value) {
        return new DecimalFormat("###,###,###.##")
                .format(value);
    }

    public static void fill(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            a[i] = random(99);
        }
    }

    public static void fill(Vector vector) {
        int n = vector.getN();
        for (int i = 0; i < n; i++) {
            vector.add(random(99));
        }
    }
    public static void fillE(VectorE vector) {
        int n = vector.getN();
        for (int i = 0; i < n; i++) {
            vector.add(random(99));
        }
    }
    public static void fillCountries(VectorE vector) {
        String[] countries = {"Costa Rica", "Panama", "Mexico", "Unite States", "Colombia", "Venezuela", "Cuba", "Belice","Japon", "China", "Corea", "Unite Kingdom", "Francia", "Marruecos", "Nigeria","Suecia"};
        int countriesN = countries.length-1;
        int n = vector.getN();
        for (int i = 0; i < n; i++) {
            vector.add(countries[random(countriesN )]);
        }
    }

    /**
     * a<b return -1
     * a>b return 1
     * a==b return 0
     * */
    public static int compare(Object a, Object b){
        switch(instanceOf(a, b)){
            case "Integer":
                Integer int1 = (Integer)a;
                Integer int2 = (Integer)b;
                return int1<int2? -1 : int1>int2? 1 : 0;

            case "String":
                String str1 = (String)a;
                String str2 = (String)b;
                return str1.compareTo(str2)<0? -1 : str1.compareTo(str2)>0? 1 : 0;

            case "Character":
                Character ch1 = (Character)a;
                Character ch2 = (Character)b;
                return ch1.compareTo(ch2)<0? -1 : ch1.compareTo(ch2)>0? 1 : 0;
        }
        return 2; //Unknown
    }

    private static String instanceOf(Object a, Object b) {
        if(a instanceof Integer && b instanceof Integer) return "Integer";
        if(a instanceof String && b instanceof String) return "String";
        if(a instanceof Character && b instanceof Character) return "Character";
        return "Unknown";
    }
}
