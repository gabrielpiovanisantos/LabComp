#include <iostream>
#include <new>
using namespace std;
class A {

private: 
int *i;
public: 
      virtual void put() {
      }

};

class B: public  A {
public: 
      virtual void put() {
      }

};

int main() {
   A *a ;
   a =    new A ;
   a->put(   0,    1, true) ;
}


