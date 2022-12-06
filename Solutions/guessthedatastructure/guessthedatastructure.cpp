/**
 * Solution to the "I Can Guess the Data Structure!" problem on Kattis.
 * @author Brendan Jones
 */
#include <cstdint>
#include <iostream>
#include <queue>
#include <stack>

// Bit masks for different data structures.
enum BitFlag : uint32_t {
    None = 0,
    Stack = (1 << 0),
    Queue = (1 << 1),
    PQueue = (1 << 2)
};

// Different operations that can be performed on the data structures.
enum Command : uint32_t {
    Push = 1,
    Pop = 2
};

bool ProcessTestCase() {
    // The number of commands in this test case, or 0 if this is the terminal case.
    int32_t numCommands;
    if (!(std::cin >> numCommands)) {
        return false;
    }

    // The underlying stack, queue, and priority queue.
    std::stack<int32_t> myStack;
    std::queue<int32_t> myQueue;
    std::priority_queue<int32_t> myPQueue;

    // All three data structures are possibilities at the start.
    uint32_t flags = BitFlag::Stack | BitFlag::Queue | BitFlag::PQueue;

    int32_t command;
    int32_t value;
    for (int32_t i = 0; i < numCommands; ++i) {
        std::cin >> command >> value;

        switch (command) {
            // Push command inserts a value into the data structure.
            case Command::Push: {
                myStack.push(value);
                myQueue.push(value);
                myPQueue.push(value);
                break;
            }

            // Pop command removes a value from all three data structures. Operand indicates the expected result.
            case Command::Pop: {
                // The data structures are empty so rule them all out.
                if (myStack.size() == 0) {
                    flags = BitFlag::None;
                    break;
                }

                if (myStack.top() != value) {
                    flags &= ~BitFlag::Stack;
                }
                myStack.pop();

                if (myQueue.front() != value) {
                    flags &= ~BitFlag::Queue;
                }
                myQueue.pop();

                if (myPQueue.top() != value) {
                    flags &= ~BitFlag::PQueue;
                }
                myPQueue.pop();

                break;
            }
        }
    }

    switch (flags) {
        case BitFlag::None:
            std::cout << "impossible" << std::endl;
            break;
        case BitFlag::Stack:
            std::cout << "stack" << std::endl;
            break;
        case BitFlag::Queue:
            std::cout << "queue" << std::endl;
            break;
        case BitFlag::PQueue:
            std::cout << "priority queue" << std::endl;
            break;
        default:
            std::cout << "not sure" << std::endl;
            break;
    }

    return true;
}

int main() {
    while (ProcessTestCase());
    return 0;
}