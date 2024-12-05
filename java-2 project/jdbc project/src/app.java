import java.util.*;

class New_Account {

    Scanner sc = new Scanner(System.in);

    static boolean validDate(String str) {
        if (str.length() != 10) {
            System.out.println("Enter Valid Date!!!");
            System.out.println("Please Re-Enter");
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (i == 2 || i == 5) {
                if (str.charAt(i) == '/') {

                } else {
                    System.out.println("Enter Valid Date!!!");
                    System.out.println("Please Re-Enter");
                    return false;
                }
            } else {
                if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {

                } else {
                    System.out.println("Enter Valid Date!!!");
                    System.out.println("Please Re-Enter");
                    return false;
                }
            }
        }
        return true;
    }

    static boolean validEmail(String str) {
        // boolean okokok = false;
        String find = "@";
        // boolean i = str.contains(find);
        if (str.charAt(0) == '@') {
            System.out.println("Enter Valid Email!!!");
            System.out.println("Please Re-Enter");
            return false;
        }
        if (str.contains(find) == false) {
            System.out.println("Enter Valid Email!!!");
            System.out.println("Please Re-Enter");
            return false;
        }

        find = ".com";
        // boolean = str.contains(find);
        if (str.contains(find) == false) {
            System.out.println("Enter Valid Number");
            System.out.println("Please Re-Enter");
            return false;
        }

        return true;

    }

    static String name;
    String Nominee;
    String gov_id;
    String Add;
    String Email;
    String con;
    static int th = 1;
    static long Acc_num;
    int di;
    static String password;
    static String tra_password;
    static long cur_bal = 0;

