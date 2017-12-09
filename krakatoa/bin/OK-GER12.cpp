#include <iostream>
#include <new>
using namespace std;
class A {
public: 
      virtual void m1() {
         cout << 1;
      }

      virtual void m2(int n) {
         cout << n;
      }

};

class B: public  A {
public: 
      virtual void m2(int n) {
         cout << n;
         A::m2( n + 1);
      }

};

class C: public  B {
public: 
      virtual void m1() {
         A::m1( );
         cout << 2;
      }

      virtual void m3() {
         this->m1();
         cout << 1;
         cout << 2;
      }

};

class Program {
public: 
};
      int main() {
         A *a;
         B *b;
         C *c;
         cout << "\n";
         cout << "Ok-ger12\n";
         cout << "The output should be :\n";
         cout << "1 2 1 2 1 2 1 2\n";
         b = new B;
         b->m2(1);
         c = new C;
         c->m1();
         c->m3();
      }


