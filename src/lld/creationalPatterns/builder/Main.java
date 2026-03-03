package lld.creationalPatterns.builder;

public class Main {
    public static void main(String args[]) {
        User user = User.builder()
                .name("Sivasaran")
                .phone("9080418110")
                .email("sivasarancbe.2003@gmail.com")
                .age(23)
                .build();
    }
}


/**
 *
 * Ex : Spring’s ResponseEntity
 * ResponseEntity.ok()
 *     .header("X-Id", "123")
 *     .body(data);
 *
 * Builder style.
 */