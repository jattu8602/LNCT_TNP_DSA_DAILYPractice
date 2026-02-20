// ✅ Example 1: Instance Method → Instance Variable/Method
// ✔ Direct access allowed

class Ex1_InstanceToInstance {
    int x = 10;           // instance variable

    void show() {
        System.out.println("Instance method accessing instance variable: x = " + x); // direct access ✔
    }

    public static void main(String[] args) {
        Ex1_InstanceToInstance obj = new Ex1_InstanceToInstance();
        obj.show();
    }
}
