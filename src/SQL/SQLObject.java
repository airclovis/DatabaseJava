package SQL;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

/**
 * 
 * @author Clovis Delarue
 * Class to create a connection to database
 * and execute different types of query
 */
public class SQLObject {

	private Connection con = null;
	private Statement s = null;
	private ResultSet rs = null;
	private ResultSetMetaData rsm = null;
	private int nbCol = 0;
	private int nbRows = 0;
	
	/**
	 * Constructor for a SQLObject
	 * @param server
	 * 		Adress of the server
	 * @param database
	 * 		Name of the database
	 * @param login
	 * 		Login to connect to the database
	 * @param pass
	 * 		Password to connect to the database
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public SQLObject(String server, String database, String login, String pass) throws ClassNotFoundException, SQLException	
	{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://" + server + "/"+ database, login, pass);
		s = con.createStatement();
	}
	
	/**
	 * Execute the query q
	 * @param q
	 * 	Query to execute
	 * @throws SQLException 
	 */
	public void executeQuery(String q) throws SQLException
	{
		rs = s.executeQuery(q);
		rsm = rs.getMetaData();
		nbCol = rsm.getColumnCount();
	}
	
	/**
	 * Return then number of column for the current query
	 * @return
	 * 		number of column for the current query
	 * @throws SQLException 
	 */
	public int nbColumns()
	{
		return nbCol;
	}
	
	/**
	 * Return the number of row for the current query
	 * @return
	 * 		number of rows
	 */
	public int nbRows()
	{
		return nbRows;
	}
	
	/**
	 * Return data for the current query in a LikedList or Object table
	 * @return
	 * 		The LinkedList with data
	 * @throws SQLException 
	 */
	public LinkedList<Object[]> getData() throws SQLException {
		LinkedList<Object[]> l = new LinkedList<Object[]>();
		if (rs != null && rsm != null) {
			nbRows = 0;
			while (rs.next()) {
				Object[] line = new Object[nbCol];
				for (int i = 1; i <= nbCol; i++) {
					line[i - 1] = rs.getObject(i);
				}
				l.add(line);
				nbRows++;
			}

		}
		return l;
	}

	/**
	 * Return a table with all the column name for the current query
	 * @return
	 * 		String[] with the name of columns
	 * @throws SQLException
	 */
	public String[] getNames() throws SQLException
	{
		String[] n = new String[nbCol];
		for(int i = 1; i <= nbCol; i++)
		{
			n[i-1] = rsm.getColumnName(i);
		}
		
		return n;
	}

	/**
	 * Method to close the connection
	 * @throws SQLException
	 */
	public void closeConnection() throws SQLException
	{
		con.close();
	}
	
}
