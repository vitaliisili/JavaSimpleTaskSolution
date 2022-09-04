import java.util.*;

/* Java Deque
In computer science, a double-ended queue (dequeue, often abbreviated to deque, pronounced deck) is an
abstract data type that generalizes a queue, for which elements can be added to or removed from either the
front (head) or back (tail).
Deque interfaces can be implemented using various types of collections such as LinkedList or ArrayDeque
classes. For example, deque can be declared as:
Deque deque = new LinkedList<>();
or
Deque deque = new ArrayDeque<>();
You can find more details about Deque here.
In this problem, you are given N integers. You need to find the maximum number of unique integers among
all the possible contiguous subarrays of size M.
Note: Time limit is 3 second for this problem.
Input Format
The first line of input contains two integers N and M: representing the total number of integers and
the size of the subarray, respectively. The next line contains N space separated integers.
Constraints
1≤N≤100000
1≤M≤100000
M≤N
The numbers in the array will range between [0,10000000].
Output Format
Print the maximum number of unique integers among all possible contiguous subarrays of size M separated by a space.
Sample Input
6 3
5 3 5 2 3 2
Sample Output
3
*/
public class DequeSubarrays {

    public static void main(String[] args) {
        List<Integer> N = List.of(5, 3, 5, 2, 3, 2, 4, 6);
        int M = 4;
        maxUniqueNumber(N, M); // 4
    }

    public static void maxUniqueNumber(List<Integer> numbers, int size) {
        Deque<Integer> deque = new ArrayDeque();
        int maxUnique = 0;
        for (int i = 0; i < numbers.size(); i++) {
            int num = numbers.get(i);
            if(i == 0){
                deque.add(num);
                maxUnique++;
            }else{
                if(deque.size() == size){
                    deque.removeFirst();
                }
                if(!deque.contains(num) && maxUnique < size){
                    maxUnique++;
                }
                deque.addLast(num);
            }
        }

        System.out.println(maxUnique);
    }
}
