#include <iostream>
#include <new>
using namespace std;
class A {

private: 
      int k;
public: 
      virtual void m1(int n) {
         this->k = 1;
         cout << this->k << n;
      }

      virtual int getK() {
         return this->k ;
      }

};

class B: public  A {

private: 
      int k;
public: 
      virtual void m2(int n) {
         this->k = 2;
         A::m1( 1);
         cout << this->k << n;
      }

      virtual int getK() {
         return this->k ;
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
         cout << "Ok-ger10\n";
         cout << "The output should be :\n";
         cout << "1 1 2 2 3 3 4 4\n";
         c = new C;
         c->m4(4);
      }


