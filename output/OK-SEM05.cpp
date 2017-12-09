#include <iostream>
#include <new>
using namespace std;
class A {

private: 
      int n;
public: 
      virtual void set(int pn) {
         this->n = pn;
      }

      virtual int get() {
         return this->n ;
      }

};

class B: public  A {
public: 
      virtual void set(int pn) {
         cout << pn;
         A::set( pn);
      }

};

class Program {
public: 
      *B m(A *a) {
         a->set(0);
         return new B ;
      }

      *A p(int i) {
         if ( i > 0)
            return new A ;
          else 
            return new B ;
      }

};
      int main() {
         A *a;
         B *b;
         a = new A;
         b = new B;
         a = b;
         a->set(0);
         a = this->m(a);
         b = this->m(b);
         a = this->p(0);
      }


