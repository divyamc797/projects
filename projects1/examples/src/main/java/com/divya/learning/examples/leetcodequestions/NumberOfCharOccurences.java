package com.divya.learning.examples.leetcodequestions;

import java.util.*;

public class NumberOfCharOccurences {
    //"aaabcbd"

    //a->3, b->2, c->1, d->1

    // to3 char occurences --abc / abd

    //steps:
    //1. String -> char list loop
    //2. I ll store to Map -> Map<char, NumberOfOcc>
    //    -> if not exist add, exist increment numberOfOccurences

    public static void main(String[] args) {
        getTop3("aaabcbdefghee");
    }

    static List<Character> getTop3(String sentence) {
        List<Character> characterList = new ArrayList<>();
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        for (char c : sentence.toCharArray()) {
            if (!characterIntegerMap.containsKey(c)) {
                characterIntegerMap.put(c, 1);
            } else {
                characterIntegerMap.put(c, characterIntegerMap.get(c) + 1);
            }
//            characterIntegerMap.put(c, characterIntegerMap.getOrDefault(c, 0) + 1);
        }

        //Sort using TreeMap
//        TreeMap<Integer, Character> tm = new TreeMap<>(Collections.reverseOrder());
//        for (Map.Entry<Character, Integer> entry : characterIntegerMap.entrySet()) {
//            tm.put(entry.getValue(), entry.getKey());
//        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap =
                new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        maxHeap.addAll(characterIntegerMap.entrySet());

        for (int i = 0; i < 3; i++) {
            characterList.add(maxHeap.remove().getKey());
        }

        return characterList;
    }


}
