import java.sql.*;
public class DBConnect {
	public Connection conn=null;
	public DBConnect() throws Exception
	{
		Class.forName("org.postgresql.Driver");
		 conn =
		DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","priyanshi");
		
	}
	public void queryExecuter(String sql) throws Exception
	{
		//DML insert update delete 
		
		Statement st = conn.createStatement();
		st.execute(sql);//execute for insert only ,, query execute for return record
		st.close();
		
	}
	public ResultSet queryReturner(String sql) throws Exception
	{
		//DDl select 
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		return rs;
	}

}
