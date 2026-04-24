package lld.structuralPatterns.compositePattern;

import java.util.ArrayList;
import java.util.List;

class Folder implements FileSystemComponent {

    private String name;
    private List<FileSystemComponent> components = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void add(FileSystemComponent component) {
        components.add(component);
    }

    public void remove(FileSystemComponent component) {
        components.remove(component);
    }

    public void showDetails() {
        System.out.println("Folder: " + name);

        for (FileSystemComponent component : components) {
            component.showDetails();
        }
    }
}
