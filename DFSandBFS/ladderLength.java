package DFSandBFS;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ladderLength {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean inList = false;
        for (int i = 0; i < wordList.size(); i ++) {
            if (endWord.equals(wordList.get(i)))
                inList = true;
        }
        if (!inList)
            return 0;
        int length = 1;
        Deque<String> stack = new LinkedList<>();
        stack.addLast(beginWord);
        while (!stack.isEmpty()) {
            int size = stack.size();
            for (int i = 0; i < size; i ++) {
                String word = stack.pollFirst();
                if (word.equals(endWord))
                    return length;
                else {
                    for (int j = 0; j < wordList.size(); j ++) {
                        if (wordList.get(j).equals("-1")) {
                            continue;
                        } else {
                            if (checkValidWord(word, wordList.get(j))) {
                                stack.addLast(wordList.get(j));
                                wordList.set(j,"-1");
                            }
                        }
                    }
                }
            }
            length += 1;
            if (length > wordList.size() + 1)
                return 0;
        }
        return 0;
    }

    private static boolean checkValidWord(String word1, String word2) {
        int difference = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i))
                difference += 1;
        }
        return difference == 1;
    }

    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>();
        //wordList.add("hot");
        //wordList.add("dot");
        //wordList.add("dog");
        //wordList.add("lot");
        //wordList.add("log");
        wordList.add("cog");
        System.out.println(ladderLength("hog", "cog", wordList));
    }
}
