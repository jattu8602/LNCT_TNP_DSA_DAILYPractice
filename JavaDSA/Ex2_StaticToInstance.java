// ✅ Example 2: Static Method → Instance Variable/Method
// ❌ Not directly allowed
// ✔ Must create object first

class Ex2_StaticToInstance {
    int x = 10;           // instance variable

    static void show() {
        // System.out.println(x); // ❌ ERROR: non-static variable x cannot be referenced from a static context
        Ex2_StaticToInstance obj = new Ex2_StaticToInstance(); // must create object ✔
        System.out.println("Static method accessing instance variable via object: x = " + obj.x);
    }

    public static void main(String[] args) {
        show(); // static method called directly
    }
}
