class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int points = 0; int maxpoints =0;
        int i =0; int j = tokens.length -1;
        while(i <= j){
            if(power >= tokens[i]){
                points++;
                power= power - tokens[i++];
                maxpoints = Math.max(maxpoints,points);
            }
            else if(points>0){
                points--;
                power += tokens[j--];
            }
            else
                return maxpoints;
            
        }
        return maxpoints;
    }
}
