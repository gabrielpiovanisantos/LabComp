#include <iostream>
#include <new>
using namespace std;
class A {
public: 
      virtual void m() {
         cout << 7;
         if ( 1 > 0)
            cout << 0;
         if ( 1 >= 0)
            cout << 1;
         if ( 1 != 0)
            cout << 2;
         if ( 0 < 1)
            cout << 3;
         if ( 0 <= 1)
            cout << 4;
         if ( 0 == 0)
            cout << 5;
         if ( 0 >= 0)
            cout << 6;
         if ( 0 <= 0)
            cout << 7;
         if ( 1 == 0)
            cout << 18;
         if ( 0 > 1)
            cout << 10;
         if ( 0 >= 1)
            cout << 11;
         if ( 0 != 0)
            cout << 12;
         if ( 1 < 0)
            cout << 13;
         if ( 1 <= 0)
            cout << 14;
      }

};

class Program {
public: 
};
      int main() {
         A *a;
         cout << "\n";
         cout << "Ok-ger01\n";
         cout << "The output should be :\n";
         cout << "7 0 1 2 3 4 5 6 7\n";
         a = new A;
         a->m();
      }


