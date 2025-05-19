package Connection;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnection {
	public static Connection getConnection() throws SQLException {
		// SQL Server connection string with Kerberos authentication
		String url = "jdbc:sqlserver://localhost:1433;databaseName=doancntt;integratedSecurity=true;encrypt=true;trustServerCertificate=true;authenticationScheme=JavaKerberos";

		// Tải driver
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// Thêm đường dẫn DLL vào java.library.path
			System.setProperty("java.library.path", 
				System.getProperty("java.library.path") + 
				";D:\\NewUniversity\\HKI_2024_2025\\CongNghePhanMem\\sqljdbc_12.10\\enu\\auth\\x64");
		} catch (ClassNotFoundException e) {
			System.out.println("Không tìm thấy driver JDBC: " + e.getMessage());
			return null;
		}

		// Tạo kết nối với Windows Authentication
		Connection connection = DriverManager.getConnection(url);
		return connection;
	}
}
