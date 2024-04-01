class Solution {
    static byte byteInput;
    static short shortInput;
    static boolean isUnderByteMax;
    static byte byteMax;
    static short shortMax;
    
    public int solution(int n) {
        byteInput = 0;
        shortInput = 0;
        isUnderByteMax = false;
        byteMax = Byte.MAX_VALUE;
        shortMax = Short.MAX_VALUE;
        
        if((n & byteMax) <= byteMax && ((n & shortMax) == (n & byteMax))){
            byteInput = (byte) n;
            isUnderByteMax = true;
        } else {
            shortInput = (short) n;
        }
        
        int sum = isUnderByteMax? byteMax & 0 : (byte) 0;
        int sumReal = (int) sum;
        
        if(isUnderByteMax){
            for(byte i = 2; i <= byteInput; i += 2){
                if(i <= byteInput){
                    sumReal += i;
                }
            }
        } else {
            for(short i = 2; i <= shortInput; i += 2){
                if(i <= shortInput){
                    sumReal += i;
                }
            }
        }
        return sumReal;
    }
}