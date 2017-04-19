package logic.pizza.model;

import java.util.Scanner;

public class PizzaModel {
	Scanner sc = new Scanner(System.in);

	public String pizzaInfo(String str) { // 피자 코드 받아서 피자 정보로 반환
		String a = str;
		String c = "";
		// P01~P20 - 피자 이름 (P20 의 경우 피자 만들기 제작 피자.)
		// 00~99 - 수량
		// R, L, - 사이즈
		// C,G,N - 치즈크러스트,리치골드,일반

		// 밀가루, 쌀가루 1 또는2 BE MUST

		// 토마토, 베샤멜, 프리미엄 토마토 1 ~ 3 BE MUST

		// 페퍼로니 0 또는 1
		// 불고기 0 또는 1
		// 새우 0 또는 1
		// 베이컨 0 또는 1
		// 피망 0 또는 1

		// 버섯 0 또는 1
		// 양파 0 또는 1
		// 블랙올리브 0 또는 1
		// 옥수수 0 또는 1
		// 고구마 0 또는 1

		// 감자 0 또는 1
		// 파인애플 0 또는 1
		// 갈릭프레이크 0 또는 1
		// 스페셜 메뉴(변경불가) 0 또는 1

		// 치즈 , +체다, +스페셜 1 ~ 3 BE MUST
		// 치즈 량 1 ~ 3 BE MUST

		// ---------------------------------------
		// S01~S20 - 사이드 메뉴 이름
		// B01~B20 - 음료 이름

		switch (a.charAt(0)) {
		case 'P':
			c = pizzaName(a);
			break;

		case 'S':
			for (int i = 0; i < a.length(); i += 5) {
				c += sideName(a.substring(i, i + 3));
				// System.out.println(a);

				if (a.charAt(i + 3) == '0')
					c += a.charAt(i + 4) + "개\n";
				else
					c += a.charAt(i + 3) + a.charAt(i + 4) + "개\n";
			}
			break;

		case 'B':
			for (int i = 0; i < a.length(); i += 5) {
				c += beverageName(a.substring(i, i + 3));
				// System.out.println(a);

				if (a.charAt(i + 3) == '0')
					c += a.charAt(i + 4) + "개\n";
				else
					c += a.charAt(i + 3) + a.charAt(i + 4) + "개\n";
			}
			break;
		}

		return c;
	}

	private String pizzaName(String substring) {
		String x = substring, a = "", ea = "", lr = "", spe = "", toping = "추가 사항 없음";
		String[] top = { "페퍼로니", "불고기", "새우", "베이컨", "피망", "버섯", "양파", "블랙올리브", "옥수수", "고구마", "감자", "파인애플", "갈릭 프레이크" };

		switch (x.substring(0, 3)) {			//피자 이름 
		case "P01":
			a = "치즈 ";
			break;
		case "P02":
			a = "슈퍼슈프림 ";
			break;
		case "P03":
			a = "콤비네이션 ";
			break;
		case "P04":
			a = "포테이토 ";
			break;
		case "P05":
			a = "페퍼로니 ";
			break;
		case "P06":
			a = "갈릭비프 ";
			break;
		case "P07":
			a = "로스트 갈릭치킨 ";
			break;
		case "P08":
			a = "베이컨 스테이크 ";
			break;
		case "P09":
			a = "고르곤 졸라 ";
			break;
		case "P10":
			a = "시카고 피자";
			break;
		case "P20":
			a = "내 피자.";
			break;
		default:
			System.out.println("error nothing pizza");
		}
		// ----------------------------------------------------------------------

		if (x.substring(5) == "l")				//피자 사이즈
			lr = "라지 사이즈 - ";
		else
			lr = "레귤러 사이즈 - ";

		// ----------------------------------------------------------------------

		if (x.substring(6) == "C")				//피자 추가 옵션 선택
			spe = "치즈 크러스트 피자 ";
		else if (x.substring(6) == "G")
			spe = "리치골드 피자 ";
		else
			spe = "일반 피자 ";
		// ----------------------------------------------------------------------

		if (x.length() != 7) {		
			toping = "재료 : ";
			if (x.substring(7) == "1")
				toping += "일반도우, ";
			else
				toping += "쌀도우, ";

			if (x.substring(8) == "1") {
				toping += "토마토 소스, ";
			} else if (x.substring(8) == "2") {
				toping += "베샤멜 소스, ";
			} else {
				toping += "프리미엄 토마토, ";
			}

			for (int i = 9; i < 22; i++) {
				if (x.charAt(i) == '1')
					toping += (top[i - 9] + ", ");
			}

			if (x.substring(22) == "1")
				toping += "치즈 ";
			else if (x.substring(22) == "2")
				toping += "체다 치즈 ";
			else
				toping += "프리미엄 치즈 ";

			if (x.substring(23) == "1")
				toping += "적게 ";
			else if (x.substring(23) == "2")
				toping += "보통 ";
			else
				toping += "많이 ";
		}
		// ----------------------------------------------------------------------

		if (x.charAt(3) == '0')
			return (a + spe + lr + x.charAt(4) + "개 \n" + toping);
		else
			return (a + spe + lr + x.charAt(3) + x.charAt(4) + "개 \n" + toping);
	}

	private String beverageName(String substring) {
		
		String tmp = substring, a = "";

		switch (tmp) {
		case "B01":
			a = "콜라 - ";
			break;
		case "B02":
			a = "사이다 - ";
			break;
		case "B03":
			a = "파인애플 에이드 - ";
			break;
		case "B04":
			a = "자몽 에이드 - ";
			break;
		case "B05":
			a = "레몬 에이드 - ";
			break;
		case "B06":
			a = "체리 에이드 - ";
			break;
		}
		return a;
	}

	private String sideName(String substring) {

		String tmp = substring, a = "";

		switch (tmp) {
		case "S01":
			a = "스파게티 - ";
			break;
		case "S02":
			a = "까르보나라 - ";
			break;
		case "S03":
			a = "알리오 올리오 - ";
			break;
		case "S04":
			a = "핫 윙 - ";
			break;
		case "S05":
			a = "샐러드 - ";
			break;
		case "S06":
			a = "치킨 샐러드 - ";
			break;
		case "S07":
			a = "비프 샐러드 - ";
			break;
		case "S08":
			a = "콘 슬로우 - ";
			break;
		case "S09":
			a = "핫소스 - ";
			break;
		case "S10":
			a = "파마산 치즈 - ";
			break;
		case "S11":
			a = "피클 - ";
			break;
		case "S12":
			a = "갈릭 딥핑 소스 - ";
			break;
		}
		return a;
	}
}
