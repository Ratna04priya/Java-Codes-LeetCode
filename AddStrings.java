//415. Add Strings
// https://leetcode.com/problems/add-strings/

/*Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.*/

class Solution {
    public String addStrings(String num1, String num2) {
/*      
        //Working but for upto 19 length.

        long number1 = Long.parseLong(num1);
        System.out.println(num1);
        long number2 =  Long.parseLong(num2);
        System.out.println(num2);
        long result = number1 + number2;
        System.out.println(result);
        String fin = Long.toString(result);
        
        
        return fin;
*/
        StringBuilder result = new StringBuilder();
        int i = num1.length() -1;
        int j = num2.length() -1;
        int carry = 0;
        
        while(i>=0 || j>=0)
        {
            int sum = carry;
            if(i>=0){
                sum +=num1.charAt(i--) - '0';
                    }
            if(j>=0){
                sum +=num2.charAt(j--) - '0';
                    }
            result.append(sum%10);
            carry = sum/10;
        }
        if(carry !=0)
        {
            result.append(carry);
        }
        
        return result.reverse().toString();
            
    }
    
}