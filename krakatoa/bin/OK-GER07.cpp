#include <iostream>
#include <new>
using namespace std;
class A {
public: 
      virtual void m() {
         cout << 0;
      }

};

class Program {
public: 
};
      int main() {
         A *a;
         cout << "\n";
         cout << "Ok-ger07\n";
         cout << "The output should be :\n";
         cout << "0\n";
         a = new A;
         a->m();
      }


