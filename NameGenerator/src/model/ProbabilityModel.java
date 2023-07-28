package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

// A probability model for a category of names.
public class ProbabilityModel {

    String alphabet = "abcdefghijklmnopqrstuvwxyz'- ";
    Set<String> names;

    public ProbabilityModel(Set<String> names) {

        this.names = names;

    }

    public double[] firstLetterProbabilities() {
        double[] firstLetterProbabilities = new double[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        for (int i = 0; i < alphabet.length()-3; i++) {
            int count = 0;
            char c = alphabet.charAt(i);
            for (String name : names) {
                if (name.toLowerCase().startsWith(String.valueOf(c))) {
                    count++;
                }
            }
            firstLetterProbabilities[i] = count;
        }
        return firstLetterProbabilities;
    }


    public List<double[]> probabilitiesList() {
        List<double[]> probabilitiesList = new ArrayList<>();
        for (int i = 0; i < alphabet.length(); i++) {
            double[] probabilities = new double[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
            char c = alphabet.charAt(i);
            for (String name : names) {
                name = name.toLowerCase();
                List<Integer> indices = new ArrayList<>();
                for (int n = 0; n < name.length(); n++) {
                    if (name.charAt(n) == c) {
                        indices.add(n);
                    }
                }
                char[] charactersAfter = new char[indices.size()];
                for (int p = 0; p < indices.size(); p++) {
                    try {
                        charactersAfter[p] = name.charAt(indices.get(p)+1);
                    } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                        charactersAfter[p] = ' ';
                    }
                }
                for (char d : charactersAfter) {
                    for (int q = 0; q < alphabet.length(); q++) {
                        if (d == alphabet.charAt(q)) {
                            probabilities[q] = probabilities[q] + 2;
                        }
                    }
                }
            }
            probabilitiesList.add(probabilities);
        }
        return probabilitiesList;
    }

}
