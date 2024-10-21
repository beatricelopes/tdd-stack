package br.edu.fatec.sjc;

import java.util.ArrayList;
import java.util.List;

public class NumberAscOrder<E extends Number> {
    private CustomStack<E> stack;

    public NumberAscOrder(CustomStack<E> stack) {
        this.stack = stack;
    }

    public List<E> sort() throws StackEmptyException {
        if (stack.isEmpty()) {
            throw new IllegalArgumentException("A pilha está vazia.");
        }

        List<E> sortedList = new ArrayList<>();
        var size = stack.size();
        for (int i = 0; i < size; i++) {
            sortedList.add(stack.pop());
        }

        int n = sortedList.size();
        E temp;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (((Double)sortedList.get(j)) > ((Double)sortedList.get(j+1))) {
                    temp = sortedList.get(j);
                    sortedList.set(j, sortedList.get(j + 1));
                    sortedList.set(j + 1, temp);
                }
            }
        }

        return sortedList;
    }
    
}
