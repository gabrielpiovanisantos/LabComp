
class Person {

   private String course;
   private int number;
   private int age;
   private String name;
   public String getCourse() {
      return this.course ;
   }

   public void setCourse(String course) {
      this.course = course ;
   }

   public int getNumber() {
      return this.number ;
   }

   public void setNumber(int number) {
      this.number = number ;
   }

   public void init(String name, int age) {
      this.name = name ;
      this.age = age ;
   }

   public String getName() {
      return this.name ;
   }

   public int getAge() {
      return this.age ;
   }

   public void print() {
      write( Name = , this.name );
      write( Age = , this.age );
   }

}

class Group {

   private Person first;
   private Person second;
   public void set(Person first, Person second) {
      this.first = first ;
      this.second = second ;
   }

   public Person getFirst() {
      return this.first ;
   }

   public Person getSecond() {
      return this.second ;
   }

   public void print() {
      write( First: , this.first.getName );
      write( Second: , this.second.getName );
   }

}

class University {

   private String name;
   private int numberOfStudents;
   private String city;
   public void init(String name, String city, int numberOfStudents) {
      this.name = name ;
      this.city = city ;
      this.numberOfStudents = numberOfStudents ;
   }

   public void print() {
      write( this.name );
      write( this.city );
      write( this.numberOfStudents );
   }

}

class Program {

   public void run() {
      University s ;
      Person joao ;
      Person maria ;
      Group g ;
      s = new University() ;
      s.init( UFSCar, Sao Carlos, 7000 ) ;
      s.print ;
      write(  );
      joao = new Person() ;
      joao.init( Joao, 21 ) ;
      joao.setCourse( EnC ) ;
      joao.setNumber( 6729 ) ;
      maria = new Person() ;
      maria.init( Maria, 20 ) ;
      maria.setCourse( Fisioterapia ) ;
      maria.setNumber( 8607 ) ;
      joao.print ;
      write(  );
      maria.print ;
      write(  );
      g = new Group() ;
      g.set( joao, maria ) ;
      g.print ;
      write(  );
   }

}

#include <iostream>
using namespace std;
class Person {

public: 
      String getCourse() {
         return this.course; ;
      }

      void setCourse() {
         this.course; = course ;
      }

      int getNumber() {
         return this.number; ;
      }

      void setNumber() {
         this.number; = number ;
      }

      void init() {
         this.name; = name ;
         this.age; = age ;
      }

      String getName() {
         return this.name; ;
      }

      int getAge() {
         return this.age; ;
      }

      void print() {
         cout << Name = , this.name;;
         cout << Age = , this.age;;
      }

}

class Group {

public: 
      void set() {
         this.first; = first ;
         this.second; = second ;
      }

      Person getFirst() {
         return this.first; ;
      }

      Person getSecond() {
         return this.second; ;
      }

      void print() {
         cout << First: , this.first.getName;;
         cout << Second: , this.second.getName;;
      }

}

class University {

public: 
      void init() {
         this.name; = name ;
         this.city; = city ;
         this.numberOfStudents; = numberOfStudents ;
      }

      void print() {
         cout << this.name;;
         cout << this.city;;
         cout << this.numberOfStudents;;
      }

}

class Program {

public: 
      void run() {
         University s ;
         Person joao ;
         Person maria ;
         Group g ;
         s =          new University() ;
         s.init( UFSCar, Sao Carlos,          7000 ); ;
         s.print; ;
         cout << ;
         joao =          new Person() ;
         joao.init( Joao,          21 ); ;
         joao.setCourse( EnC ); ;
         joao.setNumber(          6729 ); ;
         maria =          new Person() ;
         maria.init( Maria,          20 ); ;
         maria.setCourse( Fisioterapia ); ;
         maria.setNumber(          8607 ); ;
         joao.print; ;
         cout << ;
         maria.print; ;
         cout << ;
         g =          new Group() ;
         g.set( joao, maria ); ;
         g.print; ;
         cout << ;
      }

}

