// ✅ Constructor Example 7: What happens when NO constructor is written?
// → Java automatically provides a hidden "default constructor" (no-arg)
// → Instance variables get DEFAULT values:
//     int/byte/short/long → 0
//     float/double        → 0.0
//     boolean             → false
//     char                → '\u0000' (null char)
//     String/Object       → null

class Con7_DefaultValues {
    int num;
    double decimal;
    boolean flag;
    char letter;
    String text;

    // ❌ No constructor written — Java provides one automatically!

    void display() {
        System.out.println("int     default: " + num);
        System.out.println("double  default: " + decimal);
        System.out.println("boolean default: " + flag);
        System.out.println("char    default: '" + letter + "' (null char)");
        System.out.println("String  default: " + text);
    }

    public static void main(String[] args) {
        Con7_DefaultValues obj = new Con7_DefaultValues(); // Java auto-calls hidden default constructor
        System.out.println("--- Default values assigned by Java ---");
        obj.display();

        System.out.println("\n⚠ If you define ANY constructor, Java removes the auto default constructor!");
    }
}
