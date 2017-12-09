#include <iostream>
#include <new>
using namespace std;
class A {
public: 
      virtual void m() {
         cout << 6;
         cout << 1;
         cout << 1 + 1;
         cout << 4 - 1;
         cout << (6 - 3) + 1;
         cout << 10 / 2;
         cout << 2 * 3;
      }

};

class Program {
public: 
};
      int main() {
         A *a;
         cout << "\n";
         cout << "Ok-ger02\n";
         cout << "The output should be :\n";
         cout << "6 1 2 3 4 5 6\n";
         a = new A;
         a->m();
      }


