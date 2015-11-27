<%@page contentType="text/html; charset=Windows-31J"%>
<%@page import="java.sql.ResultSet, hoge.DBManager" %>

<html>
<body>

<%
try {
	ResultSet rs = DBManager.executeQuery("select * from video");

	while(rs.next()){
		String title = rs.getString("title");
		int price = rs.getInt("price");
		out.println("title=" + title + ",price=" + price + "<br>");
	}
} catch (Exception e) {
	e.printStackTrace();
}
%>
</body>
</html>
