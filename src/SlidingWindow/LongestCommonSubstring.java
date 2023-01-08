package SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
/*
Dynamic sized sliding window
 */
public class LongestCommonSubstring {

    public static String LongestSubstring(String s) {
        int n = s.length(), max = 0, temp = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int right = 0, left = 0; right < n; right++) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(map.get(s.charAt(right)), left);
            }
            max = Math.max(max, right - left + 1);
            if(max < right -left + 1)
            {
                temp = max;
            }
            map.put(s.charAt(right), right + 1);
        }
        return s.substring(temp, temp + max);
    }
        public static String lengthOfLongestSubstring(String s) {
            HashSet<Character> hs = new HashSet<>();
            int maxLength = 0;
            int currentLength = 0;
            int start = 0; int temp =0;
            for(int i = 0; i < s.length(); i++) {
                while(hs.contains(s.charAt(i))) {
                    hs.remove(s.charAt(start++));
                    currentLength--;
                }
                hs.add(s.charAt(i));
                currentLength++;
                maxLength = Math.max(currentLength, maxLength);
                if(maxLength <currentLength)
                {
                    temp = currentLength;
                }
            }
            return s.substring(temp, temp + maxLength);
        }

    public static String longestCommonSubstring(String s)
    {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int left = 0;
        int right = 0;
        int maxlen = 0;
        int temp = 0;
        while(right < s.length())
        {
            char r = s.charAt(right);
            map.put(r, map.getOrDefault(r,0) + 1);
            while(map.get(r) > 1)
            {
                char l = s.charAt(left);
                map.put(l, map.get(l) - 1);
                left++;
            }
            maxlen = Math.max(maxlen, right - left + 1);
            if(maxlen < right - left + 1)
            {
                temp = left;
            }
            right++;
        }
        return s.substring(temp , temp + maxlen);
    }
    public static void main(String args[])
    {
        String s = "xyzxyzyyxy";
        System.out.println(LongestSubstring(s));
    }



}
