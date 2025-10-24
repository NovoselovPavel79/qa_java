package com.example.tests;

import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void getKittensPositiveResult() throws Exception {
        Lion lion = new Lion(feline, "Самка");
        int expectedCount = 3;
        Mockito.when(feline.getKittens()).thenReturn(expectedCount);
        int actualCount = lion.getKittens();
        Assert.assertEquals(expectedCount, actualCount);
    }

    @Test
    public void getFoodIsPositiveResult() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood);
        List<String> actualFood = lion.getFood();
        Assert.assertEquals(expectedFood, actualFood);
    }

    @Test(expected = Exception.class)
    public void checkLionConstructorWithInvalidSex() throws Exception {
        String invalidSex = "Неопределенная особь";
        try {
            new Lion(feline, invalidSex);
        } catch (Exception exception) {
            Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
            throw exception;
        }
    }
}