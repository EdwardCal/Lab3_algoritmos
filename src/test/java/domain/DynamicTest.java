package domain;

import org.junit.jupiter.api.Test;

public class DynamicTest {
    @Test
    public void testDynamic(){
        Dynamic dm = new Dynamic();
        int n = 5;
        long factorial = dm.factorial(n);
        System.out.println("El factorial de " + n + " es " + factorial);
        int p = 6;
        long result=0;
        for (int i = 0; i <= p; i++) {
            result= dm.fibonacci(i);
        }
        System.out.println("El fibonacci de " + p + " es " + result);

    }



}