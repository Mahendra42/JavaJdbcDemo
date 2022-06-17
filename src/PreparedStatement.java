import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;


class PreparedStatement00 {
    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mmr", "root", "root");
        try {
            String sql = "insert into employees values(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, 2);
            pst.setString(2, "Yuvo");
            pst.setInt(3, 25000);
            pst.setString(4, "AP");

            pst.execute();
            System.out.println("entered value successfully...");
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            con.close();
        }



    }
}
