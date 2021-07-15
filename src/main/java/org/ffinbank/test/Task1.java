package org.ffinbank.test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

public class Task1 {

    public static void main(String[] args) throws MyException {

        //Input
        Collection<BigDecimal> numbers = new ArrayList<>();

        numbers.add(BigDecimal.valueOf(15563.3));
        numbers.add(BigDecimal.valueOf(100));
        numbers.add(BigDecimal.valueOf(9963));
        numbers.add(BigDecimal.valueOf(12));
        numbers.add(BigDecimal.valueOf(633));
        numbers.add(BigDecimal.valueOf(3));

        //calculation
        filter(numbers);

        //output
        System.out.println(numbers);


    }

    // first task
    public static void filter(Collection<BigDecimal> numbers) throws MyException {

        BigDecimal maxValue = generate(numbers)
                .max(BigDecimal::compareTo)
                .orElseThrow(() -> new MyException("Something wrong to calculate a max value"));

        BigDecimal minValue = generate(numbers)
                .min(BigDecimal::compareTo)
                .orElseThrow(() -> new MyException("Something wrong to calculate a min value"));

        var filter = maxValue.divide(minValue, RoundingMode.HALF_UP);

        try {
            numbers.removeIf(bigDecimal -> bigDecimal.compareTo(filter) < 0);
        } catch (Exception e) {
            throw new MyException("Cannot do filtrating remove operation");
        }

    }

    private static <T> Stream<T> generate(Collection<T> nums) {
        return nums
                .stream();
    }


}

class MyException extends Exception {

    public MyException(String message) {
        super(message);
    }
}
