
class Test6{
  static void display(){
    this.show(1);
    System.out.println("Hello");
  }
  void show(int a){

    System.out.println("Bye");
  }



  public static void main(String[] args){
    Test6 t1 = new Test6();
    t1.display();


  }
}
