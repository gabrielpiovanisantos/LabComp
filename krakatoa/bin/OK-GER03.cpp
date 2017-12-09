#include <iostream>
#include <new>
using namespace std;
class A {
public: 
      virtual void m() {
         cout << 6;
         if ( true && true)
            cout << 1;
         if ( false && true)
            cout << 1000;
         if ( true && false)
            cout << 1000;
         if ( false && false)
            cout << 1000;
         if ( true || true)
            cout << 2;
         if ( true || false)
            cout << 3;
         if ( false || true)
            cout << 4;
         if ( false || false)
            cout << 1000;
         if ( !false)
            cout << 5;
         if ( !true)
            cout << 1000;
         if ( true || (true && false))
            cout << 6;
      }

};

class Program {
public: 
};
      int main() {
         A *a;
         cout << "\n";
         cout << "Ok-ger03\n";
         cout << "The output should be :\n";
         cout << "6 1 2 3 4 5 6\n";
         a = new A;
         a->m();
      }


