#include <iostream>
#include <string>

int main() {
	char lastCh = '\0';
	char currCh = '\0';

	while (std::cin >> currCh) {
		if (currCh != lastCh) {
			std::cout << currCh;
			lastCh = currCh;
		}
	}

	std::cin.get();
	std::cin.get();
	return 0;
}