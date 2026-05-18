package lld.behaviouralPatterns.visitorPattern;

import lombok.Data;

@Data
public class Circle implements Shape {
    private int radius;
    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visit(this);
    }
}
