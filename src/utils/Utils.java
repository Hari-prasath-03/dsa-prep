package utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Utils {
    public static void print2dArray(int[][] arr) {
        Stream.of(arr).forEach(a -> System.out.print(Arrays.toString(a) + "\n"));
        System.out.println();
    }

    public static <T> void print2dArray(List<List<T>> arr) {
        arr.forEach(System.out::print);
        System.out.println();
    }
}
