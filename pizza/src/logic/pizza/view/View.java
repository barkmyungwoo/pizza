package logic.pizza.view;

import java.util.Scanner;

import logic.pizza.model.PizzaModel;

public class View {

	Scanner sc = new Scanner(System.in);

	public void display() {

		PizzaModel disOrder = new PizzaModel();
		int mainNum, order = 1;
		String[] allOrder = new String[100];
		String tmp;
		do {
			allOrder[order - 1] = "";
			System.out.println("\n\n****바람 피자****\n");

			System.out.println("1. 피자 고르기");
			System.out.println("2. 피자 만들기");
			System.out.println("3. 사이드 메뉴");
			System.out.println("4. 음료");
			System.out.println("5. 쿠폰");
			System.out.println("6. 내 주문 내역 ");
			System.out.println("7. 주문 완료");
			System.out.println("8. 주문 취소");

			System.out.print("번호를 누르시오 : ");
			mainNum = sc.nextInt();

			switch (mainNum) {
			case 1:
				allOrder[order - 1] += pizzaMenu();
				if (allOrder[order - 1] != "")
					order++;
				break;

			case 2:
				allOrder[order - 1] += "P20" + pizzaMadeMenu();
				order++;
				break;

			case 3:
				allOrder[order - 1] += sideMenu();
				order++;
				break;

			case 4:
				allOrder[order - 1] += beverage();
				order++;
				break;

			case 5:
				coupon();
				break;

			case 6:
				for (int i = 0; i < allOrder.length; i++) {
					if (allOrder[i] == "")
						break;
					System.out.println(disOrder.pizzaInfo(allOrder[i]));
				}
				break;
			// case 7:finalOrder();
			// break;
			case 8:
				;
				break;
			default:
				System.out.println("잘못된 번호 입력 다시.!");
			}
		} while (true);

	}

	// -------------------------------------------------------------------------

	public String pizzaMenu() {
		String order, pizza = "";
		int piz = 0;

		do {
			System.out.println("\n\n****일반 피자****\n");
			System.out.println("1. 치즈 피자		R - 10,000/L - 12,000");
			System.out.println("2. 슈퍼 슈프림 피자		R - 12,000/L - 15,000");
			System.out.println("3. 불고기 피자		R - 12,000/L - 15,000");
			System.out.println("4. 포테이토 피자		R - 12,000/L - 15,000");
			System.out.println("5. 페퍼로니 피자 		R - 12,000/L - 15,000");
			System.out.println("6. 하와이판 피자 		R - 12,000/L - 15,000");

			System.out.println("\n****스페셜 피자****\n");
			System.out.println("7. 갈릭 비프 피자		R - 25,000/L - 30,000");
			System.out.println("8. 로스트 갈릭 치킨 피자	R - 25,000/L - 30,000");
			System.out.println("9. 베이컨 스테이크 피자	R - 25,000/L - 30,000");
			System.out.println("10. 고르곤 졸라 피자		R - 20,000/L - 25,000");
			System.out.println("11. 시카고 피자 		R - 25,000/L - 35,000");

			System.out.print("번호를 누르시오 : ");
			piz = sc.nextInt();

			switch (piz) {
			case 1:
				pizza = "P01";
				break;
			case 2:
				pizza = "P02";
				break;
			case 3:
				pizza = "P03";
				break;
			case 4:
				pizza = "P04";
				break;
			case 5:
				pizza = "P05";
				break;
			case 6:
				pizza = "P06";
				break;
			case 7:
				pizza = "P07";
				break;
			case 8:
				pizza = "P08";
				break;
			case 9:
				pizza = "P09";
				break;
			case 10:
				pizza = "P10";
				break;
			case 11:
				pizza = "P11";
				break;
			default:
				System.out.println("잘못된 번호임");
			}

		} while (pizza.charAt(0) != 'P');

		order = pizzaSide();

		System.out.println(order + " : return String pizzaSide"); // check

		if (order == "")
			return "";

		if (order.length() != 0) {
			pizza += order;

			System.out.println(pizza + " : pizza + order"); // check

			return pizza;
		}

		return "";
	}

	// -------------------------------------------------------------------------
	public String pizzaMadeMenu() {
		int num = 0;
		String orderAll, orderSide, order1 = "1", order2 = "1", order3 = "00000000000000", order4 = "12";
		do {
			System.out.println("\n\n****피자 만들기****\n");
			System.out.println("1. 도우");
			System.out.println("2. 소스");
			System.out.println("3. 토핑");
			System.out.println("4. 치즈");
			System.out.println("5. 주문완료 ");

			System.out.print("번호를 누르시오 : ");
			num = sc.nextInt();

			switch (num) {
			case 1:
				order1 = pizzaMadeMenu1(order1); // 도우 디펄트 밀가루
				break;
			case 2:
				order2 = pizzaMadeMenu2(order2); // 소스 디펄트 토마토
				break;
			case 3:
				order3 = pizzaMadeMenu3(order3); // 토핑 디펄트 0000000000000
				break;
			case 4:
				order4 = pizzaMadeMenu4(order4); // 치즈 디펄트 중간
				break;
			case 5:
				orderSide = pizzaSide();
				orderAll = orderSide + order1 + order2 + order3 + order4;

				System.out.println(orderAll + "make order");

				return orderAll;
			default:

			}
		} while (true);

	}

