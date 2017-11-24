
class A {

   public int get_A() {
      return  ;
   }

   public void init() {
       =       1 ;
   }

}

class B: public  A {

   public int get_B() {
      return  ;
   }

   public void init() {
       ;
       =       2 ;
   }

}

class C: public  B {

   public int get_C() {
      return  ;
   }

   public void init() {
       ;
       =       3 ;
   }

}

class D: public  C {

   public int get_D() {
      return  ;
   }

   public void init() {
       ;
       =       4 ;
   }

}

class Program {

   public void run() {
      A a ;
      B b ;
      C c ;
      D d ;
      cout <<       cout << Ok-ger14      cout << The output should be :      cout << 4 3 2 1      d =  ;
       ;
      cout << ;
      c = d ;
      cout << ;
      b = c ;
      cout << ;
      a = b ;
      cout << ;
   }

}

