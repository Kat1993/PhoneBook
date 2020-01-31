
public class Person {
	private String firstName;
	private String midelName;
	private String lastName;
	private Address address;
	private String phonNum;
	
	public Person(){
		
	}
	public Person(String firstName,String midelName, String lastName, Address address, String phonNum) {
		super();
		this.firstName = firstName;
		this.midelName = midelName; 
		this.lastName = lastName;
		this.address = address;
		this.phonNum = phonNum;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getPhonNum() {
		return phonNum;
	}
	public void setPhonNum(String phonNum) {
		this.phonNum = phonNum;
	}
	
	
	public String getMidelName() {
		return midelName;
	}
	public void setMidelName(String midelName) {
		this.midelName = midelName;
	}
	
   
	public String toString() {
		return "First Name : " + firstName + "\nMidel Name: " + midelName + "\nLast Name: " + lastName + "\nAddress:" + address + " \nPhome Number : "
				+ phonNum.replaceFirst("(\\d{3})(\\d{3})(\\d+)","($1)-$2-$3") ;
	
	}	
	public static Person[] addPerson(Person[] source, Person value) {
		Person [] temp = new Person [source.length+1];
		for(int i = 0; i < source.length; i ++) {
			
			temp[i] = source[i];
			
		}
		temp[source.length] = value;
		
		
		return temp;
		
		
		
	}
}