	public String pizzaMadeMenu1(String str) {
		System.out.println("		- 도우 -");
		System.out.println("1. 밀가루					 		 - 7,000");
		System.out.println("2. 쌀가루					 		 - 8,000");

		System.out.print("번호를 누르시오 : ");
		int a = sc.nextInt();

		if (a == 1)
			return "1";
		if (a == 2)
			return "2";

		System.out.println("잘못 누름");
		return "1";
	}

	public String pizzaMadeMenu2(String str) {
		System.out.println("		- 소스 -");
		System.out.println("1. 토마토							 - 2,000");
		System.out.println("2. 베샤멜 						 	 - 3,000");
		System.out.println("3. 프리미엄 토마토						 - 5,000");

		System.out.print("번호를 누르시오 : ");
		int a = sc.nextInt();

		if (a == 1)
			return "1";
		if (a == 2)
			return "2";
		if (a == 3)
			return "3";

		System.out.println("잘못 누름");
		return "1";
	}

	public String pizzaMadeMenu3(String str) {
		
		PizzaModel na = new PizzaModel();
		char[] order = new char[13];
		String allOrder = str;
		int a = 0;

		for (int i = 0; i < 13; i++) {
			order[i] = allOrder.charAt(i);
		}

		do {
			System.out.println("		- 토핑 -");

			System.out.println("1. 페퍼로니					 	 - 1,000");
			System.out.println("2. 불고기						 	 - 1,500");
			System.out.println("3. 베이컨						 	 - 2,000");
			System.out.println("4. 새우						 	 - 2,000");
			System.out.println("5. 피망						 	 - 1,000");

			System.out.println("6. 버섯						 	 - 1,000");
			System.out.println("7. 양파						 	 - 1,000");
			System.out.println("8. 블랙 올리브					 	 - 3,000");
			System.out.println("9. 옥수수						 	 - 1,000");
			System.out.println("10. 고구마						 	 - 1,000");

			System.out.println("11. 감자						 	 - 1,000");
			System.out.println("12. 파인애플					 	 - 2,000");
			System.out.println("13. 갈릭 프레이크				 	 	- 1,000");
			System.out.println("14. 주문완료");

			System.out.print("번호를 누르시오 : ");
			a = sc.nextInt();

			if (a == 14)
				break;
			
			if(a==0){ 
				System.out.println("잘못누름.");
				continue;
				}

			if (order[a - 1] == '1') {
				System.out.println("재료를 취소 하셨습니다.");
				order[a - 1] = '0';
			} else {
				System.out.println("재료를 선택 하셨습니다.");
				order[a - 1] = '1';
			}
			
			allOrder = "";
			for (int i = 0; i < order.length; i++)
				allOrder += order[i];
			
//			na.pizzaName(allOrder);
			

		} while (a != 14);



		return allOrder;

	}

	public String pizzaMadeMenu4(String str) {
		System.out.println("		- 치 즈 -");
		System.out.println("1. 모짜렐라				   - 1~3,000");
		System.out.println("2. 모짜렐라 + 체다				   - 2~4,000");
		System.out.println("3. 모짜렐라 + 스페셜				   - 3~5,000");

		System.out.print("번호를 누르시오 : ");
		int a = sc.nextInt();

		System.out.println("얼마나 넣으시겠습니까? 1. 적게, 2. 보통, 3. 많이");
		System.out.print("번호를 누르시오 : ");
		int b = sc.nextInt();

		if (a == 1) {
			System.out.print("모짜렐라 ");
		}
		if (a == 2) {
			System.out.print("모짜렐라+체다 ");
		}
		if (a == 3) {
			System.out.print("모짜렐라+스페셜 ");
		}

		if (b == 1) {
			System.out.println("적게 선택");
			return a + "1";
		}
		if (b == 2) {
			System.out.println("보통 선택");
			return a + "2";
		}
		if (b == 3) {
			System.out.println("많이 선택");
			return a + "3";
		}

		return "12";
	}

	// -------------------------------------------------------------------------

