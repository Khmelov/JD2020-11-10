package by.it._khmelov_.jd01_12;

import java.util.*;
import java.util.stream.Collectors;

public class TaskC2 {

    static class Key {
        final Number NUM;

        public Key(Number number) {
            this.NUM = number;
        }

        @Override
        public boolean equals(Object obj) {
            return (obj instanceof Number)
                    && NUM.longValue() == ((Number) obj).longValue()
                    && NUM.doubleValue() == ((Number) obj).doubleValue();
        }

        @Override
        public int hashCode() {
            return NUM==null?0:Objects.hash(NUM.doubleValue(),NUM.longValue());
        }
    }

    @SafeVarargs
    private static Set<?> getUnion(Set<? extends Number>... sets) {
        return Arrays.stream(sets)
                .flatMap(Collection::stream)
                .map(Key::new)
                .collect(Collectors.toSet())
                .stream()
                .map(n -> n.NUM)
                .collect(Collectors.toSet());
    }


    @SafeVarargs
    private static Set<?> getUnion2(Set<? extends Number>... sets) {
        Set<Number> result = new HashSet<>();
        if (sets != null)
            Arrays.stream(sets)
                    .flatMap(Collection::stream)
                    .forEach(v -> {
                        if (numberNotFound(result, v)) result.add(v);
                    });
        return result;
    }

    @SafeVarargs
    private static Set<?> getCross(Set<? extends Number>... sets) {
        Set<Number> result = new HashSet<>();
        if (sets.length > 0) {
            result.addAll(sets[0]);
            for (Set<? extends Number> set : sets) {
                result.removeIf(number -> numberNotFound(set, number));
            }
        }
        return result;
    }

    private static boolean numberNotFound(Set<? extends Number> set, Number number) {
        return set.stream().noneMatch(n -> (n == number) ||
                (n != null
                        && number != null
                        && n.longValue() == number.longValue()
                        && n.doubleValue() == number.doubleValue()));
    }


    public static void main(String[] args) {

        Set<Long> a = new HashSet<>(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L, 9L, null));
        Set<Integer> b = new HashSet<>(Arrays.asList(4, 3, 5, 6, 7, 8, null));
        Set<Double> c = new HashSet<>(Arrays.asList(1., 2., 3., 4., 55., null));
        Set<Double> d = new HashSet<>(Arrays.asList(2., 3., 4., 9., 99., null));

        System.out.println(getUnion(a, b, c, d));
        System.out.println(getCross(a, b, c, d));
        System.out.println(getCross(a, d));
    }

}