    boolean traverseInt(String str) {
        if (str.length() == 0) {
            System.out.println("Input is empty.");
            return false;
        }

        char firstChar = str.charAt(0);

        if (firstChar == '8' || firstChar == '9') {
            for (int i = 1; i < str.length(); i++) {
                if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    continue;
                } else {
                    System.out.println("Enter Valid Number");
                    System.out.println("Please Re-Enter");
                    return false;
                }
            }
            return true;
        } else {
            System.out.println("First character must be '8' or '9'.");
            return false;
        }
    }

    boolean traverseInt2(String str) {
        if (str.length() != 10) {
            System.out.println("Enter Valid Number");
            System.out.println("Please Re-Enter");
            return false;
        }
        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) >= '0' && str.charAt(i) <= '9')
                continue;
            else {
                System.out.println("Enter Valid Number");
                System.out.println("Please Re-Enter");
                return false;
            }
        }
        return true;
    }

    boolean traverseString(String str) {
        if (str.length() == 0) {
            System.out.println("Enter Valid Name");
            System.out.println("Please Re-Enter");
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z' || str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {

            } else {
                System.out.println("Enter Valid Name");
                System.out.println("Please Re-Enter");

                return false;
            }
        }
        return true;

    }

    boolean gov_idd(String str) {

        if (str.length() != 12) {
            System.out.println("Enter Valid Number");
            System.out.println("Please Re-Enter");
            return false;
        }
        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) >= '0' && str.charAt(i) <= '9')
                continue;
            else {
                System.out.println("Enter Valid Number");
                System.out.println("Please Re-Enter");
                return false;
            }
        }
        return true;
    }

    static long cash[] = new long[10000];
    static String dat[] = new String[10000];
    static String act[] = new String[10000];
    static long atm_pin;
    static long limit;
    static String ATM = "NO";
    static String Online = "NO";
    static boolean ok_login = true;

    void getter() {
        ok_login = false;
        System.out.println(
                "-----------------------------------------------------------------------------------------------");
        System.out.println(
                "                                      ( Fill the Details )                                    \n");
        System.out.print("                              Enter Your Full Name             :");
        boolean is_Valid = false;
        String ok = sc.nextLine();
        while (traverseString(ok) == false) {
            ok = sc.nextLine();
            System.out.println(ok);
            // is_Valid = traverseString(ok);
        }
        this.name = ok;
        System.out.print("                              Enter Your Nominee's Name        :");
        is_Valid = false;
        while (is_Valid == false) {
            this.Nominee = sc.nextLine();
            is_Valid = traverseString(Nominee);
        }

        System.out.print("                              Enter Your Aadhar-Card  number  :");
        is_Valid = false;
        while (is_Valid == false) {
            this.gov_id = sc.nextLine();
            is_Valid = gov_idd(gov_id);
        }
        System.out.print("                              Enter Your Address               :");
        this.Add = sc.nextLine();
        System.out.print("                              Enter Your Email Address              :");
        is_Valid = false;

        while (!is_Valid) {
            this.Email = sc.nextLine();
            // System.out.println(this.Email);
            is_Valid = validEmail(Email);
        }
        System.out.print("                              Enter Your Mobile Number         :");
        is_Valid = false;
        while (!is_Valid) {
            this.con = sc.nextLine();
            is_Valid = traverseInt2(con);
        }
        System.out.println("\n                --> For verify your Mobile number we send a OTP on " + con + " <--");
        int max = 9999, min = 1000;
        Random rand = new Random(); // Random OTP number
        int a = rand.nextInt(max - min) + min;
        sleep(1000);
        int tr = 1;
        System.out.println(
                "                                                                                        -------------");
        System.out.println(
                "                                                                                        |Message box|");
        System.out
                .println("                                                                                        |   "
                        + a + "    |  ");
        System.out.println(
                "                                                                                        -------------");
        System.out.print("                              ENTER OTP:");
        di = sc.nextInt();
        while (tr < 3 && di != a) {
            System.out.println("                            ....YOUR OTP IS WRONG,PLEASE TAKE ANOTHER TRY....");
            a = rand.nextInt(max - min) + min;
            sleep(2000);
            tr++;
            System.out.println(
                    "                                                                                        -------------");
            System.out.println(
                    "                                                                                        |Message box|");
            System.out.println(
                    "                                                                                        |   " + a
                            + "    |  ");
            System.out.println(
                    "                                                                                        -------------");

            System.out.print("                              ENTER OTP NUMBER WHAT YOU RECEIVE  :");
            di = sc.nextInt();
        }

        if (di == a) {

            System.out
                    .println("\n                     Mr." + name + " Your Mobile number has been verified");
            System.out
                    .println("                     Congratulations your account has been created successfully");
            long ma = 899999999;
            Random ra = new Random();
            long acc = ra.nextInt(max) + 1000000000;
            Acc_num = acc;
            System.out.println("                     Your unique account number is created...");
            System.out.println("                       Your Account number : " + Acc_num);
            System.out.println("                    Thank you for banking with us...");
            System.out.print("\n                    Please Set Login Password for security purpose :");
            sc.nextLine();
            password = sc.nextLine();
            System.out.print("                     Please Set Transition Pin for security purpose :");
            is_Valid = false;
            while (!is_Valid) {
                tra_password = sc.nextLine();
                is_Valid = traverseInt(tra_password);
            }
            System.out.println("                     Please don't share your Passwords with anyone...");
        } else {

            System.out.println("\n                    Please try some time later.. ");
        }
        System.out.println("\n                             -->   Back to login page   <--");

    }

    public static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
        }

    }

}

class Help extends New_Account {
    Help() {
        System.out.println(
                "-----------------------------------------------------------------------------------------------");
        System.out.println("Home / Support & Services -->");
        System.out.println("                          Please visit our Website www.hav.com for help");
        System.out.println("                              Toll free number : 1800 258 4455");
        System.out.println("                              Toll free number : 1800 102 4455");
        System.out.println("                                       Thank You");
        System.out.println(
                "-----------------------------------------------------------------------------------------------");
    }
}

class Login extends New_Account {
    Login() {
        super();
    }

    String phon;
    String pass;
    Scanner sc = new Scanner(System.in);

