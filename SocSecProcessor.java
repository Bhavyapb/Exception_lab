package com.exception;
import java.util.*;

/**
 * the program checks if a user's social security number is valid or not
 * @author Bhavy
 *
 */
public class SocSecProcessor {
	public static final int SSN_LEN = 11; //length of a social security number
	
	/**
	 * the fuction checks for validity of a social security number
	 * @param ssn- a String containing social security number
	 * @return false if social security is not valid and
	 *          true if valid-11 number of characters, contains only digits and dashes at correct position
	 * @throws SocSecException 
	 */
	public static boolean isValid(String ssn) throws SocSecException{
		boolean valid = false;
		if(ssn.length()==SSN_LEN) {			//checks if string length is equal to SSN_LEN
			
			
			for(int i=0;i<SSN_LEN;i++) {
				if(ssn.charAt(i)>='0'&& ssn.charAt(i)<='9') { //checks if ssn character is a digit 
						valid =true;
				}
				else if(ssn.charAt(i)=='-'){                //check if the character is a '-'
					if(i==3||i==6)							//check if the dashes at position 3 or 7
						valid=true;
					else
						throw new SocSecException("dashes at wrong position."); 
				}	
				else
					throw new SocSecException("contains a character that is not a digit");
			}
		}
		
		else {
			throw new SocSecException("wrong number of characters");  //throws if length not equal to SSN_LEN
		}
		return valid;
}	

	
	public static void main(String[] args) {
		Scanner Nameinput = new Scanner(System.in);		//scanner to store name
		Scanner ssnInput=new Scanner(System.in);		//scanner to store social secutity number
		Scanner in = new Scanner(System.in);			//scanner to store users response whether to continue or not
		String name,ssn;
		char Continue='y';
	
		/**
		 * while loop ask user for name and ssn 
		 * calls isValid function and if true print out name and ssn
		 *            else throws an SocSecException
		 */
		while(Continue=='y'){
		System.out.print("Name? ");
		name = Nameinput.nextLine();
		try {
			
			System.out.print("SSN? ");
			ssn = ssnInput.next();
			if(isValid(ssn)) {
				System.out.println("Name: "+name+" SSN #"+ssn+" is valid");
			}
			
				
		}catch(SocSecException sse) {
			System.out.println(sse.getMessage());
		}
		
		System.out.print("Continue? ");	
		Continue=in.next().charAt(0);
		}
		
	}

}
