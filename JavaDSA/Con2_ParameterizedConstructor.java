// ✅ Constructor Example 2: Parameterized Constructor
// → You pass values while creating the object
// → Initializes object with specific data right away

class Con2_ParameterizedConstructor {
    String name;
    int age;

    // Parameterized constructor
    Con2_ParameterizedConstructor(String name, int age) {
        this.name = name;   // this.name = instance variable, name = parameter
        this.age = age;
        System.out.println("Parameterized constructor called!");
    }

    void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    public static void main(String[] args) {
        Con2_ParameterizedConstructor obj1 = new Con2_ParameterizedConstructor("Alice", 22);
        Con2_ParameterizedConstructor obj2 = new Con2_ParameterizedConstructor("Bob", 25);

        obj1.display();
        obj2.display();
    }
}
