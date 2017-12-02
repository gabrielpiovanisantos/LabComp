#include <iostream>
using namespace std;
class A {
public: 
      virtual void print() {
         cout <<          0;
      }

      virtual void accept() {
         x.print ;
      }

}

class B: public  A {
public: 
      virtual void m() {
         A::accept( this)
 ;
      }

}

class Program {
public: 
      virtual void run() {
         B b ;
         b =          new B() ;
         b.m ;
      }

}

