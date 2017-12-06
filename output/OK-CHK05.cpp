#include <iostream>
#include <new>
using namespace std;
class A {
public: 
      virtual void m() {
      }

};

class B: public  A {
public: 
      virtual void m() {
      }

};

class C: public  B {
public: 
      virtual void p() {
      }

};

int main() {
   C *c ;
   c =    new C ;
   c->m() ;
}


