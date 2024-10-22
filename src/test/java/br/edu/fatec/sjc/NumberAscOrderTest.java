package br.edu.fatec.sjc;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NumberAscOrderTest {
    private CustomStack<Integer> stack;
    private NumberAscOrder<Integer> numberAscOrder;
    private CalculableStrategy<Integer> strategy;

    @BeforeEach
    void setUp() {
        // Usando uma expressão lambda para a estratégia
        strategy = value -> value;  
        stack = new CustomStack<>(6, strategy);
        numberAscOrder = new NumberAscOrder<>(stack);
    }

    @Test
    void shouldSortSixNumbersInAscendingOrder() throws StackFullException {
        stack.push(47);
        stack.push(12);
        stack.push(35);
        stack.push(60);
        stack.push(23);
        stack.push(8);

        List<Integer> result = numberAscOrder.sort();

        List<Integer> expected = Arrays.asList(8, 12, 23, 35, 47, 60);
        assertEquals(expected, result);
    }

    @Test
    void shouldReturnEmptyListWhenStackIsEmpty() {
        List<Integer> result = numberAscOrder.sort();
        assertTrue(result.isEmpty());
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenStackIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new NumberAscOrder<>(null));
    }

    @Test
    void shouldHandleStackWithLessThanSixNumbers() throws StackFullException {
        stack.push(47);
        stack.push(12);
        stack.push(35);

        List<Integer> result = numberAscOrder.sort();

        List<Integer> expected = Arrays.asList(12, 35, 47);
        assertEquals(expected, result);
    }
}
