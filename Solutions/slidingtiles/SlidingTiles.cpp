 /**
 * Solution for the "Sliding Tiles" problem on Kattis.
 * @author Brendan Jones
 */
#include <array>
#include <cstdint>
#include <iostream>
#include <string>
#include <utility>

// The maximum number of moves that can be made in a single test.
constexpr uint16_t MAX_MOVES = 50;

// The initial size of the grid.
constexpr uint16_t START_SIZE = 5;

// The initial bounds fo the grid.
constexpr uint16_t START_BOUNDS = START_SIZE / 2;

// The size of the array (guarantees a tile will never be pushed out of bounds).
constexpr uint16_t ARRAY_SIZE = MAX_MOVES * 2 + (START_SIZE / 2) + 1;

// The center position of the array.
constexpr uint16_t ARRAY_CENTER = ARRAY_SIZE / 2;

using TilePos = std::pair<int16_t, int16_t>;

class TileMap {
public:
	TileMap();

	void SetTile(int16_t x, int16_t y, char value);
	void ClearTile(int16_t x, int16_t y);

	char GetTile(int16_t x, int16_t y) const;

	bool IsTileUsed(int16_t x, int16_t y) const;

	TilePos GetPosition(char ch) const;

	int16_t GetLeftBound() const;
	int16_t GetRightBound() const;
	int16_t GetTopBound() const;
	int16_t GetBottomBound() const;

	void MoveUp(char ch);
	void MoveDown(char ch);
	void MoveRight(char ch);
	void MoveLeft(char ch);

private:
	void MoveUp(int16_t x, int16_t y, bool isMovementSource);
	void MoveRight(int16_t x, int16_t y, bool isMovementSource);
	void MoveDown(int16_t x, int16_t y, bool isMovementSource);
	void MoveLeft(int16_t x, int16_t y, bool isMovementSource);

	char m_Tiles[ARRAY_SIZE][ARRAY_SIZE];
	TilePos m_Positions[START_SIZE * START_SIZE];

	int16_t m_LeftBound;
	int16_t m_TopBound;
	int16_t m_RightBound;
	int16_t m_BottomBound;
};

TileMap::TileMap() : m_Tiles{ } {
	for (uint16_t y = 0; y < START_SIZE; ++y) {
		for (uint16_t x = 0; x < START_SIZE; ++x) {
			SetTile(x - START_BOUNDS, y - START_BOUNDS, 'A' + (y * START_SIZE) + x);
		}
	}
	m_LeftBound = -START_BOUNDS;
	m_RightBound = START_BOUNDS;
	m_TopBound = -START_BOUNDS;
	m_BottomBound = START_BOUNDS;
}

void TileMap::SetTile(int16_t x, int16_t y, char value) {
	m_Tiles[ARRAY_CENTER + y][ARRAY_CENTER + x] = value;
	if (value != '\0') { // Only update the position of valid values.
		m_Positions[value - 'A'] = { x, y };
	}
}

void TileMap::ClearTile(int16_t x, int16_t y) {
	SetTile(x, y, '\0');
}

char TileMap::GetTile(int16_t x, int16_t y) const {
	return m_Tiles[ARRAY_CENTER + y][ARRAY_CENTER + x];
}

bool TileMap::IsTileUsed(int16_t x, int16_t y) const {
	return GetTile(x, y) != '\0';
}

TilePos TileMap::GetPosition(char ch) const {
	return m_Positions[ch - 'A'];
}

int16_t TileMap::GetLeftBound() const {
	return m_LeftBound;
}

int16_t TileMap::GetRightBound() const {
	return m_RightBound;
}

int16_t TileMap::GetTopBound() const {
	return m_TopBound;
}

int16_t TileMap::GetBottomBound() const {
	return m_BottomBound;
}

void TileMap::MoveUp(char ch) {
	TilePos pos = m_Positions[ch - 'A'];
	MoveUp(pos.first, pos.second, true);
}

void TileMap::MoveDown(char ch) {
	TilePos pos = m_Positions[ch - 'A'];
	MoveDown(pos.first, pos.second, true);
}

void TileMap::MoveLeft(char ch) {
	TilePos pos = m_Positions[ch - 'A'];
	MoveLeft(pos.first, pos.second, true);
}

void TileMap::MoveRight(char ch) {
	TilePos pos = m_Positions[ch - 'A'];
	MoveRight(pos.first, pos.second, true);
}

