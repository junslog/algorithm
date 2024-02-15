import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<Word> wordSet = new HashSet<>();
        List<Word> words = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            wordSet.add(new Word(br.readLine()));
        }
        words.addAll(wordSet);
        Collections.sort(words);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < wordSet.size(); i++) {
            sb.append(words.get(i).word).append("\n");
        }
        System.out.println(sb);
    }

    public static class Word implements Comparable<Word> {
        String word;

        public Word(String word) {
            this.word = word;
        }

        @Override
        public int compareTo(Word other) {
            if (word.length() != other.word.length()) {
                return word.length() - other.word.length();
            }
            char[] thisChar = word.toCharArray();
            char[] otherChar = other.word.toCharArray();
            for (int i = 0; i < thisChar.length; i++) {
                if (thisChar[i] > otherChar[i]) {
                    return 1;
                } else if (thisChar[i] < otherChar[i]) {
                    return -1;
                }
            }
            return 0;
        }

        @Override
        public boolean equals(Object other) {
            if (this.getClass() != other.getClass()) {
                return false;
            }
            Word w = (Word) other;
            if (this == w) {
                return true;
            }
            return this.word.equals(w.word);
        }

        @Override
        public int hashCode() {
            return Objects.hash();
        }
    }
}