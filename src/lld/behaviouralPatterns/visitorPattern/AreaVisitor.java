package lld.behaviouralPatterns.visitorPattern;

public class AreaVisitor implements ShapeVisitor {
    @Override
    public void visit(Circle circle) {
        System.out.println(circle.getRadius() * circle.getRadius() * 3.14);
    }

    @Override
    public void visit(Rectangle rectangle) {
        System.out.println(rectangle.getLength() * rectangle.getBreadth());
    }
}
