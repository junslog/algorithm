class Solution {
    public int solution(int chicken) {
        int coupon = chicken;
        int service = 0;
        while(coupon >= 10){
            int currCoupon = coupon / 10;
            service += currCoupon;
            coupon = (coupon/10) + (coupon%10);
        }
        return service;
    }
}