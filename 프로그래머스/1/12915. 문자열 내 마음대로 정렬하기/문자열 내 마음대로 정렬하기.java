import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        List<MyString> myStrings = Arrays.stream(strings)
            .map(s -> new MyString(s, s.charAt(n)))
            .collect(Collectors.toList());
        
        Collections.sort(myStrings);
        
        return myStrings.stream()
            .map(ms -> ms.value)
            .toArray(String[]::new);
    }
    
    static class MyString implements Comparable<MyString> {
        String value;
        char comp;
        
        MyString(String value, char comp){
            this.value = value;
            this.comp = comp;
        }
        
        @Override
        public int compareTo(MyString other){
            if(this.comp != other.comp){
                return this.comp - other.comp;
            }
            return this.value.compareTo(other.value);
        }
    }
}