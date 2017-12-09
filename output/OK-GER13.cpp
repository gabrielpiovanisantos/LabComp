#include <iostream>
#include <new>
using namespace std;
class A {

private: 
      int n;
private: 
      virtual void p1() {
         cout << "999";
      }

      virtual void p2() {
         cout << "888";
      }

public: 
      virtual void set(int pn) {
         cout << 1;
         this->n = pn;
      }

      virtual int get() {
         return this->n ;
      }

      virtual void print() {
         cout << "A";
      }

};

class B: public  A {
private: 
      virtual void p2() {
      }

public: 
      virtual void set(int pn) {
         cout << pn;
         A::set( pn);
      }

      virtual void p1() {
         cout << 2;
      }

      virtual void print() {
         cout << "B";
      }

};

class Program {

private: 
      Program *program;
public: 
      virtual void print() {
         cout << "P";
      }

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
         A *a, *a2;
         B *b;
         cout << "\n";
         cout << "Ok-ger13\n";
         cout << "The output should be :\n";
         cout << "0 1 0 0 1 B A 0 1 P\n";
         a = new A;
         b = new B;
         a = b;
         a->set(0);
         a = this->m(a);
         b = this->m(b);
         b->p1();
         a = this->p(0);
         a->print();
         a = this->p(1);
         a->print();
         a =          NULL;
         b =          NULL;
         a2 = new A;
         if ( a == b)
            cout << 0;
         if ( b == a)
            cout << 1;
         if ( a == a2)
            cout << 2;
         this->program = new Program;
         this->program->print();
      }


