package manupulation;

public class CapitalizeTitle {

    public static String capitalizeTitle(String title) {
        String[] arr = title.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String word: arr) {
            if (word.length() < 3) sb.append(word.toLowerCase()).append(" ");
            else sb.append(word.substring(0, 1).toUpperCase()).append(word.substring(1).toLowerCase()).append(" ");
        }

        return sb.toString().trim();
    }

    public static String capitalizeTitleOptimized(String title) {
        char[] ch = title.toCharArray();
        int i = 0, n = ch.length;

        while (i < n) {
            int s = i;
            while (i < n && ch[i] != ' ') {
                ch[i] = Character.toLowerCase(ch[i]);
                i++;
            }
            if (i - s > 2) ch[s] = Character.toUpperCase(ch[s]);

            i++;
        }

        return new String(ch);
    }

    public static void main(String[] args) {
        System.out.println(capitalizeTitle("capiTalIze tHe titLe"));
        System.out.println(capitalizeTitle("First leTTeR of EACH Word"));
        System.out.println(capitalizeTitle("i lOve leetcode"));
    }
}
