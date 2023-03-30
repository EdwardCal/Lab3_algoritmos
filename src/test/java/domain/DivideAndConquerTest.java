package domain;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DivideAndConquerTest {

    @Test
    public void testBinarySearch() {
        Vector vector = new Vector(50);
        util.Utility.fill(vector);
        System.out.println(vector.toString());
        vector.sort();
        System.out.println("\nSORTED VECTOR..."+vector.toString());

        System.out.println("BINARY SEARCH TEST...");
        for (int i = 0; i < 20; i++) {
            int value = util.Utility.random(99);
            //java.util.Arrays
            //int indexArrays =

        }
    }
}