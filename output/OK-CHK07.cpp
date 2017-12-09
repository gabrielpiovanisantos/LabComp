#include <iostream>
#include <new>
using namespace std;
class Person {

private: 
      String course;      int number;      int age;      String name;
public: 
      virtual String getCourse() {
         return this->course ;
      }

      virtual void setCourse(String course) {
         this->course = course;
      }

      virtual int getNumber() {
         return this->number ;
      }

      virtual void setNumber(int number) {
         this->number = number;
      }

      virtual void init(String name, int age) {
         this->name = name;
         this->age = age;
      }

      virtual String getName() {
         return this->name ;
      }

      virtual int getAge() {
         return this->age ;
      }

      virtual void print() {
         cout << "Name = " << this->name;
         cout << "Age = " << this->age;
      }

};

class Group {

private: 
      Person *first;      Person *second;
public: 
      virtual void set(Person *first, Person *second) {
         this->first = first;
         this->second = second;
      }

      *Person getFirst() {
         return this->first ;
      }

      *Person getSecond() {
         return this->second ;
      }

      virtual void print() {
         cout << "First: " << this->first->getName();
         cout << "Second: " << this->second->getName();
      }

};

class University {

private: 
      String name;      int numberOfStudents;      String city;
public: 
      virtual void init(String name, String city, int numberOfStudents) {
         this->name = name;
         this->city = city;
         this->numberOfStudents = numberOfStudents;
      }

      virtual void print() {
         cout << this->name;
         cout << this->city;
         cout << this->numberOfStudents;
      }

};

class Program {
public: 
};
      int main() {
         University *s;
         Person *joao;
         Person *maria;
         Group *g;
         s = new University;
         s->init("UFSCar", "Sao Carlos", 7000);
         s->print();
         cout << "\n";
         joao = new Person;
         joao->init("Joao", 21);
         joao->setCourse("EnC");
         joao->setNumber(6729);
         maria = new Person;
         maria->init("Maria", 20);
         maria->setCourse("Fisioterapia");
         maria->setNumber(8607);
         joao->print();
         cout << "\n";
         maria->print();
         cout << "\n";
         g = new Group;
         g->set(joao, maria);
         g->print();
         cout << "\n";
      }


