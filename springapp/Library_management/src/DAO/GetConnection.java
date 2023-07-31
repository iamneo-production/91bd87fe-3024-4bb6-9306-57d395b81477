package DAO;
import java.sql.Connection;
public abstract class GetConnection {
		abstract public Connection getDbConnection() throws ClassNotFoundException;
	}

