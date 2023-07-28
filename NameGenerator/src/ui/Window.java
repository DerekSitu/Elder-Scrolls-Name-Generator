package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Window extends JFrame {

    private int WIDTH = 600;
    private int HEIGHT = 600;

    NameGenerator nameGenerator;
    JCheckBox firstNameButton;
    JCheckBox lastNameButton;
    JRadioButton maleButton;
    JRadioButton femaleButton;
    JRadioButton altmerButton;
    JRadioButton argonianButton;
    JRadioButton bosmerButton;
    JRadioButton bretonButton;
    JRadioButton dunmerButton;
    JRadioButton imperialButton;
    JRadioButton khajiitButton;
    JRadioButton nordButton;
    JRadioButton orcButton;
    JRadioButton redguardButton;
    JLabel nameLabel;
    Boolean isFirstSelected;
    Boolean isLastSelected;
    String gender;
    String race;

    public Window(NameGenerator nameGenerator) {
        this.nameGenerator = nameGenerator;
        initializeWindow();
        initializeLabels();
        initializeFirstLastButtons();
        initializeGenderButtons();
        initializeRaceButtons();
        initializeGenerateButton();
    }

    private void initializeWindow() {
        this.setIconImage(new ImageIcon("NGicon.png").getImage());
        this.setTitle("The Elder Scrolls Name Generator");
        this.setSize(WIDTH, HEIGHT);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLayout(null);
    }

    private void initializeLabels() {
        JLabel firstOrLastLabel = new JLabel("Select whether to generate a first name, last name, or both.");
        firstOrLastLabel.setBounds(115,20,550,15);
        this.add(firstOrLastLabel);

        JLabel genderLabel = new JLabel("Select a gender.");
        genderLabel.setBounds(240, 90, 200, 15);
        this.add(genderLabel);

        JLabel raceLabel = new JLabel("Select a race.");
        raceLabel.setBounds(250, 160, 200, 15);
        this.add(raceLabel);
    }

    public void initializeFirstLastButtons() {
        FirstOrLastListener firstOrLastListener = new FirstOrLastListener();

        firstNameButton = new JCheckBox("First");
        firstNameButton.addItemListener(firstOrLastListener);
        firstNameButton.setBounds(200, 55, 60, 15);
        this.add(firstNameButton);
        firstNameButton.setSelected(true);
        isFirstSelected = true;

        lastNameButton = new JCheckBox("Last");
        lastNameButton.addItemListener(firstOrLastListener);
        lastNameButton.setBounds(300, 55, 60, 15);
        this.add(lastNameButton);
        lastNameButton.setSelected(true);
        isLastSelected = true;
    }

    private void initializeGenderButtons() {
        RadioButtonListener radioButtonListener = new RadioButtonListener();
        ButtonGroup genderButtonGroup = new ButtonGroup();

        maleButton = new JRadioButton("Male");
        genderButtonGroup.add(maleButton);
        maleButton.setActionCommand("Male");
        maleButton.setSelected(true);
        gender = "Male";
        maleButton.addActionListener(radioButtonListener);
        maleButton.setBounds(200, 125, 60, 15);
        this.add(maleButton);

        femaleButton = new JRadioButton("Female");
        genderButtonGroup.add(femaleButton);
        femaleButton.setActionCommand("Female");
        femaleButton.addActionListener(radioButtonListener);
        femaleButton.setBounds(300, 125, 100, 15);
        this.add(femaleButton);
    }

    private void initializeRaceButtons() {
        ButtonGroup raceButtonGroup = new ButtonGroup();
        RadioButtonListener radioButtonListener = new RadioButtonListener();

        altmerButton = new JRadioButton("Altmer");
        altmerButton.setBounds(200, 200, 100, 15);
        altmerButton.setActionCommand("Altmer");
        altmerButton.addActionListener(radioButtonListener);
        altmerButton.setSelected(true);
        race = "Altmer";
        raceButtonGroup.add(altmerButton);
        this.add(altmerButton);

        argonianButton = new JRadioButton("Argonian");
        argonianButton.setBounds(300,200, 100, 15);
        argonianButton.setActionCommand("Argonian");
        argonianButton.addActionListener(radioButtonListener);
        raceButtonGroup.add(argonianButton);
        this.add(argonianButton);

        bosmerButton = new JRadioButton("Bosmer");
        bosmerButton.setBounds(200,240,100,15);
        bosmerButton.setActionCommand("Bosmer");
        bosmerButton.addActionListener(radioButtonListener);
        raceButtonGroup.add(bosmerButton);
        this.add(bosmerButton);

        bretonButton = new JRadioButton("Breton");
        bretonButton.setBounds(300,240,100,15);
        bretonButton.setActionCommand("Breton");
        bretonButton.addActionListener(radioButtonListener);
        raceButtonGroup.add(bretonButton);
        this.add(bretonButton);

        dunmerButton = new JRadioButton("Dunmer");
        dunmerButton.setBounds(200,280,100,15);
        dunmerButton.setActionCommand("Dunmer");
        dunmerButton.addActionListener(radioButtonListener);
        raceButtonGroup.add(dunmerButton);
        this.add(dunmerButton);

        imperialButton = new JRadioButton("Imperial");
        imperialButton.setBounds(300,280,100,15);
        imperialButton.setActionCommand("Imperial");
        imperialButton.addActionListener(radioButtonListener);
        raceButtonGroup.add(imperialButton);
        this.add(imperialButton);

        khajiitButton = new JRadioButton("Khajiit");
        khajiitButton.setBounds(200,320,100,15);
        khajiitButton.setActionCommand("Khajiit");
        khajiitButton.addActionListener(radioButtonListener);
        raceButtonGroup.add(khajiitButton);
        this.add(khajiitButton);

        nordButton = new JRadioButton("Nord");
        nordButton.setBounds(300,320,100,15);
        nordButton.setActionCommand("Nord");
        nordButton.addActionListener(radioButtonListener);
        raceButtonGroup.add(nordButton);
        this.add(nordButton);

        orcButton = new JRadioButton("Orc");
        orcButton.setBounds(200,360,100,15);
        orcButton.setActionCommand("Orc");
        orcButton.addActionListener(radioButtonListener);
        raceButtonGroup.add(orcButton);
        this.add(orcButton);

        redguardButton = new JRadioButton("Redguard");
        redguardButton.setBounds(300,360,100,15);
        redguardButton.setActionCommand("Redguard");
        redguardButton.addActionListener(radioButtonListener);
        raceButtonGroup.add(redguardButton);
        this.add(redguardButton);
    }

    private void initializeGenerateButton() {
        JButton generateButton = new JButton("Generate!");
        generateButton.setBounds(WIDTH/2 - 65, HEIGHT - 200, 100, 30);
        generateButton.addActionListener(new GenerateButtonListener());
        this.add(generateButton);

        nameLabel = new JLabel("");
        nameLabel.setBounds(WIDTH/2 - 60, HEIGHT - 100, 500, 15);
        this.add(nameLabel);
    }

    private class FirstOrLastListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            Object source = e.getItemSelectable();

            if (source == firstNameButton) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    isFirstSelected = true;
                } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    isFirstSelected = false;
                }
            } else if (source == lastNameButton) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    isLastSelected = true;
                } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    isLastSelected = false;
                }
            }
        }
    }

    private class RadioButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Male")) {
                gender = "Male";
            } else if (e.getActionCommand().equals("Female")) {
                gender = "Female";
            } else {
                race = e.getActionCommand();
            }
        }
    }

    private class GenerateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = "";
            if (isFirstSelected) {
                name = getFirstName();
            }
            if (isLastSelected) {
                name = name + getLastName();
            }
            nameLabel.setText(name);
        }

        private String getLastName() {
                switch (race) {
                    case "Altmer":
                        nameGenerator.setNames(nameGenerator.familyAltmerNames);
                    case "Argonian":
                        nameGenerator.setNames(nameGenerator.familyArgonianNames);
                    case "Bosmer":
                        nameGenerator.setNames(nameGenerator.familyBosmerNames);
                    case "Breton":
                        nameGenerator.setNames(nameGenerator.familyBretonNames);
                    case "Dunmer":
                        nameGenerator.setNames(nameGenerator.familyDunmerNames);
                    case "Imperial":
                        nameGenerator.setNames(nameGenerator.familyImperialNames);
                    case "Khajiit":
                        nameGenerator.setNames(nameGenerator.familyKhajiitNames);
                    case "Nord":
                        nameGenerator.setNames(nameGenerator.familyNordNames);
                    case "Orc":
                        nameGenerator.setNames(nameGenerator.familyOrcNames);
                    default:
                        nameGenerator.setNames(nameGenerator.familyRedguardNames);
                }
                return nameGenerator.generateName();
        }

        private String getFirstName() {
                switch (race) {
                    case "Altmer":
                        if (gender.equals("Male")) {
                            nameGenerator.setNames(nameGenerator.maleAltmerNames);
                        } else {
                            nameGenerator.setNames(nameGenerator.femaleAltmerNames);
                        }
                    case "Argonian":
                        if (gender.equals("Male")) {
                            nameGenerator.setNames(nameGenerator.maleArgonianNames);
                        } else {
                            nameGenerator.setNames(nameGenerator.femaleArgonianNames);
                        }
                    case "Bosmer":
                        if (gender.equals("Male")) {
                            nameGenerator.setNames(nameGenerator.maleBosmerNames);
                        } else {
                            nameGenerator.setNames(nameGenerator.femaleBosmerNames);
                        }
                    case "Breton":
                        if (gender.equals("Male")) {
                            nameGenerator.setNames(nameGenerator.maleBretonNames);
                        } else {
                            nameGenerator.setNames(nameGenerator.femaleBretonNames);
                        }
                    case "Dunmer":
                        if (gender.equals("Male")) {
                            nameGenerator.setNames(nameGenerator.maleDunmerNames);
                        } else {
                            nameGenerator.setNames(nameGenerator.femaleDunmerNames);
                        }
                    case "Imperial":
                        if (gender.equals("Male")) {
                            nameGenerator.setNames(nameGenerator.maleImperialNames);
                        } else {
                            nameGenerator.setNames(nameGenerator.femaleImperialNames);
                        }
                    case "Khajiit":
                        if (gender.equals("Male")) {
                            nameGenerator.setNames(nameGenerator.maleKhajiitNames);
                        } else {
                            nameGenerator.setNames(nameGenerator.femaleKhajiitNames);
                        }
                    case "Nord":
                        if (gender.equals("Male")) {
                            nameGenerator.setNames(nameGenerator.maleNordNames);
                        } else {
                            nameGenerator.setNames(nameGenerator.femaleNordNames);
                        }
                    case "Orc":
                        if (gender.equals("Male")) {
                            nameGenerator.setNames(nameGenerator.maleOrcNames);
                        } else {
                            nameGenerator.setNames(nameGenerator.femaleOrcNames);
                        }
                    default:
                        if (gender.equals("Male")) {
                            nameGenerator.setNames(nameGenerator.maleRedguardNames);
                        } else {
                            nameGenerator.setNames(nameGenerator.femaleRedguardNames);
                        }
                }
                return nameGenerator.generateName();
        }
    }
}