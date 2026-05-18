package lld.behaviouralPatterns.visitorPattern;

import lombok.Data;

@Data
public class Rectangle implements Shape {
    private int length;
    private int breadth;

    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visit(this);
    }
}
