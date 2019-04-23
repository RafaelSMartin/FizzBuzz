package com.sample.fizzbuzz;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(JUnitParamsRunner.class)
public class FizzBuzzTest {
    private static final int ANY_NUMBER_EXCEPT_3_5 = 1;
    private static final int ANY_MULTIPLE_3 = 9;
    private static final int ANY_MULTIPLE_5 = 10;
    private static final int ANY_NUMBER_3_AND_5 = 15;
    private static final int ANY_NEGATIVE_NUMBER = -1;

    private OutWriter outWriter;

    @Parameters(method = "getNot3_5Input")
    @Test
    public void shouldReturnANumberWhenTheValueIsNot3or5(int value){
        //Arrange
        FizzBuzz fizzBuzz = givenFizzBuzz();
        //Act
        fizzBuzz.printValue(ANY_NUMBER_EXCEPT_3_5);
        //Assert
        verifyPrintValue(Integer.toString(ANY_NUMBER_EXCEPT_3_5));
    }

    @Test
    public void shouldProntCorrectValuesForOneTo100() {
        //No es necesario
    }

    private FizzBuzz givenFizzBuzz() {
        outWriter = mock(OutWriter.class);
        return new FizzBuzz(outWriter);
    }

    @Test
    public void shouldReturnFizzWhenNumberIs3() {
        //Arrange
        FizzBuzz fizzBuzz = givenFizzBuzz();
        //Act
        fizzBuzz.printValue(3);
        //Assert
        verifyPrintValue("fizz");
    }

    @Test
    public void shouldReturnFizzWhenNUmberIsMultipleOf3() {
        FizzBuzz fizzBuzz = givenFizzBuzz();

        fizzBuzz.printValue(ANY_MULTIPLE_3);

        verifyPrintValue("fizz");
    }

    @Test
    public void shouldReturnBuzzWhenNumberIs5() {
        FizzBuzz fizzBuzz = givenFizzBuzz();

        fizzBuzz.printValue(5);

        verifyPrintValue("buzz");
    }

    @Test
    public void shouldReturnBuzzWhenNumberIsMultipleOf5() {
        FizzBuzz fizzBuzz = givenFizzBuzz();

        fizzBuzz.printValue(ANY_MULTIPLE_5);

        verifyPrintValue("buzz");
    }

    @Test
    public void shouldReturnFizzBuzzWhenNUmberIsMultipleOf3And5() {
        FizzBuzz fizzBuzz = givenFizzBuzz();

        fizzBuzz.printValue(ANY_NUMBER_3_AND_5);

        verifyPrintValue("fizzbuzz");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThroAnExceptionWhenNumberIsNegative() {
        FizzBuzz fizzBuzz = givenFizzBuzz();

        fizzBuzz.printValue(ANY_NEGATIVE_NUMBER);
    }

    private Object[] getNot3_5Input(){
        return new Object[]{
                new Object[]{1},
                new Object[]{2},
                new Object[]{6},
                new Object[]{7},
                new Object[]{8}
        };
    }


    private void verifyPrintValue(String value) {
        verify(outWriter).print(eq(value));
    }

}
