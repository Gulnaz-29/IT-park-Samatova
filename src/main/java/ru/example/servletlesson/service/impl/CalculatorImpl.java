package ru.example.servletlesson.service.impl;

import ru.example.servletlesson.service.Calculator;

public class CalculatorImpl implements Calculator {
    @Override
    public int sum(int a, int b){
        return a+b;
    }

    @Override
    public int minus(int a, int b){
        return a-b;
    }

    @Override
    public int mult(int a, int b){
        return a*b;
    }

    @Override
    public int div(int a, int b){
        return a/b;
    }

}
