#include <iostream>
using namespace std;
class A {

private: 
int *k;
public: 
      virtual int get_A() {
         return this.k ;
      }

      virtual void init() {
         this.k =          1 ;
      }

}

class B: public  A {

private: 
int *k;
public: 
      virtual int get_B() {
         return this.k ;
      }

      virtual void init() {
         A::init( )
 ;
         this.k =          2 ;
      }

}

class C: public  B {

private: 
int *k;
public: 
      virtual int get_C() {
         return this.k ;
      }

      virtual void init() {
         A::init( )
 ;
         this.k =          3 ;
      }

}

class D: public  C {

private: 
int *k;
public: 
      virtual int get_D() {
         return this.k ;
      }

      virtual void init() {
         A::init( )
 ;
         this.k =          4 ;
      }

}

virtual void main() {
   A a ;
   B b ;
   C c ;
   D d ;
   cout << ;
   cout << Ok-ger14;
   cout << The output should be :;
   cout << 4 3 2 1;
   d =    new D() ;
   d.init ;
   cout << d.get_D;
   c = d ;
   cout << c.get_C;
   b = c ;
   cout << b.get_B;
   a = b ;
   cout << a.get_A;
}


