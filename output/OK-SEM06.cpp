#include <iostream>
#include <new>
using namespace std;
class A {

private: 
int *n;
public: 
      virtual void set() {
         int *n ;
         this->n() = pn ;
      }

      virtual int put() {
         int *put ;
         this->n() = n ;
         return n ;
      }

};

int main() {
   A *a ;
   a =    new A ;
   a->set(   0) ;
}


