
class A {

   public void first(int pn) {
   }

}

class B extends A {

   public void second() {
   }

}

class C extends B {

   public void third() {
   }

}

class Program {

   public void run() {
      A a ;
      B b ;
      C c ;
      a = new A() ;
      b = new B() ;
      c = new C() ;
      a.first( 0 ) ;
      b.first( 0 ) ;
      c.first( 0 ) ;
      b.second ;
      c.second ;
      c.third ;
      a = b ;
      a = c ;
      b = c ;
   }

}

#include <iostream>
using namespace std;
class A {

public: 
      void first() {
      }

}

class B: public  A {

public: 
      void second() {
      }

}

class C: public  B {

public: 
      void third() {
      }

}

class Program {

public: 
      void run() {
         A a ;
         B b ;
         C c ;
         a =          new A() ;
         b =          new B() ;
         c =          new C() ;
         a.first(          0 ); ;
         b.first(          0 ); ;
         c.first(          0 ); ;
         b.second; ;
         c.second; ;
         c.third; ;
         a = b ;
         a = c ;
         b = c ;
      }

}

