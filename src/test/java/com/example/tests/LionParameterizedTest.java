package com.example.tests;

import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    private final String sex;

    public LionParameterizedTest(String sex) {
        this.sex = sex;

    }

    @Mock
    Feline feline;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Parameterized.Parameters(name = "Класс Lion. Пол: {0}")
    public static Object[][] setSexForLion() {
        return new Object[][] {
                {"Самец"},
                {"Самка"},
        };
    }

    @Test
    public void doesHaveManePositiveResult() throws Exception {
        Lion lion = new Lion(feline, sex);
        switch (sex) {
            case "Самец": Assert.assertTrue("Грива есть только у льва", lion.doesHaveMane());
                break;

            case "Самка": Assert.assertFalse("У самки нет гривы", lion.doesHaveMane());
                break;
        }
    }
}
