package com.jalasoft.ocrwebservice.validation;

public class RangeValidation implements IValidateStrategy{
    private int min;
    private int max;
    public RangeValidation(int max,int min){
        this.max = max;
        this.min = min;
    }

    @Override
    public boolean validate() {
        if(this.min > this.max){
            return false;
        }
        return true;
    }
}
