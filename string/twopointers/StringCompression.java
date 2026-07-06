package twopointers;

public class StringCompression {
    public static int compress(char[] chars) {
        int write = 0, index = 0;

        for (int i = 0; i < chars.length; i++) {
            write++;
            if (i + 1 == chars.length || chars[i] != chars[i + 1]) {
                chars[index++] = chars[i];
                if (write != 1) {
                    for (char ch: Integer.toString(write).toCharArray()) {
                        chars[index++] = ch;
                    }
                }
                write = 0;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        System.out.println(compress(new char[] {'a', 'a', 'b', 'b', 'c', 'c', 'c'}));
        System.out.println(compress(new char[] {'a'}));
        System.out.println(compress(new char[] {'a','b','b','b','b','b','b','b','b','b','b','b','b'}));
    }
}
