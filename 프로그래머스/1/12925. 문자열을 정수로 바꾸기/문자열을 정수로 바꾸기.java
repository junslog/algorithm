class Solution {
    public int solution(String s) {
        String[] items = s.split("");
        if(items[0].equals("+")) {
            return Integer.parseInt(s.substring(1));
        }
        if(items[0].equals("-")){
            return -Integer.parseInt(s.substring(1));
        }
        return Integer.parseInt(s);
    }
}