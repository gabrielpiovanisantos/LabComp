#include <iostream>
#include <new>
using namespace std;
class A {
public: 
      virtual void A() {
      }

};

int main() {
   A *a ;
   a =    new A ;
   a->A() ;
}


