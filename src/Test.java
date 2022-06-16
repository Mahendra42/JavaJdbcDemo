import java.sql.*;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws SQLException {


        Scanner s = null;
        String str = null;
        int count = 0;

        while (true) {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mmr", "root", "root");
            Statement st = con.createStatement();
            ++count;
            s = new Scanner(System.in);
            str = s.nextLine();
            String sql=null;
            boolean flag=false;

            switch (str) {
                case "create":
                    if (count == 1)
                        try {
                            boolean b = st.execute("create table employees(eid int,ename varchar(10),esal int,eaddr varchar(10))");
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    else
                        System.out.println("Table is already existed ....");
                    break;
                case "insert":
                        while(true){
                            System.out.println("Enter the Emp id ,Emp_name ,Esalary ,EAddress :");
                            int eid=s.nextInt();
                            String ename=s.next();
                            int esal=s.nextInt();
                            String eaddr=s.next();

                            sql=String.format("insert into employees values(%d,'%s',%d,'%s')",eid,ename,esal,eaddr);
                            System.out.println(sql);
                            int update=st.executeUpdate(sql);
                            System.out.println("If you want to insert some more records..");
                            String c=s.nextLine();
                            if(c.equalsIgnoreCase("n")){
                                break;
                            }
                            sql=null;
                        }
                    break;

                default:
                    System.out.println("NO cases is matched ..." + "");
                    break;



            }con.close();
        }
    }
}
