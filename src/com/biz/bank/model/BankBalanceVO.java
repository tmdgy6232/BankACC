package com.biz.bank.model;

public class BankBalanceVO {

	private String acc;
	private int balance;
	private String data;
	
	
	
	public BankBalanceVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BankBalanceVO(String acc, int balance, String data) {
		super();
		this.acc = acc;
		this.balance = balance;
		this.data = data;
	}
	public String getAcc() {
		return acc;
	}
	public void setAcc(String acc) {
		this.acc = acc;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "BankBalanceVO [acc=" + acc + ", balance=" + balance + ", data=" + data + "]";
	}
	
	//getter와 setter, toString
	//기본생성자, 필드생성자
	
}
