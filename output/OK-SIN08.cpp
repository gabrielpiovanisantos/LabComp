#include <iostream>
#include <new>
using namespace std;
class A {
public: 
      virtual int m(int x, int y, boolean ok) {
         return x + y ;
      }

};

class Program {
public: 
};
      int main() {
         A *a;
         a = new A;
         cout << a->m(3, 4, true);
      }


