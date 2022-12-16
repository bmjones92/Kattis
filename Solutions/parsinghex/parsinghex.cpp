/**
 * Solution to the "Parsing Hex" problem on Kattis.
 * @author Brendan Jones
 */
#include <cctype>
#include <cstdint>
#include <iostream>
#include <sstream>
#include <string>

void PrintHexStringAndValue(const std::string& hex) {
	std::cout << hex << " " << std::strtoull(hex.c_str(), nullptr, 0) << std::endl;
}

int main() {
	std::string line;
	while (std::getline(std::cin, line)) {
		std::ostringstream buffer;
		uint32_t size = 0;

		for (auto& ch : line) {
			switch (size) {
				case 0: { // Expecting an '0' here.
					if (ch == '0') {
						buffer << ch;
						++size;
					}
					break;
				}
				case 1: { // Expecting an 'x' or 'X' here.
					if (ch == 'x' || ch == 'X') {
						buffer << ch;
						++size;
					} else {
						buffer.clear();
						size = 0;
					}
					break;
				}
				default: { // Prefix already in, so read the data itself.
					if (std::isxdigit(ch)) {
						buffer << ch;
						++size;
					} else {
						// Invalid hexadecimal character, so print the current string and clear the buffer.
						if (size > 2) {
							PrintHexStringAndValue(buffer.str());
						}
						buffer.str(std::string());
						size = 0;
					}
					break;
				}
			}
		}

		// If one exists in the buffer, print a hex string before clearing the buffer.
		if (size > 2) {
			PrintHexStringAndValue(buffer.str());
		}
		buffer.str(std::string());
		size = 0;
	}
	return 0;
}
