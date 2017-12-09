#include <iostream>
#include <new>
using namespace std;
class A {
public: 
      virtual void m1() {
         cout << 2;
      }

      virtual void m2(int n) {
         cout << n;
         this->m1();
      }

};

class B: public  A {
public: 
      virtual void m1() {
         cout << 4;
      }

};

class Program {
public: 
};
      int main() {
         A *a;
         B *b;
         cout << "\n";
         cout << "Ok-ger11\n";
         cout << "The output should be :\n";
         cout << "4 1 2 3 4\n";
         cout << 4;
         a = new A;
         a->m2(1);
         a = new B;
         a->m2(3);
      }


