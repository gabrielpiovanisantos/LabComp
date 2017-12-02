#include <iostream>
using namespace std;
class A {

private: 
int *n;
public: 
      virtual void m() {
         int k ;
         k = this.n ;
         cout << k;
      }

      virtual void p() {
         cout << this.n;
      }

      virtual void s() {
         cin >> n;
      }

}

class Program {
public: 
      virtual void run() {
         A a ;
         a =          new A() ;
         a.s ;
         a.m ;
         a.p ;
      }

}

