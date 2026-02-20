// ✅ Constructor Example 1: Default Constructor
// → Java automatically provides a no-arg constructor if you don't write any
// → You can also write your own default constructor

class Con1_DefaultConstructor {
    String name;
    int age;

    // Default constructor (no parameters)
    Con1_DefaultConstructor() {
        name = "Unknown";
        age = 0;
        System.out.println("Default constructor called!");
    }

    void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    public static void main(String[] args) {
        Con1_DefaultConstructor obj = new Con1_DefaultConstructor(); // calls default constructor
        obj.display();
    }
}
