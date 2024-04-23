class Solution {
    public String solution(String X, String Y) {
        int[] xCount = new int[10];
        int[] yCount = new int[10];
        
        for(char c : X.toCharArray()){
            xCount[Integer.parseInt(String.valueOf(c))]++;
        }
        for(char c : Y.toCharArray()){
            yCount[Integer.parseInt(String.valueOf(c))]++;
        }
        int[] duplicatedCount = new int[10];
        for(int i = 0; i < 10; i++){
            duplicatedCount[i] = Math.min(xCount[i], yCount[i]);
        }
        StringBuilder sb = new StringBuilder();
        
        boolean noDuplicated = true;
        for(int i = 0; i < 10; i++){
            if(duplicatedCount[i] > 0){
                noDuplicated = false;
                break;
            }
        }
            
        boolean isOnlyZeroDuplicated = false;
        if(duplicatedCount[0] > 0){
            isOnlyZeroDuplicated = true;
        }
        if(isOnlyZeroDuplicated){
            for(int i = 1; i < 10; i++){
                if(duplicatedCount[i] > 0){
                    isOnlyZeroDuplicated = false;
                    break;
                }
            }
        }
        
        
        if(noDuplicated){
            return "-1";
        }
        if(isOnlyZeroDuplicated){
            return "0";
        }
        
        for(int i = 9; i >= 0; i--){
            for(int j = 0; j < duplicatedCount[i]; j++){
                sb.append(i);
            }
        }
        return sb.toString();
    }
}