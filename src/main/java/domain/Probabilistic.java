package domain;

public class Probabilistic {
    public double birthdayProbability(int n) {
        if (n <= 1) {
            return 0.0;
        }
        double probability = 1.0;
        for (int i = 1; i <= n; i++) {
            probability *= (366.0 - i) / 365.0;
        }
        return (1.0 - probability) * 100.0;
    }



}
