package yobdc.offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 */
public class Problem09 {
    class CQueue {
        Deque<Integer> main;
        Deque<Integer> tmp;

        public CQueue() {
            main = new ArrayDeque<>();
            tmp = new ArrayDeque<>();
        }

        public void appendTail(int value) {
            while (!main.isEmpty()) {
                tmp.push(main.pop());
            }
            main.push(value);
            while (!tmp.isEmpty()) {
                main.push(tmp.pop());
            }
        }

        public int deleteHead() {
            if (main.isEmpty()) {
                return -1;
            }
            int result = main.pop();
            return result;
        }
    }
}
