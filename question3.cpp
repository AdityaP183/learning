#include <iostream>
#include <vector>
using namespace std;

int main() {
    int arrSize;
    cin >> arrSize;

    vector<int> arr(arrSize);

    for (int i = 0; i < arrSize; i++) {
        cin >> arr[i];
    }

    for (int i = arrSize - 1; i >= 0; i--) {
        cout << arr[i];
        if (i != 0) cout << " ";
    }

    return 0;
}
