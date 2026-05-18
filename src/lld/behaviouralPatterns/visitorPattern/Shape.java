package lld.behaviouralPatterns.visitorPattern;

public interface Shape {
    void accept(ShapeVisitor visitor);
}