    void login() {
        if (ok_login == true) {
            System.out.println("No account found !!!");
            System.out.println("Please create one!!!");
            return;
        }
        System.out.println(
                "-----------------------------------------------------------------------------------------------");
        System.out.println("Home / Login -->");
        System.out.print("                                  Enter your Mobile number       :");
        boolean ok = false;
        while (!ok) {
            phon = sc.nextLine();
            ok = traverseInt2(phon);
        }

        System.out.print("                                  Enter Your Login Password      :");
        pass = sc.nextLine();
        System.out.println(
                "-----------------------------------------------------------------------------------------------");
        if (pass.equals(password) && con.equals(phon)) {
            int ch = 0;
            while (ch != 3) {

                System.out.println(
                        "-----------------------------------------------------------------------------------------------");
                System.out.println(
                        "| Home / Login -->                                                                            |");
                System.out.println(
                        "|                            (1) Account Section                                              |");
                System.out.println(
                        "|                            (2) Card Section                                                 |");
                System.out.println(
                        "|                            (3) Logout                                                       |");
                System.out.println(
                        "|                                                                                             |");
                System.out.println(
                        "-----------------------------------------------------------------------------------------------");
                System.out.print("ENTER YOUR DESIRE CHOICE ---->");
                ch = sc.nextInt();
                switch (ch) {
                    case 1:
                        Account a = new Account();
                        break;
                    case 2:
                        int cho = 0;
                        long DN;
                        String S = "xxxxxxxx";
                        while (cho != 3) {
                            System.out.println(
                                    "-----------------------------------------------------------------------------------------------");
                            System.out.println(
                                    "| Home / Login / Card Section --->                                                            |");
                            System.out.println(
                                    "|                                                                                             |");
                            System.out.println(
                                    "|                            (1) Debit Card Request                                           |");
                            System.out.println(
                                    "|                            (2) View Debit Card                                              |");
                            System.out.println(
                                    "|                                                                                             |");
                            System.out.println(
                                    "|  <---(3) back                                                                               |");
                            System.out.println(
                                    "-----------------------------------------------------------------------------------------------");
                            System.out.print("Enter your Desire Choice --->");
                            cho = sc.nextInt();
                            switch (cho) {
                                case 1:
                                    Debit_request o = new Debit_request();
                                    o.Action();
                                    break;
                                case 2:
                                    View_Card obj = new View_Card();
                                    obj.Action();
                                    break;
                            }
                        }
                        break;

                }

            }

        }

        else {
            System.out.println("                               ** Press 1 for 'FORGOT PASSWORD' **");
            int num, b;
            int otp, ma = 9999;
            System.out.print("Enter :");
            num = sc.nextInt();
            if (num == 1) {
                System.out.print("                                  Enter your Mobile number       :");
                ok = false;
                while (!ok) {
                    phon = sc.nextLine();
                    ok = traverseInt2(phon);
                }
                Random rand = new Random();
                b = rand.nextInt(ma) + 1000;
                sleep(2000);
                System.out.println(
                        "                                                                                        -------------");
                System.out.println(
                        "                                                                                        |Message box|");
                System.out.println(
                        "                                                                                        |   "
                                + b + "    |  ");
                System.out.println(
                        "                                                                                        -------------");

                System.out.print("                              ENTER OTP NUMBER WHAT YOU RECEIVE  :");
                otp = sc.nextInt();
                if (b == otp) {
                    System.out.println("Your OTP has been verified ");
                }
                System.out.print("\n                            Enter Your New Login Password      :");
                sc.nextLine();
                pass = sc.nextLine();
                password = pass;
                System.out.println("\n Your password has been changed ");
            }
        }
    }

    static void Transition_history() {
        System.out.println(
                "-----------------------------------------------------------------------------------------------");
        System.out.println("\tCash amount\t\t\tDate\t\t\t\tAction\t");
        int gr = th;
        while ((gr - 1) > 0) {
            System.out.println("\tINR " + cash[gr - 1] + "\t\t\t" + dat[gr - 1] + "\t\t\t" + act[gr - 1]);
            gr--;
        }
        System.out.println(
                "-----------------------------------------------------------------------------------------------");
    }

}

