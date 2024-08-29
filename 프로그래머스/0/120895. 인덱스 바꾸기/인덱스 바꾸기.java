class Solution {
    public String solution(String my_string, int num1, int num2) {
        char first = my_string.charAt(num1);
        char second = my_string.charAt(num2);
        
        StringBuilder sb = new StringBuilder();
        int runner = 0;
        for(char c : my_string.toCharArray()){
            if(runner == num1){
                sb.append(second);
            } else if(runner == num2){
                sb.append(first);
            } else {
                sb.append(c);
            }
            runner++;
        }
        return sb.toString();
    }
}