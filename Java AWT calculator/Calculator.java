import java.awt.*;
import java.awt.event.*;


public class Calculator extends Frame{


    static double suma;

    public static void main(String[] args) {
        Frame f = new Frame("Mini AWT Calculator");
        GridLayout gridLayout = new GridLayout();
        f.setLayout(new GridLayout(5, 5));
        Label firstNr = new Label("enter first number");
        f.add(firstNr);

        TextField operand = new TextField();
        operand.setBackground(Color.lightGray);
        f.add(operand);


        Label semn = new Label("choose operation");
        f.add(semn);

        Choice semne = new Choice();
        semne.add("+");
        semne.add("-");
        semne.add("*");
        semne.add("/");
        semne.setBackground(Color.PINK);
        f.add(semne);


        Label secondNr = new Label("enter second number");
        f.add(secondNr);

        TextField operand2 = new TextField();
        operand2.setBackground(Color.lightGray);
        f.add(operand2);

        Label none = new Label();
        f.add(none);

        Label result = new Label("result is:");
        result.setBackground(Color.PINK);


        Label rezultatCalcul = new Label();

        rezultatCalcul.setText(String.valueOf(suma));
        rezultatCalcul.setBackground(Color.lightGray);



        Button buttonCalculate = new Button("Calculate");
        buttonCalculate.setSize(200, 200);
        buttonCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double numarul1 = Double.parseDouble(operand.getText());
                    double numarul2 = Double.parseDouble(operand2.getText());
                    String operation = semne.getSelectedItem();
                    double suma = 0;

                    switch (operation) {
                        case "+":
                            suma = numarul1 + numarul2;
                            break;
                        case "-":
                            suma = numarul1 - numarul2;
                            break;
                        case "*":
                            suma = numarul1 * numarul2;
                            break;
                        case "/":
                            suma = numarul1 / numarul2;
                            break;

                    }
                    rezultatCalcul.setText(String.valueOf(suma));
                } catch (NumberFormatException ex) {
                    rezultatCalcul.setText("Unul din operanzi nu este numar");
                }
            }


        });
        buttonCalculate.setVisible(true);
        f.add(buttonCalculate);
        f.add(result);
        f.add(rezultatCalcul);




        f.setSize(500, 300);
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

}










