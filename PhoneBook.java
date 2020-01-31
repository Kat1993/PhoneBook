
import java.util.Scanner;

public class PhoneBook {
	
	
 public static void main(String[] args) {
	 
	Scanner in = new Scanner(System.in);
	boolean rn = true;
	Name personToAdd = new Name ();
    Name[] contactList = new Name[0];
	
	 
	  while( rn) {
		 int choice = menu();
			

			switch(choice) {
				
			case 1:// Save contact
				
				System.out.println("Enter information by faloving\n( First Name "
						+ "Midele Name  Last Name , Street, City, State, Zip, Phone number ) ");
				
				personToAdd  =	addContact();
				
				contactList = Name.addName(contactList, personToAdd);
				
				System.out.println(contactList[0].getFirstName());
				
				
				if(contactList.length == 2) {
	
	
					System.out.println(contactList[1].getLastName());
					
					
				}
				break;
				
			case 2:// find
				
				System.out.println("serch by \n1.First Name \n2.Last name "
						+ "\n3.Phome number \n4. City \n5 State  ");
				   
			    int choice1 = in.nextInt();
			    findContact(choice1,contactList );
				
				break;
				
			case 3:// change
				
				System.out.println("Select the contact by phone number  ");
				
				contactList = changeContact (contactList);
				
				break;
				
			case 4:
				
				Scanner in1 = new Scanner(System.in);
				System.out.println("Enter a phone number ");
				String pNumb = in1.nextLine();
				
				contactList = deleteContact(contactList, pNumb);
				
				break;
			case 5:
				
				System.out.println(" Contact List:");
				displayContacts(contactList);
				
				break;
			case 6:
				
				System.out.println(" Good bye");
				rn = false;
				
				break;
		
				default:
					
				break;
		 
		 
		 
		 
	    }
		
	  } 
	
    }
		public static int menu() {
			
			System.out.println("Select from menu  "
					+ "\n1. Save contact \n2. Find contact"
					+ " \n3. Change contact \n4. Delete \n5. Display  \n6. Exite");
			
			Scanner in = new Scanner(System.in);
			int choice = in.nextInt();
			
			return choice;
			
	
	} 
	 
	 	
 
public static Name addContact() {

	Scanner in = new Scanner(System.in);
	
	String input = in.nextLine();
	
	String[] contact = input.split(", ");
	
	String names = contact[0];
	String street = contact[1];
	String city = contact[2];
	String state = contact[3];
	String zip = contact[4];
	String phoneNum = contact[5];
	
	String firstName ;
	String lastName ;
	String midelName;
	
	String [] wholeNames = names.split(" ");
	

	 if ( wholeNames.length == 3) {
		 
		 firstName = wholeNames[0];
		 midelName = wholeNames[1];
		 lastName = wholeNames[wholeNames.length-1];
		 
	 }else if ( wholeNames.length == 4) {
		 
		 firstName = wholeNames[0];
		 midelName = wholeNames[1]+ " " + wholeNames[2];
		 lastName = wholeNames[wholeNames.length-1];
		 
	 }else {
		 firstName = wholeNames[0];
		 midelName = "";
		 lastName = wholeNames[wholeNames.length-1];
	 }
		 
		 
		 
		 
	Address address = new Address(street, city, state, zip);
	
	Name  name = new Name (firstName, midelName,lastName, address, phoneNum );
	
	
	
	return name;

}
public static  String findContact(int imput, Name[]contactList) {
Name temp = new Name();
	Scanner in = new Scanner(System.in);
	switch(imput) {
	case 1:
		
		System.out.println("Enter First Name");
		String firstNameSerch = in.nextLine();
		
		for( int i = 0; i < contactList.length; i ++  ) {
			temp = contactList[i];
			
			if ( temp.getFirstName().equalsIgnoreCase(firstNameSerch)) {
				System.out.println(temp.toString());
				
			}
			
		}	
		break;
	case 2:
		
		
		System.out.println("Enter Last Name");
		String lastNameSerch = in.nextLine();
		
		for( int i = 0; i < contactList.length;i++) {
			temp = contactList[i];
			if(temp.getLastName().equalsIgnoreCase(lastNameSerch)) {
				System.out.println(temp.toString());
				
			}
			
		}
		
		break;
	case 3:
		
		System.out.println("Enter phone number");
		String phoneNumberSerch = in.nextLine();
		System.out.println(phoneNumberSerch);
		
		for( int i = 0; i < contactList.length ;i++) {
			temp = contactList[i];
			if(temp.getPhonNum().equals(phoneNumberSerch)){
				System.out.println(temp.toString());
			}
			
		}
		
		break;
	case 4:
		System.out.println("Enter City");
		String citySerch = in.nextLine();
		for ( int i =0; i < contactList.length;i++) {
			 temp = contactList[i];
			 if(citySerch.equalsIgnoreCase(temp.getAddress().getCity())) {
				 
				 System.out.println(temp.toString());
			 }
			
			
		}
	
		 
		break;
	case 5:
		
		
		System.out.println("Enter zip");
		String zipSerch = in.nextLine();
		for ( int i =0; i < contactList.length; i ++) {
			temp = contactList[i];
			if(zipSerch.equalsIgnoreCase(temp.getAddress().getZip())) {
				
				System.out.println(temp.toString());
			}
			
		}
		break;
	
		
		default:
			break;
	
	
	}
	
		
		

	
	
	return null;
}
public static Name[] changeContact(Name[] contactList) {
	
	
	Name [] temp1 = new Name[0];
	Name temp = new Name(); 
	Address tempAddress = new Address();
	Scanner in = new Scanner(System.in);
	
	System.out.println("To update contact enter a phone number");
	String phoneNumberSerch = in.nextLine();
	System.out.println("The number tat you enter is :" + phoneNumberSerch);
	
	 for ( int i =0; i < contactList.length; i ++ ) {
		 temp = contactList[i];
		 
		 
		 if(phoneNumberSerch.equals(temp.getPhonNum())) {
			 System.out.println("Enter new Firts Name: ");
			 temp.setFirstName(in.nextLine());
			 
			 System.out.println("Enter new midel Name  or put empty space");
			 temp.setMidelName(in.nextLine());
			 
			 System.out.println("Enter new Last Name ");
			 temp.setLastName(in.nextLine());
			 
			 System.out.println(" Enter new Street");
			 tempAddress.setStreet(in.nextLine());
			 
			 System.out.println("Enter new City");
			 tempAddress.setCity(in.nextLine());
			 
			 System.out.println("Enter new State");
			 tempAddress.setState(in.nextLine());
			 
			 System.out.println("Enter new zip");
			 
			 tempAddress.setZip(in.nextLine());
			 temp.setAddress(tempAddress);
			  
			 System.out.println(temp.toString());
			
			 
			  
		 }
		 
		 
		 
	 }
	 temp1 = (contactList);
	
	
	return temp1;
	
}


public static Name[] deleteContact(Name[]contactList, String pNumb){
	
	Name[] temp = new Name[0];
	System.out.println(pNumb);
	
	
	for (int i = 0;i < contactList.length; i ++) {
		
	
	if(!contactList[i].getPhonNum().contentEquals(pNumb)) {
		
		Name temp1 = contactList[i];
		
		temp = Name.addName(temp, temp1);
		
	}
	 
		
	
	}
	  return temp ;
	
	
	
	
	
}


 public static void displayContacts(Name [] contactList) {
	 Name  display = new Name();
	  for(int i =0; i < contactList.length; i++) {
		  
		  display = contactList[i];
		  System.out.println(display.toString());
		  
	  }
	 
	 
	 
	 
 }
}

