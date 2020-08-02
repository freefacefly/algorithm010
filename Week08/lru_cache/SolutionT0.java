package io.kvh.algo.w8.c17.lru_cache;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kvh on 2020/8/1.
 * https://leetcode-cn.com/problems/lru-cache
 */
public class SolutionT0 {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2 /* 缓存容量 */);

        cache.put(1, 1);
        cache.put(2, 2);
        Assert.assertEquals(cache.get(1), 1);       // 返回  1
        cache.put(3, 3);    // 该操作会使得关键字 2 作废
        Assert.assertEquals(cache.get(2), -1);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得关键字 1 作废
        Assert.assertEquals(cache.get(1), -1);       // 返回 -1 (未找到)
        Assert.assertEquals(cache.get(3), 3);       // 返回  3
        Assert.assertEquals(cache.get(4), 4);       // 返回  4
    }

    static class LRUCache {

        private DLinkList dLinkList;
        private Map<Integer, Node> cache;
        private int capacity;
        private int size;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            size = 0;
            dLinkList = new DLinkList();
            cache = new HashMap<>();
        }

        public int get(int key) {
            Node node = cache.get(key);
            if (node == null) {
                return -1;
            }

            dLinkList.moveToFirst(node);
            return node.value;
        }

        public void put(int key, int value) {
            Node node = cache.get(key);
            if (node == null) {
                node = new Node(key, value);
                cache.put(key, node);
                dLinkList.addFirst(node);
                size++;
                if (size > capacity) {
                    Node tail = dLinkList.remoteLast();
                    cache.remove(tail.key);
                    size--;
                }
            } else {
                node.value = value;
                dLinkList.moveToFirst(node);
            }
        }
    }


    static class DLinkList {
        /**
         * dummy head,tail
         */
        private Node head, tail;

        public DLinkList() {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }

        /**
         * head<->n1
         * head<->[node]<->n1
         *
         * @param node
         */
        public void addFirst(Node node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        public void moveToFirst(Node node) {
            remove(node);
            addFirst(node);
        }

        /**
         * n1<->[node]<->n2
         * n1<->n2
         *
         * @param node
         */
        public void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        /**
         * n2<->[node]<->tail
         * n2<->tail
         *
         * @return
         */
        public Node remoteLast() {
            Node node = tail.prev;
            remove(node);
            return node;
        }
    }

    static class Node {
        public int key, value;
        public Node prev, next;

        public Node() {
        }

        public Node(int k, int v) {
            this.key = k;
            this.value = v;
        }
    }
}
