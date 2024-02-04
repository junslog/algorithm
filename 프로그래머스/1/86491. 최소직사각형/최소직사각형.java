class Solution {
    public int solution(int[][] sizes) {
        // W, H 배열 안에 최댓값 찾고, 나머지 배열들에서 최솟값들 제외한 값들 중 최대값 구하기.
        int maxValueInArr = max(sizes);
        int maxValueInRemainingArr = maxInRemainingArr(sizes);
        int answer = maxValueInArr * maxValueInRemainingArr;
        return answer;
    }
    
    public static int max(int[][] source){
        int max = 0;
        for(int i = 0; i < source.length; i++){
            for(int j = 0; j < source[i].length; j++){
                if(max < source[i][j]){
                    max = source[i][j];
                }
            }
        }
        return max;
    }
    
    public static int maxInRemainingArr(int[][] source){
        int[] minValuesInArr = new int[source.length];
        for(int i = 0; i < source.length; i++){
            minValuesInArr[i] = Math.min(source[i][0], source[i][1]);
        }
        int maxValueInArr = 0;
        for(int i = 0; i < minValuesInArr.length; i++){
            if(maxValueInArr < minValuesInArr[i]){
                maxValueInArr = minValuesInArr[i];
            }
        }
        return maxValueInArr;
    }
}