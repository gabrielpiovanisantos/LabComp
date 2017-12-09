#include <iostream>
#include <new>
using namespace std;
class A {
public: 
      virtual void m1(int n) {
         cout << 1 << n;
      }

};

class B: public  A {
public: 
      virtual void m2(int n) {
         A::m1( 1);
         cout << 2 << n;
      }

};

class C: public  B {
public: 
      virtual void m3(int n) {
         B::m2( 2);
         cout << 3 << n;
      }

      virtual void m4(int n) {
         this->m3(3);
         cout << 4 << n;
      }

};

class Program {
public: 
};
      int main() {
         C *c;
         cout << "\n";
         cout << "Ok-ger09\n";
         cout << "The output should be :\n";
         cout << "1 1 2 2 3 3 4 4\n";
         c = new C;
         c->m4(4);
      }


