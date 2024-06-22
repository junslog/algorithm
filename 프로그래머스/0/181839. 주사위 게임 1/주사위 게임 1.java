class Solution {
    public int solution(int a, int b) {
        if(isOdd(a) && isOdd(b)){
            return a * a + b * b;
        }
        if((isOdd(a) && isEven(b)) ||
           isEven(a) && isOdd(b)){
            return 2 * (a + b);
        }
        if(isEven(a) && isEven(b)){
            return Math.abs(a-b);
        }
        return 0;
    }
    
    private static boolean isOdd(int x){
        return x % 2 == 1;
    }
    
    private static boolean isEven(int x){
        return x % 2 == 0;
    }
    
}