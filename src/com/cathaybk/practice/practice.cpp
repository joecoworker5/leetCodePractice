#include <iostream>
#include <string>
#include <cmath>
#include <array>
#include <vector>
#include <algorithm>
using namespace std; 

void foo(char *s) {
    cout << s << endl;
}

int main() {
    char name[] = "Justin";
    foo(name);
    return 0;
}
