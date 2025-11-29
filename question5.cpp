#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <sstream>

using namespace std;

int main() {
    string userInput;
    string value;

    cin >> userInput;
    stringstream ss(userInput);

    while(getline(ss, value, ',')){
        cout << value << endl;
    }
    return 0;
}
