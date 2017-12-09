#include <iostream>
#include <new>
using namespace std;
class A {
public: 
      virtual void m() {
         int i;
         i = 1;
         cout << i;
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


