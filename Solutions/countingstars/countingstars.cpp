/**
 * Solution to the "Counting Stars" problem on Kattis.
 * @author Brendan Jones
 */
#include <algorithm>
#include <cstdint>
#include <fstream>
#include <iostream>
#include <vector>

constexpr int BUFFER_SIZE = 100;

/**
 * Reads a new set of data in from the specified stream. Note that only the part of the buffer being
 * used will be reset, as the rest of the data is meaningless for the current image.
 */
void ReadData(std::istream& in, bool pixels[BUFFER_SIZE][BUFFER_SIZE], uint8_t width, uint8_t height) {
    char pixelValue;
    for (uint8_t y = 0; y < height; ++y) {
        for (uint8_t x = 0; x < width; ++x) {
            in >> pixelValue;
            pixels[y][x] = (pixelValue == '-'); // Star pixels are true, sky pixels are false.
        }
    }
}

/**
 * Performs a flood fill on the pixels of a star located at the specified position. Note that the startY is expected to be the
 * topmost row of the star.
 */
void FloodFill(bool pixels[BUFFER_SIZE][BUFFER_SIZE], uint8_t width, uint8_t height, uint8_t x, uint8_t y) {
    if (pixels[y][x]) { // Pixel has not been visited yet.
        pixels[y][x] = false; // Mark pixel as visited.

        if (y > 0) { // Fill the pixel above this one.
            FloodFill(pixels, width, height, x, y - 1);
        }
        if (y < height - 1) { // Fill the pixel below this one.
            FloodFill(pixels, width, height, x, y + 1);
        }
        if (x > 0) { // Fill the pixel to the left of this one.
            FloodFill(pixels, width, height, x - 1, y);
        }
        if (x < width - 1) { // Fill the pixel to the right of this one.
            FloodFill(pixels, width, height, x + 1, y);
        }
    }
}

int main() {
    // True represents an unvisited star pixel, while false represents a sky or visited star pixel.
    bool pixels[BUFFER_SIZE][BUFFER_SIZE];

    uint32_t currentCaseID = 0;

    uint16_t width = 0;
    uint16_t height = 0;
    while (std::cin >> height >> width) {
        // Read the data into the buffer.
        ReadData(std::cin, pixels, width, height);

        // The number of stars that this image contains.
        uint16_t numStars = 0; 

        for (uint8_t y = 0; y < height; ++y) {
            for (uint8_t x = 0; x < width; ++x) {
                if (pixels[y][x]) { // This pixel is part of an unvisited star.
                    FloodFill(pixels, width, height, x, y);
                    ++numStars;
                }
            }
        }

        std::cout << "Case " << (++currentCaseID) << ": " << numStars << std::endl;
    }

    return 0;
}