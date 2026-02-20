class A {
  int a = 100 ;


}
class B extends A{
  int b = 200;

  public static void main(String [] args){
    A a = new B();         //  A can use b  object in his class

    B obj = new B();
    S.o.p(obj.b);
    //  scope of objects in inheritance

  }

}



class-name obj-name  = new constructor-name();
---------   ---------------------------------
  1. use             2. object

  Best t1 = new Test();
  ---  ---------------




-------------------------------------------------------------------------------

P = Parent
C = Child

P p  = new p ();  p => parent can use this
C c = new C();    c => child  + parent both can use this
P c = new C();      c=> child ka object  hai , parent can use this
// C p = new P();       here incorrect - because parent ka object child use nahi kar sakta


-----------------------------------------------------------------------------------------




















