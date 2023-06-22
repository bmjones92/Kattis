/**
 * Solution to the "Squawk Virus" problem on Kattis.
 */
#include <iostream>
#include <vector>

class User;

using UserList = std::vector<User>;
using ConnectionList = std::vector<int64_t>;

class User {
public:
	User() {
		m_NumMessagesToSend = 0;
		m_NumMessagesReceived = 0;
	}

	void AddConnection(uint64_t id) {
		m_Connections.push_back(id);
	}

	void OnTickBegin() {
		m_NumMessagesToSend = m_NumMessagesReceived;
		m_NumMessagesReceived = 0;
	}

	void OnMessageReceived(uint64_t numMessages) {
		m_NumMessagesReceived += numMessages;
	}

	uint64_t SendMessages(UserList& users) {
		// The user is not infected currently.
		if (m_NumMessagesToSend == 0) {
			return 0;
		}

		// Send infected messages to each connection.
		for (auto& userID : m_Connections) {
			users[userID].OnMessageReceived(m_NumMessagesToSend);
		}

		// Return the number of messages sent to our connections.
		return m_Connections.size() * m_NumMessagesToSend;
	}

private:
	uint64_t m_NumMessagesToSend;
	uint64_t m_NumMessagesReceived;
	uint64_t m_UserID;

	ConnectionList m_Connections;
};


int main() {
	uint64_t numUsers;
	std::cin >> numUsers;

	uint64_t numConnections;
	std::cin >> numConnections;

	uint64_t initialInfectedID;
	std::cin >> initialInfectedID;

	uint64_t totalTime;
	std::cin >> totalTime;

	UserList users(numUsers);

	users[initialInfectedID].OnMessageReceived(1);

	uint64_t firstID;
	uint64_t secondID;
	for (uint64_t i = 0; i < numConnections; ++i) {
		std::cin >> firstID >> secondID;

		// Make the connection between the two nodes.
		users[firstID].AddConnection(secondID);
		users[secondID].AddConnection(firstID);
	}

	uint64_t numSquawksSent = 0;
	for (uint64_t i = 0; i < totalTime; ++i) {

		// Push the old states back and use current states.
		for (auto& user : users) {
			user.OnTickBegin();
		}

		// We only care about the number sent at that the specified time, not total.
		if (i == totalTime - 1) {
			numSquawksSent = 0;
		}

		// Send infected messages.
		for (auto& user : users) {
			numSquawksSent += user.SendMessages(users);
		}
	}

	// Print the number of infections at the specified time.
	std::cout << numSquawksSent << std::endl;

	return 0;
}