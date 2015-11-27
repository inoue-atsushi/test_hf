package hoge;

 import java.sql.Connection;
 import java.sql.DriverManager;
 import java.sql.ResultSet;
 import java.sql.SQLException;
 import java.sql.Statement;

 import com.sun.rowset.CachedRowSetImpl;

 public class DBManager {

	 public static Connection getConnection() {
		 try {
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test_hf", "root", "a-inoue");
			 return con;
		 } catch (Exception e) {
			 throw new IllegalStateException(e);
		 }
	 }

	 public static ResultSet executeQuery(String sql) throws SQLException {
		 Connection con = getConnection();
		 Statement smt = con.createStatement();
		 ResultSet rs = smt.executeQuery(sql);

		 CachedRowSetImpl rowset = new CachedRowSetImpl();
		 rowset.populate(rs);

		 smt.close();
		 con.close();

		 return rowset;
	 }

	 public static void main(String[] args) throws Exception {
		 ResultSet rs = executeQuery("select * from video");

		 while (rs.next()) {
			 String title = rs.getString("title");
			 int price = rs.getInt("price");
			 System.out.println("title=" + title + ", price=" + price);
		}
	 }
 }