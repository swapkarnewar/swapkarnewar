package com.mahe.cache;

import java.util.ArrayList;
import java.util.List;

public class CacheTestMain {

	public static void main(String[] args) {
		Employee e = new Employee();
		List<Integer> deptList = new ArrayList<>();
		deptList.add(23);
		deptList.add(24);
		deptList.add(63);
		deptList.add(43);
		e.setDeptId(deptList);
		e.setName("Swapnil");
		e.setEmployeeId(2779);

		CacheManager.putInCache(e, 1);

		Employee z = new Employee();
		List<Integer> deptListz = new ArrayList<>();
		deptListz.add(23);
		deptListz.add(24);
		deptListz.add(63);
		deptListz.add(43);
		z.setDeptId(deptListz);
		z.setName("Swapnil");
		z.setEmployeeId(2779);

		Employee obj = (Employee) CacheManager.getCache(z);

		System.out.println("Cached Object: " + obj);
	}

}
