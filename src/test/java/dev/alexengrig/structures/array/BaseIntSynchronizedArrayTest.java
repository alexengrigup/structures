package dev.alexengrig.structures.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public abstract class BaseIntSynchronizedArrayTest {
    private final int length;
    private final int numberOfThreads;
    private final int expected;

    public BaseIntSynchronizedArrayTest(int length, int numberOfThreads, int expected) {
        this.length = length;
        this.numberOfThreads = numberOfThreads;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, 2, 3},
                {4, 2, 1000_000},
                {4, 3, 1000_000},
                {4, 4, 1000_000},
                {4, 5, 1000_000},
                {4, 6, 1000_000},
                {4, Runtime.getRuntime().availableProcessors(), 1000_000},
        });
    }

    @Test
    public void test() throws InterruptedException {
        int[] values = new int[length];
        IntArray array = createArray(values);

        Random random = new Random();
        Callable<Object> task = () -> {
            boolean isReverse = random.nextBoolean();
            if (isReverse) {
                for (int index = length - 1; index >= 0; index--) {
                    array.compute(index, v -> v + 1);
                }
            } else {
                for (int index = 0; index < length; index++) {
                    array.compute(index, v -> v + 1);
                }
            }
            return null;
        };

        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);

        Collection<Callable<Object>> tasks = Collections.nCopies(expected, task);
        Instant start = Instant.now();
        executorService.invokeAll(tasks);
        Instant end = Instant.now();

        System.out.println("Time: " + Duration.between(start, end));

        int[] expectedValues = new int[length];
        Arrays.fill(expectedValues, expected);
        assertArrayEquals(expectedValues, values);
    }

    protected abstract IntArray createArray(int[] values);
}