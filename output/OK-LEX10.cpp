#include <iostream>
#include <new>
using namespace std;
class A {
public: 
      virtual void m() {
      }

};

class Program {
public: 
};
      int main() {
         A *a;
         a = new A;
         a->m();
      }


