package com.biz.bank.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.biz.bank.model.BankBalanceVO;

public class BankService {

	/*
	 * balance.txt 파일을 읽어서 계좌 정보를 balanceList에 추가하는 매서드를 작성
	 */
	List<BankBalanceVO> balanceList;
	String fileName = "src/com/biz/bank/balance.txt";
	FileReader fileReader;
	BufferedReader buffer;
	Scanner scan;

	public BankService(String fileName) throws FileNotFoundException {
		fileReader = new FileReader(fileName);
		buffer = new BufferedReader(fileReader);
		balanceList = new ArrayList<BankBalanceVO>();
		scan = new Scanner(System.in);
	}

	public void readBalance() throws IOException {

		while (true) {
			BankBalanceVO vo = new BankBalanceVO();
			String txt = buffer.readLine();
			if (txt == null)
				break;
			String[] txts = txt.split(":");
			vo.setAcc(txts[0]);
			vo.setBalance(Integer.valueOf(txts[1]));
			vo.setData(txts[2]);
			balanceList.add(vo);

		}

	}// readbalance end

	public BankBalanceVO pickAcc(String accNum) {

		/*
		 * balanceList에서 계좌번호 0001인 데이터를 찾고 그 계좌의 현 잔액을 콘솔에 표시
		 */
		int Len = balanceList.size();
		int i = 0;
		BankBalanceVO vo = null;
		for (i = 0; i < Len; i++) {
			vo = balanceList.get(i);
			if (vo.getAcc().equals(accNum)) {
				// System.out.println(vo.getBalance());
				return vo;
			}
		}
		return null;
	}// piacAcc end

	/*
	 * 계좌번호로 pickAcc로부터 vo값을 추출하고
	 * balance값과 money값을 더하여
	 * vo의 balance에 저장하고
	 * console에 보여주는 코드
	 */
	public void inputMoney(String acc, int money) {
		
		BankBalanceVO vo = pickAcc(acc);
		int inputTotal = vo.getBalance() + money;
		vo.setBalance(inputTotal);
		
		//현재 컴퓨터 날짜값을 가져오기
		
		Date date= new Date(System.currentTimeMillis());
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		
		String curDate = sf.format(date);
		vo.setData(curDate);
		
		//자바 1.8이상에서 사용하는 새로운 날짜
		LocalDate localDate = LocalDate.now();
		vo.setData(localDate.toString());
		
		System.out.println("=======================================");
		System.out.println(vo);
		System.out.println("=======================================");
		
		
		
		
	}
	public void outputMoney(String acc, int money) {
		
		BankBalanceVO vo = pickAcc(acc);
		int bal = vo.getBalance();
		
		if(bal<money) {
			System.out.println("잔액부족!!!");
			return;
		}
		
		vo.setBalance(bal - money);
		
		//현재 컴퓨터 날짜값을 가져오기
		
		Date date= new Date(System.currentTimeMillis());
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		
		String curDate = sf.format(date);
		vo.setData(curDate);
		
		//자바 1.8이상에서 사용하는 새로운 날짜
		LocalDate localDate = LocalDate.now();
		vo.setData(localDate.toString());
		
		System.out.println("=======================================");
		System.out.println(vo);
		System.out.println("=======================================");
		
		
		
		
	}
	
	public int selectMenu() {

		System.out.println("=====================================");
		System.out.println("1. 입금     2. 출금      -9. 종료");
		System.out.println("=====================================");
		System.out.print("업무선택>>");
		String strMenu = scan.nextLine();

		int intMenu = 0;
		try {
			intMenu = Integer.valueOf(strMenu);
		} catch (Exception e) {
			// 오류무시
		}

		return intMenu;
	}

}
