package DentalClinicSystem;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Scanner;

public class PatientInfo {

		int casePaperNo;
	    String fname;
	    String lname;
		int age;
	    String bloodGroup;
	    String mno;
	    String city;
	    String taluka;
	    String district;
	    LocalDate date;
	    
		public LocalDate getDate() {
			LocalDate currentDate = LocalDate.now();
			this.date = currentDate;
			return date;
		}
		public void setDate(String date) {
			LocalDate currentDate = LocalDate.now();
			this.date = currentDate;
		}
		public int getCasePaperNo() {
			return casePaperNo;
		}
		public void setCasePaperNo(int casePaperNo) {
			this.casePaperNo = casePaperNo;
		}
		public String getFname() {
			return fname;
		}
		public void setFname(String fname) {
			this.fname = fname;
		}
		public String getLname() {
			return lname;
		}
		public void setLname(String lname) {
			this.lname = lname;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getBloodGroup() {
			return bloodGroup;
		}
		public void setBloodGroup(String bloodGroup) {
			this.bloodGroup = bloodGroup;
		}
		public String getMno() {
			return mno;
		}
		public void setMno(String mno) {
			this.mno = mno;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getTaluka() {
			return taluka;
		}
		public void setTaluka(String taluka) {
			this.taluka = taluka;
		}
		public String getDistrict() {
			return district;
		}
		public void setDistrict(String district) {
			this.district = district;
		}
		 
	    
	    void patientDetails()
	    {
	    	//System.out.println("Date-"+Date.valueOf(getDate()));
	    	Scanner sc=new Scanner(System.in);
	    	System.out.println("Enter Case Paper No:");
	         setCasePaperNo(sc.nextInt());

	        System.out.println("Enter First Name:");
	         setFname(sc.next());

	        System.out.println("Enter Last Name:");
	         setLname(sc.next());

	        System.out.println("Enter Age:");
	         setAge(sc.nextInt());

	        System.out.println("Enter Blood Group:");
	         setBloodGroup(sc.next());
	         
	         System.out.println("Enter Number of Phone Numbers:");
	         setMno(sc.next());
	         
	         System.out.println("Enter the Adderss:- ");
	         System.out.println("\tCity:");
	         setCity(sc.next());

	         System.out.println("\tTaluka:");
	          setTaluka(sc.next());

	         System.out.println("\tDistrict:");
	          setDistrict(sc.next());     
	    }
	    
	    
	    void storePatientDetails()
		{
			try {
				Class.forName("com.mysql.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306/dentalclinic?characterEncoding=utf8";
			String user="root";
			String passward="Vins@123";
			Connection con=DriverManager.getConnection(url, user, passward);
			
			String query="INSERt INTO patientinfo(caseno,fname,lname,age,bloodgroup,mno,city,taluka,district,appointdate) values(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1,getCasePaperNo());
			ps.setString(2,getFname());
			ps.setString(3, getLname());
			ps.setInt(4,getAge());
			ps.setString(5, getBloodGroup());
			ps.setString(6, getMno());
			ps.setString(7, getCity());
			ps.setString(8, getTaluka());
			ps.setString(9, getDistrict());
			//ps.setString(10,"12-12-2012");
			ps.setDate(10,  Date.valueOf(getDate()));
			
			int result=ps.executeUpdate();
			if(result==1)
				System.out.println("Patient Recotd Successfully Stored...!");
			else
				System.out.println("Record is not Stored...!");
			
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	    
	    void searchPatient(int caseNo) {
	        try {
	            Class.forName("com.mysql.jdbc.Driver");

	            String url = "jdbc:mysql://localhost:3306/dentalclinic?characterEncoding=utf8";
	            String user = "root";
	            String password = "Vins@123";
	            Connection con = DriverManager.getConnection(url, user, password);

	            String query = "SELECT * FROM patientinfo WHERE caseno = ?";
	            PreparedStatement ps = con.prepareStatement(query);
	            ps.setInt(1, caseNo);

	            ResultSet rs = ps.executeQuery();

	            if (rs.next()) {
	                System.out.println("Patient Details:");
	                System.out.println("Case Paper No: " + rs.getInt("caseno"));
	                System.out.println("First Name: " + rs.getString("fname"));
	                System.out.println("Last Name: " + rs.getString("lname"));
	                System.out.println("Age: " + rs.getInt("age"));
	                System.out.println("Blood Group: " + rs.getString("bloodgroup"));
	                System.out.println("Phone Number: " + rs.getString("mno"));
	                System.out.println("City: " + rs.getString("city"));
	                System.out.println("Taluka: " + rs.getString("taluka"));
	                System.out.println("District: " + rs.getString("district"));
	                System.out.println("Appointment Date: " + rs.getDate("appointdate"));
	            } else {
	                System.out.println("Patient not found.");
	            }

	            rs.close();
	            ps.close();
	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
	    void updateInfo(int caseNo) {
	        try {
	            Class.forName("com.mysql.jdbc.Driver");

	            String url = "jdbc:mysql://localhost:3306/dentalclinic?characterEncoding=utf8";
	            String user = "root";
	            String password = "Vins@123";
	            Connection con = DriverManager.getConnection(url, user, password);

	            String query = "SELECT * FROM patientinfo WHERE caseno = ?";
	            PreparedStatement selectPs = con.prepareStatement(query);
	            selectPs.setInt(1, caseNo);

	            ResultSet rs = selectPs.executeQuery();

	            if (rs.next()) {
	                System.out.println("Patient Details:");
	                System.out.println("Case Paper No: " + rs.getInt("caseno"));
	                System.out.println("First Name: " + rs.getString("fname"));
	                System.out.println("Last Name: " + rs.getString("lname"));
	                System.out.println("Age: " + rs.getInt("age"));
	                System.out.println("Blood Group: " + rs.getString("bloodgroup"));
	                System.out.println("Phone Number: " + rs.getString("mno"));
	                System.out.println("City: " + rs.getString("city"));
	                System.out.println("Taluka: " + rs.getString("taluka"));
	                System.out.println("District: " + rs.getString("district"));
	                System.out.println("Appointment Date: " + rs.getDate("appointdate"));

	                Scanner sc = new Scanner(System.in);
	                System.out.println("Which field do you want to update? (fname/lname/age/bloodgroup/mno/city/taluka/district)");
	                String fieldToUpdate = sc.next();

	                if ("fname".equalsIgnoreCase(fieldToUpdate) || "lname".equalsIgnoreCase(fieldToUpdate) || "age".equalsIgnoreCase(fieldToUpdate) || 
	                	    "bloodgroup".equalsIgnoreCase(fieldToUpdate) ||
	                	    "mno".equalsIgnoreCase(fieldToUpdate) ||
	                	    "city".equalsIgnoreCase(fieldToUpdate) ||
	                	    "taluka".equalsIgnoreCase(fieldToUpdate) ||
	                	    "district".equalsIgnoreCase(fieldToUpdate))
	                {
	                    System.out.println("Enter new value:");
	                    String newValue = sc.next();

	                    String updateQuery = "UPDATE patientinfo SET " + fieldToUpdate + " = ? WHERE caseno = ?";
	                    PreparedStatement ps = con.prepareStatement(updateQuery);
	                    ps.setString(1, newValue);
	                    ps.setInt(2, caseNo);

	                    int updatedRows = ps.executeUpdate();

	                    if (updatedRows > 0) {
	                        System.out.println("Record updated successfully.");
	                    } else {
	                        System.out.println("Record update failed.");
	                    }

	                } else {
	                    System.out.println("Invalid field name.");
	                }
	            } else {
	                System.out.println("Patient not found.");
	            }

	            rs.close();
	            selectPs.close();
	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	
}
