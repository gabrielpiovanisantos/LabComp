#include <iostream>
#include <new>
using namespace std;
class A {
public: 
      virtual int m() {
         return x + y ;
      }

};

int main() {
   A *a ;
   a =    new A ;
   cout << a->m(   3,    4, true);
}


