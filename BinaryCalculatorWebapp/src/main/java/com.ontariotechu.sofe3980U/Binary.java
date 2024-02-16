package com.ontariotechu.sofe3980U;

/**
 * Unsigned integer Binary variable
 *
 */
public class Binary
{
	private String number="0";  // string containing the binary value '0' or '1'
	/**
	* A constructor that generates a binary object.
	*
	* @param number a String of the binary values. It should conatins only zeros or ones with any length and order. otherwise, the value of "0" will be stored.   Trailing zeros will be excluded and empty string will be considered as zero.
	*/
    public Binary(String number) {
		for (int i = 0; i < number.length(); i++) {
			// check each character if it's not 0 or 1
			char ch=number.charAt(i);
			if(ch!='0' && ch!='1') {
				number="0"; // if not store "0" and end the function
				return;
			}
		}
		// remove any trailing zeros
		int beg;
		for (beg = 0; beg < number.length(); beg++) {
			if (number.charAt(beg)!='0')
				break;
		}
		//beg has the index of the first non zero digit in the number
		this.number=number.substring(beg); // exclude the trailing zeros if any
		// uncomment the following code
		
		if(this.number.equals("")) { // replace empty strings with a single zero
			this.number="0";
		}
		
    }
	/**
	* Return the binary value of the variable
	*
	* @return the binary value in a string format.
	*/
	public String getValue()
	{
		return this.number;
	}
	/**
	* Adding two binary variables. For more information, visit <a href="https://www.wikihow.com/Add-Binary-Numbers"> Add-Binary-Numbers </a>.
	*
	* @param num1 The first addend object
	* @param num2 The second addend object
	* @return A binary variable with a value of <i>num1+num2</i>.
	*/
	public static Binary add(Binary num1,Binary num2)
	{
		// the index of the first digit of each number
		int ind1=num1.number.length()-1;
		int ind2=num2.number.length()-1;
		//initial variable
		int carry=0;
		String num3="";  // the binary value of the sum
		while(ind1>=0 ||  ind2>=0 || carry!=0) // loop until all digits are processed
		{
			int sum=carry; // previous carry
			if(ind1>=0){ // if num1 has a digit to add
				sum += (num1.number.charAt(ind1)=='1')? 1:0; // convert the digit to int and add it to sum
				ind1--; // update ind1
			}
			if(ind2>=0){ // if num2 has a digit to add
				sum += (num2.number.charAt(ind2)=='1')? 1:0; // convert the digit to int and add it to sum
				ind2--; //update ind2
			}
			carry=sum/2; // the new carry
			sum=sum%2;  // the resultant digit
			num3 =( (sum==0)? "0":"1")+num3; //convert sum to string and append it to num3
		}
		Binary result=new Binary(num3);  // create a binary object with the calculated value.
		return result;
		
	}

  public static Binary multiply(Binary num1, Binary num2) {
    String n1 = num1.number;
    String n2 = num2.number;
    
    // Result of multiplication as binary string
    String result = "0";
    // Temporary string for holding one line of multiplication before adding to the result
    String temp;
    
    for (int i = n2.length() - 1; i >= 0; i--) {
        temp = "";
        for (int j = n2.length() - 1; j > i; j--) {
            temp = "0" + temp; // Adding zeroes based on the position
        }
        if (n2.charAt(i) == '1') {
            temp = n1 + temp; // If the current digit of n2 is 1, add n1 to temp
        } else {
            temp = "0" + temp; // If current digit of n2 is 0, just add zeroes to temp
        }
        
        // Add temp to the result
        result = add(new Binary(result), new Binary(temp)).number;
    }
    
    return new Binary(result);
  }

  public static Binary and(Binary num1, Binary num2) {
    StringBuilder result = new StringBuilder();
    String n1 = num1.number;
    String n2 = num2.number;
    // Pad the shorter number with leading zeros
    while (n1.length() < n2.length()) n1 = "0" + n1;
    while (n2.length() < n1.length()) n2 = "0" + n2;
    
    for (int i = 0; i < n1.length(); i++) {
        // Only add '1' to result if both corresponding digits are '1'
        result.append((n1.charAt(i) == '1' && n2.charAt(i) == '1') ? '1' : '0');
    }
    
    return new Binary(result.toString());
  }

  public static Binary or(Binary num1, Binary num2) {
    StringBuilder result = new StringBuilder();
    String n1 = num1.number;
    String n2 = num2.number;
    // Pad the shorter number with leading zeros
    while (n1.length() < n2.length()) n1 = "0" + n1;
    while (n2.length() < n1.length()) n2 = "0" + n2;
    
    for (int i = 0; i < n1.length(); i++) {
        // Add '1' to result if any of the corresponding digits are '1'
        result.append((n1.charAt(i) == '1' || n2.charAt(i) == '1') ? '1' : '0');
    }
    
    return new Binary(result.toString());
  }

}	
