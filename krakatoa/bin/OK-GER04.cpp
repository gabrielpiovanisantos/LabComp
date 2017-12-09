#include <iostream>
#include <new>
using namespace std;
class A {
public: 
      virtual void m() {
         int i;
         bool b;
         cout << 6;
         i = 1;
         while ( i <= 5 ){
            cout << i;
            i = i + 1;
         }
         b = false;
         while ( b != true ){
            cout << 6;
            b = !b;
         }
      }

};

class Program {
public: 
};
      int main() {
         A *a;
         cout << "\n";
         cout << "Ok-ger04\n";
         cout << "The output should be :\n";
         cout << "6 1 2 3 4 5 6\n";
         a = new A;
         a->m();
      }


