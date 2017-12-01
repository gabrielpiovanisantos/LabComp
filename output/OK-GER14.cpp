
class A {

   private int k;
   public int get_A() {
      return this.k ;
   }

   public void init() {
      this.k = 1 ;
   }

}

class B extends A {

   private int k;
   public int get_B() {
      return this.k ;
   }

   public void init() {
      super.init ( ) ;
      this.k = 2 ;
   }

}

class C extends B {

   private int k;
   public int get_C() {
      return this.k ;
   }

   public void init() {
      super.init ( ) ;
      this.k = 3 ;
   }

}

class D extends C {

   private int k;
   public int get_D() {
      return this.k ;
   }

   public void init() {
      super.init ( ) ;
      this.k = 4 ;
   }

}

class Program {

   public void run() {
      A a ;
      B b ;
      C c ;
      D d ;
      write(  );
      write( Ok-ger14 );
      write( The output should be : );
      write( 4 3 2 1 );
      d = new D() ;
      d.init ;
      write( d.get_D );
      c = d ;
      write( c.get_C );
      b = c ;
      write( b.get_B );
      a = b ;
      write( a.get_A );
   }

}

#include <iostream>
using namespace std;
class A {

public: 
      int get_A() {
         return this.k; ;
      }

      void init() {
         this.k; =          1 ;
      }

}

class B: public  A {

public: 
      int get_B() {
         return this.k; ;
      }

      void init() {
         A::init( )
 ;
         this.k; =          2 ;
      }

}

class C: public  B {

public: 
      int get_C() {
         return this.k; ;
      }

      void init() {
         A::init( )
 ;
         this.k; =          3 ;
      }

}

class D: public  C {

public: 
      int get_D() {
         return this.k; ;
      }

      void init() {
         A::init( )
 ;
         this.k; =          4 ;
      }

}

class Program {

public: 
      void run() {
         A a ;
         B b ;
         C c ;
         D d ;
         cout << ;
         cout << Ok-ger14;
         cout << The output should be :;
         cout << 4 3 2 1;
         d =          new D() ;
         d.init; ;
         cout << d.get_D;;
         c = d ;
         cout << c.get_C;;
         b = c ;
         cout << b.get_B;;
         a = b ;
         cout << a.get_A;;
      }

}

