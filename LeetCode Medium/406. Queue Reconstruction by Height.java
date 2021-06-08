//406. Queue Reconstruction by Height 
//By Ratna Priya

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> result = new ArrayList();
        Arrays.sort(people, (a,b)->{
            return(a[0] == b[0] ? a[1]- b[1]: b[0]-a[0]);
        });
//         for(int i =0; i<people.length; i++){
//             for(int j =0; j<people[i].length;j++)
//                System.out.println(people[i][j]);
//         }
        
        
        for(int[] x : people){
            result.add(x[1],x); 
            System.out.println(x[1] +" " + x[0]);
        }
        return result.toArray(new int[people.length][2]);
    }
}
