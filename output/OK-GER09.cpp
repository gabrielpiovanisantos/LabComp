
class A {

   public void m1(int n) {
      write( 1, n );
   }

}

class B extends A {

   public void m2(int n) {
      super.m1 (1 ) ;
      write( 2, n );
   }

}

class C extends B {

   public void m3(int n) {
      super.m2 (2 ) ;
      write( 3, n );
   }

   public void m4(int n) {
      this.m3( 3 ) ;
      write( 4, n );
   }

}

class Program {

   public void run() {
      C c ;
      write(  );
      write( Ok-ger09 );
      write( The output should be : );
      write( 1 1 2 2 3 3 4 4 );
      c = new C() ;
      c.m4( 4 ) ;
   }

}

#include <iostream>
using namespace std;
class A {

public: 
      void m1() {
         cout <<          1, n;
      }

}

class B: public  A {

public: 
      void m2() {
         A::m1(          1)
 ;
         cout <<          2, n;
      }

}

class C: public  B {

public: 
      void m3() {
         A::m2(          2)
 ;
         cout <<          3, n;
      }

      void m4() {
         this.m3(          3 ); ;
         cout <<          4, n;
      }

}

class Program {

public: 
      void run() {
         C c ;
         cout << ;
         cout << Ok-ger09;
         cout << The output should be :;
         cout << 1 1 2 2 3 3 4 4;
         c =          new C() ;
         c.m4(          4 ); ;
      }

}

