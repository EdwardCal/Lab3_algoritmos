package domain;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class VectorETest {
    @Test
    public void testVector() {
        VectorE vector = new VectorE(50);
        util.Utility.fillE(vector);
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