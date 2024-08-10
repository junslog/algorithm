class Solution {
    public int solution(int n) {
        int target = n - 1;
        int runner = 2;
        while(true){
            if((target % runner) == 0){
                break;
            }
            runner++;
        }
        return runner;
    }
}