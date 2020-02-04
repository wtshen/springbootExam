package com.swt.generic;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 9:22 AM 2020/2/4.
 * @Modified By:
 */

import java.util.ArrayList;
import java.util.List;

public class Node<T extends Comparable<T>> {
    public Node<T> leftNode;
    public Node<T> rightNode;
    public T value;

    public void add(T v) {
        if (value == null) {
            value = v;
        } else {
            // 新加入的值比当前结点的值更小，把他放到当前结点的左结点
            if (v.compareTo(value) < 0) {
                if (leftNode == null) {
                    leftNode = new Node<T>();
                }
                leftNode.add(v);
            } else {
                if (rightNode == null) {
                    rightNode = new Node<T>();
                }
                rightNode.add(v);
            }
        }
    }

    public List<T> Inorder() { // 中序遍历，本质是递归
        List<T> values = new ArrayList<T>();
        if (leftNode != null) {
            values.addAll(leftNode.Inorder());
        }
        values.add(value);
        if (rightNode != null) {
            values.addAll(rightNode.Inorder());
        }
        return values;
    }

    public static void main(String[] args) {
        // 支持泛型的Node既可以支持Integer，也可以支持Float
        Node<Integer> root = new Node<>();
        for (int i = 0; i < 10; i++) {
            root.add((int) (Math.round(Math.random() * 100)));
        }
        System.out.println(root.Inorder());

        Node<Float> fRoot = new Node<>();
        for (int i = 0; i < 10; i++) {
            fRoot.add((float) (Math.random() * 100));
        }

        System.out.println(fRoot.Inorder());
    }
}
