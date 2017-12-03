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

virtual void main() {
   A a ;
   a =    new A() ;
   a.m ;
}


