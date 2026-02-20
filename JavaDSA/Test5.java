class Test5{
  void display(){
    this.show(1);
    System.out.println("Hello");
  }
  static void show(int a){

    System.out.println("Bye");
  }



  public static void main(String[] args){
    Test5 t1 = new Test5();
    t1.display();


  }
}

//  we cannot use this  in static method - below is the example similar to above

class Test6{
  void display(){
    this.show(1);
    System.out.println("Hello");
  }
  static void show(int a){

    System.out.println("Bye");
  }



  public static void main(String[] args){
    Test6 t1 = new Test6();
    t1.display();


  }
}


