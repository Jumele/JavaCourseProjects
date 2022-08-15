import model.Angajat;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Scanner;

public class Interfata extends JFrame {
    Methods methods = new Methods();


    public void run() throws SQLException {


        Scanner scanner = new Scanner(System.in);
        JFrame frame = new JFrame("Baza angajati");
        frame.setSize(500, 500);
        GridLayout layout = new GridLayout(0, 1);
        frame.setLayout(layout);
        frame.setBackground(Color.gray);

        JLabel informatieCeruta = new JLabel("Va rugam sa introudceti: Id, Prenume, " +
                "Varsta, Adresa, Salariu ");
        frame.add(informatieCeruta);

        JLabel blank1 = new JLabel();
        frame.add(blank1);

        JLabel idLabel = new JLabel("ID:");
        idLabel.getText();
        idLabel.setBackground(Color.lightGray);
        frame.add(idLabel);

        JTextField idText = new JTextField();
        idText.getText();
        idText.setBackground(Color.lightGray);
        frame.add(idText);

        JLabel prenumeLabel = new JLabel("Prenume:");
        frame.add(prenumeLabel);

        JTextField prenumeText = new JTextField();
        prenumeText.getText();
        prenumeText.setBackground(Color.lightGray);
        frame.add(prenumeText);

        JLabel varstaLabel = new JLabel("Varsta:");
        frame.add(varstaLabel);

        JTextField varstaText = new JTextField();
        varstaText.getText();
        varstaText.setBackground(Color.lightGray);
        frame.add(varstaText);


        JLabel adresaLabel = new JLabel("Adresa:");
        frame.add(adresaLabel);

        JTextField adresaText = new JTextField();
        adresaText.getText();
        adresaText.setBackground(Color.lightGray);
        frame.add(adresaText);

        JLabel salariuLabel = new JLabel("Salariu:");
        frame.add(salariuLabel);

        JTextField salariuText = new JTextField();
        salariuText.getText();
        salariuText.setBackground(Color.lightGray);
        frame.add(salariuText);

        JLabel blank = new JLabel();
        frame.add(blank);
        JLabel operatie = new JLabel("Alegere operatiune:");
        frame.add(operatie);


        Choice alegereOperatie = new Choice();
        alegereOperatie.add("Introducere angajat");
        alegereOperatie.add("Update angajat");
        alegereOperatie.add("Stergere angajat");
        alegereOperatie.add("Citire baza de date");
        alegereOperatie.add("Citire prenume");
        alegereOperatie.add("Citire varsta");
        alegereOperatie.add("Citire adresa");
        alegereOperatie.add("Citire salariu");
        frame.add(alegereOperatie);


        JLabel labelCriteriu = new JLabel("Va rog introduceti criteriul de sortare: ");
        JTextField preluareCriteriu = new JTextField("");
        preluareCriteriu.getText();

        frame.add(labelCriteriu);
        frame.add(preluareCriteriu);

        JButton ok = new JButton("Proceseaza");
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String alegere = alegereOperatie.getSelectedItem();

                switch (alegere) {
                    case "Introducere angajat":
                        String prenume = prenumeText.getText();
                        String varsta = varstaText.getText();
                        String adresa = adresaText.getText();
                        String salariu = salariuText.getText();

                        if (prenume.isEmpty() || varsta.isEmpty() || adresa.isEmpty() || salariu.isEmpty()) {
                            JOptionPane.showMessageDialog(frame, "Una din cele patru valori nu a fost introdusa!",
                                    "Eroare introducere date", JOptionPane.ERROR_MESSAGE);
                            break;
                        }

                        int varstaNumber = 0;
                        int salariuNumber = 0;

                        try {
                            varstaNumber = Integer.parseInt(varstaText.getText());
                            salariuNumber = Integer.parseInt(salariuText.getText());
                        } catch (NumberFormatException ignore) {
                            JOptionPane.showMessageDialog(frame, "Valoarea pentru varsta sau salariu nu este numerica",
                                    "Eroare introducere date", JOptionPane.ERROR_MESSAGE);
                            break;
                        }
                        if (varstaNumber < 0 || varstaNumber > 70) {
                            JOptionPane.showMessageDialog(frame, "Valoarea pentru varsta nu se inscrie intr-un interval adecvat",
                                    "Eroare introducere date", JOptionPane.ERROR_MESSAGE);
                            break;
                        }
                        if (salariuNumber < 0) {
                            JOptionPane.showMessageDialog(frame, "Valoarea salariului nu trebuie sa fie negativa",
                                    "Eroare introducere date", JOptionPane.ERROR_MESSAGE);
                            break;
                        } else {
                            Angajat angajat = new Angajat(prenume, varstaNumber, adresa, salariuNumber);
                            methods.insert(angajat);
                        }
                        break;

                    case "Update angajat":
                        int id_modify = 0;

                        try {
                            id_modify = Integer.parseInt(idText.getText());
                        } catch (NumberFormatException ignore) {
                            JOptionPane.showMessageDialog(frame, "Id-ul nu este numeric",
                                    "Eroare introducere date", JOptionPane.ERROR_MESSAGE);
                            break;
                        }

                        prenume = prenumeText.getText();
                        varsta = varstaText.getText();
                        adresa = adresaText.getText();
                        salariu = salariuText.getText();

                        try {
                            varstaNumber = Integer.parseInt(varsta);
                            salariuNumber = Integer.parseInt(salariu);
                        } catch (NumberFormatException ignore) {
                            JOptionPane.showMessageDialog(frame, "Valoarea pentru varsta sau salariu nu este numerica",
                                    "Eroare introducere date", JOptionPane.ERROR_MESSAGE);
                            break;
                        }

                        if (varstaNumber < 0 || varstaNumber > 70) {
                            JOptionPane.showMessageDialog(frame, "Valoarea pentru varsta nu se inscrie intr-un interval adecvat",
                                    "Eroare introducere date", JOptionPane.ERROR_MESSAGE);
                            break;
                        }

                        if (salariuNumber < 0) {
                            JOptionPane.showMessageDialog(frame, "Valoarea salariului nu trebuie sa fie negativa",
                                    "Eroare introducere date", JOptionPane.ERROR_MESSAGE);
                            break;
                        }

                        Angajat angajatOld = new Angajat(id_modify);
                        Angajat angajatNew = new Angajat(prenume, varstaNumber, adresa, salariuNumber);
                        boolean resultModify = methods.modify(angajatOld, angajatNew);

                        if (resultModify)
                            JOptionPane.showMessageDialog(frame, "Datele angajatului au fost modificate cu succes",
                                    "Rezultat stergere", JOptionPane.PLAIN_MESSAGE);
                        else
                            JOptionPane.showMessageDialog(frame, "Datele angajatului cu id-ul " + id_modify + " nu au fost modificate",
                                    "Eroare", JOptionPane.ERROR_MESSAGE);
                        break;

                    case "Stergere angajat":
                        int id_delete = 0;
                        try {
                            id_delete = Integer.parseInt(idText.getText());
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(frame, "Id-ul nu este numeric",
                                    "Eroare introducere date", JOptionPane.ERROR_MESSAGE);
                            break;
                        }
                        Angajat angajatDelete = new Angajat(id_delete);

                        boolean resultDelete = methods.delete(angajatDelete);
                        if (resultDelete)
                            JOptionPane.showMessageDialog(frame, "Datele angajatului au fost sterse cu succes",
                                    "Rezultat stergere", JOptionPane.PLAIN_MESSAGE);
                        else
                            JOptionPane.showMessageDialog(frame, "Datele angajatului cu id-ul " + id_delete + " nu au fost sterse",
                                    "Eroare", JOptionPane.ERROR_MESSAGE);

                        break;

                    case "Citire baza de date":
                        java.util.List<Angajat> angajatiLista = methods.displayAll();
                        JFrame rezultate = new JFrame("Rezultate");
                        rezultate.setSize(500, 200);

                        DefaultTableModel model = new DefaultTableModel();
                        JTable tabelRezultate = new JTable(model);
                        JScrollPane tabelScrollPane = new JScrollPane(tabelRezultate);

                        model.addColumn("Prenume");
                        model.addColumn("Varsta");
                        model.addColumn("Adresa");
                        model.addColumn("Salariu");

                        if (angajatiLista.isEmpty()) {
                            JOptionPane.showMessageDialog(frame, "Nu exista angajati",
                                    "Eroare introducere date", JOptionPane.ERROR_MESSAGE);
                            break;
                        } else {
                            for (int i = 0; i < angajatiLista.size(); i++) {
                                Angajat angajat = angajatiLista.get(i);
                                model.addRow(new Object[]{angajat.getPrenume(),
                                        "" + angajat.getVarsta(), angajat.getAdresa(),
                                        "" + angajat.getSalariu()});
                            }


                        rezultate.add(tabelScrollPane);
                        rezultate.setVisible(true);
                }
                        break;


                    case "Citire prenume":
                        String criteriu = preluareCriteriu.getText();
                        java.util.List<Angajat> results = methods.displaySelective(criteriu);

                        if (criteriu.contains("prenume")) {
                        rezultate = new JFrame("Rezultate");
                        rezultate.setSize(500, 200);

                        model = new DefaultTableModel();
                        tabelRezultate = new JTable(model);
                        tabelScrollPane = new JScrollPane(tabelRezultate);

                        model.addColumn("Prenume");
                        model.addColumn("Varsta");
                        model.addColumn("Adresa");
                        model.addColumn("Salariu");

                            if (results.isEmpty()) {
                                JOptionPane.showMessageDialog(frame, "Nu exista angajati",
                                        "Eroare introducere date", JOptionPane.ERROR_MESSAGE);
                                break;
                            } else {
                                for (int i = 0; i < results.size(); i++) {
                                    Angajat angajat = results.get(i);
                                    model.addRow(new Object[]{angajat.getPrenume(),
                                            "" + angajat.getVarsta(), angajat.getAdresa(),
                                            "" + angajat.getSalariu()});
                                }
                            }

                            rezultate.add(tabelScrollPane);
                            rezultate.setVisible(true);
                        }

                        break;


                    case "Citire varsta":
                        criteriu = preluareCriteriu.getText();
                        results = methods.displaySelective(criteriu);

                        if (criteriu.contains("varsta")) {

                            criteriu = preluareCriteriu.getText();
                            results = methods.displaySelective(criteriu);

                            rezultate = new JFrame("Rezultate");
                            rezultate.setSize(500, 200);

                            model = new DefaultTableModel();
                            tabelRezultate = new JTable(model);
                            tabelScrollPane = new JScrollPane(tabelRezultate);

                            model.addColumn("Prenume");
                            model.addColumn("Varsta");
                            model.addColumn("Adresa");
                            model.addColumn("Salariu");

                            if (results.isEmpty()) {
                                JOptionPane.showMessageDialog(frame, "Nu exista angajati",
                                        "Eroare introducere date", JOptionPane.ERROR_MESSAGE);
                                break;
                            } else {

                                for (int i = 0; i < results.size(); i++) {
                                    Angajat angajat = results.get(i);
                                    model.addRow(new Object[]{angajat.getPrenume(),
                                            "" + angajat.getVarsta(), angajat.getAdresa(),
                                            "" + angajat.getSalariu()});
                                }
                            }

                            rezultate.add(tabelScrollPane);
                            rezultate.setVisible(true);
                        }
                        break;

                    case "Citire adresa":
                        criteriu = preluareCriteriu.getText();
                        results = methods.displaySelective(criteriu);

                        if (criteriu.contains("adresa")) {
                            criteriu = preluareCriteriu.getText();
                            results = methods.displaySelective(criteriu);

                            rezultate = new JFrame("Rezultate");
                            rezultate.setSize(500, 200);

                            model = new DefaultTableModel();
                            tabelRezultate = new JTable(model);
                            tabelScrollPane = new JScrollPane(tabelRezultate);

                            model.addColumn("Prenume");
                            model.addColumn("Varsta");
                            model.addColumn("Adresa");
                            model.addColumn("Salariu");

                            if (results.isEmpty()) {
                                JOptionPane.showMessageDialog(frame, "Nu exista angajati",
                                        "Eroare introducere date", JOptionPane.ERROR_MESSAGE);
                                break;
                            } else {
                                for (int i = 0; i < results.size(); i++) {
                                    Angajat angajat = results.get(i);
                                    model.addRow(new Object[]{angajat.getPrenume(),
                                            "" + angajat.getVarsta(), angajat.getAdresa(),
                                            "" + angajat.getSalariu()});
                                }
                            }

                            rezultate.add(tabelScrollPane);
                            rezultate.setVisible(true);
                        }
                        break;

                    case "Citire salariu":
                        criteriu = preluareCriteriu.getText();
                        results = methods.displaySelective(criteriu);

                        if (criteriu.contains("salariu")) {
                            criteriu = preluareCriteriu.getText();
                            results = methods.displaySelective(criteriu);

                            rezultate = new JFrame("Rezultate");
                            rezultate.setSize(500, 200);

                            model = new DefaultTableModel();
                            tabelRezultate = new JTable(model);
                            tabelScrollPane = new JScrollPane(tabelRezultate);

                            model.addColumn("Prenume");
                            model.addColumn("Varsta");
                            model.addColumn("Adresa");
                            model.addColumn("Salariu");

                            if (results.isEmpty()) {
                                JOptionPane.showMessageDialog(frame, "Nu exista angajati",
                                        "Eroare introducere date", JOptionPane.ERROR_MESSAGE);
                                break;
                            } else {
                                for (int i = 0; i < results.size(); i++) {
                                    Angajat angajat = results.get(i);
                                    model.addRow(new Object[]{angajat.getPrenume(),
                                            "" + angajat.getVarsta(), angajat.getAdresa(),
                                            "" + angajat.getSalariu()});
                                }
                            }

                            rezultate.add(tabelScrollPane);
                            rezultate.setVisible(true);
                        }
                        break;
                }
            }

        });
        frame.add(ok);

        frame.setVisible(true);


    }


}
