#include <iostream>
#include <new>
using namespace std;
class A {

private: 
      int i;
public: 
      virtual void put(int x, int y, boolean ok) {
      }

};

class B: public  A {
public: 
      virtual void put(int x, int y, int ok) {
      }

};

class Program {
public: 
};
      int main() {
         A *a;
         a = new A;
         a->put(0, 1, true);
      }


