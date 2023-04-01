package domain;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class VectorTest {

    @Test
    public void testVector() {
        Vector vector = new Vector(50);
        util.Utility.fill(vector);
        vector.sort();
        System.out.println("\nSORTED VECTOR..."+vector.toString());
        System.out.println("The vector has "+vector.size()+" elements");
        System.out.println(vector.isEmpty()
                ?"Vector is empty"
                :"Vector is not empty"
        );
        System.out.println(vector.contains(1));
        System.out.println("\nSORTED VECTOR..."+vector.toString());
        vector.add(1);
        System.out.println(vector.toString());
    }
}