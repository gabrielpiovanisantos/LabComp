
class A {

   private int n;
   public void m() {
      int k ;
      k = this.n ;
      write( k );
   }

   public void p() {
      write( this.n );
   }

   public void s() {
      this.n = 0 ;
   }

}

class Program {

   public void run() {
      A a ;
      a = new A() ;
      a.s ;
      a.m ;
      a.p ;
   }

}

#include <iostream>
using namespace std;
class A {

public: 
      void m() {
         int k ;
         k = this.n; ;
         cout << k;
      }

      void p() {
         cout << this.n;;
      }

      void s() {
         this.n; =          0 ;
      }

}

class Program {

public: 
      void run() {
         A a ;
         a =          new A() ;
         a.s; ;
         a.m; ;
         a.p; ;
      }

}

