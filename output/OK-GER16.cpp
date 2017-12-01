
class A {

   private int k;
   public int get_A() {
      return this.k ;
   }

   public void set(int k) {
      this.k = k ;
   }

   public void print() {
      write( this.get_A() );
   }

   public void init() {
      this.set( 0 ) ;
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

   public void print() {
      write( this.get_B() );
      write( this.get_A() );
      super.print ( ) ;
   }

}

class C extends A {

   public int get_A() {
      return 0 ;
   }

}

class Program {

   public void run() {
      A a ;
      B b ;
      C c ;
      write(  );
      write( Ok-ger16 );
      write( The output should be:  );
      write( 2 2 0 0 2 0 0 0 0 0 0 );
      b = new B() ;
      b.init ;
      c = new C() ;
      c.init ;
      write( b.get_B );
      a = b ;
      a.print ;
      b.print ;
      a.init ;
      b.init ;
      write( a.get_A );
      write( b.get_A );
      a = c ;
      write( a.get_A );
      c = new C() ;
      write( c.get_A );
   }

}

#include <iostream>
using namespace std;
class A {

public: 
      int get_A() {
         return this.k; ;
      }

      void set() {
         this.k; = k ;
      }

      void print() {
         cout << this.get_A();;
      }

      void init() {
         this.set(          0 ); ;
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

      void print() {
         cout << this.get_B();;
         cout << this.get_A();;
         A::print( )
 ;
      }

}

class C: public  A {

public: 
      int get_A() {
         return          0 ;
      }

}

class Program {

public: 
      void run() {
         A a ;
         B b ;
         C c ;
         cout << ;
         cout << Ok-ger16;
         cout << The output should be: ;
         cout << 2 2 0 0 2 0 0 0 0 0 0;
         b =          new B() ;
         b.init; ;
         c =          new C() ;
         c.init; ;
         cout << b.get_B;;
         a = b ;
         a.print; ;
         b.print; ;
         a.init; ;
         b.init; ;
         cout << a.get_A;;
         cout << b.get_A;;
         a = c ;
         cout << a.get_A;;
         c =          new C() ;
         cout << c.get_A;;
      }

}

