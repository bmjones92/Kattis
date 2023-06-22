#include <fstream>
#include <iostream>

int main() {
    int input;
    std::cin >> input;
    
    int output = 0;
    do {
        output = (output << 1) | (input % 2);
    } while (input >>= 1);
    
    std::cout << output << std::endl;
    
    return 0;
}