#include <iostream>
#include <new>
using namespace std;
class A {

private: 
      int n;
public: 
      virtual void set(int n) {
         this->n = n;
      }

      virtual int get() {
         return this->n ;
      }

};

class Program {

private: 
      A *a;
private: 
      virtual void set(A *a) {
         this->a = a;
      }

public: 
      virtual void print() {
         cout << this->a->get();
      }

      *A get() {
         return this->a ;
      }

};
      int main() {
         cout << "\n";
         cout << "Ok-ger21\n";
         cout << "The output should be :\n";
         cout << "0\n";
         cout << "0";
      }


