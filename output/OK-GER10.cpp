
class A {

   private int k;
   public void m1(int n) {
      this.k = 1 ;
      write( this.k, n );
   }

   public int getK() {
      return this.k ;
   }

}

class B extends A {

   private int k;
   public void m2(int n) {
      this.k = 2 ;
      super.m1 (1 ) ;
      write( this.k, n );
   }

   public int getK() {
      return this.k ;
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
      write( Ok-ger10 );
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
         this.k; =          1 ;
         cout << this.k;, n;
      }

      int getK() {
         return this.k; ;
      }

}

class B: public  A {

public: 
      void m2() {
         this.k; =          2 ;
         A::m1(          1)
 ;
         cout << this.k;, n;
      }

      int getK() {
         return this.k; ;
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
         cout << Ok-ger10;
         cout << The output should be :;
         cout << 1 1 2 2 3 3 4 4;
         c =          new C() ;
         c.m4(          4 ); ;
      }

}

