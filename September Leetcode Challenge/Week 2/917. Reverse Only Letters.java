//917. Reverse Only Letters
//By Ratna Priya

class Solution {
    public String reverseOnlyLetters(String S) {
        char[] characters = S.toCharArray();
        int i = 0;
        int j = S.length() -1;
        char temp;
        while(i<j)
        {
            while(i<j && !Character.isLetter(S.charAt(i))){
                i++;
                    }
             while(j>i && !Character.isLetter(S.charAt(j))){
                j--;
                    }
    
                temp = characters[i];
                characters[i++] = characters[j];
                characters[j--] = temp;

        }
        
        return new String(characters);

    }
}
