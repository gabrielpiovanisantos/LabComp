
class A {

   public int get_A() {
   }

   public void init() {
       =       1 ;
   }

}

class B: public  A {

   public int get_B() {
   }

   public void init() {
       ;
       =       2 ;
   }

}

class C: public  B {

   public int get_C() {
   }

   public void init() {
       ;
       =       3 ;
   }

}

class D: public  C {

   public int get_D() {
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
      cout << d.get_D      c = d ;
      cout << c.get_C      b = c ;
      cout << b.get_B      a = b ;
      cout << a.get_A   }

}

