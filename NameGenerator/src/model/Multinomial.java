package model;

import java.util.Random;

public class Multinomial {
    static Random generator = new Random();
    double[] distribution;
    int range;

    //Constructor
    public Multinomial(double[] probabilities) {
        range = probabilities.length;
        distribution = new double[range];
        double sumProb = 0;
        for (double value : probabilities) {
            sumProb += value;
        }
        double position = 0;
        for (int i = 0; i < range; ++i) {
            position += probabilities[i] / sumProb;
            distribution[i] = position;
        }
        distribution[range - 1] = 1.0;
    }

    public int sample() {
        double uniform = generator.nextDouble();
        for (int i = 0; i < range; ++i) {
            if (uniform < distribution[i]) {
                return i;
            }
        }
        return range - 1;
    }


    // REQUIRES: this Multinomial has 29 categories
    public char sampleLetter() {
            String alphabet = "abcdefghijklmnopqrstuvwxyz'- ";
            return alphabet.charAt(this.sample());
    }

    // REQUIRES: this Multinomial has 26 categories
    public char sampleFirstLetter() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        return alphabet.charAt(this.sample());
    }

}