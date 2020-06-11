package DesignPattern.AbstractFactoryPattern;

import com.hongshen.boke.utils.StringUtils;

public class ShapeFactory extends AbstractFactory{
    @Override
    public Color getColor(String color) {
        return null;
    }

    @Override
    public Shape getShape(String shape) {
        if (StringUtils.isBlank(shape)){
            return null;
        }
        if (shape.equals("circle")){
            return new CircleShapeImpl();
        }else if (shape.equals("rectangle")){
            return new RectangleShapeImpl();
        }
        return null;
    }
}
