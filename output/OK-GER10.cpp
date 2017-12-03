#include <iostream>
using namespace std;
class A {

private: 
int *k;
public: 
      virtual void m1() {
         this.k =          1 ;
         cout << this.k, n;
      }

      virtual int getK() {
         return this.k ;
      }

}

class B: public  A {

private: 
int *k;
public: 
      virtual void m2() {
         this.k =          2 ;
         A::m1(          1)
 ;
         cout << this.k, n;
      }

      virtual int getK() {
         return this.k ;
      }

}

class C: public  B {
public: 
      virtual void m3() {
         A::m2(          2)
 ;
         cout <<          3, n;
      }

      virtual void m4() {
         this.m3(          3 ) ;
         cout <<          4, n;
      }

}

virtual void main() {
   C c ;
   cout << ;
   cout << Ok-ger10;
   cout << The output should be :;
   cout << 1 1 2 2 3 3 4 4;
   c =    new C() ;
   c.m4(    4 ) ;
}


