package banking;

import java.util.Scanner;

public class Main {
	
	private static Account[] accountArray = new Account[100];
	static Scanner scan = new Scanner(System.in);
	

	public static void main(String[] args) {
		boolean run = true;
		while(run) {
			System.out.println("===============================================");
			System.out.println("1.���� ���� | 2.���� ��� | 3.���� | 4.��� | 5.����");
			System.out.println("===============================================");
			System.out.print("����>");
			
			int selNum = scan.nextInt();
			if(selNum == 1) {
				createAccount();
			}
			else if(selNum ==2) {
				accountList();
			}
			else if (selNum ==3) {
				deposit();
			}
			else if(selNum == 4) {
				withdraw();
			}
			else if(selNum ==5) {
				run = false;
			}
			else {
				System.out.println("�������� �ʴ� ����Դϴ�.");
				return;
			}
			
		}
		System.out.println("���α׷� ����");
		
	}

	private static void deposit() {
		System.out.println("===============================================");
		System.out.println("3.����");
		System.out.println("===============================================");
		
		System.out.println("���� ��ȣ : ");
		String ano = scan.next();
		
		System.out.println("�Աݾ� : ");
		int money = scan.nextInt();
		
		Account account = findAccount(ano);
		if(account == null) {
			System.out.println("���°� �����ϴ�.");
			return; //�ݺ������� ��������(����)
	}
		account.setBalance(account.getBalance() + money);
		System.out.println("��� : �Ա��� �����Ͽ����ϴ�.");
	}
	private static Account findAccount(String ano) {
		Account account = null;
		for(int i=0; i<accountArray.length; i++) {
			if(accountArray[i] != null) {  //�ڵ带 �ݵ�� ����
				String dbAno = accountArray[i].getAno();
				if(dbAno.equals(ano)) { //�̹� ����� ���¹�ȣ�� �ܺο��� ã�� ���¹�ȣ�� ��ġ�ϸ�
					account = accountArray[i];
					break;
					
				}
				
			}
		}
		return account;
	}

	private static void withdraw() {
	
	}
	
	//���� ���
	private static void accountList() {
		System.out.println("===============================================");
		System.out.println("2.���¸��");
		System.out.println("===============================================");
		
		//����� ��� ���°� ���(null�� �ƴ� ����)
		for(int i=0; i< accountArray.length; i++) {
			Account account = accountArray[i];
			if(account != null) { //����! null�� �ƴ� ��� ���
				System.out.print("���� ��ȣ : " + account.getAno() + "    ");
				System.out.print("������ : " + account.getOwner() + "    ");
				System.out.println("�ܰ� : " + account.getBalance() + "    ");
			}
		}
		}
	
	
	//���»���
	private static void createAccount() {
		System.out.println("===============================================");
		System.out.println("1.���»���");
		System.out.println("===============================================");
		
		System.out.println("���� ��ȣ : ");
		String ano = scan.next();
		
		System.out.println("������ : ");
		String owner = scan.next();
		
		System.out.println("�ʱ� �Աݾ� : ");
		int balance = scan.nextInt();
		
		Account newAccount = new Account(ano, owner, balance);
		for(int i= 0; i<accountArray.length; i++) {
			if(accountArray[i] == null)  { //null�� ���� ����
				accountArray[i] = newAccount;
				System.out.println("��� : ���°� �����Ǿ����ϴ�.");
				break;
			}
			
		}
	}


}