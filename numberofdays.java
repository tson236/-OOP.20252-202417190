import java.util.Scanner;

public class numberofdays {
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int month = 0;
        int year = -1;
        while (true) {
            System.out.print("Enter month: ");
            String m = sc.nextLine().trim().toLowerCase();

            if (m.equals("january") || m.equals("jan.") || m.equals("jan") || m.equals("1"))
                month = 1;
            else if (m.equals("february") || m.equals("feb.") || m.equals("feb") || m.equals("2"))
                month = 2;
            
            else if (m.equals("march") || m.equals("mar.") || m.equals("mar") || m.equals("3"))
                month = 3;
            else if (m.equals("april") || m.equals("apr.") || m.equals("apr") || m.equals("4"))
                month = 4;
            else if (m.equals("may") || m.equals("5"))
                month = 5;
            else if (m.equals("june") || m.equals("jun.") || m.equals("jun") || m.equals("6"))
                month = 6;
            else if (m.equals("july") || m.equals("jul.") || m.equals("jul") || m.equals("7"))
                month = 7;
            else if (m.equals("august") || m.equals("aug.") || m.equals("aug") || m.equals("8"))
                month = 8;
            else if (m.equals("september") || m.equals("sept.") || m.equals("sep") || m.equals("9"))
                month = 9;
            else if (m.equals("october") || m.equals("oct.") || m.equals("oct") || m.equals("10"))
                month = 10;
            else if (m.equals("november") || m.equals("nov.") || m.equals("nov") || m.equals("11"))
                month = 11;
            else if (m.equals("december") || m.equals("dec.") || m.equals("dec") || m.equals("12"))
                month = 12;
            else {
                System.out.println("Invalid month, please enter again.");
                continue;
            }
            break;
        }

        // Nhập năm
        while (true) {
            System.out.print("Enter year: ");
            if (sc.hasNextInt()) {
                year = sc.nextInt();
                if (year >= 0 && year >= 1000) {
                    break;
                }
            } else {
                sc.next();
            }
            System.out.println("Invalid year, please enter again.");
        }

        // Kiểm tra năm nhuận
        boolean leapYear = false;
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            leapYear = true;
        }

        int days = 0;

        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                days = 31;
                break;

            case 4: case 6: case 9: case 11:
                days = 30;
                break;

            case 2:
                if (leapYear)
                    days = 29;
                else
                    days = 28;
                break;
        }

        System.out.println("Number of days: " + days);
    }
}