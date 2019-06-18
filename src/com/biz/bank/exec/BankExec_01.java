package com.biz.bank.exec;

import java.io.IOException;
import java.util.Scanner;

import com.biz.bank.model.BankBalanceVO;
import com.biz.bank.service.BankService;

public class BankExec_01 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String fileName = "src/com/biz/bank/balance.txt";

		// bs선언부만 트라이 밖으로 빼내고
		// 널값으로 초기화한다
		BankService bs = null;

		try {
			bs = new BankService(fileName);
			bs.readBalance();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (true) {
			
			int intMenu= bs.selectMenu();
			
			if(intMenu ==-9) break;
			System.out.println("계좌번호>>");
			String accNum = scan.nextLine();
			
			//입금처리
			if(intMenu ==1) {
				System.out.println("입금금액 >>");
				String inputmoney = scan.nextLine();
				int intInputMoney = Integer.valueOf(inputmoney);
				bs.inputMoney(accNum, intInputMoney);
			}
			if(intMenu ==2)  {
				System.out.println("출금금액 >>");
				String outputmoney = scan.nextLine();
				int outoutputMoney = Integer.valueOf(outputmoney);
				bs.outputMoney(accNum, outoutputMoney);
				//bs.inputMoney(accNum, outoutputMoney);
			} //출금처리
//			BankBalanceVO vo = bs.pickAcc(accNum);
//			bs.inputMoney(accNum, 50000);
//			if (vo == null)
//				System.out.println("계좌없음");
//			else
//				System.out.println(vo.getBalance());
		}
		
	}

}
