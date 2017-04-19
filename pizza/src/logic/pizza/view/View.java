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
			System.out.println("\n\n****�ٶ� ����****\n");

			System.out.println("1. ���� ����");
			System.out.println("2. ���� �����");
			System.out.println("3. ���̵� �޴�");
			System.out.println("4. ����");
			System.out.println("5. ����");
			System.out.println("6. �� �ֹ� ���� ");
			System.out.println("7. �ֹ� �Ϸ�");
			System.out.println("8. �ֹ� ���");

			System.out.print("��ȣ�� �����ÿ� : ");
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
				System.out.println("�߸��� ��ȣ �Է� �ٽ�.!");
			}
		} while (true);

	}

	// -------------------------------------------------------------------------

	public String pizzaMenu() {
		String order, pizza = "";
		int piz = 0;

		do {
			System.out.println("\n\n****�Ϲ� ����****\n");
			System.out.println("1. ġ�� ����		R - 10,000/L - 12,000");
			System.out.println("2. ���� ������ ����		R - 12,000/L - 15,000");
			System.out.println("3. �Ұ�� ����		R - 12,000/L - 15,000");
			System.out.println("4. �������� ����		R - 12,000/L - 15,000");
			System.out.println("5. ���۷δ� ���� 		R - 12,000/L - 15,000");
			System.out.println("6. �Ͽ����� ���� 		R - 12,000/L - 15,000");

			System.out.println("\n****����� ����****\n");
			System.out.println("7. ���� ���� ����		R - 25,000/L - 30,000");
			System.out.println("8. �ν�Ʈ ���� ġŲ ����	R - 25,000/L - 30,000");
			System.out.println("9. ������ ������ũ ����	R - 25,000/L - 30,000");
			System.out.println("10. ���� ���� ����		R - 20,000/L - 25,000");
			System.out.println("11. ��ī�� ���� 		R - 25,000/L - 35,000");

			System.out.print("��ȣ�� �����ÿ� : ");
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
				System.out.println("�߸��� ��ȣ��");
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
			System.out.println("\n\n****���� �����****\n");
			System.out.println("1. ����");
			System.out.println("2. �ҽ�");
			System.out.println("3. ����");
			System.out.println("4. ġ��");
			System.out.println("5. �ֹ��Ϸ� ");

			System.out.print("��ȣ�� �����ÿ� : ");
			num = sc.nextInt();

			switch (num) {
			case 1:
				order1 = pizzaMadeMenu1(order1); // ���� ����Ʈ �а���
				break;
			case 2:
				order2 = pizzaMadeMenu2(order2); // �ҽ� ����Ʈ �丶��
				break;
			case 3:
				order3 = pizzaMadeMenu3(order3); // ���� ����Ʈ 0000000000000
				break;
			case 4:
				order4 = pizzaMadeMenu4(order4); // ġ�� ����Ʈ �߰�
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
		System.out.println("		- ���� -");
		System.out.println("1. �а���					 		 - 7,000");
		System.out.println("2. �Ұ���					 		 - 8,000");

		System.out.print("��ȣ�� �����ÿ� : ");
		int a = sc.nextInt();

		if (a == 1)
			return "1";
		if (a == 2)
			return "2";

		System.out.println("�߸� ����");
		return "1";
	}

	public String pizzaMadeMenu2(String str) {
		System.out.println("		- �ҽ� -");
		System.out.println("1. �丶��							 - 2,000");
		System.out.println("2. ������ 						 	 - 3,000");
		System.out.println("3. �����̾� �丶��						 - 5,000");

		System.out.print("��ȣ�� �����ÿ� : ");
		int a = sc.nextInt();

		if (a == 1)
			return "1";
		if (a == 2)
			return "2";
		if (a == 3)
			return "3";

		System.out.println("�߸� ����");
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
			System.out.println("		- ���� -");

			System.out.println("1. ���۷δ�					 	 - 1,000");
			System.out.println("2. �Ұ��						 	 - 1,500");
			System.out.println("3. ������						 	 - 2,000");
			System.out.println("4. ����						 	 - 2,000");
			System.out.println("5. �Ǹ�						 	 - 1,000");

			System.out.println("6. ����						 	 - 1,000");
			System.out.println("7. ����						 	 - 1,000");
			System.out.println("8. �� �ø���					 	 - 3,000");
			System.out.println("9. ������						 	 - 1,000");
			System.out.println("10. ����						 	 - 1,000");

			System.out.println("11. ����						 	 - 1,000");
			System.out.println("12. ���ξ���					 	 - 2,000");
			System.out.println("13. ���� ������ũ				 	 	- 1,000");
			System.out.println("14. �ֹ��Ϸ�");

			System.out.print("��ȣ�� �����ÿ� : ");
			a = sc.nextInt();

			if (a == 14)
				break;
			
			if(a==0){ 
				System.out.println("�߸�����.");
				continue;
				}

			if (order[a - 1] == '1') {
				System.out.println("��Ḧ ��� �ϼ̽��ϴ�.");
				order[a - 1] = '0';
			} else {
				System.out.println("��Ḧ ���� �ϼ̽��ϴ�.");
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
		System.out.println("		- ġ �� -");
		System.out.println("1. ��¥����				   - 1~3,000");
		System.out.println("2. ��¥���� + ü��				   - 2~4,000");
		System.out.println("3. ��¥���� + �����				   - 3~5,000");

		System.out.print("��ȣ�� �����ÿ� : ");
		int a = sc.nextInt();

		System.out.println("�󸶳� �����ðڽ��ϱ�? 1. ����, 2. ����, 3. ����");
		System.out.print("��ȣ�� �����ÿ� : ");
		int b = sc.nextInt();

		if (a == 1) {
			System.out.print("��¥���� ");
		}
		if (a == 2) {
			System.out.print("��¥����+ü�� ");
		}
		if (a == 3) {
			System.out.print("��¥����+����� ");
		}

		if (b == 1) {
			System.out.println("���� ����");
			return a + "1";
		}
		if (b == 2) {
			System.out.println("���� ����");
			return a + "2";
		}
		if (b == 3) {
			System.out.println("���� ����");
			return a + "3";
		}

		return "12";
	}

	// -------------------------------------------------------------------------

	public String pizzaSide() {
		String sizeNspecial = "";
		char fin, size;
		int sideDo = 0, sizeDo = 0, ea = 0, side;

		System.out.println("�� �� �Դϱ�?");
		ea = sc.nextInt(); // ����

		if (ea > 0)
			if (ea < 10)
				sizeNspecial += "0" + ea; // large
			else
				sizeNspecial += ea; // large

		do {
			System.out.print("���� ������ Regula / Large : ");
			size = sc.next().toUpperCase().charAt(0); // ������

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
				System.out.println("�߸� ������!");
			}

		} while (sizeDo != 1);

		do {
			System.out.println("		- �߰� �ֹ� -");
			System.out.println("1. �Ϲ�����  				- (non)");
			System.out.println("2. ġ��ũ����Ʈ				- 2,000");
			System.out.println("3. ��帮ġ(��������+ ġ��)		   	- 5,000");

			System.out.print("��ȣ�� �����ÿ� : ");
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
				System.out.print("�Է� �߸��Կ�.");
			}
		} while (sideDo != 1);

		do {
			System.out.print("���ڸ� �ֹ��Ͻðڽ��ϱ�?(Y - �ֹ��Ϸ�/ N-�ֹ����) : ");
			fin = sc.next().toUpperCase().charAt(0);

			switch (fin) {
			case 'Y':
				break;

			case 'N':
				return "";

			default:
				System.out.print("�Է� �߸��Կ�.");
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
			System.out.println("\n\n****���̵� �޴�****\n");
			System.out.println("		- �Ľ�Ÿ -");
			System.out.println("1. ���İ�Ƽ				 - 5,000");
			System.out.println("2. �������				 - 6,000");
			System.out.println("3. �˸����ø���				 - 5,000");

			System.out.println("4. �� ��				 	 - 7,000");

			System.out.println("		- ������ -");
			System.out.println("5. ������				 	 - 3,000");
			System.out.println("6. ġŲ ������				 - 5,000");
			System.out.println("7. ���� ������				 - 3,000");
			System.out.println("8. �� ���ο�				 - 5,000");

			System.out.println("		- �� �� -");
			System.out.println("9. �ּҽ�				 	   - 500");
			System.out.println("10. �ĸ���				   - 500");
			System.out.println("11. ��Ŭ				 	   - 500");
			System.out.println("12. ���� ���μҽ�				   - 500");

			System.out.print("��ȣ�� �����ÿ� (0-�׸�) : ");
			c = sc.nextInt();
			if (c == 0)
				break;

			if (c < 10)
				side += "S0" + c;
			else
				side += "S" + c;

			System.out.print("�� �� �Դϱ�? : ");
			ea = sc.nextInt();
			if (ea == 0)
				break;

			if (c < 10)
				side += "0" + ea;
			else
				side += ea;

			System.out.print("��� �ֹ� �Ͻðڽ��ϱ�?(Y/N) : ");
			a = sc.next().toUpperCase().charAt(0);

		} while (a != 'N');

		return side;

	}

	public String beverage() {

		String beverage = "";
		char a;
		int c, ea;
		do {
			System.out.println("\n\n****�� ��****\n");
			System.out.println("1. �ݶ�					 - 2,000");
			System.out.println("2. ���̴�				 	 - 2,000");
			System.out.println("		- ���̵� -");
			System.out.println("3. �ڸ� ���̵�				 - 3,500");
			System.out.println("4. ���� ���̵�				 - 3,500");
			System.out.println("5. ���ξ��� ���̵�				 - 3,500");

			System.out.print("��ȣ�� �����ÿ� (0-�׸�) : ");
			c = sc.nextInt();
			if (c == 0)
				break;

			if (c < 10)
				beverage += "B0" + c;
			else
				beverage += "B" + c;

			System.out.print("�� �� �Դϱ�? : ");
			ea = sc.nextInt();
			if (ea == 0)
				break;

			if (c < 10)
				beverage += "0" + ea;
			else
				beverage += ea;

			System.out.print("��� �ֹ� �Ͻðڽ��ϱ�?(Y/N) : ");
			a = sc.next().toUpperCase().charAt(0);
			
		} while (a != 'N');
		return beverage;
	}

	public void coupon() {
		System.out.println("���� ��ȣ�� ���� �ּ���.");
		System.out.println("�������ڸ� �˷� �ּ���.ex>20160708");

		System.out.print("��ȣ�� �����ÿ� : ");
	}
}