class Account extends Login {
    Scanner sc = new Scanner(System.in);
    long n;
    String ta;
    String date;
    int ty = 0;
    int l = 0;
    {
        while (l != 5) {

            System.out.println(
                    "-----------------------------------------------------------------------------------------------");
            System.out.println(
                    "| Home / Login / Account Section -->                                                          |");
            System.out.println(
                    "|                                                                                             |");
            System.out.println(
                    "|                            (1) View  Balance                                                |");
            System.out.println(
                    "|                            (2) Deposite cash                                                |");
            System.out.println(
                    "|                            (3) Withdraw cash                                                |");
            System.out.println(
                    "|                            (4) Transition History                                           |");
            System.out.println(
                    "|                            (5) back                                                         |");
            System.out.println(
                    "-----------------------------------------------------------------------------------------------");
            int t;
            System.out.print("Enter your Desire Choice ");
            t = sc.nextInt();
            switch (t) {
                case 1:
                    System.out.println(
                            "-----------------------------------------------------------------------------------------------");
                    System.out.println(
                            " Home / Login / Account Section / View Balance -->                                             ");
                    System.out.println(
                            "                                                                                               ");
                    System.out.println("   Account number :" + Acc_num);
                    System.out.println(
                            "                                                                                               ");
                    System.out.println("                         YOUR CURRENT BALANCE :" + cur_bal + " INR");
                    System.out.println(
                            "-----------------------------------------------------------------------------------------------");
                    break;
                case 2:
                    this.Deposite();
                    break;
                case 3:
                    this.withdraw();
                    break;
                case 4:
                    Transition_history();
                    break;
            }
            l = t;
        }
    }

    void Deposite() {
        ty = 0;
        while (ty != 2) {
            System.out.println(
                    "-----------------------------------------------------------------------------------------------");
            System.out.println("| Home / Login / Account Section / Deposite Cash -->    ");
            System.out.println(
                    "                                                                                               ");
            System.out.print("   Account number :" + Acc_num + "                               Date:");
            sc.nextLine();
            date = sc.nextLine();
            while (validDate(date) == false) {
                date = sc.nextLine();
            }
            System.out.println("Current Balance " + cur_bal);
            System.out.println(
                    "                                                                                               ");
            System.out.print("                          Enter Amount of Cash  :");
            n = sc.nextLong();
            System.out.print("                          Enter Transaction pin :");
            sc.nextLine();
            ta = sc.nextLine();
            System.out.println(
                    "-----------------------------------------------------------------------------------------------");
            if (ta.equals(tra_password)) {
                System.out.println("\n" + n + " Rupees Deposited in account succesfully....\n");
                cur_bal += n;
                break;
            } else {
                System.out.println("\nYour inserted transaction pin is not correct, please take another try..\n");
                ty++;
            }
        }

        if (ty == 2) {
            System.out.println("\nSorry, We can't proccess ahead\n");
        }
        cash[th] = n;
        dat[th] = date;
        act[th] = "Deposited";
        th++;

    }

