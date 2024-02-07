class Solution {
    
    static int[][] dungeon;
    static int dungeonCount;
    static int maxTrials = 0;
    static boolean[] check;
    
    public int solution(int k, int[][] dungeons) {
        dungeon = dungeons;
        dungeonCount = dungeon.length;
        check = new boolean[dungeonCount];
        backtracking(k, 0);
        return maxTrials;
    }
    
    public static void backtracking(int remainingK, int depth){
        if(depth == dungeonCount){
            maxTrials = dungeonCount;
            return;
        }
        
        for(int i = 0; i < dungeonCount; i++){
            if(check[i]){
                continue;
            }
            if(canEntryDungeon(remainingK, dungeon[i][0])){
                check[i] = true;
                backtracking(remainingK - dungeon[i][1], depth + 1);
                check[i] = false;
            } else {
                if(maxTrials < depth){
                    maxTrials = depth;
                }
            }
        }
    }
    
    public static boolean canEntryDungeon(int remainingK, int needK){
        if(remainingK >= needK){
            return true;
        }
        return false;
    }
}