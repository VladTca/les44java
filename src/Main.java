import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Auto> list = new ArrayList<>(Arrays.asList(
                new Auto("1xxx", "BMW", 2020, 510000.0),
                new Auto("ad2xxx", "KIA", 2021, 20000.0),
                new Auto("fgn3xxx", "TOYOTA", 2022, 300000.0),
                new Auto("bncv4xxx", "NISSAN", 2023, 8400000.0),
                new Auto("xv5xxx", "HYUNDAI", 2024, 50000.0),
                new Auto("nb6xxx", "SEAT", 2025, 6000000.0),
                new Auto("7cvbxxxx", "MITSUBISHI", 2026, 70000.0),
                new Auto("asd8xxx", "SUBARU", 2027, 80000.0)
        ));
        list.forEach(System.out::println);
        System.out.println("==========================");
        System.out.println("Sort by id");
        Collections.sort(list,((a, b) -> a.id().compareTo(b.id())));
        list.forEach(System.out::println);
        System.out.println("==========================");
        System.out.println("Sort by price");
        Collections.sort(list,((a, b) -> Double.compare(a.price(), b.price())));
        list.forEach(System.out::println);
        System.out.println("==========================");
        System.out.println("Sort by brand");
        Collections.sort(list,((a, b) -> a.brand().compareTo(b.brand())));
        list.forEach(System.out::println);
        System.out.println("==========================");
        System.out.println("Sort by year");
        Collections.sort(list,((a, b) -> a.year() - b.year()));
        list.forEach(System.out::println);
    }
}