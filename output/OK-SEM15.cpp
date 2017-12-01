
class A {

   public void print() {
      write( 0 );
   }

   public void accept(A x) {
      x.print ;
   }

}

class B extends A {

   public void m() {
      super.accept (this ) ;
   }

}

class Program {

   public void run() {
      B b ;
      b = new B() ;
      b.m ;
   }

}

#include <iostream>
using namespace std;
class A {

public: 
      void print() {
         cout <<          0;
      }

      void accept() {
         x.print; ;
      }

}

class B: public  A {

public: 
      void m() {
         A::accept( this;)
 ;
      }

}

class Program {

public: 
      void run() {
         B b ;
         b =          new B() ;
         b.m; ;
      }

}

