#include <iostream>
using namespace std;
class A {

private: 
int *i;
public: 
      virtual void put() {
      }

}

class B: public  A {
public: 
      virtual void put() {
      }

}

virtual void main() {
   A a ;
   a =    new A() ;
   a.put(    0,    1, true ) ;
}


