#include <cmath>
#include <cstdint>
#include <iostream>

int main() {
	int64_t num1;
	int64_t num2;

	while (std::cin >> num1 >> num2) {
		std::cout << std::abs(num1 - num2) << std::endl;
	}

	return 0;
}