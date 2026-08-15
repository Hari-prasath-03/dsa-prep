package general;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis(n, "", 0, 0, 0, result);
        return result;
    }

    private static void generateParenthesis(int n, String s, int i, int open, int close, List<String> r) {
        if (s.length() == n * 2) {
            r.add(s);
            return;
        }
        if (open < n) generateParenthesis(n, s + "(", i + 1, open + 1, close, r);
        if (open > close) generateParenthesis(n, s + ")", i + 1,  open, close + 1, r);
    }

    static void main() {
        System.out.println(generateParenthesis(3)); // ["((()))","(()())","(())()","()(())","()()()"]
        System.out.println(generateParenthesis(1)); // ["()"]
    }
}
