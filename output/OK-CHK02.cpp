#include <iostream>
#include <new>
using namespace std;
class A {

private: 
      int n;      boolean b;      String s;
public: 
      virtual void m() {
         this->n = 0;
         this->b = false;
         this->s = "";
      }

      virtual boolean m_returns_boolean() {
         return this->b ;
      }

      virtual void m_integer(int n) {
         this->n = n;
      }

      virtual void m_integer_boolean_String(int n, boolean b, String s) {
         this->n = n;
         this->b = b;
         this->s = s;
         cout << this->s;
      }

      virtual boolean m_integer_returns_boolean(int n) {
         if ( this->n > n)
            return false ;
          else 
            return this->b ;
      }

      virtual boolean m_integer_boolean_String_return(int n, boolean b, String s) {
         this->s = s;
         if ( b)
            return (n + n) > 0 ;
          else 
            return this->b && b ;
      }

};

class B: public  A {
};

class C {

private: 
      String name;      boolean letter;      int n;      int time;
public: 
      virtual void method() {
         this->name = "";
         this->letter = false;
         this->n = 0;
         this->time = 0;
      }

      virtual boolean method_returns_boolean() {
         return this->letter ;
      }

      virtual void method_integer(int n) {
         cout << this->name << n << this->time;
         if ( this->letter)
            cout << "true";
          else 
            cout << "false";
      }

      virtual void method_integer_boolean_String(int n, boolean b, String name) {
         this->name = name;
         cout << n;
         if ( b)
            cout << 0;
          else 
            cout << 1;
      }

      virtual boolean method_integer_returns_boolean(int n) {
         return this->n > n ;
      }

      virtual boolean method_integer_boolean_String_r(int n, boolean b, String name) {
         cout << name;
         this->name = name;
         return (this->n > n) && !(b && this->letter) && (this->time > 0) ;
      }

};

class Program {
public: 
};
      int main() {
         B *b;
         C *c;
         b = new B;
         b->m();
         c = new C;
         c->method();
      }


