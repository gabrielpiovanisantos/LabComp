
class A {

   private int n;
   public int get() {
      return this.n ;
   }

   public void set(int pn) {
      this.n = pn ;
   }

}

class B extends A {

   private int k;
   public void m() {
      int i ;
      read( i );
      read( k );
      super.set (0 ) ;
      write( super.get ( ), this.get(), this.k, i );
   }

   public void print() {
      write( this.k );
   }

}

class Program {

   public void run() {
      B b ;
      b = new B() ;
      b.set( 1 ) ;
      b.m ;
   }

}

#include <iostream>
using namespace std;
class A {

public: 
      int get() {
         return this.n; ;
      }

      void set() {
         this.n; = pn ;
      }

}

class B: public  A {

public: 
      void m() {
         int i ;
         cin >> i;
         cin >> k;
         A::set(          0)
 ;
         cout << A::get( )
, this.get();, this.k;, i;
      }

      void print() {
         cout << this.k;;
      }

}

class Program {

public: 
      void run() {
         B b ;
         b =          new B() ;
         b.set(          1 ); ;
         b.m; ;
      }

}

