// ✅ Example 3: Instance Method → Static Variable/Method
// ✔ Allowed directly

class Ex3_InstanceToStatic {
    static int x = 10;   // static variable

    void show() {
        System.out.println("Instance method accessing static variable: x = " + x); // direct access ✔
    }

    public static void main(String[] args) {
        Ex3_InstanceToStatic obj = new Ex3_InstanceToStatic();
        obj.show();
    }
}
