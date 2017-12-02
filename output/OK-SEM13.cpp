#include <iostream>
using namespace std;
class A {
public: 
      virtual void m() {
      }

      virtual void p() {
         int m ;
      }

}

class Program {
public: 
      virtual void run() {
         A a ;
         a =          new A() ;
         a.p ;
      }

}

