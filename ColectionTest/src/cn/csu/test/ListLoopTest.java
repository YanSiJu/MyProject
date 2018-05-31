package cn.csu.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.RandomAccess;

/**
 * ����Random Access List(��������б�)�� ArrayList �� Sequence Access List(˳������б�)��
 * LinkedList </br>
 * ��ͬ�����㷨��Ч��</br>
 * ���ۣ�ǰ����ѭ���������õ�����
 */

public class ListLoopTest {

	/**
	 * ��ʼ�� list�����n��Ԫ��
	 * 
	 * @param list
	 * @return
	 */
	public static <T> List<Integer> initList(List<Integer> list, int n) {
		for (int i = 0; i < n; i++)
			list.add(i);
		return list;
	}

	/**
	 * ���� list���ж��Ƿ�ʵ�� RandomAccess �ӿ���ʹ�ò�ͬ�ı�������
	 * 
	 * @param list
	 */
	public static void accessList(List<Integer> list) {
		long startTime = System.currentTimeMillis();

		if (list instanceof RandomAccess) {
			System.out.println("ʵ���� RandomAccess �ӿ�...");
			for (int i = 0; i < list.size(); i++) {
				list.get(i);
			}
		} else {
			System.out.println("ûʵ�� RandomAccess �ӿ�...");
			for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext();) {
				iterator.next();
			}
		}

		long endTime = System.currentTimeMillis();
		System.out.println("����ʱ�䣺" + (endTime - startTime));
	}

	/**
	 * loop ���� list
	 */
	public static void accessListByLoop(List<Integer> list) {
		long startTime = System.currentTimeMillis();

		for (int i = 0; i < list.size(); i++) {
			list.get(i);
		}

		long endTime = System.currentTimeMillis();
		System.out.println("loop����ʱ�䣺" + (endTime - startTime));
	}

	/**
	 * ����������
	 */
	public static void accessListByIterator(List<Integer> list) {
		long startTime = System.currentTimeMillis();

		for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext();) {
			iterator.next();
		}

		long endTime = System.currentTimeMillis();
		System.out.println("Iterator����ʱ�䣺" + (endTime - startTime));
	}

	public static void main(String[] args) {
		List<Integer> aList = (ArrayList<Integer>) initList(new ArrayList<>(), 2000000);
		List<Integer> lList = (LinkedList<Integer>) initList(new LinkedList<>(), 2000000);

		accessList(aList);
		accessList(lList);

		System.out.println("ArrayList");
		accessListByLoop(aList);
		accessListByIterator(aList);

		System.out.println("LinkedList");
		accessListByLoop(lList);
		accessListByIterator(lList);
	}

}

// ���ߣ�LD00000 ���ӣ�https:// www.jianshu.com/p/89aaaee1077e
// ��Դ������ ����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������