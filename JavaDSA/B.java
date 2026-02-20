class A{
  A(){
    this(10);
    System.out.println("Parent Constructor - 1 ");
  }
  A(int a){

    System.out.println("Parent Constructor - - 2 ");


  }

}
class B extends A{

   B(){
      //  Super() automatically
      super();

      System.out.println("Child constructor ");
    }
  public static void main(String[] args){


      B obj = new B();


  }
}


// hw
// - polymoriphm , abstraction ,

// - encapsulation ,

//  raat ko 8 baje - object oriented programming ka test hoga





