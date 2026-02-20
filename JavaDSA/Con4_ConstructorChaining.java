// ✅ Constructor Example 4: this() – Constructor Chaining
// → One constructor can call another constructor in the SAME class using this()
// → this() must be the FIRST statement in the constructor
// → Avoids code duplication

class Con4_ConstructorChaining {
    String name;
    int age;
    String city;

    // Constructor 1 – base constructor with all values
    Con4_ConstructorChaining(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
        System.out.println("Base constructor called → name=" + name + ", age=" + age + ", city=" + city);
    }

    // Constructor 2 – calls Constructor 1 with default city
    Con4_ConstructorChaining(String name, int age) {
        this(name, age, "Unknown");  // calls Constructor 1 ✔
        System.out.println("Constructor 2 chained ↑");
    }

    // Constructor 3 – calls Constructor 2 with default age and city
    Con4_ConstructorChaining(String name) {
        this(name, 0);  // calls Constructor 2 ✔
        System.out.println("Constructor 3 chained ↑");
    }

    void display() {
        System.out.println("→ Name: " + name + ", Age: " + age + ", City: " + city);
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("--- Creating obj1 (all values) ---");
        Con4_ConstructorChaining obj1 = new Con4_ConstructorChaining("Alice", 22, "Mumbai");
        obj1.display();

        System.out.println("--- Creating obj2 (name + age only) ---");
        Con4_ConstructorChaining obj2 = new Con4_ConstructorChaining("Bob", 25);
        obj2.display();

        System.out.println("--- Creating obj3 (name only) ---");
        Con4_ConstructorChaining obj3 = new Con4_ConstructorChaining("Charlie");
        obj3.display();
    }
}
