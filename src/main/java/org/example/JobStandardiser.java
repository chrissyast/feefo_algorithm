package org.example;

import info.debatty.java.stringsimilarity.Damerau;

import java.util.*;

public class JobStandardiser {
    private Damerau dam = new Damerau();

    public String standardise(String input) {
        // return exact match if available
        String exactMatch = exactMatch(input);
        if (exactMatch != null) {
            return exactMatch;
        }
        // look for aliases we can substitute
        String substitutedInput = "";
        for (final String wordInInput : input.split(" ")) {
            String wordAfterSubstitution = wordInInput;
            for (final Word standardWord : Word.values()) {
                if (standardWord.aliases.contains(wordInInput) ||
                    standardWord.aliases.stream()
                            .filter(a -> dam.distance(a, wordInInput) * wordInInput.length() <= 2) // essentially, if the word is only two keystrokes away from the intended word, it can be considered a typo
                            .findAny()
                            .isPresent()
                    ) {
                    wordAfterSubstitution = standardWord.label;
                }
            }
            substitutedInput += wordAfterSubstitution + " ";
        }
        substitutedInput = format(substitutedInput);
        // try again for an exact match
        exactMatch = exactMatch(substitutedInput);
        if (exactMatch != null) {
            return exactMatch;
        }
        // if we still haven't got an exact match, order by keystroke similarity and return the top match
        final String comparisonString = substitutedInput;
        List<Job> jobs = Arrays.asList(Job.values());
        jobs.sort(Comparator.comparingDouble((Job j) -> dam.similarity(j.label, comparisonString)).reversed());
        Job topMatch = jobs.stream().findFirst().get();
        return topMatch.label;
    }

    private String exactMatch(String input) {
        for (Job value : Job.values()) {
            if (input.equalsIgnoreCase(value.label)) {
                return value.label;
            }
        }
        return null;
    }

    private String format(String input) {
        String output = input.strip();
        String outputChar1 = output.substring(0, 1).toUpperCase();
        String capitalised = outputChar1 + output.substring(1);
        return capitalised;
    }
}
