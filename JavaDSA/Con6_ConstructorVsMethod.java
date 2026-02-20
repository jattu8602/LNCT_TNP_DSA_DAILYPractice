// ✅ Constructor Example 6: Constructor vs Method – Key Differences
// → Constructors are special: same name as class, no return type, called only at object creation
// → Methods are regular functions: any name, must have return type, called explicitly

class Con6_ConstructorVsMethod {
    String model;
    int speed;

    // ✅ CONSTRUCTOR — no return type, same name as class, called once at creation
    Con6_ConstructorVsMethod(String model, int speed) {
        this.model = model;
        this.speed = speed;
        System.out.println("Constructor called → Car created: " + model + " at " + speed + " kmph");
    }

    // ✅ METHOD — has return type (void), different name, called explicitly anytime
    void accelerate(int increase) {
        speed += increase;
        System.out.println("Method called → " + model + " accelerated! New speed: " + speed + " kmph");
    }

    // ✅ METHOD with return type
    int getSpeed() {
        return speed;
    }

    public static void main(String[] args) {
        System.out.println("--- Creating object (constructor runs automatically) ---");
        Con6_ConstructorVsMethod car = new Con6_ConstructorVsMethod("Tesla", 60);

        System.out.println("\n--- Calling methods explicitly ---");
        car.accelerate(40);
        car.accelerate(20);

        System.out.println("\nFinal speed from method: " + car.getSpeed() + " kmph");

        System.out.println("\n--- Key Differences ---");
        System.out.println("Constructor: same name as class, no return type, auto-called at new");
        System.out.println("Method     : any name, must have return type, explicitly called");
    }
}
