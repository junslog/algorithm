import java.util.*;

class Solution {
    static int N;
    static int[] input;

    public String solution(int[] numbers) {
        Map<Integer,Integer> items = new HashMap<>();
        int k = numbers.length;
        for(int i = 0; i < k; i++){
            items.put(numbers[i], items.getOrDefault(numbers[i], 0) + 1);
        }

        List<Item> keyList = new ArrayList<>();
        boolean isAllZero = true;
        for(int key : items.keySet()){
            keyList.add(new Item(key));
            if(key != 0){
                isAllZero = false;
            }
        }
        Collections.sort(keyList);

        StringBuilder sb = new StringBuilder();
        for(int i = keyList.size() - 1; i >= 0; i--){
            int ke = keyList.get(i).item;
            for(int j = 0; j < items.get(ke); j++){
                sb.append(ke);
            }
        }
        if(isAllZero){
            return "0";
        } else {
            return sb.toString();
        }
    }

    public static class Item implements Comparable<Item>{
        int item;

        public Item(int item){
            this.item = item;
        }

        @Override
        public int compareTo(Item other) {
            int otherItem = other.item;
            int A = Integer.valueOf(String.valueOf(item).concat(String.valueOf(other.item)));
            int B = Integer.valueOf(String.valueOf(other.item).concat(String.valueOf(item)));
            return A - B;
        }
    }
}