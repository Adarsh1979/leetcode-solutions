import java.util.*;

public class LC118_PascalsTriangle {

    int ncr(int n, int r) {
        r = Math.min(r, n-r);
        int res = 1;
        for(int i=0; i<r; i++) {
            res = res * (n-i) / (i+1);
        }
        return res;
    }

    public List<List<Integer>> generate(int numRows) {

        // my brute force
        // List<List<Integer>> ans = new ArrayList<>();

        // for(int i=0; i<numRows; i++) {
        //     List<Integer> row = new ArrayList<>();
        //     if(i == 0) {
        //         row.add(1);
        //         ans.add(row);
        //         continue;
        //     }
        //     for(int j=0; j<=i; j++) {
        //         // 1st ya last hai to 1
        //         if(j==0 || j == i) {
        //             row.add(1);
        //         }
        //         else {
        //             row.add(ans.get(i-1).get(j-1) + ans.get(i-1).get(j));
        //         }
        //     }
        //     ans.add(row);
        // }

        // return ans;

        //optimized using ncr
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<numRows; i++) {
            List<Integer> l = new ArrayList<>();
            for(int j=0; j<i+1; j++) {
                l.add(ncr(i, j));
            }
            ans.add(l);
        }
        return ans;

    }
    
    public static void main(String[] args) {
        System.out.println(new LC118_PascalsTriangle().generate(5));
    }
}