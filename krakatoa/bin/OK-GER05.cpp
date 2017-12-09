#include <iostream>
#include <new>
using namespace std;
class A {
public: 
      virtual void m() {
         int a;
         int b;
         int c;
         int d;
         int e;
         int f;
         cin >> a >> b >> c >> d >> e >> f;
         cout << a << b << c << d << e << f;
      }

};

class Program {
public: 
};
      int main() {
         A *a;
         cout << "\n";
         cout << "Ok-ger05\n";
         cout << "The output should be what you give as input.\n";
         cout << "Type in six numbers\n";
         a = new A;
         a->m();
      }


