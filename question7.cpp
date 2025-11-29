#include <iostream>
#include <string>

using namespace std;

class Student
{
private:
    int age;
    string first_name;
    string last_name;
    int standard;

public:
    void set_age(int a) { age = a; }
    void set_first_name(string fn) { first_name = fn; }
    void set_last_name(string ln) { last_name = ln; }
    void set_standard(int st) { standard = st; }

    int get_age()
    {
        return this->age;
    }
    string get_first_name()
    {
        return this->first_name;
    }
    string get_last_name()
    {
        return this->last_name;
    }
    int get_standard()
    {
        return this->standard;
    }

    string to_string()
    {
        return std::to_string(this->age) + "," + this->first_name + "," + this->last_name + "," + std::to_string(this->standard);
    }
};

int main()
{
    int age;
    string first_name;
    string last_name;
    int standard;

    Student student1;
    student1.set_age(20);

    cin >> age;
    cin >> first_name;
    cin >> last_name;
    cin >> standard;

    student1.set_age(age);
    student1.set_first_name(first_name);
    student1.set_last_name(last_name);
    student1.set_standard(standard);

    cout << student1.get_age() << endl;
    cout << student1.get_last_name() << "," << student1.get_first_name() << endl;
    cout << student1.get_standard() << endl;
    cout << "\n";
    cout << student1.to_string() << endl;
}
