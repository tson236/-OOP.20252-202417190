
import javax.swing.JOptionPane;
public class ShowTwoNumbers {
    public static void main(String[] args) {
        String strNum1, strNum2;
        String strNotification = "You've just entered: ";

        strNum1 = JOptionPane.showInputDialog(null,
                "Please input the first number: ",
                "Input the first number",
                JOptionPane.INFORMATION_MESSAGE);
        if (strNum1 != null) {
            strNotification += strNum1 + " and ";
        } else {
            strNotification += "nothing (cancelled) and ";
        }
        strNum2 = JOptionPane.showInputDialog(null,
                "Please input the second number: ",
                "Input the second number",
                JOptionPane.INFORMATION_MESSAGE);

        if (strNum2 != null) {
            strNotification += strNum2;
        } else {
            strNotification += "nothing (cancelled)";
        }
        JOptionPane.showMessageDialog(null, strNotification,
                "Show two numbers",
                JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);  
    }
}