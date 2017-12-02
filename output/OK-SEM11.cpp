#include <iostream>
using namespace std;
class A {
public: 
      virtual void A() {
      }

}

class Program {
public: 
      virtual void run() {
         A a ;
         a =          new A() ;
         a.A ;
      }

}

