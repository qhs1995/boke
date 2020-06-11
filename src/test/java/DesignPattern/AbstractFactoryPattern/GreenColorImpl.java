package DesignPattern.AbstractFactoryPattern;

public class GreenColorImpl implements Color{
    @Override
    public void fill() {
        System.out.println("Im GreenColorImpl");
    }
}
