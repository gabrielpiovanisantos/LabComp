
class A {

   public void m() {
   }

}

class B extends A {

   public void m() {
   }

}

class C extends B {

   public void p() {
   }

}

class Program {

   public void run() {
      C c ;
      c = new C() ;
      c.m ;
   }

}

#include <iostream>
using namespace std;
class A {

public: 
      void m() {
      }

}

class B: public  A {

public: 
      void m() {
      }

}

class C: public  B {

public: 
      void p() {
      }

}

class Program {

public: 
      void run() {
         C c ;
         c =          new C() ;
         c.m; ;
      }

}

