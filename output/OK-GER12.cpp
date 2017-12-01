
class A {

   public void m1() {
      write( 1 );
   }

   public void m2(int n) {
      write( n );
   }

}

class B extends A {

   public void m2(int n) {
      write( n );
      super.m2 (n + 1 ) ;
   }

}

class C extends B {

   public void m1() {
      super.m1 ( ) ;
      write( 2 );
   }

   public void m3() {
      this.m1() ;
      write( 1 );
      write( 2 );
   }

}

class Program {

   public void run() {
      A a ;
      B b ;
      C c ;
      write(  );
      write( Ok-ger12 );
      write( The output should be : );
      write( 1 2 1 2 1 2 1 2 );
      b = new B() ;
      b.m2( 1 ) ;
      c = new C() ;
      c.m1 ;
      c.m3 ;
   }

}

#include <iostream>
using namespace std;
class A {

public: 
      void m1() {
         cout <<          1;
      }

      void m2() {
         cout << n;
      }

}

class B: public  A {

public: 
      void m2() {
         cout << n;
         A::m2( n +          1)
 ;
      }

}

class C: public  B {

public: 
      void m1() {
         A::m1( )
 ;
         cout <<          2;
      }

      void m3() {
         this.m1(); ;
         cout <<          1;
         cout <<          2;
      }

}

class Program {

public: 
      void run() {
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

