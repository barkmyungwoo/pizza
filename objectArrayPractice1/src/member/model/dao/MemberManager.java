package member.model.dao;

import java.util.Scanner;

import member.model.dto.Member;

public class MemberManager {
	Scanner sc = new Scanner(System.in);

	public static final int SIZE = 10;
	Member[] mem = new Member[SIZE];
	Member tmem = new Member();
	int cnt = 0;

	
//------------------------------------------------------------------------

	{
		mem[0] = new Member("kim12*3", "������", "01234!", "kim123@hanmail.net", 'M', 33);
		mem[1] = new Member("bmw923", "�ڸ��", "45678", "kim123@google.com", 'M', 17);
		mem[2] = new Member("kongyou", "����", "850923", "kim123@naver.com", 'M', 32);
		mem[3] = new Member("bbakayaro", "�̼���", "pwkkk34!", "kim123@naver.com", 'M', 35);
		mem[4] = new Member("yksrose77#", "�����", "yksrose77#", "yksrose77@daum.net", 'F', 29);
		cnt = 5;

	}

//------------------------------------------------------------------------
	
	
	
	
	
	public void memberInput() {
		if (cnt == SIZE) {
			System.out.println("�޸𸮰� ���� á���ϴ�.");
			return;
		}

		mem[cnt] = new Member();

		System.out.println("\n---------- " + (cnt + 1) + "�� ���� ��� ----------\n");

		System.out.print("ID : ");
		String s = sc.next();
		if (searchMemberId(s) == -1)
			mem[cnt].setId(s);
		else {
			System.out.println("ID �� �ߺ��˴ϴ�.");
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
		System.out.print("������ ID �� ���� �ּ��� : ");
		int index = searchMemberId(sc.next());

		if (index == -1) {
			System.out.println("���̵� �����.");
			return;
		}

		System.out.println("��й�ȣ�� �˷� �ּ��� : ");
		String s = sc.next();
		int count=0;

		if (mem[index].getPassword().length() == s.length()) {
			for (int j = 0; j < s.length(); j++) {
				if (mem[index].getPassword().charAt(j) == s.charAt(j)) {
					count++;
				}
			}
			if (s.length() == count) {
				mem[index]= new Member();
				System.out.println("�����Ǿ����ϴ�.");

				for(int i=index;i<cnt-1;i++){
					mem[i] = mem[i+1];
				}				
				mem[cnt]= new Member();
				cnt--;
			}
		}
	}

	public void printAllMember() {
		// TODO Auto-generated method stub
		for (int i = 0; i < cnt; i++)
			printMember(i);
	}

	public void sortIDAsc() {
		// id ��������
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

	public void sortIDDes() {
		// id ��������
		for (int i = 0; i < cnt - 1; i++) {
			for (int j = i; j < cnt; j++) {
				if (mem[i].getId().compareTo(mem[j].getId()) < 0) {
					tmem = mem[i];
					mem[i] = mem[j];
					mem[j] = tmem;
				}
			}
		}
	}

	public void sortAgeAsc() {
		// ���� ��������
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
		// ���� ��������
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
		// ���� �������� ������
		sortIDAsc();
		for (int i = 0; i < cnt - 1; i++) {
			for (int j = i; j < cnt; j++) {
				if (mem[i].getGender() < mem[j].getGender()) {
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
