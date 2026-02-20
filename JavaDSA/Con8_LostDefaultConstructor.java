// ✅ Constructor Example 8: ⚠ Losing the Auto Default Constructor
// → When you write ANY constructor, Java STOPS providing the automatic default one
// → You must explicitly add a no-arg constructor if you still want it

class Con8_LostDefaultConstructor {
    String name;
    int age;

    // ✅ We wrote a parameterized constructor
    Con8_LostDefaultConstructor(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // ✅ We HAVE to manually add no-arg constructor if needed
    Con8_LostDefaultConstructor() {
        this.name = "Default";
        this.age = 0;
        System.out.println("Manually written no-arg constructor — because we also have parameterized one!");
    }

    void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    public static void main(String[] args) {
        // ✔ Works because we manually added no-arg constructor
        Con8_LostDefaultConstructor obj1 = new Con8_LostDefaultConstructor();
        // ✔ Works because parameterized constructor exists
        Con8_LostDefaultConstructor obj2 = new Con8_LostDefaultConstructor("Alice", 22);

        obj1.display();
        obj2.display();

        System.out.println("\n⚠ If you delete the no-arg constructor above,");
        System.out.println("   Con8_LostDefaultConstructor() would give COMPILE ERROR!");
    }
}