    void withdraw() {
        ty = 0;
        boolean tra_err = false;
        while (ty != 2) {
            System.out.println(
                    "-----------------------------------------------------------------------------------------------");
            System.out.println("| Home / Login / Account Section / Withdraw Cash -->    ");
            System.out.println(
                    "                                                                                               ");
            System.out.print("   Account number :" + Acc_num + "                               Date:");

            sc.nextLine();
            date = sc.nextLine();
            while (validDate(date) == false) {
                date = sc.nextLine();
            }
            System.out.println("Current Balance " + cur_bal);

            System.out.println(
                    "                                                                                               ");
            System.out.print("                          Enter Amount of Cash  :");
            n = sc.nextLong();
            System.out.print("                          Enter Transaction pin :");
            sc.nextLine();
            ta = sc.nextLine();
            System.out.println(
                    "-----------------------------------------------------------------------------------------------");

            if (ta.equals(tra_password) && n < cur_bal) {
                System.out.println("\n" + n + " Rupees Withdrawed from your account succesfully....\n");
                cur_bal -= n;
                break;
            } else if (ta.equals(tra_password) == false) {
                System.out.println("\nYour inserted transaction pin is not correct, please take another try..\n");
                ty++;
            } else if (n > cur_bal) {
                System.out.println("You can`t withdraw your account has no enough ammount");
                tra_err = true;
                break;
            }

        }

        if (ty == 2) {
            System.out.println("\nSorry, We can't proccess ahead\n");
            cash[th] = n;
            dat[th] = date;
            act[th] = "Canclled";
            th++;

            return;
        }
        if (tra_err == true) {
            cash[th] = n;
            dat[th] = date;
            act[th] = "Canclled";
            th++;
            return;
        }
        cash[th] = n;
        dat[th] = date;
        act[th] = "Withdrawed";
        th++;

    }

}

abstract class Card extends Login {

    int DN;
    String S = "XXXXXXXX";
    int ca;

    abstract void Action();

}

class Debit_request extends Card {

    void Action() {
        int number;
        Random rand = new Random();
        DN = rand.nextInt(9000) + 1000;
        S = S + DN;

        System.out.print("\n...Enter Transaction Pin -->");
        number = sc.nextInt();
        System.out.println("Please wait your card being ready!");
        sleep(5000);
        System.out.println("                                  *** YOUR DEBIT CARD ***");
        System.out.println("                        ==============================================");
        System.out.println("                        |                  * BON *                   |");
        System.out.println("                        |                                 CLASSIC    |");
        System.out.println("                        | " + S + "                              |");
        System.out.println("                        | " + name);
        System.out.println("                        | valid from : 11/22  valid thru : 11/27     |");
        System.out.println("                        |                                            |");
        System.out.println("                        |                                  RUPAY ->  |");
        System.out.println("                        |                  CVV : 767                 |");
        System.out.println("                        ==============================================");
        System.out.println("                           ATM :" + ATM + " ONLINE :" + Online);

    }
}

class View_Card extends Card {

    void Action() {
        System.out.println(
                "-----------------------------------------------------------------------------------------------");
        System.out.println(" Home / Login / Card Section / View Card-->                                ");

        System.out.println("                                  *** YOUR DEBIT CARD ***");
        System.out.println("                        ==============================================");
        System.out.println("                        |                  * BON *                   |");
        System.out.println("                        |                                 CLASSIC    |");
        System.out.println("                        | " + S + DN + "                             |");
        System.out.println("                        | " + name);
        System.out.println("                        | valid from : 11/22  valid thru : 11/27     |");
        System.out.println("                        |                                            |");
        System.out.println("                        |                                  RUPAY ->  |");
        System.out.println("                        |                  CVV : 767                 |");
        System.out.println("                        ==============================================");
        System.out.println("                           ATM :" + ATM + " ONLINE :" + Online);

    }

}

public class app {
    public static void main(String[] args) {

        Login user = new Login();
        int i = 0;
        while (i != 4) {
            System.out.println(
                    "|                                    Welcome to H-A-V Bank                                    |");
            System.out.println(
                    "|                                                                                             |");
            System.out.println(
                    "|                                    (1)      Open new Account                                |");
            System.out.println(
                    "|                                    (2)      Login                                           |");
            System.out.println(
                    "|                                    (3)      Support & Services                              |");
            System.out.println(
                    "|                                    (4)      Exit                                            |");

            int t;
            System.out.print("\t\t\t\t\tEnter your Desire Choice ");
            Scanner sc = new Scanner(System.in);
            t = sc.nextInt();
            switch (t) {
                case 1:
                    user.getter();
                    break;
                case 2:
                    user.login();
                    break;
                case 3:
                    Help obj = new Help();
                    break;
                case 4:
                    System.out.println("You Have been exited ....");
                    break;
            }
            i = t;
        }
    }
}
