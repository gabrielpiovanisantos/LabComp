#include <iostream>
using namespace std;
class A {

private: 
public: 
      virtual int m() {
         return x + y ;
      }

}

class Program {

private: 
public: 
      virtual void run() {
         A a ;
         a =          new A() ;
         cout << a.m(          3,          4, true );;
      }

}

