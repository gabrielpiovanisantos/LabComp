#include <iostream>
#include <new>
using namespace std;
class A {
public: 
      virtual void first(int pn) {
      }

};

class B: public  A {
public: 
      virtual void second() {
      }

};

class C: public  B {
public: 
      virtual void third() {
      }

};

class Program {
public: 
};
      int main() {
         A *a;
         B *b;
         C *c;
         a = new A;
         b = new B;
         c = new C;
         a->first(0);
         b->first(0);
         c->first(0);
         b->second();
         c->second();
         c->third();
         a = b;
         a = c;
         b = c;
      }


