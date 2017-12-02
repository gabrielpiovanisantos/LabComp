#include <iostream>
using namespace std;
class A {
public: 
      virtual void m() {
      }

}

class B: public  A {
public: 
      virtual void m() {
      }

}

class C: public  B {
public: 
      virtual void p() {
      }

}

class Program {
public: 
      virtual void run() {
         C c ;
         c =          new C() ;
         c.m ;
      }

}

