package DesignPattern.AbstractFactoryPattern;

import com.hongshen.boke.utils.StringUtils;

public class ColorFactory extends AbstractFactory{
    @Override
    public Color getColor(String color) {
        if (StringUtils.isBlank(color)){
            return null;
        }
        if (color.equals("red")){
            return new RedColorImpl();
        }else if (color.equals("green")){
            return new GreenColorImpl();
        }
        return null;
    }

    @Override
    public Shape getShape(String shape) {
        return null;
    }
}
