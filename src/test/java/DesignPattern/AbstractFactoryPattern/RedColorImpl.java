package DesignPattern.AbstractFactoryPattern;

public class RedColorImpl implements Color{
    @Override
    public void fill() {
        System.out.println("Im RedColorImpl");
    }
}
