package DentalClinicSystem;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		PatientInfo pinfo=new PatientInfo();
		Scanner sc=new Scanner(System.in);
		int caseno;
		//pinfo.patientDetails();
		//pinfo.storePatientDetails();
		//pinfo.searchPatient(1005);
		//pinfo.updateInfo(1002);
		while(true)
		{
		System.out.println("\t1. New Patient ");
		System.out.println("\t2. Search Patient using caseno");
		//System.out.println("2.Search Patient using name");
		System.out.println("\t3. Upadate patient Info");
		System.out.print("Enter Your Choice ");
		int choice=sc.nextInt();
		
		switch (choice) {
		case 1:  
			pinfo.patientDetails();
			pinfo.storePatientDetails();
			break;
			
		case 2:
			System.out.print("Enter the case no to search ");
			caseno=sc.nextInt();
			pinfo.searchPatient(caseno);
			break;
			
		case 3:
			System.out.print("Enter the case no to Update ");
			caseno=sc.nextInt();
			pinfo.updateInfo(caseno);
			break;
		
		case 4:
			System.exit(0);
		default:
			 System.out.println("Enter valid choice...");
		}
		}
	}

}
