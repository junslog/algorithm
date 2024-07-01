class Solution {
    public int solution(int[] numbers, int n) {
        int cumul = 0;
        for(int x : numbers){
            cumul += x;
            if(cumul > n){
                return cumul;
            }
        }
        return -1;
    }
}