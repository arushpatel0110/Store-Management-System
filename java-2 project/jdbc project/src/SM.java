import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class SM {
    static Scanner sc = new Scanner(System.in);
    static Statement st;
    static PreparedStatement ps;
    static ResultSet rs;
    static Connection con;
    String name;
    long mobileNumber;
    static ArrayList<Integer> purchesedItemId = new ArrayList<>();
    static ArrayList<String> purchesedItemName = new ArrayList<>();
    static ArrayList<Double> purchesedItemPrice = new ArrayList<>();
    static ArrayList<Integer> purchesedItemQuantity = new ArrayList<>();
    static ArrayList<Double> purchesedItemAmount = new ArrayList<>();

    SM() throws ClassNotFoundException, SQLException {
        String dburl = "jdbc:mysql://localhost:3306/storemanagement";
        String dbuser = "root";
        String dbpass = "";
        String driverName = "com.mysql.cj.jdbc.Driver";
        Class.forName(driverName);
        con = DriverManager.getConnection(dburl, dbuser, dbpass);
        st = con.createStatement();
        if (con != null) {
            System.out.println("Connection Done");
    //   createTables();
         //    setData();
        } else {
            System.out.println("Error In Connection");
        }
    }

//     void createTables() throws SQLException {
//     String createTable1 = "create table IF NOT Exists employee(name text,password text);";
//     String createTable2 = "create table IF NOT Exists items(name text,itemid int,itemprice double,type text);";
//     String createTable3 = "create table IF NOT Exists customers(name text,mobile_Number bigint,bill_number bigint,Amount double);";
//     st.execute(createTable1);
//     st.execute(createTable2);
//     st.execute(createTable3);
//     }

//     void setData() throws SQLException {
//     st.execute("insert into employee(name,password) values('Arush','123');");
//  st.execute("INSERT INTO items (name, itemid, itemprice, type) VALUES ('Rice', 1, 100, 'grocery'),('Dal', 2, 80, 'grocery'),('Cooking Oil', 3, 150, 'grocery'),('Milk', 4, 40, 'grocery'),('Bread', 5, 30, 'grocery'),('Smartphone', 6, 15000, 'electronics'),('Laptop', 7, 40000, 'electronics'),('LED TV', 8, 25000, 'electronics'),('Headphones', 9, 1000, 'electronics'),('Charger', 10, 200, 'electronics'),('Notebook', 11, 20, 'stationary'),('Pen Set', 12, 50, 'stationary'),('Pencils', 13, 10, 'stationary'),('Eraser', 14, 5, 'stationary'),('Scissors', 15, 30, 'stationary'),('T-Shirt', 16, 500, 'fashion'),('Jeans', 17, 1000, 'fashion'),('Dress', 18, 800, 'fashion'),('Sneakers', 19, 1500, 'fashion'),('Handbag', 20, 1200, 'fashion');");
//     }

    void addItem() throws SQLException {
        ps = con.prepareStatement("insert into items(name,itemid,itemprice,type) values(?,?,?,?)");
        sc.nextLine();
        System.out.print("Enter Item Name : ");
        String name = sc.nextLine();
        System.out.print("Enter Item Id : ");
        int id = sc.nextInt();
        System.out.print("Enter Item Price : ");
        double price = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter Item Type : ");
        String type = sc.nextLine();
        ps.setString(1, name);
        ps.setInt(2, id);
        ps.setDouble(3, price);
        ps.setString(4, type);
        int i = ps.executeUpdate();
        if (i > 0) {
            System.out.println("Item Added");
        } else {
            System.out.println("Error");
        }
    }

    void addEmployee() throws SQLException {
        ps = con.prepareStatement("insert into employee(name,password) values(?,?)");
        sc.nextLine();
        System.out.print("Enter Employee Name : ");
        String name = sc.nextLine();
        System.out.print("Enter Employee Password : ");
        String password = sc.nextLine();
        ps.setString(1, name);
        ps.setString(2, password);
        int i = ps.executeUpdate();
        if (i > 0) {
            System.out.println("Employee Added");
        } else {
            System.out.println("Error");
        }
    }

    void update() throws SQLException {
     
            System.out.print("Enter Id Of A Item Which Details you Want To Update : ");
            int id = sc.nextInt();
            System.out.println("Enter 1 For Update In Name");
            System.out.println("Enter 2 For Update In Id");
            System.out.println("Enter 3 For Update In Price");
            System.out.println("Enter 4 For Update In Type");
            System.out.println("Enter 5 For Back");
            System.out.print("What Do You Want To Update : ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1: {// name
                    System.out.println("Enter New Name : ");
                    sc.nextLine();
                    String newname = sc.nextLine();
                    String s = "update items set name=? where itemid=?;";
                    ps = con.prepareStatement(s);
                    ps.setString(1, newname);
                    ps.setInt(2, id);
                    ps.executeUpdate();
                }
                    break;
                case 2: {// Id
                    System.out.println("Enter New Id : ");
                    int newId = sc.nextInt();
                    String s = "update items set itemid=? where itemid=?;";
                    ps = con.prepareStatement(s);
                    ps.setInt(1, newId);
                    ps.setInt(2, id);
                    ps.executeUpdate();
                }
                    break;
                case 3: {// price
                    System.out.println("Enter New Price : ");
                    double price = sc.nextDouble();
                    String s = "update items set itemprice=? where itemid=?;";
                    ps = con.prepareStatement(s);
                    ps.setDouble(1, price);
                    ps.setInt(2, id);
                    ps.executeUpdate();
                }
                    break;
                case 4: {// type
                    sc.nextLine();
                    System.out.println("Enter New Type : ");
                    String type = sc.nextLine();
                    String s = "update items set type=? where itemid=?;";
                    ps = con.prepareStatement(s);
                    ps.setString(1, type);
                    ps.setInt(2, id);
                    ps.executeUpdate();
                }
                    break;

                case 5:
                    
                    break;
                default:
                    System.out.println("Enter Valid Choice");
                    break;
            }
        }
   

    void display() throws SQLException {
        System.out.println("Enter 1 To Sort Items By Name ");
        System.out.println("Enter 2 To Sort Items By Id ");
        System.out.println("Enter 3 To Sort Items By Price ");
        System.out.println("Enter 4 To Sort Items By Type ");
        System.out.print("How Do You Want Saw Items : ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1: {// name
                
                rs = st.executeQuery("Select * from items order by name");
                while (rs.next()) {
                    System.out.println("Name : " + rs.getString(1) + " ID : " + rs.getInt(2) +
                            " Price : " + rs.getDouble(3) + " Type : " + rs.getString(4));
                }
            }
                break;
            case 2: {// id
                
                rs = st.executeQuery("Select * from items order by itemid");
                while (rs.next()) {
                    System.out.println("Name : " + rs.getString(1) + " ID : " + rs.getInt(2) +
                            " Price : " + rs.getDouble(3) + " Type : " + rs.getString(4));
                }
            }
                break;
            case 3: {// price
                
                rs = st.executeQuery("Select * from items order by itemprice");
                while (rs.next()) {
                    System.out.println("Name : " + rs.getString(1) + " ID : " + rs.getInt(2)
                            + " Price : " + rs.getDouble(3) + " Type : " + rs.getString(4));
                }
            }
                break;
            case 4: {// type
                
                rs = st.executeQuery("Select * from items order by type");
                while (rs.next()) {
                    System.out.println("Name : " + rs.getString(1) + " ID : " + rs.getInt(2) + " Price : "
                            + rs.getDouble(3) + " Type : " + rs.getString(4));
                }
            }
                break;
            default:
                System.out.println("Enter Valid choice");
                break;
        }
    }

   String getLine(int i) {
    int temp_id =purchesedItemId.get(i),temp_quantity = purchesedItemQuantity.get(i);
    double  temp_price = purchesedItemPrice.get(i),temp_amount = purchesedItemAmount.get(i);

    String no, name = "|  " + purchesedItemName.get(i), code, price, quantity, amount ;
    if (i < 10) {
        no = "|    " + i + "   ";
    } else {
        no = "|   " + i + "   ";
    }
    while (name.length() != 43) {
        name += " ";
    }
    if (temp_id < 10) {
        code = "|     " + temp_id + "  ";
    } else if ( temp_id < 100) {
        code = "|    " + temp_id + "  ";
    } else {
        code = "|   " + temp_id + "  ";
    }
    if (temp_price<100) {
        price = "|     " + (int)temp_price + "  ";
    } else if ( temp_price< 1000) {
        price = "|    " + (int)temp_price + "  ";
    } else {
        price = "|   " + (int)temp_price + "  ";
    }
    if (temp_quantity< 10) {
        quantity = "|     " + temp_quantity + "      ";
    } else {
        quantity = "|    " +temp_quantity + "      ";
    }

    if (temp_amount< 100) {
        amount = "|    " +(int)temp_amount + "   |";
    } else if ( temp_amount< 1000) {
        amount = "|   " + (int)temp_amount+ "   |";
    } else {
        amount = "|  " + (int)temp_amount + "   |";
    }
    return no + name + code + price + quantity + amount;
}

    void printBill() throws IOException, SQLException {
        sc.nextLine();
        rs = st.executeQuery("Select count(*) from customers;");
        rs.next();
        int bill_number = rs.getInt(1) + 1;
        System.out.print("Enter Your Name : ");
        name = sc.nextLine();
        System.out.print("Enter Your Mobile Number : ");
        mobileNumber = sc.nextLong(10);
        File f = new File(name);
        f.createNewFile();
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        String line = "-----------------------------------------------------------------------------------------------";
            bw.write(line);
            bw.newLine();
            bw.write("|                                        All In One Store                                         |");
            bw.newLine();
            bw.write(line);
            bw.newLine();
            name = "|   Customer Name : " + name;
            String moNumber = "|   Customer Mobile Number : " + mobileNumber;
            String tempBillNo = "|   Bill Number  : " + bill_number;
            while (name.length() != (line.length() - 1)) {
                name += " ";
            }
            while (moNumber.length() != (line.length() - 1)) {
                moNumber += " ";
            }
            while (tempBillNo.length() != (line.length() - 1)) {
                tempBillNo += " ";
            }
            bw.write(name + "|");
            bw.newLine();
            bw.write(moNumber + "|");
            bw.newLine();
            bw.write(tempBillNo + "|");
            bw.newLine();
            bw.write(line);
            bw.newLine();
            bw.write("|   No.  |              Item Name                   |  Code  |  Price  |  Quantity  |  Amount |");
            bw.newLine();
            bw.write(line);
            bw.newLine();
            int quantity = 0;
            double amount = 0;
            for (int i = 0; i < purchesedItemId.size(); i++) {
                quantity +=  purchesedItemQuantity.get(i);
                amount +=  purchesedItemAmount.get(i);
                bw.write(getLine((i)));
                bw.newLine();
            }
            bw.write(line);
            bw.newLine();
            String temp = "|         Total Item Quantity : " + quantity + "         |    Total Amount : " + amount
                    + "                 ";
            while (temp.length() != name.length()) {
                temp += " ";
            }
            bw.write(temp + "|");
            bw.newLine();
            bw.write(line);
            bw.newLine();
            bw.write("|                                   Thanks For Purchasing                                     |");
            bw.newLine();
            bw.write(line);
            bw.newLine();
            bw.close();
        addIntoCustomesTable(name, mobileNumber, bill_number,(int)(amount));
}

    boolean loginCheck(String name, String password) throws SQLException {
        rs = st.executeQuery("Select * from employee");
        while (rs.next()) {
            if (rs.getString(1).equals(name) && rs.getString(2).equals(password)) {
                return true;
            }
        }
        return false;
    }

    void displayCart() {
        for (int i = 0; i < purchesedItemName.size(); i++) {
            System.out.println((i + 1) + ".  Id : " + purchesedItemId.get(i) + " Name : " + purchesedItemName.get(i)
                    + " Price : " + purchesedItemPrice.get(i) + " Quantity : " + purchesedItemQuantity.get(i)
                    + " Amount : " + purchesedItemAmount.get(i));
        }
    }

    void removeItem() throws SQLException {
        String query = "delete from items where itemid=?";
        ps = con.prepareStatement(query);
        System.out.print("Enter The ID Of Item : ");
        int id = sc.nextInt();
        ps.setInt(1, id);
        ps.execute();
    }

    void removeEmployee() throws SQLException {
        String query = "delete from employee where name=?";
        ps = con.prepareStatement(query);
        sc.nextLine();
        System.out.print("Enter The Name Of Employee : ");
        String Name = sc.nextLine();
        ps.setString(1, Name);
        ps.executeUpdate();
    }

    void showAllEmployees() throws SQLException {
        String query = "Select* from employee";
        rs = st.executeQuery(query);
        while (rs.next()) {
            System.out.println("Name : " + rs.getString(1));
        }
    }

    void addIntoCustomesTable(String name, long mobileNumber, int bill_number, double amount) throws SQLException {
        ps = con.prepareStatement("insert into customers(name,mobile_Number,bill_number,Amount) values(?,?,?,?)");
        ps.setString(1, name);
        ps.setLong(2, mobileNumber);
        ps.setInt(3, bill_number);
        ps.setDouble(4, amount);
        ps.executeUpdate();
    }

    void showCustomerHistory() throws SQLException {
        rs = st.executeQuery("select * from customers;");
        while (rs.next()) {
            System.out.println("Name : " + rs.getString(1) + " Mobile Number : " + rs.getLong(2) + " Bill Number : "
                    + rs.getInt(3) + " Amount : " + rs.getDouble(4));
        }
    }

    void addToCart() throws SQLException {
        ps = con.prepareStatement("Select * from items where itemid = ?");
        System.out.print("Enter ID Of Item : ");
        int id = sc.nextInt();
        ps.setInt(1, id);
        rs = ps.executeQuery();
        while (rs.next()) {
            if (rs.getInt(2) == id) {
                String temp = rs.getString(1);
                double price = rs.getDouble(3);
                purchesedItemId.add(id);
                purchesedItemName.add(temp);
                purchesedItemPrice.add(price);
                System.out.print("Enter How Many " + temp + " You Want To Purchase ? ");
                int quantity = sc.nextInt();
                purchesedItemQuantity.add(quantity);
                purchesedItemAmount.add(quantity * price);
                System.out.println("Item Added To Cart.");
                break;
            }
        }
    }

    void removeFromCart() {
        System.out.print("Enter Id Of Product Which You Want To Remove : ");
        int id = sc.nextInt();
        if (purchesedItemId.contains(id)) {
            for (int i = 0; i < purchesedItemId.size(); i++) {
                if (purchesedItemId.get(i) == id) {
                    purchesedItemAmount.remove(i);
                    purchesedItemId.remove(i);
                    purchesedItemName.remove(i);
                    purchesedItemPrice.remove(i);
                    purchesedItemQuantity.remove(i);
                    break;
                }
            }
        } else {
            System.out.println("No Such Item Found For That Id In you Cart");
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        SM s = new SM();
        while (true) {
            System.out.print("How Would You Like To Enter , Customer Or Employee : ");

            String userRole = sc.nextLine();
            if (userRole.equalsIgnoreCase("Customer")) {
            
                boolean tempb = true;
                while (tempb) {
                    System.out.println("Enter 1 For Show All Items");
                    System.out.println("Enter 2 For Add Items Into Cart");
                    System.out.println("Enter 3 For Remove Items From Cart");
                    System.out.println("Enter 4 For Show Cart");
                    System.out.println("Enter 5 For Generate Bill");
                    System.out.println("Enter 6 For Back");
                    System.out.print("Enter Choice : ");
                    int choice1 = sc.nextInt();
                    switch (choice1) {
                        case 1:
                            s.display();
                            break;
                        case 2:
                            s.addToCart();
                            break;
                        case 3:
                            s.removeFromCart();
                            break;
                        case 4:
                            s.displayCart();
                            break;
                        case 5:
                            try {
                                s.printBill();
                            } catch (Exception e) {
                                //ignore
                            }
                            break;
                        case 6:
                        sc.nextLine();
                            tempb = false;
                            break;
                        default:
                            System.out.println("Enter Valid Choice");
                    }
                }
            } else if (userRole.equalsIgnoreCase("Employee")) {
                boolean tempb = true;
                while (true) {
                    System.out.print("Enter Name : ");
                    String name = sc.nextLine();
                    System.out.print("Enter Password : ");
                    String password = sc.nextLine();
                    if (s.loginCheck(name, password)) {
                        System.out.println("Login Done");
                        break;
                    } else {
                        System.out.println("Wrong Name Or Password");
                    }
                }
                while (tempb) {
                    System.out.println("Enter 1 For Show All Items");
                    System.out.println("Enter 2 For Add New Items");
                    System.out.println("Enter 3 For Remove Items");
                    System.out.println("Enter 4 For Update Item Details");
                    System.out.println("Enter 5 For Show All Employee");
                    System.out.println("Enter 6 For Add New Employee");
                    System.out.println("Enter 7 For Remove Employee");
                    System.out.println("Enter 8 For Show Customer History");
                    System.out.println("Enter 9 For Back");
                    System.out.print("Enter Choice : ");
                    int choice1 = sc.nextInt();
                    switch (choice1) {
                        case 1:
                            s.display();
                            break;
                        case 2:
                            s.addItem();
                            break;
                        case 3:
                            s.removeItem();
                            break;
                        case 4:
                            s.update();
                            break;
                        case 5:
                            s.showAllEmployees();
                            break;
                        case 6:
                            s.addEmployee();
                            break;
                        case 7:
                            s.removeEmployee();
                            break;
                        case 8:
                            s.showCustomerHistory();
                            break;
                        case 9:
                        sc.nextLine();
                            tempb = false;
                            break;
                        default:
                            System.out.println("Enter Valid Choice");
                    }
                }
            } else if (userRole.equalsIgnoreCase("Quit")) {
                System.exit(0);
            }
}
}
}