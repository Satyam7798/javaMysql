package mysqlJava;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class SqlProject1 {

		static void selects(){
		//case 1:
			try{ Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/satyam","root","root");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from Employe_1");
			
			while(rs.next())
			{
			System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
			}
			}
			catch(Exception e)
			{
			System.out.println(e.toString());}
		}
		
		static void delets() {
			
			try{ Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/satyam","root","root");
			String s="delete from employe_1 where e_id=?";
			PreparedStatement ps=con.prepareStatement(s);
			ps.setInt(1,3);
			ps.execute();
			con.close();
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());}
		}
		
		static void inserts() {
			try{ Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/satyam","root","root");
			Statement st=con.createStatement();
			st.executeUpdate("insert into employe_1 values(5,'rohan','sales',98765434)");
			con.close();
			}
			catch(Exception e)
			{
			System.out.println(e.getMessage());}
		
		}
		static void updates() {
			try{ Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/satyam","root","root");
			Statement st=con.createStatement();
			st.executeUpdate("update employe_1 set position='sales manager' where e_id=5");
			con.close();
			}
			catch(Exception e)
			{
			System.out.println(e.getMessage());}
			
		}
		public static void main(String args []) {
			
			Scanner c=new Scanner(System.in);
			System.out.println("Insert:1 Delete:2 Select:3 Update:4 <To perform operation press>:");
			int a=c.nextInt();
			SqlProject1 p=new SqlProject1();
			switch(a) {
			case 1:
				p.inserts();
				break;
			case 2:
				p.delets();
				break;
			case 3:
				p.selects();
				break;
			case 4:
				p.updates();
				break;
				
			}
			
		}	

}
