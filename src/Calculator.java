import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    private final JTextField display;
    private final JButton[] numberButtons = new JButton[10];
    private JButton addButton, subButton, mulButton, divButton, decButton, equButton, clrButton;

    private final Font myFont = new Font("SansSerif", Font.BOLD, 20);
    private double num1 = 0;
    private double result = 0;
    private char operator;

    public Calculator() {
        setTitle("Calculator");
        setSize(500, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(58, 58, 58));

        display = createDisplay();
        add(display);

        initButtons();
        addButtonsToPanel();

        setVisible(true);
    }

    private JTextField createDisplay() {
        JTextField displayField = new JTextField();
        displayField.setBounds(50, 25, 380, 50);
        displayField.setFont(myFont);
        displayField.setEditable(false);
        displayField.setHorizontalAlignment(SwingConstants.RIGHT);
        displayField.setBackground(new Color(220, 219, 225));
        displayField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        return displayField;
    }

    private void initButtons() {
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = createButton(String.valueOf(i), this);
        }
        addButton = createButton("+", this);
        subButton = createButton("-", this);
        mulButton = createButton("*", this);
        divButton = createButton("/", this);
        decButton = createButton(".", this);
        equButton = createButton("=", this);
        clrButton = createButton("C", this);
    }

    private JButton createButton(String label, ActionListener listener) {
        JButton button = new JButton(label);
        button.addActionListener(listener);
        button.setFont(myFont);
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(255, 110, 32));
        button.setFocusable(false);
        return button;
    }

    private void addButtonsToPanel() {
        JPanel panel = new JPanel();
        panel.setBounds(50, 100, 380, 600);
        panel.setLayout(new GridLayout(5, 4, 10, 10));

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(divButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(mulButton);
        panel.add(clrButton);

        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                display.setText(display.getText().concat(String.valueOf(i)));
                return;
            }
        }

        if (e.getSource() == decButton) {
            display.setText(display.getText().concat("."));
        } else if (e.getSource() == addButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '+';
            display.setText("");
        } else if (e.getSource() == subButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '-';
            display.setText("");
        } else if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '*';
            display.setText("");
        } else if (e.getSource() == divButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '/';
            display.setText("");
        } else if (e.getSource() == equButton) {
            double num2 = Double.parseDouble(display.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            display.setText(String.valueOf(result));
            num1 = result;
        } else if (e.getSource() == clrButton) {
            display.setText("");
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
