
class A {

   private int i;
   private int j;
   public void init_A() {
      this.i = 1 ;
      this.j = 2 ;
   }

   public void call_p() {
      this.p() ;
   }

   public void call_q() {
      this.q() ;
   }

   public void r() {
      write( this.i );
   }

   public void s() {
      write( this.j );
   }

}

class B extends A {

   private int i;
   private int j;
   public void init_B() {
      this.i = 3 ;
      this.j = 4 ;
   }

   public void call_p() {
      this.p() ;
   }

   public void call_q() {
      this.q() ;
   }

   public void r() {
      write( this.i );
   }

   public void s() {
      write( this.j );
   }

}

class C extends A {

   private int i;
   private int j;
   public void init_C() {
      this.i = 5 ;
      this.j = 6 ;
   }

   public void call_p() {
      this.p() ;
   }

   public void call_q() {
      this.q() ;
   }

   public void r() {
      write( this.i );
   }

   public void s() {
      write( this.j );
   }

}

class Program {

   public void run() {
      A a ;
      B b ;
      C c ;
      write(  );
      write( Ok-ger15 );
      write( The output should be : );
      write( 1 2 1 2 3 4 3 4 5 6 5 6 );
      a = new A() ;
      a.init_A ;
      a.call_p ;
      a.call_q ;
      a.r ;
      a.s ;
      b = new B() ;
      b.init_B ;
      b.init_A ;
      b.call_p ;
      b.call_q ;
      b.r ;
      b.s ;
      c = new C() ;
      c.init_C ;
      c.init_A ;
      c.init_C ;
      c.call_p ;
      c.call_q ;
      c.r ;
      c.s ;
   }

}

#include <iostream>
using namespace std;
class A {

public: 
      void init_A() {
         this.i; =          1 ;
         this.j; =          2 ;
      }

      void call_p() {
         this.p(); ;
      }

      void call_q() {
         this.q(); ;
      }

      void r() {
         cout << this.i;;
      }

      void s() {
         cout << this.j;;
      }

}

class B: public  A {

public: 
      void init_B() {
         this.i; =          3 ;
         this.j; =          4 ;
      }

      void call_p() {
         this.p(); ;
      }

      void call_q() {
         this.q(); ;
      }

      void r() {
         cout << this.i;;
      }

      void s() {
         cout << this.j;;
      }

}

class C: public  A {

public: 
      void init_C() {
         this.i; =          5 ;
         this.j; =          6 ;
      }

      void call_p() {
         this.p(); ;
      }

      void call_q() {
         this.q(); ;
      }

      void r() {
         cout << this.i;;
      }

      void s() {
         cout << this.j;;
      }

}

class Program {

public: 
      void run() {
         A a ;
         B b ;
         C c ;
         cout << ;
         cout << Ok-ger15;
         cout << The output should be :;
         cout << 1 2 1 2 3 4 3 4 5 6 5 6;
         a =          new A() ;
         a.init_A; ;
         a.call_p; ;
         a.call_q; ;
         a.r; ;
         a.s; ;
         b =          new B() ;
         b.init_B; ;
         b.init_A; ;
         b.call_p; ;
         b.call_q; ;
         b.r; ;
         b.s; ;
         c =          new C() ;
         c.init_C; ;
         c.init_A; ;
         c.init_C; ;
         c.call_p; ;
         c.call_q; ;
         c.r; ;
         c.s; ;
      }

}

