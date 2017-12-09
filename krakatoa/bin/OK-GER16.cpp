#include <iostream>
#include <new>
using namespace std;
class A {

private: 
      int k;
public: 
      virtual int get_A() {
         return this->k ;
      }

      virtual void set(int k) {
         this->k = k;
      }

      virtual void print() {
         cout << this->get_A();
      }

      virtual void init() {
         this->set(0);
      }

};

class B: public  A {

private: 
      int k;
public: 
      virtual int get_B() {
         return this->k ;
      }

      virtual void init() {
         A::init( );
         this->k = 2;
      }

      virtual void print() {
         cout << this->get_B();
         cout << this->get_A();
         A::print( );
      }

};

class C: public  A {
public: 
      virtual int get_A() {
         return 0 ;
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
         cout << "Ok-ger16\n";
         cout << "The output should be: \n";
         cout << "2 2 0 0 2 0 0 0 0 0 0\n";
         b = new B;
         b->init();
         c = new C;
         c->init();
         cout << b->get_B();
         a = b;
         a->print();
         b->print();
         a->init();
         b->init();
         cout << a->get_A();
         cout << b->get_A();
         a = c;
         cout << a->get_A();
         c = new C;
         cout << c->get_A();
      }


