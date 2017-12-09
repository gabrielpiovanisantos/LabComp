#include <iostream>
#include <new>
using namespace std;
class A {
};

class B: public  A {
};

class Program {
public: 
};
      int main() {
         A *a, *a2;
         B *b;
         a =          NULL;
         b =          NULL;
         a2 =          NULL;
         if ( a == b)
            cout << 0;
         if ( b == a)
            cout << 1;
         if ( a == a2)
            cout << 2;
      }


