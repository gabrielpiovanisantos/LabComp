#include <iostream>
using namespace std;
class A {

private: 
public: 
      virtual void m1() {
         cout <<          1;
      }

      virtual void m2() {
         cout << n;
      }

}

class B: public  A {

private: 
public: 
      virtual void m2() {
         cout << n;
         A::m2( n +          1)
 ;
      }

}

class C: public  B {

private: 
public: 
      virtual void m1() {
         A::m1( )
 ;
         cout <<          2;
      }

      virtual void m3() {
         this.m1(); ;
         cout <<          1;
         cout <<          2;
      }

}

class Program {

private: 
public: 
      virtual void run() {
         A a ;
         B b ;
         C c ;
         cout << ;
         cout << Ok-ger12;
         cout << The output should be :;
         cout << 1 2 1 2 1 2 1 2;
         b =          new B() ;
         b.m2(          1 ); ;
         c =          new C() ;
         c.m1; ;
         c.m3; ;
      }

}

