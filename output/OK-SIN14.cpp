#include <iostream>
#include <new>
using namespace std;
class Point {

private: 
      int x;      int y;
public: 
      virtual void set(int x, int y) {
         this->x = x;
         this->y = y;
      }

      virtual int getX() {
         return this->x ;
      }

      virtual int getY() {
         return this->y ;
      }

};

class Program {

private: 
      Point *p;
public: 
};
      int main() {
         this->p = new Point;
         this->p->set(0, 0);
      }

      *Point getPoint() {
         return this->p ;
      }


