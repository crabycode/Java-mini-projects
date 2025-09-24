/*
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog("What is your name? ");
        JOptionPane.showMessageDialog(null, "Hello "+name);

        int age = Integer.parseInt(JOptionPane.showInputDialog("What is your age? "));
        JOptionPane.showMessageDialog(null, "You are "+age+" years old");

        double height = Double.parseDouble(JOptionPane.showInputDialog("How tall are you? "));
        JOptionPane.showMessageDialog(null, "You are "+height+" cm tall");
    }
}
         */
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog("What is your name? ");
        int age = Integer.parseInt(JOptionPane.showInputDialog("What is your age? "));
        double height = Double.parseDouble(JOptionPane.showInputDialog("How tall are you? "));
        JOptionPane.showMessageDialog(null, "Hello "+name+"! Being "+age+" years old"+
                " is great. And it's even greater to be "+ height +" cm tall");
    }
}