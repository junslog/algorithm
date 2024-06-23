class Solution {
    public int solution(int[] num_list, int n) {
        for(int x : num_list){
            if(n == x){
                return 1;
            }
        }
        return 0;
    }
}