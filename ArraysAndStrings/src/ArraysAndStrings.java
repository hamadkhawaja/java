import com.sun.javaws.exceptions.InvalidArgumentException;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.MultiHashtable;
import sun.font.TrueTypeFont;

import java.util.*;
import java.util.Arrays;


/**
 * Created by Hamad on 27/04/2015.
 */
public class ArraysAndStrings {

    /**
     * @param str
     * @return
     */
    public String stringConpressString(String str) {
        String retVal = "";
        char previousElement = str.charAt(0);
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == previousElement) {
                count++;
            } else {
                retVal += previousElement + "" + count;
                previousElement = str.charAt(i);
                count = 1;
            }
        }

        if (str.length() == retVal.length()) {
            return str;
        }

        return retVal;
    }

    public void setZeros(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (row[i] || column[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * Determine is a string has all unique char.
     *
     * @param str
     * @return
     */
    public boolean checkStringHasAllUniqueChar(String str) {
        Map<Character, Integer> map = new HashMap();

        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                return false;
            }

            map.put(str.charAt(i), 1);
        }

        return true;
    }

    String sort(String str) {
        char []content = str.toCharArray();
        Arrays.sort(content);
        return new String (content);
    }
    public boolean isPermutation(String str1, String str2) {
        String sortedString1 = sort(str1);
        String sortedString2 = sort(str2);
        if (sortedString1.equals(sortedString2)) {
            return true;
        }
        return false;
    }

    public boolean isPermutationNonSorted(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        int []count = new int[128];
        for(int i = 0; i < str1.length(); i++) {
            int ord = (int)str1.charAt(i);
            count[ord]++;
        }

        for(int i = 0; i < str2.length(); i++) {
            int ord = (int)str2.charAt(i);
            count[ord]--;
            if (count[ord] < 0) {
                return false;
            }
        }

        return true;
    }

    public boolean hasAllUniqueCharacters(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }

        if (str.isEmpty()) {
            return true;
        }

        int chk = 0;
        for (int i = 0; i < str.length(); i++) {
            int current = 1 << (str.charAt(i) - 'a');
            if ((chk & current) > 0) {
                return false;
            }

            chk |= current;
        }

        return true;
    }

    public boolean hasAllUniqueCharactersWithHash(String str) {
        HashSet<Character> hash = new LinkedHashSet<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (hash.contains(c)) {
                return false;
            }

            hash.add(c);
        }

        return true;
    }

    public String replaceSpaces(String str) {
        StringBuffer sb = new StringBuffer();
        boolean spaceAlreadySeen = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ((c == ' ' || c == '\t') && !spaceAlreadySeen) {
                sb.append("%20");
                spaceAlreadySeen = true;

            } else if ((c == ' ' || c == '\t') && spaceAlreadySeen) {
                continue;
            } else {
                sb.append(c);
                spaceAlreadySeen = false;
            }
        }

        return sb.toString();
    }

    public String compressString(String str) {
        StringBuffer sb = new StringBuffer();
        int index = 0;
        while (index < str.length()) {
            int count = 1;
            while ((index + count < str.length()) && str.charAt(index + count) == str.charAt(index)) {
                count++;
            }
            sb.append(str.charAt(index));
            sb.append(count);
            index += count;
        }

        if (sb.toString().length() > str.length()) {
            return str;
        }

        return sb.toString();
    }

    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int x = numbers[i];
            if (map.containsKey(target - x)) {
                return new int[]{map.get(target - x) + 1, i + 1};
            }

            map.put(x, i);
        }

        throw new IllegalArgumentException("No two numbers are same");
    }

    public int[] twoSumSorted(int []numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;

        while (start < end) {
            if (target == numbers[start] + numbers[end]) {
                return new int[]{start + 1, end + 1};
            } else if (target < numbers[start] + numbers[end]) {
                start++;
            } else {
                end--;
            }
        }

        throw new IllegalArgumentException("No two numbers are same.");
    }

    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            while (start < end && !Character.isLetterOrDigit(s.charAt(start))) start++;
            while (start < end && !Character.isLetterOrDigit(s.charAt(end))) end--;
            if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            }
        }

        return true;
    }

    public int strStr(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }

    public String reverseString(String str) {
        StringBuffer sb = new StringBuffer();
        int end = str.length();
        for (int start = str.length() - 1; start >= 0; start--) {
            if (str.charAt(start) == ' ') {
                end = start;
            } else if (start == 0 || str.charAt(start - 1) == ' ') {
                if (sb.length() != 0) {
                    sb.append(" ");
                }

                sb.append(str.substring(start, end));
            }
        }

        return sb.toString();
    }

    public void reverseWords(char[] s) {
        reverse(s, 0, s.length);
        for (int i = 0, j = 0; j <= s.length; j++) {
            if (j == s.length || s[j] == ' ') {
                reverse(s, i, j);
                i = j + 1;
            }
        }
    }
    private void reverse(char[] s, int begin, int end) {
        for (int i = 0; i < (end - begin) / 2; i++) {
            char temp = s[begin + i];
            s[begin + i] = s[end - i - 1];
            s[end - i - 1] = temp;
        }
    }

    public int[] rotateArray(int []array, int key) {
        for (int i =0; i < key; i++) {
            int last = array[array.length - 1];
            for (int j = array.length - 1; j >=1 ; j--) {
                array[j] = array[j -1];
            }
            array[0] = last;
        }

        return array;
    }

    public int atoi(String str) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Invalid exception.");
        }
        int i = 0;

        while (i < str.length() && Character.isWhitespace(str.charAt(i))) i++;
        int sign = 1;
        if (str.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (str.charAt(i) == '+') {
            i++;
        }

        int num = 0;
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            int digit = Character.getNumericValue(str.charAt(i));
            num = num * 10 + digit;
            i++;
        }

        return sign * num;
    }

    public boolean isNumeric(String str) {
        if (str.isEmpty()) {
            return false;
        }
        boolean isNumeric = false;
        int i = 0;
        while (i < str.length() && Character.isWhitespace(str.charAt(i))) i++;
        if (i < str.length() && (str.charAt(i) == '-' || str.charAt(i) == '+')) i++;
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            i++;
            isNumeric = true;
        }
        if (i < str.length() && str.charAt(i) == '.') {
            i++;
            while (i < str.length() && Character.isDigit(str.charAt(i))) {
                i++;
                isNumeric = true;
            }
        }
        while (i < str.length() && Character.isWhitespace(str.charAt(i))) i++;
        return isNumeric && i == str.length();
    }

    public int longestSubstring(String s) {
        boolean[] exists = new boolean[256];
        int maxLength = 0, start = 0;
        for (int end = 0; end < s.length(); end ++) {
            while (exists[s.charAt(end)]) {
                exists[s.charAt(start)] = false;
                start++;
            }

            exists[s.charAt(end)] = true;
            maxLength = Math.max(end - start + 1, maxLength);
        }

        return maxLength;
    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int start = 0, lastPositionOf = -1, maxLength = 0;
        for (int end = 1; end < s.length(); end++) {
            if (s.charAt(end) == s.charAt(end -1)) continue;
            if (lastPositionOf >= 0 && s.charAt(lastPositionOf) != s.charAt(end)) {
                maxLength = Math.max(start - end, maxLength);
                start = lastPositionOf + 1;
            }
            lastPositionOf = end - 1;
        }

        return maxLength;
    }

    public List<String> findMissingRanges(int []vals, int start, int end) {
        List<String> ranges = new ArrayList<>();
        int prev = start - 1;
        for (int i = 0; i <= vals.length; i++) {
            int current = (i == vals.length) ? end + 1 : vals[i];
            if (current - prev >= 2) {
                ranges.add(range(prev + 1, current -1));
            }
            prev = current;
        }

        return ranges;
    }

    private String range(int from, int to) {
        return (from == to) ? String.valueOf(to) : from + "->" + to;
    }
}