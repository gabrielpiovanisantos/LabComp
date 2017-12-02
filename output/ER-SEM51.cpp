#include <iostream>
using namespace std;
class A {

private: 
int *i;
public: 
      virtual void put() {
      }

}

class B: public  A {

private: 
public: 
      virtual void put() {
      }

}

class Program {

private: 
public: 
      virtual void run() {
         A a ;
         a =          new A() ;
         a.put(          0,          1, true ); ;
      }

}

