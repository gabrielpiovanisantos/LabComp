
class A {

   public void m1() {
      write( 2 );
   }

   public void m2(int n) {
      write( n );
      this.m1() ;
   }

}

class B extends A {

   public void m1() {
      write( 4 );
   }

}

class Program {

   public void run() {
      A a ;
      B b ;
      write(  );
      write( Ok-ger11 );
      write( The output should be : );
      write( 4 1 2 3 4 );
      write( 4 );
      a = new A() ;
      a.m2( 1 ) ;
      a = new B() ;
      a.m2( 3 ) ;
   }

}

#include <iostream>
using namespace std;
class A {

public: 
      void m1() {
         cout <<          2;
      }

      void m2() {
         cout << n;
         this.m1(); ;
      }

}

class B: public  A {

public: 
      void m1() {
         cout <<          4;
      }

}

class Program {

public: 
      void run() {
         A a ;
         B b ;
         cout << ;
         cout << Ok-ger11;
         cout << The output should be :;
         cout << 4 1 2 3 4;
         cout <<          4;
         a =          new A() ;
         a.m2(          1 ); ;
         a =          new B() ;
         a.m2(          3 ); ;
      }

}

