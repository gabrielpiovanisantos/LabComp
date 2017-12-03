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

virtual void main() {
   A a ;
   a =    new A() ;
   a.p ;
}


