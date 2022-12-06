/**
 * Solution to the "Hitting Targets" problem on Kattis.
 * @author Brendan Jones
 */
#include <cstdint>
#include <iostream>
#include <memory>
#include <string>
#include <vector>

class ITarget {
public:
    // Calculates whether the point (x, y) intersects this target.
    virtual bool IsCollision(int32_t x, int32_t y) = 0;
};

class Circle : public ITarget {
public:
    Circle(std::istream& in) {
        in >> m_X;
        in >> m_Y;
        in >> m_Radius;
    }

    bool IsCollision(int32_t x, int32_t y) {
        // Calculate the deltas between the origin and hit point.
        int32_t dX = (x - m_X);
        int32_t dY = (y - m_Y);

        // Calculate the distance from the hit point to the center of the circle.
        int32_t distance = dX * dX + dY * dY;

        // Faster to square one variable than to take the sqrt of the other.
        return (distance <= m_Radius * m_Radius);
    }

private:
    int32_t m_X;
    int32_t m_Y;
    int32_t m_Radius;
};

class Rectangle : public ITarget {
public:
    Rectangle(std::istream& in) {
        in >> m_Left;
        in >> m_Bottom;
        in >> m_Right;
        in >> m_Top;
    }

    bool IsCollision(int32_t x, int32_t y) {
        return (x >= m_Left && x <= m_Right && y >= m_Bottom && y <= m_Top);
    }

private:
    int32_t m_Left;   // Left edge of rectangle
    int32_t m_Bottom; // Bottom edge of rectangle
    int32_t m_Right;  // Right edge of rectangle
    int32_t m_Top;    // Top edge of rectangle
};

int main() {
    std::vector<std::shared_ptr<ITarget>> targets;

    uint32_t numTargets = 0;
    std::cin >> numTargets;

    // Read and store each target for later use.
    for (uint32_t i = 0; i < numTargets; ++i) {
        std::string type;
        std::cin >> type;

        if (type == "rectangle") { // Rectangle target
            targets.push_back(std::make_shared<Rectangle>(std::cin));
        } else { // Circle target
            targets.push_back(std::make_shared<Circle>(std::cin));
        }
    }

    uint32_t numShots = 0;
    std::cin >> numShots;

    // Read each shot and check how many targets they hit.
    for (uint32_t i = 0; i < numShots; ++i) {
        int32_t shotX = 0;
        std::cin >> shotX;

        int32_t shotY = 0;
        std::cin >> shotY;

        // Iterate through the targets and report the number of them that were hit.
        uint32_t numHits = 0;
        for (auto& target : targets) {
            if (target->IsCollision(shotX, shotY)) {
                ++numHits;
            }
        }

        std::cout << numHits << std::endl;
    }
}
