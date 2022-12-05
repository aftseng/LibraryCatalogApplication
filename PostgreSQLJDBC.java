import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class PostgreSQLJDBC 
{
	
	static boolean result = false;
	public static ArrayList<Book> list = new ArrayList<Book>();
	//private final static ObservableList<Book> list = FXCollections.observableArrayList();
	
	public static void main(String args[])
	{
		//selectBookQuery();
		//selectUserQuery();
		//selectPublisherQuery();
		//selectReservationQuery();
		//selectSearchQuery();
		//selectAuthenticateQuery();
		//selectFromBookQuery("White Fang");
		//insertQuery();
	}
	
	public static void insertQuery()
	{
		Connection c = null;
		Statement stmt = null;
		try
		{
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Project", "postgres", "student");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");
			System.out.println();
			
			stmt = c.createStatement();
			//String sql = "INSERT INTO Book (AUTHOR, TITLE, RESERVATIONSTATUS, ISBN, GENRE, PUBLISHERID)" + "VALUES ('Jane Austen', 'Pride and Prejudice', 'Reserved', '9781435172487', 'Domestic Fiction', '789');";
			//String sql = "INSERT INTO USERS (FIRST_NAME, LAST_NAME, USERID, EMAIL, PHONE_NUMBER)" + "VALUES ('Andrew', 'Tseng', 'aft', 'aft@gmail.com', '222-222-2222');";
			//String sql = "INSERT INTO Publisher (NAME, PUBLISHERID, YEAR)" + "VALUES ('Tilbury House', '456', '2021');";
			//String sql = "INSERT INTO RESERVATION (RESERVE_DATE, DUE_DATE, RETURN_DATE, USERID, ISBN)" + "VALUES ('11/30/22', '12/25/22', 'NA', 'aft', '9780684171609');";
			String sql = "INSERT INTO AUTHENTICATION_SYSTEM (USERID, PASSWORD)" + "VALUES ('aft', '54321');";
			stmt.executeUpdate(sql);
			
			stmt.close();
			c.commit();
			c.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Records created successfully");
		System.out.println();
	}
	
	public static void selectUserQuery()
	{
		Connection c = null;
		Statement stmt = null;
		try
		{
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Project", "postgres", "student");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");
			System.out.println();
			
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM users");
			while(rs.next())
			{
				String f_name = rs.getString("first_name");
				String l_name = rs.getString("last_name");
				String uid = rs.getString("userid");
				String email = rs.getString("email");
				String pnumber = rs.getString("phone_number");
				System.out.println("First Name: " + f_name);
				System.out.println("Last Name: " + l_name);
				System.out.println("UserID: " + uid);
				System.out.println("Email: " + email);
				System.out.println("Phone Number: " + pnumber);
				System.out.println();
			}
			rs.close();
			stmt.close();
			c.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Operation done and closed successfully");
		System.out.println();
	}
	
	public static String selectFromBookQuery(String t)
	{
		Connection c = null;
		Statement stmt = null;
		String text = "";
		try
		{
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Project", "postgres", "student");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");
			System.out.println();
			
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM book");
			while(rs.next())
			{
				String author = rs.getString("author");
				String title = rs.getString("title");
				String status = rs.getString("reservationstatus");
				String isbn = rs.getString("isbn");
				String genre = rs.getString("genre");
				String pid = rs.getString("publisherid");
				if(author.equalsIgnoreCase(t) || title.equalsIgnoreCase(t) || status.equalsIgnoreCase(t) || isbn.equalsIgnoreCase(t) || genre.equalsIgnoreCase(t) || pid.equals(t))
				{
					text += "Author: " + author + "\nTitle: " + title + "\nReservation Status: " + status + "\nISBN: " + isbn + "\nGenre: " + genre + "\nPublisherID: " + pid + "\n---------------------------------\n";
				}
			}
			rs.close();
			stmt.close();
			c.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Operation done and closed successfully");
		System.out.println();
		return text;
	}
	
	public static String selectBookQuery()
	{
		Connection c = null;
		Statement stmt = null;
		String result = "";
		//Book b = new Book();
		try
		{
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Project", "postgres", "student");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");
			System.out.println();
			
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM book");
			while(rs.next())
			{
				String author = rs.getString("author");
				String title = rs.getString("title");
				String status = rs.getString("reservationstatus");
				String isbn = rs.getString("isbn");
				String genre = rs.getString("genre");
				String pid = rs.getString("publisherid");
				result += "Author: " + author + "\nTitle: " + title + "\nReservation Status: " + status + "\nISBN: " + isbn + "\nGenre: " + genre + "\nPublisherID: " + pid + "\n---------------------------------\n";
				//b = new Book(author, title, status, isbn, genre, pid);
				//list.add(b);
				/*System.out.println("Author: " + author);
				System.out.println("Last Name: " + title);
				System.out.println("UserID: " + status);
				System.out.println("Email: " + isbn);
				System.out.println("Phone Number: " + genre);
				System.out.println("PublisherID: " + pid); 
				System.out.println();*/
			}
			rs.close();
			stmt.close();
			c.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Operation done and closed successfully");
		System.out.println();
		return result;
	}
	
	public static String selectFromPublisherQuery(String t)
	{
		Connection c = null;
		Statement stmt = null;
		String text = "";
		try
		{
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Project", "postgres", "student");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");
			System.out.println();
			
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM publisher");
			while(rs.next())
			{
				String name = rs.getString("name");
				String pid = rs.getString("publisherid");
				String year = rs.getString("year");
				if(name.equalsIgnoreCase(t) || pid.equalsIgnoreCase(t) || year.equalsIgnoreCase(t))
				{
					text += "Publisher Name: " + name + "\nPublisherID: " + pid + "\nYear: " + year + "\n---------------------------------\n";
				}
			}
			rs.close();
			stmt.close();
			c.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Operation done and closed successfully");
		System.out.println();
		return text;
	}
	
	public static String selectPublisherQuery()
	{
		Connection c = null;
		Statement stmt = null;
		String result = "";
		try
		{
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Project", "postgres", "student");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");
			System.out.println();
			
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM publisher");
			while(rs.next())
			{
				String name = rs.getString("name");
				String pid = rs.getString("publisherid");
				String year = rs.getString("year");
				result += "Publisher Name: " + name + "\nPublisherID: " + pid + "\nYear: " + year + "\n---------------------------------\n";
				/*System.out.println("Author: " + name);
				System.out.println("Last Name: " + pid);
				System.out.println("PublisherID: " + year); 
				System.out.println();*/
			}
			rs.close();
			stmt.close();
			c.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Operation done and closed successfully");
		System.out.println();
		return result;
	}
	
	public static String selectFromReservationQuery(String t)
	{
		Connection c = null;
		Statement stmt = null;
		String text = "";
		try
		{
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Project", "postgres", "student");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");
			System.out.println();
			
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM reservation");
			while(rs.next())
			{
				String reserve = rs.getString("reserve_date");
				String due = rs.getString("due_date");
				String ret = rs.getString("return_date");
				String uid = rs.getString("userid");
				String isbn = rs.getString("isbn");
				if(reserve.equalsIgnoreCase(t) || due.equalsIgnoreCase(t) || ret.equalsIgnoreCase(t) || uid.equalsIgnoreCase(t) || isbn.equalsIgnoreCase(t))
				{
					text += "Reserve Date: " + reserve + "\nDue Date: " + due + "\nReturn Date: " + ret +  "\nUser ID: " + uid + "\nISBN: " + isbn + "\n---------------------------------\n";
				}
			}
			rs.close();
			stmt.close();
			c.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Operation done and closed successfully");
		System.out.println();
		return text;
	}
	
	public static String selectReservationQuery()
	{
		Connection c = null;
		Statement stmt = null;
		String result = "";
		try
		{
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Project", "postgres", "student");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");
			System.out.println();
			
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM reservation");
			while(rs.next())
			{
				String reserve = rs.getString("reserve_date");
				String due = rs.getString("due_date");
				String ret = rs.getString("return_date");
				String uid = rs.getString("userid");
				String isbn = rs.getString("isbn");
				result += "Reserve Date: " + reserve + "\nDue Date: " + due + "\nReturn Date: " + ret +  "\nUser ID: " + uid + "\nISBN: " + isbn + "\n---------------------------------\n";
				/*System.out.println("Reserve Date: " + reserve);
				System.out.println("Due Date: " + due);
				System.out.println("Return Date: " + ret);
				System.out.println("User ID: " + uid);
				System.out.println("ISBN: " + isbn);
				System.out.println();*/
			}
			rs.close();
			stmt.close();
			c.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Operation done and closed successfully");
		System.out.println();
		return result;
	}
	
	public static void selectSearchQuery()
	{
		Connection c = null;
		Statement stmt = null;
		try
		{
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Project", "postgres", "student");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");
			System.out.println();
			
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM search_feature");
			while(rs.next())
			{
				String publisher = rs.getString("publisher");
				String isbn = rs.getString("isbn");
				String booktitle = rs.getString("booktitle");
				String author = rs.getString("author");
				String genre = rs.getString("genre");
				System.out.println("Publisher: " + publisher);
				System.out.println("ISBN: " + isbn);
				System.out.println("BookTitle: " + booktitle);
				System.out.println("Author: " + author);
				System.out.println("Genre: " + genre);
				System.out.println();
			}
			rs.close();
			stmt.close();
			c.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Operation done and closed successfully");
		System.out.println();
	}
	
	public static void selectFromAuthenticateQuery(String u, String p)
	{
		Connection c = null;
		Statement stmt = null;
		try
		{
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Project", "postgres", "student");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");
			System.out.println();
			
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM authentication_system");
			while(rs.next())
			{
				String uid = rs.getString("userid");
				String password = rs.getString("password");
				if(uid.equals(u) && password.equals(p))
				{
					result = true;
				}
				//System.out.println("UserID: " + uid);
				//System.out.println("Password: " + password);
			}
			rs.close();
			stmt.close();
			c.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Operation done and closed successfully");
		System.out.println();
	}
	
	
	public static void selectAuthenticateQuery()
	{
		Connection c = null;
		Statement stmt = null;
		try
		{
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Project", "postgres", "student");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");
			System.out.println();
			
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM authentication_system");
			while(rs.next())
			{
				String uid = rs.getString("userid");
				String password = rs.getString("password");
				System.out.println("UserID: " + uid);
				System.out.println("Password: " + password);
				System.out.println();
			}
			rs.close();
			stmt.close();
			c.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Operation done and closed successfully");
		System.out.println();
	}
	
	
}

