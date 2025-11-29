#include <iostream>
#include <vector>
using namespace std;

int main()
{
    int totalArr, totalQueries;

    cin >> totalArr >> totalQueries;

    vector<vector<int>> arr(totalArr);

    for (int i = 0; i < totalArr; i++)
    {
        int arrLength;
        cin >> arrLength;

        arr[i].resize(arrLength);

        for (int j = 0; j < arrLength; j++)
        {
            cin >> arr[i][j];
        }
    }

    while (totalQueries--) {
        int i, j;

        cin >> i >> j;

        cout << arr[i][j] << endl;
    }

    return 0;
}
