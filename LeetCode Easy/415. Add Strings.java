//415. Add Strings
//By Ratna Priya

class Solution {
    public String addStrings(String num1, String num2) {
        int first = num1.length() - 1, second = num2.length() - 1, carry = 0;
        StringBuilder result = new StringBuilder();
        
        while(first >= 0 || second >= 0){
            int rightChar = (first >= 0) ? Character.getNumericValue(num1.charAt(first)) : 0;
            int rightChar1 = (second >= 0) ? Character.getNumericValue(num2.charAt(second)) : 0;
            int addition = rightChar + rightChar1 + carry;
            result.insert(0, addition % 10);
            carry = addition / 10;
            first--;
            second--;
        }
        
        if(carry != 0){
            result.insert(0, carry);
        }
            
        return result.toString();
    }
}
