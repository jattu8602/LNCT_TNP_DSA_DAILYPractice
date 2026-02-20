// ✅ Constructor Example 5: Copy Constructor
// → Creates a new object as a copy of an existing object
// → Java doesn't provide a built-in copy constructor — you write it yourself
// → Changes to the copy do NOT affect the original

class Con5_CopyConstructor {
    String name;
    int age;

    // Parameterized constructor
    Con5_CopyConstructor(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Copy constructor – takes another object as parameter
    Con5_CopyConstructor(Con5_CopyConstructor other) {
        this.name = other.name;   // copies values from other object
        this.age = other.age;
        System.out.println("Copy constructor called! Copying from: " + other.name);
    }

    void display(String label) {
        System.out.println(label + " → Name: " + name + ", Age: " + age);
    }

    public static void main(String[] args) {
        Con5_CopyConstructor original = new Con5_CopyConstructor("Alice", 22);
        Con5_CopyConstructor copy = new Con5_CopyConstructor(original); // copy constructor ✔

        original.display("Original");
        copy.display("Copy    ");

        System.out.println("\n--- Modifying copy (original should NOT change) ---");
        copy.name = "Bob";
        copy.age = 30;

        original.display("Original (after modifying copy)");
        copy.display("Copy     (after modification)    ");
    }
}
