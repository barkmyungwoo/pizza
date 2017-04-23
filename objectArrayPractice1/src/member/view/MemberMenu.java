package member.view;

import java.util.Scanner;
import member.model.dao.MemberManager;

public class MemberMenu {
	Scanner sc = new Scanner(System.in);
	MemberManager mem = new MemberManager();

	public void mainMenu() {
		int a;
		do {
			System.out.println("***** ȸ�� ���� ���α׷� *****");
			System.out.println("1. �� ȸ�� ���");
			System.out.println("2. ȸ�� ��ȸ");
			System.out.println("3. ȸ�� ���� ����");
			System.out.println("4. ȸ�� ���� ����");
			System.out.println("5. ȸ�� ����");
			System.out.println("6. ��� ���");
			System.out.println("9. ������");
			System.out.print("�޴� ���� :");
			a = sc.nextInt();

			switch (a) {
			case 1:
				mem.memberInput();
				break;
			case 2:
				searchMenu();
				break;
			case 3:
				modifyMenu();
				break;
			case 4:
				sortMenu();
				break;
			case 5:
				mem.deleteMember();
				break;
			case 6:
				mem.printAllMember();
				break;
			case 9:
				System.out.println("are you really? Y/N");
				char c = sc.next().toUpperCase().charAt(0);
				if (c == 'Y')
					return;
				break;

			default:
				System.out.println("�߸� ������ ��?");
			}
		} while (a != 9);

		System.out.println("ȸ������ ���α׷��� �����մϴ�.");
	}

	public void searchMenu() {
		int a, index = -1;
		do {
			System.out.println("***** ȸ�� ���� �˻� �޴� *****");
			System.out.println("1. ���̵�� �˻�");
			System.out.println("2. �̸����� �˻�");
			System.out.println("3. �̸��Ϸ� �˻�");
			System.out.println("9. ���� �޴��� ����");
			System.out.print("�޴� ���� :");
			a = sc.nextInt();

			switch (a) {
			case 1:
				System.out.print("ID�� ���� �ּ��� :");
				index = mem.searchMemberId(sc.next());

				if (index == -1)
					System.out.println("���� ID �Դϴ�.");
				else
					mem.printMember(index);
				break;

			case 2:
				System.out.print("�̸��� ���� �ּ��� :");
				index = mem.searchMemberName(sc.next());

				if (index == -1)
					System.out.println("���� �̸� �Դϴ�.");
				else
					mem.printMember(index);
				break;

			case 3:
				System.out.print("�̸����� ���� �ּ��� :");
				index = mem.searchMemberEmail(sc.next());

				if (index == -1)
					System.out.println("���� �̸��� �Դϴ�.");
				else
					mem.printMember(index);
				break;

			case 9:
				System.out.println("���� �޴��� ȭ�� �̵��մϴ�.");
				return;

			default:
			}

		} while (a != 9);
	}

	public void sortMenu() {
		int a;
		do {
			System.out.println("***** ȸ�� ���� ���� ��� �޴� *****");
			System.out.println("1. ���̵� �������� ���� ���");
			System.out.println("2. ���̵� �������� ���� ���");
			System.out.println("3. ���� �������� ���� ���");
			System.out.println("4. ���� �������� ���� ���");
			System.out.println("5. ���� �������� ���� ���(������)");
			System.out.println("9. ���� �޴��� ����");
			System.out.print("�޴� ���� :");
			a = sc.nextInt();

			switch (a) {
			case 1:
				mem.sortIDAsc();
				mem.printAllMember();

				break;
			case 2:
				mem.sortIDDes();
				mem.printAllMember();

				break;
			case 3:
				mem.sortAgeAsc();
				mem.printAllMember();

				break;
			case 4:
				mem.sortAgeDes();
				mem.printAllMember();

				break;
			case 5:
				mem.sortGenderDes();
				mem.printAllMember();

				break;
			case 9:
				System.out.println("���� �޴��� ȭ�� �̵��մϴ�.");

				return;
			default:
			}
		} while (a != 9);
	}

	public void modifyMenu() {
		int a, index = -1;

		do {
			System.out.println("***** ȸ�� ���� ���� �޴� *****");
			System.out.println("1. ��ȣ ����");
			System.out.println("2. �̸��� ����");
			System.out.println("3. ���� ����");
			System.out.println("9. ���� �޴��� ����");
			System.out.print("�޴� ���� :");
			a = sc.nextInt();

			switch (a) {

			case 1:
				System.out.print("���̵� ���� �ּ��� :");
				index = mem.searchMemberId(sc.next() + sc.nextLine());
				if (index == -1) {
					System.out.println("���̵� �����..");
					break;
				}
				mem.printMember(index);
				System.out.print("������ ��ȣ�� �Է��ϼ��� : ");
				mem.changePassword(index, sc.next());
				break;

			case 2:
				System.out.print("���̵� ���� �ּ��� :");
				index = mem.searchMemberId(sc.next() + sc.nextLine());
				if (index == -1) {
					System.out.println("���̵� �����..");
					break;
				}
				mem.printMember(index);
				System.out.print("������ �̸����� �Է��ϼ��� : ");
				mem.changeEmail(index, sc.next());
				break;

			case 3:
				System.out.print("���̵� ���� �ּ��� :");
				index = mem.searchMemberId(sc.next() + sc.nextLine());
				if (index == -1) {
					System.out.println("���̵� �����..");
					break;
				}
				mem.printMember(index);
				System.out.print("������ ���̸� �Է��ϼ��� : ");
				mem.changeAge(index, sc.nextInt());
				break;

			case 9:
				System.out.println("���� �޴��� ȭ�� �̵��մϴ�.");
				return;

			default:
			}

		} while (a != 9);
	}
}
