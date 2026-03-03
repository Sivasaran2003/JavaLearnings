package lld.creationalPatterns.builder;

public class User {

    private String name;
    private String email;
    private String phone;
    private int age;
    private String address;
    private boolean verified;

    public User(Builder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.phone = builder.phone;
        this.age = builder.age;
        this.address = builder.address;
        this.verified = builder.verified;
    }

    public static class Builder {

        private String name;
        private String email;
        private String phone;
        private int age;
        private String address;
        private boolean verified;

//        public Builder(String name, String email) {
//            this.name = name;
//            this.email = email;
//        }
//        if some fields need to be mandatory - use this
//        User user = new User.Builder("Siva", "mail")
//        .age(25)
//        .build();

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder verified(boolean verified) {
            this.verified = verified;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}

/**
 * also useful when the object data shld be immutable
 * - make attributes final
 * - make constructor private
 * if object created with certain fields, its immutable
 */