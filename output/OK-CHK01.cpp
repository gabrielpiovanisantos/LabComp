#include <iostream>
#include <new>
using namespace std;
class A {
public: 
      virtual void m1() {
      }

      virtual void m2() {
      }

};

class B: public  A {
public: 
      virtual void m3() {
      }

      virtual void m4() {
      }

};

class C {
public: 
      virtual void m5() {
      }

      virtual void m6() {
      }

      virtual void m7() {
      }

};

class Program {
public: 
};
      int main() {
         A *a1;
         A *a2;
         B *b1;
         B *b2;
         C *c1;
         C *c2;
         a1 = new A;
         a2 = new A;
         b1 = new B;
         b2 = new B;
         c1 = new C;
         c2 = new C;
         a1->m1();
         a1->m2();
         a2->m2();
         b1->m3();
         b1->m3();
         b2->m3();
         b1->m4();
         b2->m4();
         b1->m4();
         b2->m4();
         c1->m5();
         c2->m5();
         c1->m5();
         c2->m5();
         c1->m5();
         c1->m6();
         c1->m6();
         c1->m6();
         c2->m6();
         c2->m6();
         c2->m6();
         c1->m7();
         c1->m7();
         c1->m7();
         c2->m7();
         c2->m7();
         c2->m7();
         c2->m7();
      }


