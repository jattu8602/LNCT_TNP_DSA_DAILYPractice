// Constructor

class Test{
  // Test(){

  // } autocreated on compile time
  int a ;
  Test(){
    System.out.println("Constructor");

  }





  public static void main(String[] args){
    Test t = new Test();

    System.out.println(t.a); // auto assigns 0  - assigned by the compiler
  }



}













