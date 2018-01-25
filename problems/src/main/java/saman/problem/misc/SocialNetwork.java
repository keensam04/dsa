package saman.problem.misc;

import saman.util.adt.linear.queue.Queue;
import saman.util.adt.linear.queue.QueueImpl;
import saman.util.adt.linear.queue.QueueOverflowException;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * A social network has n active users, numbered from 0 to n-1,
 * who selectively friend other users to create groups of friends within the network.
 * We define the following:
 *
 * - Two users, x and y, are direct friends if ther friend each other on the network
 * - Two users, x and z, are indirect friends if there exists some direct friend y, common to both users x and z.
 * - Two users, x and y, belong to the same group if they are friends (either directly or indirectly) with each other.
 *   In other words, if user x is part of a group. then all of user x's friends and friend of friends belong to the same group.
 * - We describe the number of people in each group as an array of n integers, counts, where each counts(i) (0 <= i < n)
 *   denotes the total number of users in the group that user i belongs to.
 *   For example, if counts = [3,3,3,3,3,1,3], then there are 3 groups; users 0,1,2,3,4 and 6 are in one of two 3-person groups,
 *   and user 5 is in a 1-person group.
 * - A group is valid if all the users in the group have minimal ID numbers.
 *   In other words, a group of size k must contain the k smallest ID numbers belonging to a group of that size with
 *   respect to the smallest user ID in the group. For example, if counts = [3,3,3,3,3,1,3], then the grouping [0,1,2],
 *   [3,4,6] and [5] is valid; however, the grouping [0,1,4],[2,3,6] and [5] is not valid becuse the group [0,1,4] does
 *   not contain the three smallest user IDs for the set of user IDs belonging to 3-person groups (i.e.,{0,10,2,3,4,6}).
 * - We print the information for each valid group on a new line in the format user(smallest ID) ... user(largest ID),
 *   where the users within each group are ordered by ascending ID and the groups themselves are ordered by ascending
 *   user(smallest ID). For example, we print the valid grouping [0,1,2],[3,4,6], and [5] for counts = [3,3,3,3,3,1,3] as:
 *     0 1 2
 *     3 4 6
 *     5
 * Complete the socialGraphs function. It has one parameter: an array of n integers, counts, where each count(i) denotes
 * the total number of users in the group that user i belongs to. The function must print the information for each valid
 * group in the specified format.
 */
public class SocialNetwork {

    /**
     * if counts = [3,3,3,3,3,1,3]
     * then print
     *  0 1 2
     *  3 4 6
     *  5
     * @param counts an array of n integers, counts, where each count(i) denotes the total number of users in the group
     *              that user i belongs to
     * print the information for each valid group in the specified format
     */
    public static void socialGraphs(int[] counts) {
        Map<Integer, Queue> groups = new LinkedHashMap<>();
        Queue group;
        try {
            for (int i=0; i < counts.length; i++) {
                if (groups.containsKey(counts[i])) {
                    group = groups.get(counts[i]);
                    if (group.isFull()) {
                        printResult(group, counts[i]);
                        group = new QueueImpl(counts[i]);
                        groups.remove(counts[i]);
                        groups.put(counts[i], group);
                    }
                } else {
                    group = new QueueImpl(counts[i]);
                    groups.put(counts[i], group);
                }
                group.enqueue(i);
            }
            groups.forEach((groupId, subGroup) -> {
                try {
                    printResult(subGroup, groupId);
                } catch (QueueOverflowException e) {
                    e.printStackTrace();
                }
            });
        } catch (QueueOverflowException e) {
            e.printStackTrace();
        }
    }

    private static void printResult(Queue group, int groupSize) throws QueueOverflowException {
        StringBuilder output = new StringBuilder();
        for (int j = 0; j < groupSize; j++)
            output.append(group.dequeue()).append(" ");
        System.out.println(output);
    }
}
