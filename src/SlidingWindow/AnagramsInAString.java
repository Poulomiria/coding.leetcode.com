package SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/find-all-anagrams-in-a-string/
 */
public class AnagramsInAString {
    /**
     * Will use the sliding window approach on the source having the length of pattern.
     * For each window will prepare the frequency array/map and match it with the pattern's frequency array/map
     */
    public List<Integer> findAnagrams(String source, String pattern) {
        List<Integer> result = new ArrayList<>();
        /**
         * Base case if pattern length is more than source then return.
         */
        if (pattern.length() > source.length()) {
            return result;
        }

        /**
         * Two frequency array for source & pattern [Map also can be used for the same]
         */
        int[] sourceFrequency = new int[26];
        int[] patternFrequency = new int[26];
        int length = pattern.length();

        /**
         * Creating the source and pattern's frequency hashing
         */
        for (int i = 0; i < length; i++) {
            char sourceChar = source.charAt(i);
            char patternChar = pattern.charAt(i);
            sourceFrequency[sourceChar - 'a'] += 1;
            patternFrequency[patternChar - 'a'] += 1;
        }

        int position = length;
        while (position < source.length()) {
            /**
             * Comparing the array elements whether it is same or not.
             * If same add the starting point
             */
            if (Arrays.equals(sourceFrequency, patternFrequency)) {
                result.add(position - length);
            }

            /**
             * Adding the new character from source to sourceFrequency
             */
            char sourceChar = source.charAt(position);
            sourceFrequency[sourceChar - 'a'] += 1;

            /**
             * Removing the trailing character of source from sourceFrequency
             */
            char sourceTrailingChar = source.charAt(position - length);
            if (sourceFrequency[sourceTrailingChar - 'a'] > 0) {
                sourceFrequency[sourceTrailingChar - 'a'] -= 1;
            }
            position++;
        }

        /**
         * For the last window we are not able to match in the loop as its on the breaking condition
         * Hence checking it once more.
         */
        if (Arrays.equals(sourceFrequency, patternFrequency)) {
            result.add(position - length);
        }

        return result;
    }
}
