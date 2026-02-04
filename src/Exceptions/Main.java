package Exceptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public void method1() throws IOException {
        String fileName = "file";
        FileInputStream file = new FileInputStream(fileName);
    }

    public void method2() {
        try {
            String fileName = "file";
            FileInputStream file = new FileInputStream(fileName);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println();
        }
    }

    public void method3() throws WrongCalculationException, Exception{
        // only Exception is used since it covers many / overall exceptions
        try {
            method1(); // either added in try block or add throws in curr method's signature
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        a++;
        if(a != 2) {
            throw new WrongCalculationException(); // must be included in header signature
        }
    }

    public void method4() throws Exception{
        method1(); // add throws in method signature
        method2();
    }

    public static void main() throws Exception {
        try {
            int a = 1 / 0;
            System.out.println(a);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        /**
         * ordering must from most specific to most generic
         * Exception
         *      |
         * Runtime Exception
         *      |
         *  Arithmetic Exception
         */
//        catch (ArithmeticException e) { // already caught - exception
//            System.out.println(e.getMessage());
//        }

        new Main().method3();
    }
}
