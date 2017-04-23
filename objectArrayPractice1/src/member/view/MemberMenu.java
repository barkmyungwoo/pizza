package member.view;

import java.util.Scanner;
import member.model.dao.MemberManager;

public class MemberMenu {
	Scanner sc = new Scanner(System.in);
	MemberManager mem = new MemberManager();

	public void mainMenu() {
		int a;
		do {
			System.out.println("***** 회원 관리 프로그램 *****");
			System.out.println("1. 새 회원 등록");
			System.out.println("2. 회원 조회");
			System.out.println("3. 회원 정보 수정");
			System.out.println("4. 회원 정보 정렬");
			System.out.println("5. 회원 삭제");
			System.out.println("6. 모두 출력");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 선택 :");
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
				System.out.println("잘못 눌렀을 껄?");
			}
		} while (a != 9);

		System.out.println("회원관리 프로그램을 종료합니다.");
	}

	public void searchMenu() {
		int a, index = -1;
		do {
			System.out.println("***** 회원 정보 검색 메뉴 *****");
			System.out.println("1. 아이디로 검색");
			System.out.println("2. 이름으로 검색");
			System.out.println("3. 이메일로 검색");
			System.out.println("9. 이전 메뉴로 가기");
			System.out.print("메뉴 선택 :");
			a = sc.nextInt();

			switch (a) {
			case 1:
				System.out.print("ID를 적어 주세요 :");
				index = mem.searchMemberId(sc.next());

				if (index == -1)
					System.out.println("없는 ID 입니다.");
				else
					mem.printMember(index);
				break;

			case 2:
				System.out.print("이름을 적어 주세요 :");
				index = mem.searchMemberName(sc.next());

				if (index == -1)
					System.out.println("없는 이름 입니다.");
				else
					mem.printMember(index);
				break;

			case 3:
				System.out.print("이메일을 적어 주세요 :");
				index = mem.searchMemberEmail(sc.next());

				if (index == -1)
					System.out.println("없는 이메일 입니다.");
				else
					mem.printMember(index);
				break;

			case 9:
				System.out.println("메인 메뉴로 화면 이동합니다.");
				return;

			default:
			}

		} while (a != 9);
	}

	public void sortMenu() {
		int a;
		do {
			System.out.println("***** 회원 정보 정렬 출력 메뉴 *****");
			System.out.println("1. 아이디 오름차순 정렬 출력");
			System.out.println("2. 아이디 내림차순 정렬 출력");
			System.out.println("3. 나이 오름차순 정렬 출력");
			System.out.println("4. 나이 내림차순 정렬 출력");
			System.out.println("5. 성별 내림차순 정렬 출력(남여순)");
			System.out.println("9. 이전 메뉴로 가기");
			System.out.print("메뉴 선택 :");
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
				System.out.println("메인 메뉴로 화면 이동합니다.");

				return;
			default:
			}
		} while (a != 9);
	}

	public void modifyMenu() {
		int a, index = -1;

		do {
			System.out.println("***** 회원 정보 수정 메뉴 *****");
			System.out.println("1. 암호 변경");
			System.out.println("2. 이메일 변경");
			System.out.println("3. 나이 변경");
			System.out.println("9. 이전 메뉴로 가기");
			System.out.print("메뉴 선택 :");
			a = sc.nextInt();

			switch (a) {

			case 1:
				System.out.print("아이디를 적어 주세요 :");
				index = mem.searchMemberId(sc.next() + sc.nextLine());
				if (index == -1) {
					System.out.println("아이디가 없어요..");
					break;
				}
				mem.printMember(index);
				System.out.print("변경할 암호를 입력하세요 : ");
				mem.changePassword(index, sc.next());
				break;

			case 2:
				System.out.print("아이디를 적어 주세요 :");
				index = mem.searchMemberId(sc.next() + sc.nextLine());
				if (index == -1) {
					System.out.println("아이디가 없어요..");
					break;
				}
				mem.printMember(index);
				System.out.print("변경할 이메일을 입력하세요 : ");
				mem.changeEmail(index, sc.next());
				break;

			case 3:
				System.out.print("아이디를 적어 주세요 :");
				index = mem.searchMemberId(sc.next() + sc.nextLine());
				if (index == -1) {
					System.out.println("아이디가 없어요..");
					break;
				}
				mem.printMember(index);
				System.out.print("변경할 나이를 입력하세요 : ");
				mem.changeAge(index, sc.nextInt());
				break;

			case 9:
				System.out.println("메인 메뉴로 화면 이동합니다.");
				return;

			default:
			}

		} while (a != 9);
	}
}
