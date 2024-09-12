class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        for(int i = 0; i < n; i++){
            int[] arr = new int[n];
            for(int j = 0; j < n; j++){
                if(j != i){
                    arr[j] = 0;
                } else {
                    arr[j] = 1;
                }
            }
            answer[i] = arr;
        }
        return answer;
    }
}