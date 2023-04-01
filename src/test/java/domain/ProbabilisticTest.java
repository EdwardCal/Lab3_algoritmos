package domain;

import org.junit.jupiter.api.Test;

import static org.testng.Assert.*;

public class ProbabilisticTest {

    @Test
    public void testProbabilistic() {
        Probabilistic probabilistic = new Probabilistic();

        int n1 = 30;
        int n2 = 23;
        int n3 = 57;
        int n4 = 10;
        int n5 = 85;
        int n6 = 5;


        System.out.printf("Birthday Paradox Probability for %d persons is: %.2f%%%n", n1, probabilistic.birthdayProbability(n1));
        System.out.printf("Birthday Paradox Probability for %d persons is: %.2f%%%n", n2, probabilistic.birthdayProbability(n2));
        System.out.printf("Birthday Paradox Probability for %d persons is: %.2f%%%n", n3, probabilistic.birthdayProbability(n3));
        System.out.printf("Birthday Paradox Probability for %d persons is: %.2f%%%n", n4, probabilistic.birthdayProbability(n4));
        System.out.printf("Birthday Paradox Probability for %d persons is: %.2f%%%n", n5, probabilistic.birthdayProbability(n5));
        System.out.printf("Birthday Paradox Probability for %d persons is: %.2f%%%n", n6, probabilistic.birthdayProbability(n6));

    }
}