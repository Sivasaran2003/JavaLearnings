package lld.structuralPatterns.compositePattern;

public class Main {

    public static void main(String[] args) {

        File file1 = new File("file1.txt");
        File file2 = new File("file2.txt");

        Folder folder1 = new Folder("Documents");
        folder1.add(file1);
        folder1.add(file2);

        File file3 = new File("file3.txt");

        Folder root = new Folder("Root");
        root.add(folder1);
        root.add(file3);

        root.showDetails();
    }
}