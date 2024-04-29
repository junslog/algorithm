class Solution {
    public int solution(int n) {
        StringBuilder sb = new StringBuilder();
        while(true){
            int currDigit = n % 3;
            if(n / 3 == 0){
                sb.append(n);
                break;
            }
            n = n / 3;
            sb.append(currDigit);
        }
        char[] convert = sb.toString().toCharArray();
        int pow = 1;
        int sum = 0;
        for(int i = convert.length - 1; i >= 0; i--){
            sum += ((convert[i] - '0') * pow);
            pow *= 3;
        }
        return sum;
    }
}