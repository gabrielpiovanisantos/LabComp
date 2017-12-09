#include <iostream>
#include <new>
using namespace std;
class A {
public: 
      virtual void A() {
      }

};

class Program {
public: 
};
      int main() {
         A *a;
         a = new A;
         a->A();
      }


