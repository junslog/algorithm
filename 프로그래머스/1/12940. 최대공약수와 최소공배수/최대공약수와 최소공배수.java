class Solution {
    public int[] solution(int n, int m) {
        int g = gcd(n,m);
        int l = n * m / g;
        return new int[]{g,l};
    }
    
    public static int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        return gcd(b, a%b);
    }
}