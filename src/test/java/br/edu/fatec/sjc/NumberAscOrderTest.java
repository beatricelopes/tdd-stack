package br.edu.fatec.sjc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.when;
import java.util.*;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.util.CollectionUtils;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class) 
public class NumberAscOrderTest {
    private NumberAscOrder<Double> numberAscOrder;
    @Mock CustomStack<Double> stack;
    @Mock CalculableStrategy<Double> calculableStrategy;

    @BeforeEach
    public void setUp() {
        stack = new CustomStack<>(6, calculableStrategy);
        numberAscOrder = new NumberAscOrder<>(stack);
    }

    @Test
    public void testSortWithNumbers() throws StackFullException, StackEmptyException {
        var l = List.of(Math.random(), Math.random(),Math.random(),Math.random(),Math.random(),Math.random());

        Mockito.when(calculableStrategy.calculateValue(Mockito.anyDouble()))
            .thenReturn(l.get(0))
            .thenReturn(l.get(1))
            .thenReturn(l.get(2))
            .thenReturn(l.get(3))
            .thenReturn(l.get(4))
            .thenReturn(l.get(5));

        for(int i = 0; i<6; i ++){
            stack.push(0D);
        }
        
            
        var sortedList = numberAscOrder.sort();

        Assertions.assertEquals(l.stream().sorted().collect(Collectors.toList()), sortedList);
    }

    @Test
    public void testSortWithEmptyStack() {
        NumberAscOrder ascOrder = new NumberAscOrder(stack);

        Assertions.assertThrows(IllegalArgumentException.class, ascOrder::sort);
    }
}
