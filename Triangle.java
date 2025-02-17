//Time Complexity O(M*N)
//Space Complexity O(1)
//Leetcode tested

import java.util.Collections;
import java.util.List;

public class Triangle {
    public static int minimumTotal(List<List<Integer>> triangle) {
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int sum=0;
                if(j==0){
                    sum=triangle.get(i).get(j)+triangle.get(i-1).get(j);
                }
                else if(j == triangle.get(i).size()-1){
                    sum=triangle.get(i).get(j) + triangle.get(i-1).get(triangle.get(i-1).size()-1);
                }else{
                    int min=Math.min(triangle.get(i-1).get(j),triangle.get(i-1).get(j-1));
                    sum=min+triangle.get(i).get(j);
                }
                triangle.get(i).set(j,sum);
            }
        }
        return Collections.min(triangle.get(triangle.size()-1));
    }
}
