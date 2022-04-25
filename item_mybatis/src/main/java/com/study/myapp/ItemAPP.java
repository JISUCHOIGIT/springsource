package com.study.myapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.service.ItemService;
import com.stuyd.dto.ItemDTO;
import com.sun.jdi.connect.Connector.IntegerArgument;


public class ItemAPP {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		
		ItemService service = (ItemService) ctx.getBean("service");
		
		boolean flag = true;
		Scanner sc = new Scanner(System.in);
		while(flag) {
			System.out.println("-----------------------------------");
			System.out.println("1.아이템 추가");
			System.out.println("2.아이템 조회");
			System.out.println("3.아이템 삭제");
			System.out.println("4.아이템 수정");
			System.out.println("5.아이템 전체 조회");
			System.out.println("6.종료");
			System.out.println("-----------------------------------");

			System.out.println("번호>>");
			int no = Integer.parseInt(sc.nextLine());
			
			switch(no) {
			case 1:
				
				System.out.println("\n--아이템 입력--");
				
				ItemDTO insertDto = new ItemDTO();
				System.out.print("카테고리:");
				insertDto.setCategory(sc.nextLine());
				
				System.out.print("상품명:");
				insertDto.setName(sc.nextLine());
				
				System.out.print("내용:");
				insertDto.setContent(sc.nextLine());
				
				System.out.print("사이즈:");
				insertDto.setPsize(sc.nextLine());
				
				System.out.print("가격:");
				insertDto.setPrice(Integer.parseInt(sc.nextLine()));
				
				System.out.println(service.itemInsert(insertDto)?"입력성공":"입력실패");
				
//				System.out.println("카테고리를 입력해주세요");
//				String category = sc.nextLine();
//				ItemDTO insertDto = new ItemDTO();
//				insertDto.setCategory(category);
//				System.out.println("바지를 입력해주세요");
//				String name = sc.nextLine();
//				insertDto.setName(name);
//				System.out.println("content를 입력해주세요");
//				String content = sc.nextLine();
//				insertDto.setContent(content);
//				System.out.println("바지사이즈를 입력해주세요");
//				String psize = sc.nextLine();
//				insertDto.setPsize("30");
//				System.out.println("가격을 입력해주세요");
//				int price = Integer.parseInt(sc.nextLine());
//				insertDto.setPrice(30000);
				break;
				
			case 2:
				System.out.println("조회할 아이템 번호를 입력해주세요 ");
				int num = Integer.parseInt(sc.nextLine());
				System.out.println(service.getRow(num));
				break;
				
			case 3:
				System.out.println("삭제할 아이템 번호를 입력해주세요 ");
				int input = Integer.parseInt(sc.nextLine());
				System.out.println(service.itemDelete(input)?"삭제성공":"삭제실패");
				break;
				
			case 4:
				System.out.println("\n--아이템 수정--");
				
				System.out.print("번호:");
				int num1 = Integer.parseInt(sc.nextLine());
				
				System.out.print("사이즈:");
				String size = sc.nextLine();
				
				System.out.print("가격:");
				int price = Integer.parseInt(sc.nextLine());
				
				System.out.println(service.itemUpdate(num1, size, price)?"수정성공":"수정실패");
				
				
//				ItemDTO updateDto = new ItemDTO();
//				System.out.println("수정할 아이템 번호를 입력해주세요 ");
//			//	int num1 = ;
//				updateDto.setNum(sc.nextInt());
//				//int num2 = sc.nextInt();
//				System.out.println("수정할 아이템 바지 사이즈를 입력해주세요 ");
//				//String num3 = ;
//				updateDto.setPsize(sc.nextLine());
//				System.out.println("수정할 가격을 입력해주세요 ");
//				//int num4 = ;
//				updateDto.setPrice(sc.nextInt());
//				break;
				
			case 5:
				System.out.println("\n--아이템 전체 조회--");
				System.out.println("번호 :");
				
				List<ItemDTO> list = service.getList();
				
				System.out.println("num\tcategory\tname\tcontent\tpsize\tprice");
				System.out.println("----------------------------------------------'");
				for(ItemDTO dto : list) {
					System.out.println(dto.getNum()+"\t");
					System.out.println(dto.getCategory()+"\t");
					System.out.println(dto.getName()+"\t");
					System.out.println(dto.getContent()+"\t");
					System.out.println(dto.getPsize()+"\t");
					System.out.println(dto.getPrice()+"\t");
				}
				break;
			case 6:
				flag = false;
				break;
			default:
				break;
			}
		}
	}

}