void TileMap::MoveUp(int16_t x, int16_t y, bool isMovementSource) {
	if (!IsTileUsed(x, y)) {
		return; // Tile is out of bounds or empty.
	}

	// Move the tile above this up one position.
	MoveUp(x, y - 1, false);
	// Move this tile up one position.
	SetTile(x, y - 1, GetTile(x, y));

	if (isMovementSource) {
		ClearTile(x, y);

		// Update the top bound if it has changed.
		if (IsTileUsed(x, m_TopBound - 1)) {
			--m_TopBound; // Shift the top bound up one.
		}

		// Update the bottom bounds if it has changed.
		if (m_BottomBound == y) { // This tile could potentially change the bound.
			for (int16_t i = m_LeftBound; i <= m_RightBound; ++i) { // Check the entire bounds bottom row.
				if (IsTileUsed(i, y)) { // There is a tile on the old bounds still.
					return;
				}
			}
			--m_BottomBound; // Shift the bottom bound up one.
		}
	}
}

void TileMap::MoveDown(int16_t x, int16_t y, bool isMovementSource) {
	if (!IsTileUsed(x, y)) {
		return; // Tile is out of bounds or empty.
	}

	// Move the tile above this up one position.
	MoveDown(x, y + 1, false);
	// Move this tile up one position.
	SetTile(x, y + 1, GetTile(x, y));

	if (isMovementSource) {
		ClearTile(x, y);

		// Update the bottom bound if it has changed.
		if (IsTileUsed(x, m_BottomBound + 1)) {
			++m_BottomBound; // Shift the bottom bound down one.
		}

		// Update the top bound if it has changed.
		if (m_TopBound == y) {
			for (int16_t i = m_LeftBound; i <= m_RightBound; ++i) { // Check the entire top row.
				if (IsTileUsed(i, y)) { // There is a tile on the old bounds still.
					return;
				}
			}
			++m_TopBound; // Shift the top bound down one.
		}
	}
}

void TileMap::MoveLeft(int16_t x, int16_t y, bool isMovementSource) {
	if (!IsTileUsed(x, y)) {
		return; // Tile is out of bounds or empty.
	}

	// Move the tile above this up one position.
	MoveLeft(x - 1, y, false);
	// Move this tile up one position.
	SetTile(x - 1, y, GetTile(x, y));

	if (isMovementSource) {
		ClearTile(x, y);

		// Update the left bound if it has changed.
		if (IsTileUsed(m_LeftBound - 1, y)) {
			--m_LeftBound;
		}

		// Update the right bound if it has changed.
		if (m_RightBound == x) { // The tile could potentially change the bound.
			for (int16_t i = m_TopBound; i <= m_BottomBound; ++i) { // Check the entire right column.
				if (IsTileUsed(x, i)) { // There is a tile on the old bounds still.
					return;
				}
			}
			--m_RightBound; // Shift the right bound left one.
		}
	}
}

void TileMap::MoveRight(int16_t x, int16_t y, bool isMovementSource) {
	if (!IsTileUsed(x, y)) {
		return; // Tile is out of bounds or empty.
	}

	// Move the tile above this up one position.
	MoveRight(x + 1, y, false);
	// Move this tile up one position.
	SetTile(x + 1, y, GetTile(x, y));

	if (isMovementSource) {
		ClearTile(x, y);

		// Update the right bound if it has changed.
		if (IsTileUsed(m_RightBound + 1, y)) {
			++m_RightBound; // Shift the right bound right one.
		}

		// Update the left bound if it has changed.
		if (m_LeftBound == x) { // This tile could potentially change the bound.
			for (int16_t i = m_TopBound; i <= m_BottomBound; ++i) { // Check the entire left column.
				if (IsTileUsed(x, i)) { // There is a tile on the old bounds still.
					return;
				}
			}
			++m_LeftBound; // Shift the left bound right one.
		}
	}
}


void ProcessTestCase(int32_t numMoves) {
	TileMap tiles;

	char ch;
	std::string dir;
	for (int32_t i = 0; i < numMoves; ++i) {
		std::cin >> ch >> dir;

		if (dir == "up") {
			tiles.MoveUp(ch);
		} else if (dir == "right") {
			tiles.MoveRight(ch);
		} else if (dir == "down") {
			tiles.MoveDown(ch);
		} else if (dir == "left") {
			tiles.MoveLeft(ch);
		}
	}

	for (int16_t y = tiles.GetTopBound(); y <= tiles.GetBottomBound(); ++y) {
		int32_t numSpaces = 0;
		for (int16_t x = tiles.GetLeftBound(); x <= tiles.GetRightBound(); ++x) {
			if (tiles.IsTileUsed(x, y)) {
				for (int16_t i = 0; i < numSpaces; ++i) {
					std::cout << ' ';
				}
				numSpaces = 0;
				std::cout << tiles.GetTile(x, y);
			}
			else {
				++numSpaces;
			}
		}
		std::cout << std::endl;
	}
	std::cout << std::endl;

}

int main() {
	int32_t numMoves;
	while (std::cin >> numMoves && numMoves != -1) {
		ProcessTestCase(numMoves);
	}
	std::cin.get();
	return 0;
}