	public String pizzaSide() {
		String sizeNspecial = "";
		char fin, size;
		int sideDo = 0, sizeDo = 0, ea = 0, side;

		System.out.println("몇 개 입니까?");
		ea = sc.nextInt(); // 수량

		if (ea > 0)
			if (ea < 10)
				sizeNspecial += "0" + ea; // large
			else
				sizeNspecial += ea; // large

		do {
			System.out.print("피자 사이즈 Regula / Large : ");
			size = sc.next().toUpperCase().charAt(0); // 사이즈

			switch (size) {
			case 'L':
				sizeNspecial += "L"; // large
				sizeDo = 1;
				break;

			case 'R':
				sizeNspecial += "R"; // regular
				sizeDo = 1;
				break;

			default:
				System.out.println("잘못 눌렀어!");
			}

		} while (sizeDo != 1);

		do {
			System.out.println("		- 추가 주문 -");
			System.out.println("1. 일반피자  				- (non)");
			System.out.println("2. 치즈크러스트				- 2,000");
			System.out.println("3. 골드리치(고구마무스+ 치즈)		   	- 5,000");

			System.out.print("번호를 누르시오 : ");
			side = sc.nextInt();
			switch (side) {
			case 1:
				sizeNspecial += "N"; // nomal
				sideDo = 1;
				break;
			case 2:
				sizeNspecial += "C"; // cheesecrust
				sideDo = 1;
				break;
			case 3:
				sizeNspecial += "G"; // goldreach
				sideDo = 1;
				break;
			default:
				System.out.print("입력 잘못함요.");
			}
		} while (sideDo != 1);

		do {
			System.out.print("피자를 주문하시겠습니까?(Y - 주문완료/ N-주문취소) : ");
			fin = sc.next().toUpperCase().charAt(0);

			switch (fin) {
			case 'Y':
				break;

			case 'N':
				return "";

			default:
				System.out.print("입력 잘못함요.");
			}
		} while (fin != 'Y');

		System.out.println(sizeNspecial + " : sucess order and pizzaside return"); // check
		return sizeNspecial;
	}

	// --------------------------------------------------------------------------
	public String sideMenu() {

		String side = "";
		char a;
		int c, ea;
		do {
			System.out.println("\n\n****사이드 메누****\n");
			System.out.println("		- 파스타 -");
			System.out.println("1. 스파게티				 - 5,000");
			System.out.println("2. 까르보나라				 - 6,000");
			System.out.println("3. 알리오올리오				 - 5,000");

			System.out.println("4. 핫 윙				 	 - 7,000");

			System.out.println("		- 셀러드 -");
			System.out.println("5. 샐러드				 	 - 3,000");
			System.out.println("6. 치킨 샐러드				 - 5,000");
			System.out.println("7. 비프 샐러드				 - 3,000");
			System.out.println("8. 콘 슬로우				 - 5,000");

			System.out.println("		- 소 스 -");
			System.out.println("9. 핫소스				 	   - 500");
			System.out.println("10. 파마산				   - 500");
			System.out.println("11. 피클				 	   - 500");
			System.out.println("12. 갈릭 딥핑소스				   - 500");

			System.out.print("번호를 누르시오 (0-그만) : ");
			c = sc.nextInt();
			if (c == 0)
				break;

			if (c < 10)
				side += "S0" + c;
			else
				side += "S" + c;

			System.out.print("몇 개 입니까? : ");
			ea = sc.nextInt();
			if (ea == 0)
				break;

			if (c < 10)
				side += "0" + ea;
			else
				side += ea;

			System.out.print("계속 주문 하시겠습니까?(Y/N) : ");
			a = sc.next().toUpperCase().charAt(0);

		} while (a != 'N');

		return side;

	}

	public String beverage() {

		String beverage = "";
		char a;
		int c, ea;
		do {
			System.out.println("\n\n****음 료****\n");
			System.out.println("1. 콜라					 - 2,000");
			System.out.println("2. 사이다				 	 - 2,000");
			System.out.println("		- 에이드 -");
			System.out.println("3. 자몽 에이드				 - 3,500");
			System.out.println("4. 레몬 에이드				 - 3,500");
			System.out.println("5. 파인애플 에이드				 - 3,500");

			System.out.print("번호를 누르시오 (0-그만) : ");
			c = sc.nextInt();
			if (c == 0)
				break;

			if (c < 10)
				beverage += "B0" + c;
			else
				beverage += "B" + c;

			System.out.print("몇 잔 입니까? : ");
			ea = sc.nextInt();
			if (ea == 0)
				break;

			if (c < 10)
				beverage += "0" + ea;
			else
				beverage += ea;

			System.out.print("계속 주문 하시겠습니까?(Y/N) : ");
			a = sc.next().toUpperCase().charAt(0);
			
		} while (a != 'N');
		return beverage;
	}

	public void coupon() {
		System.out.println("쿠폰 번호를 적어 주세요.");
		System.out.println("발행일자를 알려 주세요.ex>20160708");

		System.out.print("번호를 누르시오 : ");
	}
}
