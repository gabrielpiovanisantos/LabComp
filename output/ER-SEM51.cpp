
class A {

   private int i;
   public void put(int x, int y, boolean ok) {
   }

}

class B extends A {

   public void put(int x, int y, int ok) {
   }

}

class Program {

   public void run() {
      A a ;
      a = new A() ;
      a.put( 0, 1, true ) ;
   }

}

#include <iostream>
using namespace std;
class A {

public: 
      void put() {
      }

}

class B: public  A {

public: 
      void put() {
      }

}

class Program {

public: 
      void run() {
         A a ;
         a =          new A() ;
         a.put(          0,          1, true ); ;
      }

}

