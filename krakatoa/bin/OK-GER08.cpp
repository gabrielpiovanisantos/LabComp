#include <iostream>
#include <new>
using namespace std;
class A {
public: 
      virtual void m1(int n) {
         cout << 1 << n;
      }

      virtual void m2(int n) {
         cout << 2 << n;
      }

      virtual void m3(int n) {
         cout << 3 << n;
      }

};

class Program {
public: 
};
      int main() {
         A *a;
         cout << "\n";
         cout << "Ok-ger08\n";
         cout << "The output should be :\n";
         cout << "1 1 2 2 3 3\n";
         a = new A;
         a->m1(1);
         a->m2(2);
         a->m3(3);
      }


