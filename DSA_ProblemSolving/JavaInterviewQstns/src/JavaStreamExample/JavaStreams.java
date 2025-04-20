package JavaStreamExample;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.*;



public class JavaStreams {

    public static void main(String[] args) throws IOException {
        // 1. Integer Stream
        IntStream.range(1, 5).forEach(System.out::print);
        System.out.println();

        // 2. Integer Stream with skip
        IntStream.range(1, 5).skip(2).forEach(System.out::print);
        System.out.println();

        // 3. Integer Stream with sum
        System.out.println(IntStream.range(1, 5).sum());
        System.out.println();

        // 4. Stream.of, sorted and findFirst
        Stream.of("Subhajit", "Rahul", "Shilajit")
                .sorted().findFirst().ifPresent(System.out::println);

        // 5. Stream from Array, sort, filter and print
        String [] names= {"Zalatan","Cristiano","Messi","Neymar","Cafu","Casmero"};
        Arrays.stream(names).filter(x->x.startsWith("C")).
                sorted().forEach(System.out::println);

        // 6. average of squares of an int array
        Arrays.stream(new int[]{1,2,3,4}).map(x->x*x)
                .forEach(System.out::println);
        Arrays.stream(new int[] { 1,2,3,4 }).map(y -> y * y)
                .average().ifPresent(System.out::println);

        // 7. Stream from List, filter and print
        List<String> people = Arrays.asList("Al", "Ankit", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sarah");
        people.stream().map(String::toLowerCase)
                .filter(x->x.startsWith("a")).forEach(System.out::println);

        // 8. Stream rows from text file, sort, filter, and print
        Stream<String> bands = Files.lines(Paths.get("bands.txt"));
        bands.sorted().filter(x -> x.length()> 13)
                .forEach(System.out::println);
        bands.close();

        // 9. Stream rows from text file and save to List
        List<String> bands2 = Files.lines(Paths.get("bands.txt"))
                .filter(x -> x.contains("jit")).collect(Collectors.toList());
        bands2.forEach(x -> System.out.println(x));


        // 13. Reduction - sum
        double total = Stream.of(7.3, 1.5, 4.8)
                .reduce(0.0, (Double a, Double b) -> a + b);
        System.out.println("Total = " + total);


        // 14. Reduction - summary statistics
        IntSummaryStatistics summary = IntStream.of(7, 2, 19, 88, 73, 4, 10)
                .summaryStatistics();
        System.out.println(summary);

    }

}