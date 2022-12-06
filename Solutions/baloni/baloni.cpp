/*
 * Solution to the "Baloni" problem on Kattis.
 * @author Brendan Jones
 */
#include <algorithm>
#include <cstdint>
#include <iostream>
#include <utility>
#include <vector>

//  ALGORITHM OVERVIEW
// 
//  1. Read in an interval of balloons.
//  2. Search through the existing intervals and determine where the new one fits.
//  3. If there are remaining parts of the interval after checking all existing intervals, create a new one with the remaining section.
//  4. If an interval is completed (It's low-end reaches 1), remove it from the list and add 1 to the number of arrows fired.
//  5. After all balloons have been read in, add the number of intervals remaining on the list to the arrow count.

using Interval = std::pair<uint32_t, uint32_t>;
using IntervalList = std::vector<Interval>;

/**
 * Calculates the next interval from the input list.
 *
 * @param numRemaining - The maximum number of elements that can be read into the list.
 * @return The next interval in the input list.
 */
Interval GetNextInterval(uint32_t numRemaining) {
    static uint32_t currHeight = -1;

    Interval interval = { currHeight, currHeight };
    if (currHeight == -1) {
        std::cin >> interval.first;
        interval.second = interval.first;
    }

    for (uint32_t i = 0; i < numRemaining - 1 && std::cin >> currHeight && currHeight == interval.second - 1; ++i) {
        --interval.second;
    }

    return interval;
}

/**
 * Calculates whether the intervals can be merged together.
 * @param a - The existing interval.
 * @param b - The interval being merged in.
 * @return True if the intervals can be merged.
 */
inline bool CanMergeIntervals(const Interval& a, const Interval& b) {
    return b.first >= a.second - 1 && a.second - 1 >= b.second;
}

/**
 * Checks whether an interval is considered valid.
 * @param a The interval to check.
 * @return True if the interval is valid.
 */
inline bool IsIntervalValid(const Interval& a) {
    return (a.first != -1 && a.second != -1 && a.first >= a.second);
}

/**
 * Inserts an interval into the list, and merges it with the
 * existing intervals.
 * @param list The list to insert the interval into.
 * @param interval The interval to insert into the list.
 * @return The number of intervals that were eliminated with the merge.
 */
uint32_t InsertInterval(IntervalList& list, Interval interval) {
    // The number of arrows that were fired to eliminate from the list.
    uint32_t numArrows = 0;

    // Iterate through all of the existing intervals to eliminate
    // complete intervals.
    IntervalList::iterator iter = list.begin();
    while (iter != list.end() && IsIntervalValid(interval)) {
        if (CanMergeIntervals(*iter, interval)) {
            // Merge the bottom part of the interval with the existing one.
            std::swap(iter->second, interval.second);

            // The lowest valid height is 1, so if an interval has this
            // height, it is considered "complete" and can be removed
            // from the list.
            if (iter->second == 1) {
                // Erase the interval from the list and increment the
                // number of arrows fired.
                iter = list.erase(iter);
                ++numArrows;
            } else {
                // Move on to the next interval in the list.
                ++iter;
            }
        } else {
            // Move on to the next interval in the list.
            ++iter;
        }
    }

    // If there is anything remaining of the interval, we will push it
    // onto the back of the list so that other intervals can attempt
    // to merge with it.
    if (IsIntervalValid(interval)) {
        list.push_back(interval);
    }

    // Returns the number of intervals that were removed.
    return numArrows;
}

int main() {
    // The number of balloons to read in.
    uint32_t numBalloons;
    std::cin >> numBalloons;

    // The number of arrows that have been fired.
    uint32_t numArrows = 0;

    IntervalList list;
    while (numBalloons > 0) {
        // Grab the next interval from the input.
        Interval next = GetNextInterval(numBalloons);

        // Add up the number of arrows that would be fired to pop the eliminated intervals.
        numArrows += InsertInterval(list, next);

        // Subtract the number of balloons that we have read from the last interval.
        numBalloons -= 1 + (next.first - next.second);
    }

    // Adds the remaining intervals to the number of arrows fired.
    numArrows += list.size();

    // Print the number of arrows that were fired.
    std::cout << numArrows << std::endl;

    return 0;
}