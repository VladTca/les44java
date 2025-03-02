// File location: src/test/java/MainTest.java

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MainTest {
    private List<Auto> list;
    @BeforeEach
    void getAutos() {
        list = new ArrayList<>();
        list.add(new Auto("1xxx", "BMW", 2020, 510000.0));
        list.add(new Auto("ad2xxx", "KIA", 2021, 20000.0));
        list.add(new Auto("fgn3xxx", "TOYOTA", 2022, 300000.0));
        list.add(new Auto("bncv4xxx", "NISSAN", 2023, 8400000.0));
    }

    @Test
    @DisplayName("Test sorting by id")
    void testSortingById() {

        List<Auto> expected = List.of(
                new Auto("1xxx", "BMW", 2020, 510000.0),
                new Auto("ad2xxx", "KIA", 2021, 20000.0),
                new Auto("bncv4xxx", "NISSAN", 2023, 8400000.0),
                new Auto("fgn3xxx", "TOYOTA", 2022, 300000.0)

        );


        List<Auto> newList = new ArrayList<>(list);
        Collections.sort(newList, (a, b) -> a.id().compareTo(b.id()));
        assertAllTests(list, newList, expected);

    }

    @Test
    @DisplayName("Test sorting by price")
    void testSortingByPrice() {

        List<Auto> expected = List.of(
                new Auto("ad2xxx", "KIA", 2021, 20000.0),
                new Auto("fgn3xxx", "TOYOTA", 2022, 300000.0),
                new Auto("1xxx", "BMW", 2020, 510000.0),
                new Auto("bncv4xxx", "NISSAN", 2023, 8400000.0)
        );

        List<Auto> newList = new ArrayList<>(list);
        Collections.sort(newList, (a, b) -> Double.compare(a.price(), b.price()));

        assertAllTests(list, newList, expected);
    }

    @Test
    @DisplayName("Test sorting by brand")
    void testSortingByBrand() {

        List<Auto> expected = List.of(
                new Auto("1xxx", "BMW", 2020, 510000.0),
                new Auto("ad2xxx", "KIA", 2021, 20000.0),
                new Auto("bncv4xxx", "NISSAN", 2023, 8400000.0),
                new Auto("fgn3xxx", "TOYOTA", 2022, 300000.0)
        );

        List<Auto> newList = new ArrayList<>(list);
        Collections.sort(newList, (a, b) -> a.brand().compareTo(b.brand()));

        Assertions.assertAll(
                () -> Assertions.assertEquals(expected, newList),
                () -> Assertions.assertEquals(expected.size(), newList.size()),
                () -> Assertions.assertTrue(newList.containsAll(expected)),
                () -> Assertions.assertTrue(expected.containsAll(newList))
        );
    }

    @Test
    @DisplayName("Test sorting by year")
    void testSortingByYear() {

        List<Auto> expected = List.of(
                new Auto("1xxx", "BMW", 2020, 510000.0),
                new Auto("ad2xxx", "KIA", 2021, 20000.0),
                new Auto("fgn3xxx", "TOYOTA", 2022, 300000.0),
                new Auto("bncv4xxx", "NISSAN", 2023, 8400000.0)
        );

        List<Auto> newList = new ArrayList<>(list);
        Collections.sort(newList, (a, b) -> a.year() - b.year());

        assertAllTests(list, newList, expected);
    }

    private static void assertAllTests(List<Auto> list, List<Auto> newList, List<Auto> expected) {
        Assertions.assertAll(
                () -> Assertions.assertNotSame(list, newList),
                () -> Assertions.assertEquals(expected, newList),
                () -> Assertions.assertTrue(newList.size() == expected.size()),
                () -> Assertions.assertTrue(newList.containsAll(expected)),
                () -> Assertions.assertTrue(expected.containsAll(newList))
        );
    }


}