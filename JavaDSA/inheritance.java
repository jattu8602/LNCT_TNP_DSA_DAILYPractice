class A {
  int a = 100 ;


}
class B extends A{
  int b = 200;

  public static void main(String [] args){
    A a = new A();

  }

}

// B is a A
// parent  , super , base  , A <----------------------------------- B , child , sub , derieved
// code reusability can be possible via inheritance
//

//  in java  every class ka base class object class hota hai
//   extends Object can be written or not  - its not required
class Test extends Object {
  public static void main(String[] args){


  }
}


class A extends Object {

}
class B extends A{

}

----------------------------------------------------------------------------
//  java does not supports cyclic inheritance

// class A extends B {

// }
// class B extends A{

// }
----------------------------------------------------------------------------------
//  we cant create child class of final class
// final class A {

// }
// class B extends A{

// }


 class A {

}
final class B extends A{                  // correct

}
//  extends represents - > is a relationship
-------------------------------------------------------------------------
//  Types of inheritance  :

1. Single
2. Multiple                 // java does not supports multiple inheritance via class , but we can achieve it via interface
3. MultiLevel
4. Hirearchical
5. Hybrid

-----------------------------------------------------------------------------------




















