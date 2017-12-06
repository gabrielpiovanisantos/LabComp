#include <iostream>
#include <new>
using namespace std;
class A {

private: 
int *n;
int *k;
public: 
      virtual int m() {
         this->m2(         0) ;
         return this->m1() + this->k() ;
      }

      virtual void init() {
         this->k() =          1 ;
         this->n() =          0 ;
      }

};

int main() {
   A *a ;
   a =    new A ;
   cout << a->m();
}


