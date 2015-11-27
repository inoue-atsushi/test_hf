import java.net.*;
import java.sql.*;

public class connectMain {

    public static void main(String args[]){
        String server   = "localhost"; //MySQLサーバ
        String db       = "test_hf";  //
        String user     = "a-inoue";      //ユーザー名
        String pass     = "a-inoue";  //パスワード
        String url      = "jdbc:mysql://" + server + "/" + db;
        Connection con  = null;
        try{
            //ドライバのロード
           Class.forName("org.gjt.mm.mysql.Driver");

            //MySQLサーバへの接続
            con = DriverManager.getConnection(url,user,pass);

            System.out.println("接続成功です！");

            //切断
            con.close();
        }catch(SQLException e) {
            System.err.println("接続失敗です～\n理由：" + e.toString());
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                //切断
                con.close();
            }catch(Exception e){}
        }
    }

}
