/**
 * Solution to the "Oddities" problem on Kattis.
 * @author Brendan Jones
 */
#include <iostream>

int main() {
    int count = 0;
    std::cin >> count;
    
    for (int i = 0; i < count; ++i) {
        int number;
        std::cin >> number;
        
        std::cout << number << " is " << ((number % 2) ? "odd" : "even") << std::endl; 
    }
    
    return 0;
}