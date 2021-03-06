package utility;

import java.io.InputStream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionManager{
	
	public static Connection getConnection() throws Exception {
		Properties p=loadProperties();
		Class.forName(p.getProperty("driver"));
		Connection con=null;
		con=DriverManager.getConnection(p.getProperty("url"),p.getProperty("username"),p.getProperty("password"));
		if(con!=null)
			return con;
		else
			return null;
	}
	
	public static Properties loadProperties() throws Exception {
			Properties prop=new Properties();
			InputStream in=ConnectionManager.class.getClassLoader().getResourceAsStream("jdbc.properties");
			prop.load(in);
			in.close();
			return prop;
	}
	
}
