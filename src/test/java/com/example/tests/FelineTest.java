package com.example.tests;

import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class FelineTest {

    Feline feline = new Feline();

    @Test
    public void eatMeatPositiveResult() throws Exception{
        List<String> expectedResult = feline.getFood("Хищник");
        List<String> actualResult = feline.eatMeat();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getFamilyPositiveResult(){
        String expectedResult = "Кошачьи";
        String actualResult = feline.getFamily();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getKittensNoParametersPositiveResult(){
        int expectedResult = feline.getKittens(1);
        int actualResult = feline.getKittens();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test public void getKittensPositiveResult(){
        int expectedResult = 3;
        int actualResult = feline.getKittens(3);
        Assert.assertEquals(expectedResult, actualResult);
    }

}
