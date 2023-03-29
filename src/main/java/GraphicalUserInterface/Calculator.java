package GraphicalUserInterface;
import javax.swing.*;

import DataModules.Polynomial;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.color.*;
import java.awt.event.*;

public class Calculator extends JFrame {

    //public static void main(String args[]){


    private JFrame frame;
    private JPanel panelMain;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JLabel labelResult;
    private JLabel labelPolyOne;
    private JLabel labelPolyTwo;
    private JLabel labelTitle;
    private JTextField textOne;
    private JTextField textTwo;
    private JTextField textResult;
    private JButton addButton ;
    private JButton subtractButton;
    private JButton multiplicateButton;
    private JButton divisionButton;
    private JButton derivationButton;
    private JButton integrationButton;


    public Calculator()
    {

        this.frame = new JFrame();
        this.panelMain = new JPanel();
        this.panel1 = new JPanel();
        this.panel2 = new JPanel();
        this.panel3 = new JPanel();
        this.panel4 = new JPanel();
        this.labelResult = new JLabel();
        this.labelPolyOne = new JLabel();
        this. labelPolyTwo = new JLabel();
        this.labelTitle = new JLabel();
        this.textOne = new JTextField();
        this. textTwo = new JTextField();
        this.textResult = new JTextField();
        this.addButton = new JButton("Add");
        this.subtractButton = new JButton("Subtract");
        this.multiplicateButton = new JButton("Multiply");
        this.divisionButton = new JButton("Divide");
        this.derivationButton = new JButton("Derive");
        this.integrationButton = new JButton("Integrate");


        labelTitle.setText("Polynomial Calculator");
        labelTitle.setFont(new Font("Times New Roman", Font.ITALIC, 20));

        panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
        panel1.setBackground(Color.cyan);
        panel1.add(labelTitle);


        labelPolyOne.setText("First Polynomial = ");
        labelPolyOne.setFont(new Font("Times New Roman", Font.BOLD |Font.ITALIC, 15));
        labelPolyOne.setForeground(Color.black);


        textOne.setFont(new Font("Tahoma", Font.ITALIC, 12));
        textOne.setText("+9.8*X3+2*X1+6*X0");
        textOne.setPreferredSize(new Dimension(220,20));



        textTwo.setFont(new Font("Tahoma", Font.ITALIC, 12));
        textTwo.setText("-1*X3+3*X2-6*X0");
        textTwo.setPreferredSize(new Dimension(220,20));



        labelPolyTwo.setText("Second Polynomial =");
        labelPolyTwo.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
        labelPolyTwo.setForeground(Color.black);



        panel2.setLayout(new FlowLayout(FlowLayout.LEFT,10, 5));
        panel2.setBackground(Color.cyan);
        panel2.add(labelPolyOne);
        panel2.add(textOne);
        panel2.add(labelPolyTwo);
        panel2.add(textTwo);



        panel3.setLayout(new GridLayout(3,3,30,30));
        panel3.setBackground(Color.cyan);
        panel3.add(addButton);
        panel3.add(subtractButton);
        panel3.add(multiplicateButton);
        panel3.add(divisionButton);
        panel3.add(derivationButton);
        panel3.add(integrationButton);


        labelResult.setText("Result = ");
        labelResult.setFont(new Font("Times New Roman", Font.ITALIC, 20));
        labelResult.setForeground(Color.black);


        textResult.setFont(new Font("Tahoma", Font.ITALIC, 12));
        textResult.setPreferredSize(new Dimension(390,30));


        panel4.setLayout(new FlowLayout(FlowLayout.LEFT,10, 5));
        panel4.setBackground(Color.cyan);
        panel4.add(labelResult);
        panel4.add(textResult);



        frame.setTitle("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.PAGE_AXIS));
        panelMain.setBackground(Color.cyan);
        frame.setResizable(false);
        frame.setSize(500,550);
        frame.setVisible(true);
        panelMain.add(panel1);
        panelMain.add(panel2);
        panelMain.add(panel4);
        panelMain.add(panel3);
        frame.add(panelMain);


    }

    public void additioningListener(ActionListener actionL)
    {
        this.addButton.addActionListener(actionL);
    }

    public void subtractioningListener(ActionListener actionL)
    {
        this.subtractButton.addActionListener(actionL);
    }

    public void multiplyingListener(ActionListener actionL)
    {
        this.multiplicateButton.addActionListener(actionL);
    }

    public void dividingListener(ActionListener actionL)
    {
        this.divisionButton.addActionListener(actionL);
    }

    public void derivationListener(ActionListener actionL)
    {
        this.derivationButton.addActionListener(actionL);
    }

    public void integrationingListener(ActionListener actionL)
    {
        this.integrationButton.addActionListener(actionL);
    }

    public void showNumberError(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }

    public String getFirstPoly() {
        return this.textOne.getText();
    }

    public String getSecondPoly()
    {
        return this.textTwo.getText();
    }

    public void updateResultLabel(Polynomial p)
    {
        this.textResult.setText(p.toString());

    }
}

