class Solution {
    public long solution(int price, int money, int count) {
        return money - (long)(count * (count + 1) / 2) * price >= 0? 0 
            : (price*((long)(count * (count + 1))/2)) - money;
    }
}