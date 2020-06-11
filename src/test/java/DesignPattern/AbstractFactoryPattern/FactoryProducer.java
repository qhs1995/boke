package DesignPattern.AbstractFactoryPattern;

import com.hongshen.boke.utils.StringUtils;

public class FactoryProducer {
    public static AbstractFactory getFactory(String factoryName){
        if (StringUtils.isBlank(factoryName)){
            return null;
        }
        if (factoryName.equals("shape")){
            return new ShapeFactory();
        }else if (factoryName.equals("color")){
            return new ColorFactory();
        }
        return null;
    }


    public static void main(String[] args) {
        AbstractFactory shape = FactoryProducer.getFactory("shape");
        Shape circle = shape.getShape("circle");
        circle.draw();
        Shape rectangle = shape.getShape("rectangle");
        rectangle.draw();
    }
}
