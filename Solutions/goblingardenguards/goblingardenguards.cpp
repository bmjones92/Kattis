/**
 * Solution for the "Goblin Garden Guards" problem on Kattis.
 * @author Brendan Jones
 */

#include <algorithm>
#include <iostream>
#include <list>
#include <map>

constexpr int32_t MAX_GARDEN_SIZE = 10000;

struct Position {
	int32_t x;
	int32_t y;

	bool operator==(const Position& rhs) const {
		return (x == rhs.x && y == rhs.y);
	}

	bool operator<(const Position& rhs) const {
		return (y < rhs.y || y == rhs.y && x < rhs.x);
	}

};

struct Sprinkler {
	Position pos;
	int32_t radius;

	int32_t left;
	int32_t right;
	int32_t top;
	int32_t bottom;
};

using GoblinMap = std::map<Position, int32_t>;
using SprinklerList = std::list<Sprinkler>;

inline int32_t Clamp(int32_t value, int32_t min, int32_t max) {
	return (value < min) ? min : (value > max) ? max : value;
}

GoblinMap ReadGoblinPositions(int32_t numGoblins) {
	GoblinMap goblins;

	Position pos;
	for(int32_t i = 0; i < numGoblins; ++i) {
		std::cin >> pos.x >> pos.y;
		goblins[pos]++;
	}

	return goblins;
}

SprinklerList ReadSprinklers(int32_t numSprinklers) {
	SprinklerList sprinklers(numSprinklers);

	//Read and initialize the sprinkler data.
	for(Sprinkler& s : sprinklers) {
		//Read the x and y coordinates, as well as the radius.
		std::cin >> s.pos.x >> s.pos.y >> s.radius;

		//Calculate the bounding box around this sprinkler.
		s.left = Clamp(s.pos.x - s.radius, 0, MAX_GARDEN_SIZE);
		s.top = Clamp(s.pos.y - s.radius, 0, MAX_GARDEN_SIZE);
		s.right = Clamp(s.pos.x + s.radius, 0, MAX_GARDEN_SIZE);
		s.bottom = Clamp(s.pos.y + s.radius, 0, MAX_GARDEN_SIZE);

		//Square the radius of this sprinkler for later calculations to avoid
		//having to calculate the square root of all of our distance calculations.
		s.radius *= s.radius;
	}

	//Sort by position and radius.
	sprinklers.sort([](const Sprinkler& a, const Sprinkler& b) {
		return (a.pos == b.pos && a.radius > b.radius) || (a.pos < b.pos);
	});

	//Remove all sprinklers at the same position except for the largest one.
	sprinklers.unique([](const Sprinkler& a, const Sprinkler& b) {
		return (a.pos == b.pos);
	});

	//Sort by radius only so the sprinklers with the largest radius are processed first.
	sprinklers.sort([](const Sprinkler& a, const Sprinkler& b) {
		return (a.radius > b.radius);
	});

	return sprinklers;
}

int32_t ProcessSprinkler(const Sprinkler& s, GoblinMap& goblins) {
	int32_t numGoblinsRemoved = 0;

	for(int32_t y = s.top; y <= s.bottom; ++y) {
		//Get the "scanline" for this row.
		auto lowerBound = goblins.lower_bound({ s.left, y });
		auto upperBound = goblins.upper_bound({ s.right, y });

		//Remove all elements in the scanline that are within range of the sprinkler.
		while(lowerBound != upperBound) {
			Position pos = lowerBound->first;

			int32_t dX = pos.x - s.pos.x;
			int32_t dY = pos.y - s.pos.y;

			//Note: The radius is squared to eliminate the need to calculate the square root
			//of every distance.
			if((dX * dX + dY * dY) <= s.radius) {
				numGoblinsRemoved += lowerBound->second;

				lowerBound = goblins.erase(lowerBound);
			} else {
				++lowerBound;
			}
		}
	}

	return numGoblinsRemoved;
}

int main() {
	//The number of goblins that we will start with.
	int32_t numGoblins;
	std::cin >> numGoblins;

	//Read the goblins into the map.
	GoblinMap goblins = ReadGoblinPositions(numGoblins);

	//The number of sprinklers that we will start with.
	int32_t numSprinklers;
	std::cin >> numSprinklers;

	//Read the sprinklers into the vector.
	SprinklerList sprinklers = ReadSprinklers(numSprinklers);

	int32_t numGoblinsRemaining = numGoblins;
	for(Sprinkler& s : sprinklers) {
		numGoblinsRemaining -= ProcessSprinkler(s, goblins);
	}

	//Print out the number of goblins that were removed from the list.
	std::cout << numGoblinsRemaining;

	return 0;
}
