import java.sql.*;
import java.util.*;
import java.lang.*;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Hello {
	

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		
		String url="jdbc:mysql://sql3.freesqldatabase.com:3306/sql3480463";
		String username="sql3480463";
		String password="QT35UGBk7I";
		
		
		try {
			
	        
			

	         Date thisDate =new Date();
	         SimpleDateFormat dateForm= new SimpleDateFormat("YYYY-MM-dd");
	        
	
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			Connection connection=DriverManager.getConnection(url,username,password);
			
			Statement statement=connection.createStatement();
	        while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println(" 1.Enter customer details\n 2.Update Cost Involved\n 3.Report in range of date\n 4.Total Report\n");
			int option=sc.nextInt();
			switch(option)
			{
			case 1:
			{
				int token=(int)Math.floor(Math.random()*10000);
				System.out.println("Your Tokennumber is : "+token);
				System.out.print ("Enter Your name : ");
				String name=sc.next();
				System.out.print ("Enter Mobile no : ");
				String no=sc.next();
				
				System.out.println("Enter Mobile model : ");
				sc.nextLine();
				String mo=sc.nextLine();
				
				
				System.out.print ("Enter your problem in detail : ");
				
				String prob=sc.nextLine();
				
				String query1 = "INSERT INTO `first`(`token`, `name`, `mobile`,`model`, `date`, `descrip`) VALUES ("+token+",'"+name+"',"+no+",'"+mo+"','"+dateForm.format(thisDate)+"','"+prob+"')";
         	    statement.executeUpdate(query1);
         	    System.out.println("Data added successfully....");
         	    break;
			}
  			
			case 2:
			{
			  System.out.println("Enter the id to update : ");
  			  int x=sc.nextInt();
  			  System.out.println("Enter the cost : ");
  			  int c=sc.nextInt();
  			  String query2 = "UPDATE `first` SET `cost`='"+c+"' WHERE `token`="+x+"";
     	      statement.executeUpdate(query2);
     	      System.out.println("Updated successfully.....");
     	      break;
  				
  				
  			}
			case 3:
			{
				System.out.println("Enter From Date : ");
				String s=sc.next();
				System.out.println("Enter To Date : ");
				String e=sc.next();
				
				ResultSet resultSet = statement.executeQuery("select * from `first` where `date` between '"+s+"' and '"+e+"' ");
	        	 while(resultSet.next()) {
						
	        		 System.out.println("\nToken no : "+resultSet.getInt(1)+ " \n" +"Name : "+ resultSet.getString(2)+ "\n" + "Mobile no : "+ resultSet.getString(3)+"\n"+ "Model : "+ resultSet.getString(4)+ "\n" + "Date : "+ resultSet.getString(5)+"\n"+"Description : "+ resultSet.getString(6)+" \n"+ "Cost Involved : "+ resultSet.getInt(7)+ "\n");
	        		 System.out.println("----------------------------------------------------------------------------------\n");
	  			
				  }
	        	 break;
			}
			case 4:
			{
				ResultSet resultSet1 = statement.executeQuery("select * from first");
	        	 while(resultSet1.next()) {
						
	        		 System.out.println("\nToken no : "+resultSet1.getInt(1)+ " \n" +"Name : "+ resultSet1.getString(2)+ "\n" + "Mobile no : "+ resultSet1.getString(3)+"\n"+ "Model : "+ resultSet1.getString(4)+ "\n" + "Date : "+ resultSet1.getString(5)+"\n"+"Description : "+ resultSet1.getString(6)+" \n"+ "Cost Involved : "+ resultSet1.getInt(7)+ "\n");
	        		 System.out.println("----------------------------------------------------------------------------------\n");
	        	 
	        	 }
	        	 break;
				
			}
			}
			System.out.println("press 1 to continue and 0 to stop");
			int fin=sc.nextInt();
			if(fin==1)
			{
				continue;
			}
			else {
				break;
			}
	        }
	         
			
			
			connection.close();
				
				
			
		}
		catch(Exception e) {
			
			System.out.println(e);
		}
		

	}

}