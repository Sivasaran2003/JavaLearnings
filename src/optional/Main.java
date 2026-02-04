package optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        
        // ========== 1. Creating Optional Objects ==========
        System.out.println("=== Creating Optional Objects ===");
        
        // Optional.of() - throws NullPointerException if value is null
        Optional<String> optional1;
        System.out.println("Optional.of(\"Hello\"): " + optional1);
        
        // Optional.ofNullable() - safe for null values
        Optional<String> optional2 = Optional.ofNullable("World");
        Optional<String> optional3 = Optional.ofNullable(null); // Safe!
        System.out.println("Optional.ofNullable(\"World\"): " + optional2);
        System.out.println("Optional.ofNullable(null): " + optional3);
        
        // Optional.empty() - creates an empty Optional
        Optional<String> optional4 = Optional.empty();
        System.out.println("Optional.empty(): " + optional4);
        
        System.out.println();
        
        
        // ========== 2. Checking if Optional has a value ==========
        System.out.println("=== Checking if Optional has a value ===");
        
        Optional<String> name = Optional.of("Siva");
        Optional<String> emptyName = Optional.empty();
        
        // isPresent() - checks if value exists
        System.out.println("name.isPresent(): " + name.isPresent()); // true
        System.out.println("emptyName.isPresent(): " + emptyName.isPresent()); // false
        
        // isEmpty() - checks if Optional is empty (Java 11+)
        System.out.println("name.isEmpty(): " + name.isEmpty()); // false
        System.out.println("emptyName.isEmpty(): " + emptyName.isEmpty()); // true
        
        System.out.println();
        
        
        // ========== 3. Getting values from Optional ==========
        System.out.println("=== Getting values from Optional ===");
        
        Optional<String> value = Optional.of("Java");
        
        // get() - throws NoSuchElementException if empty (use carefully!)
        System.out.println("value.get(): " + value.get());
        
        // orElse() - returns default value if empty
        Optional<String> empty = Optional.empty();
        String result1 = empty.orElse("Default Value");
        System.out.println("empty.orElse(\"Default Value\"): " + result1);
        
        // orElseGet() - uses Supplier for default value (lazy evaluation)
        String result2 = empty.orElseGet(() -> "Computed Default");
        System.out.println("empty.orElseGet(() -> \"Computed Default\"): " + result2);
        
        // orElseThrow() - throws exception if empty
        try {
            String result3 = empty.orElseThrow(() -> new RuntimeException("Value not found"));
        } catch (RuntimeException e) {
            System.out.println("orElseThrow() threw: " + e.getMessage());
        }
        
        System.out.println();
        
        
        // ========== 4. ifPresent() - Execute action if value exists ==========
        System.out.println("=== ifPresent() - Execute action if value exists ===");
        
        Optional<String> present = Optional.of("Hello World");
        Optional<String> absent = Optional.empty();
        
        // ifPresent() - executes Consumer if value exists
        present.ifPresent(str -> System.out.println("Value is: " + str));
        absent.ifPresent(str -> System.out.println("This won't print"));
        
        // ifPresentOrElse() - execute action if present, else run another (Java 9+)
        present.ifPresentOrElse(
            str -> System.out.println("Present: " + str),
            () -> System.out.println("Not present")
        );
        absent.ifPresentOrElse(
            str -> System.out.println("Present: " + str),
            () -> System.out.println("Not present - this will print")
        );
        
        System.out.println();
        
        
        // ========== 5. map() - Transform Optional value ==========
        System.out.println("=== map() - Transform Optional value ===");
        
        Optional<String> str = Optional.of("hello");
        
        // map() - transforms value if present, returns empty Optional if not
        Optional<String> upperCase = str.map(s -> s.toUpperCase());
        System.out.println("str.map(s -> s.toUpperCase()): " + upperCase.get());
        
        Optional<Integer> length = str.map(s -> s.length());
        System.out.println("str.map(s -> s.length()): " + length.get());
        
        Optional<String> emptyStr = Optional.empty();
        Optional<String> mappedEmpty = emptyStr.map(s -> s.toUpperCase());
        System.out.println("emptyStr.map() is empty: " + mappedEmpty.isEmpty());
        
        System.out.println();
        
        
        // ========== 6. flatMap() - Flatten nested Optional ==========
        System.out.println("=== flatMap() - Flatten nested Optional ===");
        
        // Problem: map() would return Optional<Optional<String>>
        Optional<String> name2 = Optional.of("Siva");
        Optional<Optional<String>> nested = name2.map(n -> Optional.of(n.toUpperCase()));
        
        // Solution: flatMap() flattens it to Optional<String>
        Optional<String> flattened = name2.flatMap(n -> Optional.of(n.toUpperCase()));
        System.out.println("flatMap() result: " + flattened.get());
        
        // Example: Method returning Optional
        Optional<String> result = name2.flatMap(Main::getUpperCaseOptional);
        System.out.println("flatMap() with method reference: " + result.get());
        
        System.out.println();
        
        
        // ========== 7. filter() - Filter Optional value ==========
        System.out.println("=== filter() - Filter Optional value ===");
        
        Optional<Integer> number = Optional.of(10);
        Optional<Integer> filtered = number.filter(n -> n > 5);
        System.out.println("number.filter(n -> n > 5): " + filtered.get());
        
        Optional<Integer> filtered2 = number.filter(n -> n > 20);
        System.out.println("number.filter(n -> n > 20) is empty: " + filtered2.isEmpty());
        
        Optional<String> text = Optional.of("Java");
        Optional<String> filteredText = text.filter(t -> t.length() > 3);
        System.out.println("text.filter(t -> t.length() > 3): " + filteredText.get());
        
        System.out.println();
        
        
        // ========== 8. Combining Optional with Streams ==========
        System.out.println("=== Combining Optional with Streams ===");
        
        List<Optional<String>> list = new ArrayList<>();
        list.add(Optional.of("Apple"));
        list.add(Optional.empty());
        list.add(Optional.of("Banana"));
        list.add(Optional.of("Cherry"));
        list.add(Optional.empty());
        
        // Filter out empty Optionals and get values
        List<String> presentValues = list.stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
        System.out.println("Present values: " + presentValues);
        
        // Using flatMap to filter and map in one step
        List<String> values = list.stream()
                .flatMap(opt -> opt.map(List::of).orElse(List.of()))
                .toList();
        System.out.println("Values using flatMap: " + values);
        
        // Using Optional's stream() method (Java 9+)
        List<String> values2 = list.stream()
                .flatMap(Optional::stream)
                .toList();
        System.out.println("Values using Optional::stream: " + values2);
        
        System.out.println();
        
        
        // ========== 9. Practical Example: Safe method chaining ==========
        System.out.println("=== Practical Example: Safe method chaining ===");
        
        // Without Optional (NullPointerException risk)
        Person person = new Person("John", new Address("123 Main St"));
        // Person person2 = new Person("Jane", null); // Would cause NPE
        
        // With Optional (safe)
        Person safePerson = new Person("Jane", null);
        String street = safePerson.getAddress()
                .map(Address::getStreet)
                .orElse("No address");
        System.out.println("Street: " + street);
        
        // Chaining multiple Optional operations
        Optional<String> resultChain = safePerson.getAddress()
                .map(Address::getStreet)
                .filter(s -> s.length() > 5)
                .map(String::toUpperCase);
        System.out.println("Chained result: " + resultChain.orElse("No valid address"));
        
    }
    
    // Helper method for flatMap example
    private static Optional<String> getUpperCaseOptional(String str) {
        return Optional.of(str.toUpperCase());
    }
    
    // Helper classes for practical example
    static class Person {
        private String name;
        private Address address;
        
        public Person(String name, Address address) {
            this.name = name;
            this.address = address;
        }
        
        public Optional<Address> getAddress() {
            return Optional.ofNullable(address);
        }
    }
    
    static class Address {
        private String street;
        
        public Address(String street) {
            this.street = street;
        }
        
        public String getStreet() {
            return street;
        }
    }
}
