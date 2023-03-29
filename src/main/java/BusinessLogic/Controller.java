package BusinessLogic;
import java.awt.event.ActionEvent;
import java.util.regex.*;
import java.awt.event.ActionListener;
import DataModules.Monomial;
import DataModules.Polynomial;
import GraphicalUserInterface.Calculator;
import BusinessLogic.Operations;
public class Controller {
    private Calculator calculatorView;
    Pattern pattern = Pattern.compile("([+-]\\d*\\.?\\d*)?\\*?X?([+-]?\\d*)");

    public Controller(Calculator calculatorView) {
        this.calculatorView = calculatorView;
        this.calculatorView.additioningListener(new AddActionListener());
        this.calculatorView.subtractioningListener(new SubtractionListener());
        this.calculatorView.multiplyingListener(new MultiplicationListener());
        this.calculatorView.derivationListener(new DerivationListener());
        this.calculatorView.integrationingListener(new IntegrationListener());
    }
    // Pattern pattern = Pattern.compile("([+-]\\d*\\.?\\d*)?\\*?X?([+-]?\\d*)");

    public void validationInput(String input, Polynomial p) {
        Double coef = 0.0;
        Integer power = 0;

        System.out.println("Input: " + input);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            if (matcher.group(1) == null)
                break;
           try {
               coef = Double.parseDouble(matcher.group(1));
           }catch(NumberFormatException nfc)
           {
               calculatorView.showNumberError("Not a correct coefficient: ");
           }
           try {
               power = Integer.parseInt(matcher.group(2));
           }catch(NumberFormatException nfc)
           {
               calculatorView.showNumberError("Not a correct power:");
           }
            Monomial m = new Monomial(coef, power);
            p.addM(m);

        }
    }

    class AddActionListener implements ActionListener {

        String userInput = "";
        String userInput2 = "";
        Double coef = 0.0;
        Integer power = 0;

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            Polynomial p = new Polynomial();
            Polynomial p2 = new Polynomial();
            try {
                userInput = calculatorView.getFirstPoly();
                validationInput(userInput, p);
            } catch (NumberFormatException nfex) {
                calculatorView.showNumberError("Bad input: '" + userInput + "'");

            }

            try {
                userInput2 = calculatorView.getSecondPoly();
                validationInput(userInput2, p2);
            } catch (NumberFormatException nfex) {
                calculatorView.showNumberError("Bad input: '" + userInput2 + "'");

            }
            System.out.println(Operations.additionP(p, p2));
            calculatorView.updateResultLabel(Operations.additionP(p, p2));

        }
    }

    class SubtractionListener implements ActionListener{

        String userInput = "";
        String userInput2 = "";
        Double coef = 0.0;
        Integer power = 0;


        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            Polynomial p = new Polynomial();
            Polynomial p2 = new Polynomial();
            try {
                userInput = calculatorView.getFirstPoly();
                validationInput(userInput, p);
            } catch (NumberFormatException nfex) {
                calculatorView.showNumberError("Bad input: '" + userInput + "'");

            }

            try {
                userInput2 = calculatorView.getSecondPoly();
                validationInput(userInput2, p2);
            } catch (NumberFormatException nfex) {
                calculatorView.showNumberError("Bad input: '" + userInput2 + "'");

            }
            System.out.println(Operations.subtractionP(p, p2));
            calculatorView.updateResultLabel(Operations.subtractionP(p, p2));

        }
    }

    class MultiplicationListener implements ActionListener{

        String userInput = "";
        String userInput2 = "";
        Double coef = 0.0;
        Integer power = 0;


        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            Polynomial p = new Polynomial();
            Polynomial p2 = new Polynomial();
            try {
                userInput = calculatorView.getFirstPoly();
                validationInput(userInput, p);
            } catch (NumberFormatException nfex) {
                calculatorView.showNumberError("Bad input: '" + userInput + "'");

            }

            try {
                userInput2 = calculatorView.getSecondPoly();
                validationInput(userInput2, p2);
            } catch (NumberFormatException nfex) {
                calculatorView.showNumberError("Bad input: '" + userInput2 + "'");

            }
            System.out.println(Operations.multiplication(p, p2));
            calculatorView.updateResultLabel(Operations.multiplication(p, p2));

        }
    }


    class DerivationListener implements ActionListener{

        String userInput = "";
        String userInput2 = "";
        Double coef = 0.0;
        Integer power = 0;


        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            Polynomial p = new Polynomial();
            Polynomial p2 = new Polynomial();
            try {
                userInput = calculatorView.getFirstPoly();
                validationInput(userInput, p);
            } catch (NumberFormatException nfex) {
                calculatorView.showNumberError("Bad input: '" + userInput + "'");

            }
            System.out.println(Operations.derivation(p));
            calculatorView.updateResultLabel(Operations.derivation(p));

        }
    }


    class IntegrationListener implements ActionListener{

        String userInput = "";
        String userInput2 = "";
        Double coef = 0.0;
        Integer power = 0;


        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            Polynomial p = new Polynomial();
            Polynomial p2 = new Polynomial();
            try {
                userInput = calculatorView.getFirstPoly();
                validationInput(userInput, p);
            } catch (NumberFormatException nfex) {
                calculatorView.showNumberError("Bad input: '" + userInput + "'");

            }
            System.out.println(Operations.integration(p));
            calculatorView.updateResultLabel(Operations.integration(p));

        }
    }
}
