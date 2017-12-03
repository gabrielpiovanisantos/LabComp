#include <iostream>
using namespace std;
class A {

private: 
int *i;
int *j;
public: 
      virtual void init_A() {
         this.i =          1 ;
         this.j =          2 ;
      }

      virtual void call_p() {
         this.p() ;
      }

      virtual void call_q() {
         this.q() ;
      }

      virtual void r() {
         cout << this.i;
      }

      virtual void s() {
         cout << this.j;
      }

}

class B: public  A {

private: 
int *i;
int *j;
public: 
      virtual void init_B() {
         this.i =          3 ;
         this.j =          4 ;
      }

      virtual void call_p() {
         this.p() ;
      }

      virtual void call_q() {
         this.q() ;
      }

      virtual void r() {
         cout << this.i;
      }

      virtual void s() {
         cout << this.j;
      }

}

class C: public  A {

private: 
int *i;
int *j;
public: 
      virtual void init_C() {
         this.i =          5 ;
         this.j =          6 ;
      }

      virtual void call_p() {
         this.p() ;
      }

      virtual void call_q() {
         this.q() ;
      }

      virtual void r() {
         cout << this.i;
      }

      virtual void s() {
         cout << this.j;
      }

}

virtual void main() {
   A a ;
   B b ;
   C c ;
   cout << ;
   cout << Ok-ger15;
   cout << The output should be :;
   cout << 1 2 1 2 3 4 3 4 5 6 5 6;
   a =    new A() ;
   a.init_A ;
   a.call_p ;
   a.call_q ;
   a.r ;
   a.s ;
   b =    new B() ;
   b.init_B ;
   b.init_A ;
   b.call_p ;
   b.call_q ;
   b.r ;
   b.s ;
   c =    new C() ;
   c.init_C ;
   c.init_A ;
   c.init_C ;
   c.call_p ;
   c.call_q ;
   c.r ;
   c.s ;
}


