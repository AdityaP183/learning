#include <iostream>

using namespace std;

struct Info
{
    int age;
    string first_name;
    string last_name;
    int standard;
};

int main()
{
    Info userInfo;

    cin >> userInfo.age;
    cin >> userInfo.first_name;
    cin >> userInfo.last_name;
    cin >> userInfo.standard;

    cout << userInfo.age << " " << userInfo.first_name << " " << userInfo.last_name << " " << userInfo.standard << endl;
};
