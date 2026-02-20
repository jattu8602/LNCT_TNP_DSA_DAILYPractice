// ✅ Example 4: Static Method → Static Variable/Method
// ✔ Allowed directly

class Ex4_StaticToStatic {
    static int x = 10;   // static variable

    static void show() {
        System.out.println("Static method accessing static variable: x = " + x); // direct access ✔
    }

    public static void main(String[] args) {
        show(); // static method called directly
    }
}
