
#ifndef HOME_ICE
#define HOME_ICE

module Home
{
  enum operation { TURNON, TURNOFF, RESTART, OPEN, CLOSE};
  
  exception NoInput {};
  dictionary <string, int> contents;
  struct Fridge
  {
    contents freezerContents;
    contents fridgeContents;
    double temperature;
  };

  interface HomeServer
  {
    void move(string what, double x, double y);
    void set(string what, double value);
    void perform(operation op, short b1);
    string list();
    void put(string where, contents what);
  };

};

#endif
