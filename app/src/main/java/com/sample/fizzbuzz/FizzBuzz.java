package com.sample.fizzbuzz;

class FizzBuzz {

    private final OutWriter outWriter;

    public FizzBuzz(OutWriter outWriter){
        this.outWriter = outWriter;
    }

    private static final String FIZZ = "fizz";
    private static final int FIZZ_VALUE = 3;
    private static final String BUZZ = "buzz";
    private static final int BUZZ_VALUE = 5;
    private static final String FIZZ_BUZZ = "fizzbuzz";

    private String getValue(int number) {
        if(number <0){
            throw  new IllegalArgumentException("the number must be positive");
        }

        String response = "";

        response = addFizz(number, response);

        response = addBuzz(number, response);

        if(response.isEmpty()){
            response = "" + number;
        }

        return response;
    }


    public void printValue(int number) {
        outWriter.print(getValue(number));
    }

    private String addFizz(int number, String response) {
        if (isMultiple(number, FIZZ_VALUE)) {
            response += FIZZ;
        }
        return response;
    }

    private String addBuzz(int number, String response) {
        if (isMultiple(number, BUZZ_VALUE)) {
            response += BUZZ;
        }
        return response;
    }

    private boolean isMultiple(int number, int multipleValue) {
        return number % multipleValue == 0;
    }

}
