#include <iostream>
#include <new>
using namespace std;
class A {
public: 
      virtual void m() {
         int i;
         int j;
         int k;
         cout << 7;
         i = 1;
         j = i + 1;
         k = j + 1;
         cout << i;
         cout << j;
         cout << k;
         i = ((((3 + 1) * 3) / 2) / 2) + 1;
         cout << i;
         i = ((100 - 95) * 2) - 5;
         cout << i;
         i = (100 - (45 * 2)) - 4;
         cout << i;
         cout << 7;
      }

};

class Program {
public: 
};
      int main() {
         A *a;
         cout << "\n";
         cout << "Ok-ger06\n";
         cout << "The output should be :\n";
         cout << "7 1 2 3 4 5 6 7\n";
         a = new A;
         a->m();
      }


