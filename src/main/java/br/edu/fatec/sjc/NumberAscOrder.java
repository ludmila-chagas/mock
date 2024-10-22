package br.edu.fatec.sjc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberAscOrder<E extends Number> {
    private final CustomStack<E> stack;

    public NumberAscOrder(CustomStack<E> stack) {
        if (stack == null) { // Verifique se a pilha é nula
            throw new IllegalArgumentException("Stack cannot be null");
        }
        this.stack = stack;
    }

    public List<E> sort() {
        List<E> numbers = new ArrayList<>();
        
        // Extrai todos os números da pilha
        while (!stack.isEmpty()) {
            try {
                numbers.add(stack.pop());
            } catch (StackEmptyException e) {
                // Não deve ocorrer devido ao check isEmpty()
                break;
            }
        }

        // Ordena a lista
        Collections.sort(numbers, (a, b) -> Double.compare(a.doubleValue(), b.doubleValue()));

        return numbers;
    }
}
