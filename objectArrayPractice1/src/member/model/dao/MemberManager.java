package member.model.dao;

import java.util.Scanner;

import member.model.dto.Member;

public class MemberManager {
	Scanner sc = new Scanner(System.in);

	public static final int SIZE = 10;
	Member[] mem = new Member[SIZE];
	Member tmem = new Member();
	int cnt = 0;

	public void memberInput() {
		if (cnt == SIZE) {
			System.out.println("메모리가 가득 찼습니다.");
			return;
		}

		mem[cnt] = new Member();

		System.out.println("\n---------- " + (cnt + 1) + "번 정보 등록 ----------\n");

		System.out.print("ID : ");
		String s = sc.next();
		if (searchMemberId(s) == -1)
			mem[cnt].setId(s);
		else {
			System.out.println("ID 가 중복됩니다.");
			return;
		}
		System.out.print("name : ");
		mem[cnt].setName(sc.next() + sc.nextLine());
		System.out.print("Password : ");
		mem[cnt].setPassword(sc.next() + sc.nextLine());
		System.out.print("eMail : ");
		mem[cnt].setEmail(sc.next() + sc.nextLine());
		System.out.print("gender : ");
		mem[cnt].setGender(sc.next().toUpperCase().charAt(0));
		System.out.print("Age : ");
		mem[cnt].setAge(sc.nextInt());
		System.out.println();
		cnt++;
	}

	public int searchMemberId(String s) {

		int count;

		for (int i = 0; i < cnt; i++) {
			if (mem[i].getId().length() == s.length()) {
				count = 0;
				for (int j = 0; j < s.length(); j++) {
					if (mem[i].getId().charAt(j) == s.charAt(j)) {
						count++;
					}
				}
				if (s.length() == count)
					return i;
			}
		}

		return -1;
	}

	public int searchMemberName(String s) {
		int count;

		for (int i = 0; i < cnt; i++) {
			if (mem[i].getName().length() == s.length()) {
				count = 0;
				for (int j = 0; j < s.length(); j++) {
					if (mem[i].getName().charAt(j) == s.charAt(j)) {
						count++;
					}
				}
				if (s.length() == count)
					return i;
			}
		}

		return -1;
	}

	public int searchMemberEmail(String s) {
		int count;

		for (int i = 0; i < cnt; i++) {
			if (mem[i].getEmail().length() == s.length()) {
				count = 0;
				for (int j = 0; j < s.length(); j++) {
					if (mem[i].getEmail().charAt(j) == s.charAt(j)) {
						count++;
					}
				}
				if (s.length() == count)
					return i;
			}
		}

		return -1;
	}

	public void printMember(int index) {
		System.out.println(mem[index].memberInfo());
	}

	public void deleteMember() {

	}

	public void printAllMember() {
		// TODO Auto-generated method stub
		for (int i = 0; i < cnt; i++)
			printMember(i);
	}

	public void sortIDAsc() {
		// id 오름차순
		for (int i = 0; i < cnt - 1; i++) {
			for (int j = i; j < cnt; j++) {
				if (mem[i].getId().compareTo(mem[j].getId()) <0) {
					tmem = mem[i];
					mem[i] = mem[j];
					mem[j] = tmem;					
				}
			}
		}
	}

	public void sortIDDes() {
		// id 내림차순
		for (int i = 0; i < cnt - 1; i++) {
			for (int j = i; j < cnt; j++) {
				if (mem[i].getId().compareTo(mem[j].getId()) > 0) {
					tmem = mem[i];
					mem[i] = mem[j];
					mem[j] = tmem;					
				}
			}
		}
	}

	public void sortAgeAsc() {
		// 나이 오름차순
		for (int i = 0; i < cnt - 1; i++) {
			for (int j = i; j < cnt; j++) {
				if (mem[i].getAge() > mem[j].getAge()) {
					tmem = mem[i];
					mem[i] = mem[j];
					mem[j] = tmem;
				}
			}
		}
	}

	public void sortAgeDes() {
		// 나이 내림차순
		for (int i = 0; i < cnt - 1; i++) {
			for (int j = i; j < cnt; j++) {
				if (mem[i].getAge() < mem[j].getAge()) {
					tmem = mem[i];
					mem[i] = mem[j];
					mem[j] = tmem;
				}
			}
		}
	}

	public void sortGenderDes() {
		// 성별 내림차순 남여순
		sortIDAsc();
		for (int i = 0; i < cnt - 1; i++) {
			for (int j = i; j < cnt; j++) {
				if (mem[i].getGender() > mem[j].getGender()) {
					tmem = mem[i];
					mem[i] = mem[j];
					mem[j] = tmem;
				}
			}
		}
	}

	public void changePassword(int index, String s) {
		mem[index].setPassword(s);

	}

	public void changeEmail(int index, String s) {
		mem[index].setEmail(s);
	}

	public void changeAge(int index, int age) {
		mem[index].setAge(age);
	}

}
