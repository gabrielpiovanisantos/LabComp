#include <iostream>
#include <new>
using namespace std;
class A {
public: 
      virtual void m() {
      }

      virtual void p() {
         int *m ;
      }

};

int main() {
   A *a ;
   a =    new A ;
   a->p() ;
}


