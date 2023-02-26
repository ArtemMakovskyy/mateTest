package main.java8.stream.tasks.c_02;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class StreamApiMedium {
    /**
     * +++++++++++ Given list strings representing records of patients' visits to a Hospital
     * {"John Stevenson:2020", "Andrew Ferguson:2012", "Andrew Ferguson:2013"}.
     * Return number of unique persons who have visited hospital during the given year (second input param).
     * Be careful, because one person may visit a hospital several times per year and for each visit new record
     * will be generated. Result shouldn't contain duplicates.
     */
    public Long getVisitorsPerYear(List<String> records, int year) {
        List<String> recordsList = records.stream()
                .flatMap(pair -> Stream.of(pair.split(":")))
                .collect(Collectors.toList());
        String[] recordsArray = recordsList.toArray(new String[0]);
        Stream<List<String>> iterate = Stream.iterate(Arrays.asList(recordsArray), list -> list.subList(2, list.size()));
        Stream<List<String>> limit = iterate.limit(recordsArray.length / 2);
        HashMap<String, Integer> map = limit.collect(toMap(
                list -> list.get(0),
                list -> Integer.valueOf(list.get(1)),
                (x, y) -> y, () -> new HashMap<String, Integer>()));

        long count = map.entrySet().stream().filter(e -> e.getValue() == year).count();



        return records.stream()
                // leave only records where year of record equals to passed one
                .filter(r -> Integer.parseInt(r.split(":")[1]) == year)
                // leave only unique visitors
                .distinct()
                // return number of visitors
                .count();


    }

    /**
     * +++++* Given a map with the following view : "company name" - "monthly income delta"  (String/Integer)
     * Return list of the companies with positive delta. Their names should be sorted alphabetically
     * Example input : {"Sun.ltd" : 20_000}, {"Micro" : -5_200}, {"Clarity": 0}, {"Odyssey": 9_640};
     * Output : {"Odyssey", "Sun.ltd"}
     */
    public List<String> getCompanies(Map<String, Integer> input) {
        return input.entrySet()
                .stream()
                .filter(company -> company.getValue() > 0)
                .map(Map.Entry::getKey)
                .sorted()
                .collect(Collectors.toList());
    }

    /**
     * +++++* Given a list of integer numbers, convert each integer into its' binary representation in string format
     * and join all of them into a single string and putting each value into brackets, it should look like this:
     * Input: {1, 20, 33}
     * Output:
     * (1)
     * (10100)
     * (100001)
     */
    public String convertAndModifyNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(i -> "(" + Integer.toBinaryString(i) + ")")
                .collect(Collectors.joining(System.lineSeparator()));
//         .collect(Collectors.joining(")" + System.lineSeparator() + "(", "(", ")"));
    }

    /**
     * ++++++++++* Given string value. Your task is
     * to increment char value of each symbol from the string. Amount to increment is
     * passed with the second input param - 'increment'
     */

    public String charsIncrementation(String string, int increment) {
        return string.chars()
                .map(c -> c + increment)
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
    }

    /**
     * Given List of string where each element represents persons' age and name:
     * {"99:Johny", "20:Brad", ...} return the age of the oldest person
     */
    public Long getOldestPersonAge(List<String> people) {
        Map<Integer, String> hashPeople = new HashMap<>();
        for (int i = 0; i < people.size(); i++) {
            String[] split = people.get(i).split(":");
            hashPeople.put(Integer.valueOf(split[0]), split[1]);
        }
//        hashPeople.entrySet().stream().max(c -> c.getKey()).get().getKey()
        return 0L;
    }
}
