class Solution {
    public long solution(long n) {
        for(long l = 1; l*l <= n; l++){
            if(l*l == n){
                return (l+1) * (l+1);
            }
        }
        return -1;
    }
}