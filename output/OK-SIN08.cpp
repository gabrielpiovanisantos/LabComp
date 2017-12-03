#include <iostream>
using namespace std;
class A {
public: 
      virtual int m() {
         return x + y ;
      }

}

virtual void main() {
   A a ;
   a =    new A() ;
   cout << a.m(    3,    4, true );
}


