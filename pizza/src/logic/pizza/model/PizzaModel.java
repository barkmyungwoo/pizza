package logic.pizza.model;

import java.util.Scanner;

public class PizzaModel {
	Scanner sc = new Scanner(System.in);

	public String pizzaInfo(String str) { // ���� �ڵ� �޾Ƽ� ���� ������ ��ȯ
		String a = str;
		String c = "";
		// P01~P20 - ���� �̸� (P20 �� ��� ���� ����� ���� ����.)
		// 00~99 - ����
		// R, L, - ������
		// C,G,N - ġ��ũ����Ʈ,��ġ���,�Ϲ�

		// �а���, �Ұ��� 1 �Ǵ�2 BE MUST

		// �丶��, ������, �����̾� �丶�� 1 ~ 3 BE MUST

		// ���۷δ� 0 �Ǵ� 1
		// �Ұ�� 0 �Ǵ� 1
		// ���� 0 �Ǵ� 1
		// ������ 0 �Ǵ� 1
		// �Ǹ� 0 �Ǵ� 1

		// ���� 0 �Ǵ� 1
		// ���� 0 �Ǵ� 1
		// ���ø��� 0 �Ǵ� 1
		// ������ 0 �Ǵ� 1
		// ���� 0 �Ǵ� 1

		// ���� 0 �Ǵ� 1
		// ���ξ��� 0 �Ǵ� 1
		// ����������ũ 0 �Ǵ� 1
		// ����� �޴�(����Ұ�) 0 �Ǵ� 1

		// ġ�� , +ü��, +����� 1 ~ 3 BE MUST
		// ġ�� �� 1 ~ 3 BE MUST

		// ---------------------------------------
		// S01~S20 - ���̵� �޴� �̸�
		// B01~B20 - ���� �̸�

		switch (a.charAt(0)) {
		case 'P':
			c = pizzaName(a);
			break;

		case 'S':
			for (int i = 0; i < a.length(); i += 5) {
				c += sideName(a.substring(i, i + 3));
				// System.out.println(a);

				if (a.charAt(i + 3) == '0')
					c += a.charAt(i + 4) + "��\n";
				else
					c += a.charAt(i + 3) + a.charAt(i + 4) + "��\n";
			}
			break;

		case 'B':
			for (int i = 0; i < a.length(); i += 5) {
				c += beverageName(a.substring(i, i + 3));
				// System.out.println(a);

				if (a.charAt(i + 3) == '0')
					c += a.charAt(i + 4) + "��\n";
				else
					c += a.charAt(i + 3) + a.charAt(i + 4) + "��\n";
			}
			break;
		}

		return c;
	}

	private String pizzaName(String substring) {
		String x = substring, a = "", ea = "", lr = "", spe = "", toping = "�߰� ���� ����";
		String[] top = { "���۷δ�", "�Ұ��", "����", "������", "�Ǹ�", "����", "����", "���ø���", "������", "����", "����", "���ξ���", "���� ������ũ" };

		switch (x.substring(0, 3)) {			//���� �̸� 
		case "P01":
			a = "ġ�� ";
			break;
		case "P02":
			a = "���۽����� ";
			break;
		case "P03":
			a = "�޺���̼� ";
			break;
		case "P04":
			a = "�������� ";
			break;
		case "P05":
			a = "���۷δ� ";
			break;
		case "P06":
			a = "�������� ";
			break;
		case "P07":
			a = "�ν�Ʈ ����ġŲ ";
			break;
		case "P08":
			a = "������ ������ũ ";
			break;
		case "P09":
			a = "���� ���� ";
			break;
		case "P10":
			a = "��ī�� ����";
			break;
		case "P20":
			a = "�� ����.";
			break;
		default:
			System.out.println("error nothing pizza");
		}
		// ----------------------------------------------------------------------

		if (x.substring(5) == "l")				//���� ������
			lr = "���� ������ - ";
		else
			lr = "���ַ� ������ - ";

		// ----------------------------------------------------------------------

		if (x.substring(6) == "C")				//���� �߰� �ɼ� ����
			spe = "ġ�� ũ����Ʈ ���� ";
		else if (x.substring(6) == "G")
			spe = "��ġ��� ���� ";
		else
			spe = "�Ϲ� ���� ";
		// ----------------------------------------------------------------------

		if (x.length() != 7) {		
			toping = "��� : ";
			if (x.substring(7) == "1")
				toping += "�Ϲݵ���, ";
			else
				toping += "�ҵ���, ";

			if (x.substring(8) == "1") {
				toping += "�丶�� �ҽ�, ";
			} else if (x.substring(8) == "2") {
				toping += "������ �ҽ�, ";
			} else {
				toping += "�����̾� �丶��, ";
			}

			for (int i = 9; i < 22; i++) {
				if (x.charAt(i) == '1')
					toping += (top[i - 9] + ", ");
			}

			if (x.substring(22) == "1")
				toping += "ġ�� ";
			else if (x.substring(22) == "2")
				toping += "ü�� ġ�� ";
			else
				toping += "�����̾� ġ�� ";

			if (x.substring(23) == "1")
				toping += "���� ";
			else if (x.substring(23) == "2")
				toping += "���� ";
			else
				toping += "���� ";
		}
		// ----------------------------------------------------------------------

		if (x.charAt(3) == '0')
			return (a + spe + lr + x.charAt(4) + "�� \n" + toping);
		else
			return (a + spe + lr + x.charAt(3) + x.charAt(4) + "�� \n" + toping);
	}

	private String beverageName(String substring) {
		
		String tmp = substring, a = "";

		switch (tmp) {
		case "B01":
			a = "�ݶ� - ";
			break;
		case "B02":
			a = "���̴� - ";
			break;
		case "B03":
			a = "���ξ��� ���̵� - ";
			break;
		case "B04":
			a = "�ڸ� ���̵� - ";
			break;
		case "B05":
			a = "���� ���̵� - ";
			break;
		case "B06":
			a = "ü�� ���̵� - ";
			break;
		}
		return a;
	}

	private String sideName(String substring) {

		String tmp = substring, a = "";

		switch (tmp) {
		case "S01":
			a = "���İ�Ƽ - ";
			break;
		case "S02":
			a = "������� - ";
			break;
		case "S03":
			a = "�˸��� �ø��� - ";
			break;
		case "S04":
			a = "�� �� - ";
			break;
		case "S05":
			a = "������ - ";
			break;
		case "S06":
			a = "ġŲ ������ - ";
			break;
		case "S07":
			a = "���� ������ - ";
			break;
		case "S08":
			a = "�� ���ο� - ";
			break;
		case "S09":
			a = "�ּҽ� - ";
			break;
		case "S10":
			a = "�ĸ��� ġ�� - ";
			break;
		case "S11":
			a = "��Ŭ - ";
			break;
		case "S12":
			a = "���� ���� �ҽ� - ";
			break;
		}
		return a;
	}
}
