package ui;

import model.Multinomial;
import model.ProbabilityModel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class NameGenerator {

    private static final String path1 = "./data/names1.csv"; // contains Altmer, Argonian, Bosmer, Breton, Dunmer, Imperial, Khajiit names
    private static final String path2 = "./data/names2.csv"; // contains Nord, Orc, Redguard, Human names

    private Set<String> names;
    public Set<String> maleAltmerNames = new HashSet<>();
    public Set<String> femaleAltmerNames = new HashSet<>();
    public Set<String> familyAltmerNames = new HashSet<>();
    public Set<String> maleArgonianNames = new HashSet<>();
    public Set<String> femaleArgonianNames = new HashSet<>();
    public Set<String> familyArgonianNames = new HashSet<>();
    public Set<String> maleBosmerNames = new HashSet<>();
    public Set<String> femaleBosmerNames = new HashSet<>();
    public Set<String> familyBosmerNames = new HashSet<>();
    public Set<String> maleBretonNames = new HashSet<>();
    public Set<String> femaleBretonNames = new HashSet<>();
    public Set<String> familyBretonNames = new HashSet<>();
    public Set<String> maleDunmerNames = new HashSet<>();
    public Set<String> femaleDunmerNames = new HashSet<>();
    public Set<String> familyDunmerNames = new HashSet<>();
    public Set<String> maleImperialNames = new HashSet<>();
    public Set<String> femaleImperialNames = new HashSet<>();
    public Set<String> familyImperialNames = new HashSet<>();
    public Set<String> maleKhajiitNames = new HashSet<>();
    public Set<String> femaleKhajiitNames = new HashSet<>();
    public Set<String> familyKhajiitNames = new HashSet<>();
    public Set<String> maleNordNames = new HashSet<>();
    public Set<String> femaleNordNames = new HashSet<>();
    public Set<String> familyNordNames = new HashSet<>();
    public Set<String> maleOrcNames = new HashSet<>();
    public Set<String> femaleOrcNames = new HashSet<>();
    public Set<String> familyOrcNames = new HashSet<>();
    public Set<String> maleRedguardNames = new HashSet<>();
    public Set<String> femaleRedguardNames = new HashSet<>();
    public Set<String> familyRedguardNames = new HashSet<>();
    public Set<String> femaleHumanNames = new HashSet<>();

    public NameGenerator() {
        loadData();
        names = new HashSet<>();
        new Window(this);
    }

    public Set<String> getNames() {
        return names;
    }

    public void setNames(Set<String> names) {
        this.names = names;
    }

    public void loadData() {
        try {
            String line = "";
            BufferedReader bufferedReader1 = new BufferedReader(new FileReader(path1));
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(path2));

            while ((line = bufferedReader1.readLine()) != null) {
                String[] names = line.split(",");
                for (int i = 0; i < names.length; i++) {
                    addNameToSet1(names[i].toLowerCase(), i);
                }
            }

            while ((line = bufferedReader2.readLine()) != null) {
                String[] names = line.split(",");
                for (int i = 0; i < names.length; i++) {
                    addNameToSet2(names[i].toLowerCase(), i);
                }
            }

        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Files not found.");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    private void addNameToSet1(String name, int i) {
        switch (i) {
            case 0:
                maleAltmerNames.add(name);
            case 2:
                femaleAltmerNames.add(name);
            case 3:
                familyAltmerNames.add(name);
            case 4:
                maleArgonianNames.add(name);
            case 5:
                femaleArgonianNames.add(name);
            case 6:
                familyArgonianNames.add(name);
            case 7:
                maleBosmerNames.add(name);
            case 8:
                femaleBosmerNames.add(name);
            case 9:
                familyBosmerNames.add(name);
            case 10:
                maleBretonNames.add(name);
            case 11:
                femaleBretonNames.add(name);
            case 12:
                familyBretonNames.add(name);
            case 13:
                maleDunmerNames.add(name);
            case 14:
                femaleDunmerNames.add(name);
            case 15:
                familyDunmerNames.add(name);
            case 16:
                maleImperialNames.add(name);
            case 17:
                femaleImperialNames.add(name);
            case 18:
                familyImperialNames.add(name);
            case 19:
                maleKhajiitNames.add(name);
            case 20:
                femaleKhajiitNames.add(name);
            default:
                familyKhajiitNames.add(name);
        }
    }

    private void addNameToSet2(String name, int i) {
        switch (i) {
            case 0:
                maleNordNames.add(name);
            case 1:
                femaleNordNames.add(name);
            case 2:
                familyNordNames.add(name);
            case 3:
                maleOrcNames.add(name);
            case 4:
                femaleOrcNames.add(name);
            case 5:
                familyOrcNames.add(name);
            case 6:
                maleRedguardNames.add(name);
            case 7:
                femaleRedguardNames.add(name);
            case 8:
                familyRedguardNames.add(name);
            default:
                femaleHumanNames.add(name);
        }
    }

    public String generateName() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz'- ";
        String name = "";
        boolean doneGenerating = false;
        ProbabilityModel model = new ProbabilityModel(names);

        Multinomial firstLetterMultinomial = new Multinomial(model.firstLetterProbabilities());
        name = name.concat(String.valueOf(firstLetterMultinomial.sampleFirstLetter()));

        while (!doneGenerating) {
            char currentLetter = name.charAt(name.length() - 1);
            if (currentLetter == ' ') {
                doneGenerating = true;
            }
            for (int i = 0; i < alphabet.length(); i++) {
                if (currentLetter == alphabet.charAt(i)) {
                    Multinomial multinomial = new Multinomial(model.probabilitiesList().get(i));
                    char nextLetter = multinomial.sampleLetter();
                    while (nextLetter == ' ' && name.length() < 4) {
                        nextLetter = multinomial.sampleLetter();
                    }
                    name = name.concat(String.valueOf(nextLetter));
                    if (name.length() > 10) {
                        name = name.concat(" ");
                        doneGenerating = true;
                    }
                }
            }
        }
        return name.substring(0,1).toUpperCase() + name.substring(1);
    }
}
