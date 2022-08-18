package project;

import java.sql.*;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DataBase {
	
	public static Connection connection;
	public String databaseURL = "jdbc:ucanaccess://UsersData.accdb";
	public static String sql;
	public static String sql2;
	public static String sql3;
	public static int found=0;
	public static String name;
	public static String lastName;
	public static String userName;
	public static String emailId;
	public static String passCode;
	public static String educate;
	public static String inter;
	public static String faceBook;
	public static String userCall;
	public static String tw;
	public static String occupate;
	public static String insta;
	public static Double weightKg;
	public static Double heightCm;
	public static Double bmiNo;
	public static String friend;
	public static int call;
	public static int countWater;
	public static int check=0;
	public static int checkStatus=0;
	public static int callStatus=0;
	public static int checkFriend=0;
	public static int checkFriendReq=0;
	
	public void Registration1(String f,String u, String p,Double w, Double h, String l, String cp, String email) {
		try {
			connection =DriverManager.getConnection(databaseURL);  
			System.out.println("Database Connected (Registration1)");
			
			sql = "INSERT INTO Registration1 (First_Name, Username, Password, Weight, Height, Last_name, Confirm_Password, Email) VALUES (?,?,?,?,?,?,?,?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, f);
			statement.setString(2, u);
			statement.setString(3, p);
			statement.setDouble(4, w);
			statement.setDouble(5, h);
			statement.setString(6, l);
			statement.setString(7, cp);
			statement.setString(8, email);

			statement.executeUpdate();
			statement.close();
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void Registration2(String edu,String i, String fb, String t, String occup, String insta,String u, String p) {
		try {
			connection =DriverManager.getConnection(databaseURL);  
			System.out.println("Database Connected (Registration2)");
			
			sql = "INSERT INTO Registration2 (Education, Interest, Fb, Twitter, Occupation, Instagram, Username, Password) VALUES (?,?,?,?,?,?,?,?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, edu);
			statement.setString(2, i);
			statement.setString(3, fb);
			statement.setString(4, t);
			statement.setString(5, occup);
			statement.setString(6, insta);
			statement.setString(7, u);
			statement.setString(8, p);

			statement.executeUpdate();
			statement.close();
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void Registration3(String pref) {
		try {
			connection =DriverManager.getConnection(databaseURL);  
			System.out.println("Database Connected (Registration2)");
			
			sql = "INSERT INTO Registration3 (WeightPreference) VALUES (?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, pref);

			statement.executeUpdate();
			statement.close();
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
//	172.217.6.77
public void userLogin(String c, String p) {
		
		PreparedStatement statement;
		ResultSet rs;
		
		try {
			connection =DriverManager.getConnection(databaseURL);  
			System.out.println("Connected Search Cnic");
			sql = "SELECT Username, Password FROM Registration1";
			statement = connection.prepareStatement(sql);
			rs = statement.executeQuery();		
			while(rs.next()) {
				String username = rs.getString("Username");
				String pass = rs.getString("Password");
				
				if(c.equals(username)) {
					if(p.equals(pass)) {
						System.out.println("Logged IN");
						found=1;
						break;
				}
				}	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
public void userSearch(String c, String p) {
	
	PreparedStatement statement;
	ResultSet rs;
	
	try {
		connection =DriverManager.getConnection(databaseURL);  
		System.out.println("Connected Search Cnic");
		sql = "SELECT First_name, Username, Password, Weight, Height, Last_name,Email FROM Registration1";
		statement = connection.prepareStatement(sql);
		rs = statement.executeQuery();		
		while(rs.next()) {
			String firstname = rs.getString("First_Name");
			String username = rs.getString("Username");
			String pass = rs.getString("Password");
			Double weight = rs.getDouble("Weight");
			Double height = rs.getDouble("Height");
			String lastname = rs.getString("Last_name");
			String email = rs.getString("Email");

			if(c.equals(username)) {
				if(p.equals(pass)) {
					name=firstname;
					userName = username;
					passCode = pass;
					weightKg = weight;
					heightCm = height;
					lastName = lastname;
					emailId = email;
					check=1;
					break;
			}
			}
			else {
				check=0;
			}
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
}

public void userSearch(String c) {
	
	PreparedStatement statement;
	ResultSet rs;
	
	try {
		connection =DriverManager.getConnection(databaseURL);  
		System.out.println("Connected Search Cnic");
		sql = "SELECT First_name, Username, Password, Weight, Height, Last_name,Email FROM Registration1";
		statement = connection.prepareStatement(sql);
		rs = statement.executeQuery();		
		while(rs.next()) {
			String firstname = rs.getString("First_Name");
			String username = rs.getString("Username");
			String pass = rs.getString("Password");
			Double weight = rs.getDouble("Weight");
			Double height = rs.getDouble("Height");
			String lastname = rs.getString("Last_name");
			String email = rs.getString("Email");

			if(c.equals(username)) {
					name=firstname;
					userName = username;
					passCode = pass;
					weightKg = weight;
					heightCm = height;
					lastName = lastname;
					emailId = email;
					check=1;
					break;
			}
			else {
				check=0;
			}
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
}

public void userSearchReg2(String c, String p) {
	
	PreparedStatement statement;
	ResultSet rs;
	
	try {
		connection =DriverManager.getConnection(databaseURL);  
		System.out.println("Connected Search Cnic");
		sql = "SELECT Education, Interest, Fb, Twitter, Occupation, Instagram, Username, Password FROM Registration2";
		statement = connection.prepareStatement(sql);
		rs = statement.executeQuery();		
		while(rs.next()) {
			String education = rs.getString("Education");
			String interest = rs.getString("Interest");
			String fb = rs.getString("Fb");
			String twitter = rs.getString("Twitter");
			String occupation = rs.getString("Occupation");
			String instagram = rs.getString("Instagram");
			String username = rs.getString("Username");
			String pass = rs.getString("Password");

			if(c.equals(username)) {
				if(p.equals(pass)) {
					userName = username;
					passCode = pass;
					educate = education;
					inter = interest;
					faceBook = fb;
					tw = twitter;
					occupate = occupation;
					insta = instagram;
					break;
			}
			}	
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
}

public void userSearchReg2(String c) {
	
	PreparedStatement statement;
	ResultSet rs;
	
	try {
		connection =DriverManager.getConnection(databaseURL);  
		System.out.println("Connected Search Cnic");
		sql = "SELECT Education, Interest, Fb, Twitter, Occupation, Instagram, Username, Password FROM Registration2";
		statement = connection.prepareStatement(sql);
		rs = statement.executeQuery();		
		while(rs.next()) {
			String education = rs.getString("Education");
			String interest = rs.getString("Interest");
			String fb = rs.getString("Fb");
			String twitter = rs.getString("Twitter");
			String occupation = rs.getString("Occupation");
			String instagram = rs.getString("Instagram");
			String username = rs.getString("Username");
			String pass = rs.getString("Password");

			if(c.equals(username)) {
					userName = username;
					passCode = pass;
					educate = education;
					inter = interest;
					faceBook = fb;
					tw = twitter;
					occupate = occupation;
					insta = instagram;
					break;
			}	
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
}


public void updatePassword(String u, String password) {
	PreparedStatement statement;
	PreparedStatement statementC;
	PreparedStatement statementP;
	ResultSet rs;
	
	try {
		connection =DriverManager.getConnection(databaseURL);  
		System.out.println("Connected Search Cnic");
		sql = "SELECT Username, Password, Confirm_Password FROM Registration1";
		statement = connection.prepareStatement(sql);
		rs = statement.executeQuery();		
		while(rs.next()) {
			String username = rs.getString("Username");

			if(u.equals(username)) {
					sql2 = "UPDATE Registration1 SET Password = '"+password+"' WHERE Username='"+u+"'";
					sql3 = "UPDATE Registration1 SET Confirm_Password = '"+password+"' WHERE Username='"+u+"'";
					statementC = connection.prepareStatement(sql2);
					statementC.executeUpdate();
					statementC.close();
					statementP = connection.prepareStatement(sql3);
					statementP.executeUpdate();
					statementP.close();
					break;
			}	
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
}

public void searchUsername(String u) {
	
	PreparedStatement statement;
	ResultSet rs;
	
	try {
		connection =DriverManager.getConnection(databaseURL);  
		System.out.println("Connected Search Cnic");
		sql = "SELECT Username FROM Registration1";
		statement = connection.prepareStatement(sql);
		rs = statement.executeQuery();		
		while(rs.next()) {
			String username = rs.getString("Username");
			if(u.equals(username)) {
					check=1;
					break;
			}
			else {
				check=0;
			}
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
}

public void newDB(String userN) {
	
	Statement statement;
	try {
		connection =DriverManager.getConnection(databaseURL);  
		System.out.println("Connected Search Cnic");
		String sql = "CREATE Table "+ userN +" (ID AUTOINCREMENT, FriendName VARCHAR(255), PRIMARY KEY(ID))";
		statement = connection.createStatement();
		statement.executeUpdate(sql);
		statement.close();
		connection.close();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

public void newDBForStatus(String userN) {
	
	Statement statement;
	try {
		connection =DriverManager.getConnection(databaseURL);  
		System.out.println("Connected Search Cnic");
		String sql = "CREATE Table "+ userN +"_status (ID AUTOINCREMENT, Status INT, PRIMARY KEY(ID))";
		statement = connection.createStatement();
		statement.executeUpdate(sql);
		statement.close();
		connection.close();
		insertStatus(userN);
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

public void newDBForCalls(String userN) {
	
	Statement statement;
	try {
		connection =DriverManager.getConnection(databaseURL);  
		System.out.println("Connected Search Cnic");
		String sql = "CREATE Table "+ userN +"_calls (ID AUTOINCREMENT, FriendName VARCHAR(255), Caller INT , PRIMARY KEY(ID))";
		statement = connection.createStatement();
		statement.executeUpdate(sql);
		statement.close();
		connection.close();
		insertCallStatus(userN);
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

public void insertStatus(String userN) {
	try {
		connection =DriverManager.getConnection(databaseURL);  
		System.out.println("Database Connected (Registration1)");
		
		sql = "INSERT INTO "+userN+"_status (Status) VALUES (?)";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, 0);

		statement.executeUpdate();
		statement.close();
		connection.close();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

public void insertCallStatus(String userN) {
	try {
		connection =DriverManager.getConnection(databaseURL);  
		System.out.println("Database Connected (Registration1)");
		
		sql = "INSERT INTO "+userN+"_calls (FriendName, Caller) VALUES (?,?)";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, "random");
		statement.setInt(2, 0);

		statement.executeUpdate();
		statement.close();
		connection.close();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

public void updateUserStatus(String userN, int No) {
	PreparedStatement statement;
	PreparedStatement statementC;
	PreparedStatement statementP;
	ResultSet rs;
	
	try {
		connection =DriverManager.getConnection(databaseURL);  
		System.out.println("Connected Search Cnic");
	
		sql2 = "UPDATE "+userN+"_status SET Status = "+No+" WHERE ID = 1";
		statementC = connection.prepareStatement(sql2);
		statementC.executeUpdate();
		statementC.close();
		connection.close();

		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
}

public void updateUserCallStatus(String userN, String friend,int No) {
	PreparedStatement statement;
	PreparedStatement statementC;
	PreparedStatement statementP;
	ResultSet rs;
	
	try {
		connection =DriverManager.getConnection(databaseURL);  
		System.out.println("Connected Search Cnic");
	
		sql2 = "UPDATE "+userN+"_calls SET FriendName = '"+friend+"' WHERE ID = 1";
		sql3 = "UPDATE "+userN+"_calls SET Caller = "+No+" WHERE ID = 1";
		statementC = connection.prepareStatement(sql2);
		statementC.executeUpdate();
		statementC.close();
		statementP = connection.prepareStatement(sql3);
		statementP.executeUpdate();
		statementP.close();
		connection.close();

		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
}

public void checkUserStatus(String userN) {
	
	PreparedStatement statement;
	ResultSet rs;
	
	try {
		connection =DriverManager.getConnection(databaseURL);  
		System.out.println("Connected Search Cnic");
		sql = "SELECT Status FROM "+userN+"_status";
		statement = connection.prepareStatement(sql);
		rs = statement.executeQuery();		
		while(rs.next()) {
			int status = rs.getInt("Status");
			
			if(status==1) {
				System.out.println("Status 1");
				checkStatus=1;
				break;
			}	
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
}

public void checkUserCallStatus(String userN) {
	
	PreparedStatement statement;
	ResultSet rs;
	
	try {
		connection =DriverManager.getConnection(databaseURL);  
		System.out.println("Connected Search Cnic");
		sql = "SELECT FriendName, Caller FROM "+userN+"_calls";
		statement = connection.prepareStatement(sql);
		rs = statement.executeQuery();		
		while(rs.next()) {
			friend = rs.getString("FriendName");
			call = rs.getInt("Caller");
			
			if(call==1) {
				System.out.println("Call 1");
				userCall = friend;
				callStatus=1;
				break;
			}
			else {
				userCall=null;
				callStatus=0;
			}
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
}


public void newDbRequests(String userN) {
	
	Statement statement;
	try {
		connection =DriverManager.getConnection(databaseURL);  
		System.out.println("Connected Search Cnic");
		String sql = "CREATE Table "+ userN +"_requests (ID AUTOINCREMENT, FriendName VARCHAR(255), PRIMARY KEY(ID))";
		statement = connection.createStatement();
		statement.executeUpdate(sql);
		statement.close();
		connection.close();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

public void sendRequest(String friend, String user) {
	try {
		connection =DriverManager.getConnection(databaseURL);  
		System.out.println("Database Connected (Registration2)");
		
		sql = "INSERT INTO "+friend+"_requests (FriendName) VALUES (?)";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, user);

		statement.executeUpdate();
		statement.close();
		connection.close();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

public void showFriendRequests(JTable compTable, String user) {
	String columns[]= {""};
	PreparedStatement statement;
	ResultSet rs;

	try {
		connection = DriverManager.getConnection(databaseURL);
		sql = "SELECT * FROM "+user+"_requests";
		statement = connection.prepareStatement(sql);
		rs = statement.executeQuery();
		
		while(rs.next()) {
			String friend = String.valueOf(rs.getString("FriendName"));
			
			String compData[]= {friend};
			DefaultTableModel tableModel = (DefaultTableModel)compTable.getModel();
			tableModel.setColumnIdentifiers(columns);
			tableModel.addRow(compData);
		}
		statement.close();
		connection.close();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

public void showAllFriends(JTable compTable, String user) {
	String columns[]= {""};
	PreparedStatement statement;
	ResultSet rs;

	try {
		connection = DriverManager.getConnection(databaseURL);
		sql = "SELECT * FROM "+user;
		statement = connection.prepareStatement(sql);
		rs = statement.executeQuery();
		
		while(rs.next()) {
			String friend = String.valueOf(rs.getString("FriendName"));
			
			String compData[]= {friend};
			DefaultTableModel tableModel = (DefaultTableModel)compTable.getModel();
			
			tableModel.setColumnIdentifiers(columns);
			tableModel.addRow(compData);
		}
		statement.close();
		connection.close();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

public void searchFriend(String u, String friend) {
	
	PreparedStatement statement;
	ResultSet rs;
	
	try {
		connection =DriverManager.getConnection(databaseURL);  
		System.out.println("Connected Search Cnic");
		sql = "SELECT FriendName FROM "+u;
		statement = connection.prepareStatement(sql);
		rs = statement.executeQuery();		
		while(rs.next()) {
			String FriendN = rs.getString("FriendName");
			if(friend.equals(FriendN)) {
					checkFriend=1;
					break;
			}
			else {
				checkFriend=0;
			}
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
}

public void searchFriendList(String u, String friend) {
	
	PreparedStatement statement;
	ResultSet rs;
	
	try {
		connection =DriverManager.getConnection(databaseURL);  
		System.out.println("Connected Search Cnic");
		sql = "SELECT FriendName FROM "+u+"_requests";
		statement = connection.prepareStatement(sql);
		rs = statement.executeQuery();		
		while(rs.next()) {
			String FriendN = rs.getString("FriendName");
			if(friend.equals(FriendN)) {
					checkFriendReq=1;
					break;
			}
			else {
				checkFriendReq=0;
			}
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
}

public void deleteReq(String userN, String friendName) {
	PreparedStatement statement;
	PreparedStatement statementC;
	ResultSet rs;
	
	try {
		connection = DriverManager.getConnection(databaseURL);
		sql = "SELECT * FROM "+userN+"_requests";
		statementC = connection.prepareStatement(sql);	
		rs = statementC.executeQuery();	
		
		while(rs.next()) {
			if(friendName.equals(rs.getString("FriendName"))) {
					sql = "DELETE FROM "+userN+"_requests"+" WHERE FriendName ='"+friendName+"'";
					statement = connection.prepareStatement(sql);
					statement.executeUpdate();
					statement.close();
					break;
			}
		}
		statementC.close();
		connection.close();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

public void addFriend(String friendName,String userN) {
	try {
		connection =DriverManager.getConnection(databaseURL);  
		System.out.println("Database Connected (Registration1)");
		
		sql = "INSERT INTO "+userN+" (FriendName) VALUES (?)";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, friendName);

		statement.executeUpdate();
		statement.close();
		connection.close();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

public int checkNoOfFriends(String userN) {
	PreparedStatement statement;
	ResultSet rs;
	int count = 0;
	
	try {
		connection =DriverManager.getConnection(databaseURL);  
//		System.out.println("Connected Search Citizens");
		String sql = "SELECT * FROM "+userN;
		statement = connection.prepareStatement(sql);
		rs = statement.executeQuery();	
		
		while(rs.next()) {
			count++;
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return count;
}

}
