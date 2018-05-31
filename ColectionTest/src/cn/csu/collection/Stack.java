package cn.csu.collection;

import java.util.Deque;
import java.util.LinkedList;

public class Stack<E> {

	public Stack() {
	}

	private Deque<E> stack = new LinkedList<>();

	// ��ջ
	public E pop() {
		return stack.pop();
	}

	// ��ջ
	public void push(E e) {
		stack.push(e);
	}

	// ����ջ��Ԫ��
	public E peek() {
		return stack.peek();
	}

	// ����ջ��Ԫ��
	public E peekLast() {
		return stack.peekLast();
	}

	public boolean isEmpty() {
		return stack.isEmpty();
	}

	public int size() {
		return stack.size();
	}

	public String toString() {
		return stack.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stack<?> other = (Stack<?>) obj;
		if (stack == null) {
			if (other.stack != null)
				return false;
		} else if (!stack.equals(other.stack))
			return false;
		return true;
	}

}
