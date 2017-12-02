#include <iostream>
using namespace std;
class A {
public: 
      virtual void m() {
         int i ;
         i =          1 ;
         cout << i;
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

