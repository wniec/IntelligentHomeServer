
#ifndef HOME_ICE
#define HOME_ICE

module Home
{
  enum operation { MIN, MAX, AVG };
  
  exception NoInput {};

  struct A
  {
    short a;
    long b;
    float c;
    string d;
  };

  interface HomeServer
  {
    long add(int a, int b);
    long subtract(int a, int b);
    void op(A a1, short b1);
  };

};

#endif
