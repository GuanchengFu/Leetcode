package Array;

public class shortestDistance {
    public static int solution(String[] words, String word1, String word2) {
        int p1 = -1;
        int p2 = -1;
        int index = 0;
        int distance = Integer.MAX_VALUE;
        while (index < words.length) {
            String word = words[index];
            if (word.equals(word1)) {
                p1 = index;
            }
            if (word.equals(word2)) {
                p2 = index;
            }
            index += 1;
            if (p1 != -1 && p2 != -1) {
                distance = Math.min(distance, Math.abs(p1 - p2));
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        System.out.println(solution(words,"coding", "practice"));
    }
}
