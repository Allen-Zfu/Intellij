package singleDesignPattern;

/*
传统初始化fields：
getter
setter
直接生成class object
 */


//*builder pattern*/
public class User {
    private final String firstName; // required, and immutable
    private final String lastName; // required
    private final int age; //optional, but immutable
    private String phone; //optional, mutable
    private String address; //optional

    //User constructor (UserBuilder can access)
    private User(UserBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.phone = builder.phone;
        this.address = builder.address;
    }

    //'User' getter (User中只用getter，不再设置setter，而是通过UserBuilder完成)
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getAge() {
        return age;
    }
    public String getPhone() {
        return phone;
    }
    public String getAddress() {
        return address;
    }

    //'UserBuilder'负责'User'中fields （'User'的object只能通过'UserBuilder'来产生）
    public static class UserBuilder {
        private String firstName; // these two are required!
        private String lastName;
        private int age = 0; // default value is 0
        private String phone = ""; // default value is an empty string
        private String address; // default value is null

        public UserBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder age(int age) {
            this.age = age;
            return this;
        }

        public UserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public UserBuilder address(String address) {
            this.address = address;
            return this;
        }

        //生成'user'的一个object
        public User build() {
            if (firstName == null || lastName == null) {
                throw new IllegalArgumentException("required fields are not set!");
            }
            return new User(this);
        }
    }

    /*
    1.生成'UserBuilder' object
    2.'UserBuilder' object修改'user'中field的值（相当于setter）
    3.'UserBuilder' object调用build()，从而最终生成'User'的object
    */
    public static void main(String[] argv) {
        User user = new User.UserBuilder()
                .lastName("Zhang")
                .firstName("San")
                .age(25)
                .phone("1234567890")
                .address("Fake address")
                .build();  //
    }
}
