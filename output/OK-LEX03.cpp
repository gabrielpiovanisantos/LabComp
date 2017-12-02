#include <iostream>
using namespace std;
class A {
public: 
      virtual void m() {
      }

}

class Program {
public: 
      virtual void run() {
         A a ;
         a =          new A() ;
         a.m ;
      }

}

