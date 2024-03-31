class Solution {
    public int solution(int num) {
        if(num == 1){
            return 0;
        }
        boolean reachedOne = false;
        int count = -1;
        for(int i = 0; i < 500; i++){
            
            if(num % 2 == 0){
                num /= 2;
            } else if(num % 2 == 1){
                num = num * 3 + 1;
            }
            
            if(num == 1){
                count = i + 1;
                reachedOne = true;
                break;
            }
        }
        if(reachedOne){
            return count;
        }
        return -1;
    }
}