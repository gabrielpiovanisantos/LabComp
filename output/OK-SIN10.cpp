#include <iostream>
#include <new>
using namespace std;
class A {

private: 
int *n;
public: 
      virtual int get() {
         return this->n() ;
      }

      virtual void set() {
         this->n() = pn ;
      }

};

class B: public  A {

private: 
int *k;
public: 
      virtual void m() {
         int *i ;
         cin >> i;
         cin >> k;
         A::set(          0)
 ;
         cout << A::get( )
, this->get(), this->k(), i;
      }

      virtual void print() {
         cout << this->k();
      }

};

int main() {
   B *b ;
   b =    new B ;
   b->set(   1) ;
   b->m() ;
}


