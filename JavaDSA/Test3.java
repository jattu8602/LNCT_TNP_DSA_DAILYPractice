class Test3{
  int a;
  Test3(int b){         // ✅ constructor name matches class name
    a = b;              // instance variable = local variable
                        // ✅ no return statement
  }
  public static void main(String[] args){
    Test3 t1 = new Test3(10);
    System.out.println(t1.a);
  }
}