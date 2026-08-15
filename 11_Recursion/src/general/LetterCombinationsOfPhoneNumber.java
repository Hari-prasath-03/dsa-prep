package general;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {
    private static final String[] phone = new String[] {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public static List<String> letterCombinations(String digits) {
        if ("".equals(digits)) return new ArrayList<>();
        return calcCombinations("", digits);
    }

    private static List<String> calcCombinations(String p, String up) {
        if (up.isEmpty()) return Collections.singletonList(p);

        List<String> list = new ArrayList<>();
        String letters = phone[up.charAt(0) - '0'];
        for (char letter: letters.toCharArray()) {
            list.addAll(calcCombinations(p + letter, up.substring(1)));
        }
        return list;
    }

    public static List<String> letterCombinations1(String digits) {
        List<String> result = new ArrayList<>();
        calcCombinations("", digits, result);
        return result;
    }

    private static void calcCombinations(String p, String up, List<String> r) {
        if (up.isEmpty()) {
            r.add(p);
            return;
        }

        String letters = phone[up.charAt(0) - '0'];
        for (char letter: letters.toCharArray()) {
            calcCombinations(p + letter, up.substring(1), r);
        }
    }

    static void main() {
        System.out.println(letterCombinations1("23"));
        System.out.println(letterCombinations1("2"));
        System.out.println(letterCombinations1(""));
    }
}
