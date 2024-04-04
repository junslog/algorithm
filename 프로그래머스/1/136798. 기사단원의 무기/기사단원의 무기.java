class Solution {
    public int solution(int number, int limit, int power) {
        int[] powers = new int[number + 1];
        powers[1] = 1;
        for(int i = 2; i <= number; i++){
            for(int j = 1; j * j <= i; j++){
                if(j * j == i){
                    powers[i] += 1;
                    break;
                }
                if(i % j == 0){
                    powers[i] += 2;
                }
            }
            if(powers[i] > limit){
                powers[i] = power;
            }
        }
        
        int answer = 0;
        for(int i = 1; i <= number; i++){
            answer += powers[i];
        }
        return answer;
    }
}