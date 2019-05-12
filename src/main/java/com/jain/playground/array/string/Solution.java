package com.jain.playground.array.string;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.mapping;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;

class Solution {

    String[] morse = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
            ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-",
            "...-", ".--", "-..-", "-.--", "--.."};

    public static void main(String[] args) {
        System.out.println(
                "new Solution().uniqueMorseRepresentations((String[])\n                Arrays.asList(\"noilq\",\"kzlq\",\"ydreq\",\"ybxk\",\"kzlq\").toArray()) = "
                        + new Solution().uniqueMorseRepresentations((String[])
                        Arrays.asList("noilq", "kzlq", "ydreq", "ybxk", "kzlq").toArray()));
    }

    public int uniqueMorseRepresentations(String[] words) {
        Map<String, String> collect = Arrays.stream(words)
                .distinct()
                .collect(groupingBy(Function.identity(),
                        mapping(s -> s.chars().mapToObj(operand -> morse[operand - 'a'])
                                .collect(joining()), joining())));
        return (int) collect
                .values()
                .stream()
                .distinct()
                .count();
    }
}