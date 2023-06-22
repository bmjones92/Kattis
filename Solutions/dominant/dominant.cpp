#include <algorithm>
#include <array>
#include <cstdint>
#include <iostream>
#include <string>
#include <vector>

constexpr int32_t NUM_VALID_CHARACTERS = 26;

constexpr int32_t MAX_ELEMENT_LENGTH = 10;

struct Element {
    /* The string that this element represents. */
    std::string m_String;

    /* The number of times each letter occurs within the string. */
    std::array<char, NUM_VALID_CHARACTERS> m_Counts;

    bool IsSupersetOf(const Element& e) {
        for (uint8_t i = 0; i < NUM_VALID_CHARACTERS; ++i) {
            if (m_Counts[i] < e.m_Counts[i]) {
                return false;
            }
        }
        return true;
    }

};

int main() {
    std::vector<Element> elements;
    std::array<int32_t, MAX_ELEMENT_LENGTH> numElementsOfLength = { 0 };
    int longestStringLength = 0;

    // Read the input lines in.
    std::string line;
    while (std::cin >> line) {

        ++numElementsOfLength[line.length() - 1];

        // This string is the longest string we've read in so far, so update the longest string length to match it.
        if (line.length() > longestStringLength) {
            longestStringLength = line.length();
        }

        Element e { line, { 0 } };
        for (char ch : line) {
            ++e.m_Counts[ch - 'a'];
        }
        elements.push_back(e);
    }

    // Sort the strings from longest to shortest in alphabetical order.
    std::sort(elements.begin(), elements.end(), [](const Element& a, const Element& b) {
        return (a.m_String.length() > b.m_String.length());
    });

    // Because a superset must be larger than a subset, we know that all strings of the longest length are dominant
    // strings, so we skip the longest length strings.
    auto iter = elements.begin() + numElementsOfLength[longestStringLength - 1];
    while (iter != elements.end()) {

        bool bFoundDominant = false;
        for (auto& other : elements) {
            // Because a superset must be larger than a subset, we know that the rest of the elements in this list cannot
            // dominate this one, as they are sorted by length.
            if (iter->m_String.length() >= other.m_String.length()) {
                break;
            }
            
            // If we have found a dominant element, remove t his one from the list and flag a dominant element as found.
            if (other.IsSupersetOf(*iter)) {
                iter = elements.erase(iter);
                bFoundDominant = true;
                break;
            }
        }

        // No dominant element has been found, so iterate to the next element in the list.
        if (!bFoundDominant) {
            ++iter;
        }
    }

    // Sort the remaining elements in alphabetical order (this needs to be done separately because
    // we previously sorted them by length).
    std::sort(elements.begin(), elements.end(), [](const Element& a, const Element& b) {
        return a.m_String < b.m_String;
    });

    // Print the remaining elements out in alphabetical order.
    for (auto& e : elements) {
        std::cout << e.m_String << std::endl;
    }

    return 0;
} 