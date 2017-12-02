#include <iostream>
using namespace std;
class A {

private: 
public: 
      virtual void m() {
      }

}

class B: public  A {

private: 
public: 
      virtual void m() {
      }

}

class C: public  B {

private: 
public: 
      virtual void p() {
      }

}

class Program {

private: 
public: 
      virtual void run() {
         C c ;
         c =          new C() ;
         c.m; ;
      }

}

