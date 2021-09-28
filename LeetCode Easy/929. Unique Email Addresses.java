//929. Unique Email Addresses
//By Ratna Priya

class Solution {
    public int numUniqueEmails(String[] emails) {
        String[] array = new String[2];
        //StringBuilder result =new StringBuilder("");
        HashSet<String> set = new HashSet<String>();
        for(String str : emails){
            array = str.split("@");
            StringBuilder result =new StringBuilder("");
            for(int i =0; i<array[0].length();i++){
                if(array[0].charAt(i) =='.'){
                    //i++;
                    continue;
                }
                else if(array[0].charAt(i) =='+'){
                    //result = result.append(array[0].charAt(i)); 
                    break;
                }
                else
                    result = result.append(array[0].charAt(i));
            }
            String fin = result.toString()+"@"+array[1];
            if(!set.contains(fin)){
                set.add(fin);
            }
        }
        System.out.println(set);
        return set.size();
    }
}
