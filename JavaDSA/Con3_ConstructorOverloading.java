// ✅ Constructor Example 3: Constructor Overloading
// → Multiple constructors with different parameters in the same class
// → Java picks the right one based on arguments you pass

class Con3_ConstructorOverloading {
    String name;
    int age;
    String city;

    // Constructor 1 – no arguments
    Con3_ConstructorOverloading() {
        name = "Unknown";
        age = 0;
        city = "Unknown";
        System.out.println("Constructor 1 called (no args)");
    }

    // Constructor 2 – name and age
    Con3_ConstructorOverloading(String name, int age) {
        this.name = name;
        this.age = age;
        this.city = "Unknown";
        System.out.println("Constructor 2 called (name + age)");
    }

    // Constructor 3 – name, age and city
    Con3_ConstructorOverloading(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
        System.out.println("Constructor 3 called (name + age + city)");
    }

    void display() {
        System.out.println("Name: " + name + ", Age: " + age + ", City: " + city);
    }

    public static void main(String[] args) {
        Con3_ConstructorOverloading obj1 = new Con3_ConstructorOverloading();
        Con3_ConstructorOverloading obj2 = new Con3_ConstructorOverloading("Alice", 22);
        Con3_ConstructorOverloading obj3 = new Con3_ConstructorOverloading("Bob", 25, "Delhi");

        obj1.display();
        obj2.display();
        obj3.display();
    }
}
