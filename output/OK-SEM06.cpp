#include <iostream>
#include <new>
using namespace std;
class A {

private: 
      int n;
public: 
      virtual void set(int pn) {
         int n;
         this->n = pn;
      }

      virtual int put(int n, String set) {
         bool put;
         this->n = n;
         return n ;
      }

};

class Program {
public: 
};
      int main() {
         A *a;
         a = new A;
         a->set(0);
      }


