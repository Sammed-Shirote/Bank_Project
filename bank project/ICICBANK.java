
import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

//import com.checked.exception.BalanceException;
//import com.checked.exception.PswdException;

public class ICICBANK 
{
	ArrayList <BankAccount> a = new ArrayList<>();
	
	Scanner sc = new Scanner(System.in);
	{
		String path = "E:\\Study\\Tutions\\QSPIDERS\\Bank\\";
		File f = new File(path);
		if(f.mkdir()) System.out.println("Bank Folder is Created");
		else System.out.println("Bank Folder is alreday Present");
	}
	public void addAccount() throws IOException
	{
		
		
				System.out.println("Enter a name ");
				String name = sc.next();
				System.out.println("Enter a Account Number ");
				long accNo = sc.nextLong();
				System.out.println("Enter a pswd ");
				int pswd = sc.nextInt();
			
				System.out.println("Enter a Deposit amount ");
				double bal = sc.nextDouble();
				System.out.println("Enter a add ");
				String add = sc.next();
				BankAccount a1 = new BankAccount(name, accNo, pswd, bal, add);
				a.add(a1);
				createFolder(name);
				putDataInDetails(name);
				
	}
	public void createFolder(String name) throws IOException
	{
		String path = "E:\\Study\\Tutions\\QSPIDERS\\Bank";
		String filePath = path+name;
		File f = new File(filePath);
		if(f.mkdir()) System.out.println("Created");
		else System.out.println("not created");
		createTxtFile(filePath);
	}
	
	public void createTxtFile(String filePath) throws IOException
	{
		 String newPath1 = filePath+"\\details.txt";
		 String newPath2 = filePath+"\\transaction.txt";
		 String newPath3 = filePath+"\\withdraw.txt";
		 String newPath4 = filePath+"\\deposit.txt";
		 File f1 = new File(newPath1);
		 f1.createNewFile();	
		 File f2 = new File(newPath2);
		 f2.createNewFile();
		 File f3 = new File(newPath3);
		 f3.createNewFile();
		 File f4 = new File(newPath4);
		 f4.createNewFile(); 
	}

	public void putDataInDetails(String name) throws IOException
	{
		System.out.println("Enter a pswd to fetch data in detail.txt");
		int pass = sc.nextInt();
		for(int i=0; i<a.size(); i++)
		{
			if(a.get(i)!=null )
			{
				if(a.get(i).pswd==pass)
				{
					String path = "E:\\Study\\Tutions\\QSPIDERS\\Bank";
					String path2 = name+"\\details.txt";
					String detailsPath = path+path2;
					FileWriter fw = new FileWriter(detailsPath);
					fw.write("Personal Information\n");
					fw.write("Name            : "+ a.get(i).name+"\n");
					fw.write("Ac no.          : "+ a.get(i).accountNo+"\n");
					fw.write("Password        : "+ a.get(i). pswd+"\n");
					fw.write("Address         : "+ a.get(i).add+"\n");
					fw.close();
					System.out.println("Details Fetched");
					return;
				}
			}
		}
		System.out.println("Details not get Fetched");
		putDataInDetails(name);
	}
	/*
	public void putDataIntransiton(double Deposit, double WithdrawAmount, double Balance, String detailsPath) throws IOException
	{
		Date date = new Date();
		String d = date+"";
		FileWriter fw = new FileWriter(detailsPath);
		fw.write("Transaction Date and time : "+d+"\n");
		fw.write("Withdraw Amount           :"+WithdrawAmount+"\n");
		fw.write("deposit Amount            :"+Deposit+"\n");
		fw.write("Balance                   :"+Balance+"\n");
		fw.write("-------------------------------------------------");
		fw.close();
	}*/

	public void removeAccount()
	{
		System.out.println("Enter a account number ");
		long acNo = sc.nextLong();
		for(int i=0; i<a.size(); i++)
		{
			if(a.get(i)!=null )
			{
				if(a.get(i).accountNo== acNo)
				{
					String path = "E:\\Study\\Tutions\\QSPIDERS\\Bank";
					String FinalPath = path+a.get(i).name;
					File f = new File(FinalPath);
					//FileUtils.deleteDirectory(f);
					if(f.delete())
					{
						System.out.println(a.get(i).name+ " this file is deleted");
					}
					else
					{
						System.out.println("Not presented");
					}
					a.remove(i);
					
					
					System.out.println("Account is removed ......");
					return;
				}
			}
		}
		System.err.println("Data NOT FOUND");		
	}
	
	public void withdrow() throws IOException
	{
		System.out.println("Enter a acoount Number ");
		long acNo = sc.nextLong();
		
		for(int i=0; i<a.size(); i++)
		{
			if(a.get(i)!=null )
			{
				if(a.get(i).accountNo == acNo )
				{
					System.out.println("Enter a password ");
					int pass = sc.nextInt();
					if(a.get(i).pswd==pass)
					{
						System.out.println("Enter a Amount ");
						double money = sc.nextDouble();
						if(a.get(i).bal>=money)
						{
							a.get(i).bal=a.get(i).bal-money;
							System.out.println("Collect your Cash .... ");
							System.out.println("Your Balance is  "+ a.get(i).bal);
							
							
							String path = "E:\\Study\\Tutions\\QSPIDERS\\Bank";
							String path2 =a.get(i).name+"\\transaction.txt";
							String detailsPath = path+path2;
							
							Date date = new Date();
							String d = date+"";
							
							FileWriter fw = new FileWriter(detailsPath,true);
							fw.write("Status ------  withdrow ------ "+"\n");
							fw.write("Transaction Date and time : "+d+"\n");
							fw.write("Withdraw Amount           :"+money+"\n");
							fw.write("deposit Amount            :"+"----"+"\n");
							fw.write("Balance                   :"+a.get(i).bal+"\n");
							fw.write("-------------------------------------------------\n");
							fw.close();
							
							
							String path3 =a.get(i).name+"\\withdraw.txt";
							String withdrowPath = path+path3;
							
							FileWriter fww = new FileWriter(withdrowPath,true);
							fww.write("Status ------  withdrow ------ "+"\n");
							fww.write("Transaction Date and time : "+d+"\n");
							fww.write("Withdraw Amount           :"+money+"\n");
							fww.write("Balance                   :"+a.get(i).bal+"\n");
							fww.write("-------------------------------------------------\n");
							fww.close();
							
							System.out.println("Thank you ............");
							return;
						}
						//else
						// {
						// 	try
						// 	{
						// 		throw new BalanceException("Insufficient Balance");
						// 	}
						// 	catch(BalanceException e)
						// 	{
						// 		System.err.println(e.getMessage());
						// 	}
						// 	return;
						// }
					}
					else
					{
						// try
						// {
						// 	throw new PswdException("Incorrect pin");
						// }
						// catch(PswdException e)
						// {
						// 	System.out.println(e.getMessage());
						// }
						// return;
					}
				}
			}
			
			
		}
		System.err.println("Data NOT FOUND");	
	}
	
	public void deposit() throws IOException
	{
		System.out.println("Enter a acoount Number ");
		long acNo = sc.nextLong();
		
		for(int i=0; i<a.size(); i++)
		{
			
			if(a.get(i)!=null)
			{
				if(a.get(i).accountNo == acNo)
				{
					System.out.println("Enter a password ");
					int pass = sc.nextInt();
					if(a.get(i).pswd==pass)
					{
						System.out.println("Enter a Deposit Amount ");
						double money = sc.nextDouble();
						a.get(i).bal= a.get(i).bal+money;
						System.out.println("Your Balance is  "+ a.get(i).bal);
						
						String path = "E:\\Study\\Tutions\\QSPIDERS\\Bank";
						String path2 =a.get(i).name+"\\transaction.txt";
						String detailsPath = path+path2;
						Date date = new Date();
						String d = date+"";
						FileWriter fw = new FileWriter(detailsPath,true);
						fw.write("Status  ------  Deposit ------ "+"\n");
						fw.write("Transaction Date and time : "+d+"\n");
						fw.write("Withdraw Amount           :"+"----"+"\n");
						fw.write("deposit Amount            :"+money+"\n");
						fw.write("Balance                   :"+a.get(i).bal+"\n");
						fw.write("-------------------------------------------------\n");
						fw.close();
						
						String path3 =a.get(i).name+"\\deposit.txt";
						String depositPath = path+path3;
						
						FileWriter fww = new FileWriter(depositPath,true);
						fww.write("Status ------  withdrow ------ "+"\n");
						fww.write("Transaction Date and time : "+d+"\n");
						fww.write("Deposit Amount           :"+money+"\n");
						fww.write("Balance                   :"+a.get(i).bal+"\n");
						fww.write("-------------------------------------------------\n");
						fww.close();
						
						
						System.out.println("Thank you ............");
						return;
					}
					else
					{
						// try
						// {
						// 	throw new PswdException("Incorrect pin");
						// }
						// catch(PswdException e)
						// {
						// 	System.out.println(e.getMessage());
						// }
						// return;
					}
				}
				
			}
			
		}
		System.err.println("Data NOT FOUND");	
	}
	public void changePswd() throws IOException
	{
		System.out.println("Enter a acoount Number ");
		long acNo = sc.nextLong();
		for(int i=0; i<a.size(); i++)
		{
			if(a.get(i)!=null)
			{
				if( a.get(i).accountNo == acNo)
				{
					System.out.println("Enter a old password ");
					int pass = sc.nextInt();
					if(a.get(i).pswd==pass)
					{
						System.out.println("Enter a new pass");
						int p1 = sc.nextInt();
						System.out.println("ReEnter a new pass");
						int p2 = sc.nextInt();
						if(p1==p2)
						{
							a.get(i).pswd=p1;
							

							 putDataInDetails(a.get(i).name);
							
							System.out.println("Your pswd is set............");
							return;
						}
						else
						{
							System.out.println("pswd Notmatched");
							return;
						}
						
					}	
					//else
					// {
					// 	try
					// 	{
					// 		throw new PswdException("Incorrect pin");
					// 	}
					// 	catch(PswdException e)
					// 	{
					// 		System.out.println(e.getMessage());
					// 	}
					// 	return;
					//}
				}
				
			}
		}
			
		System.err.println("Data NOT FOUND");	
	}

	public void checkBal()
	{
		System.out.println("Enter a acoount Number ");
		long acNo = sc.nextLong();
		
		for(int i=0; i<a.size(); i++)
		{
			if(a.get(i)!=null)
				{
					if(a.get(i).accountNo == acNo)
					{
						System.out.println("your Balance is "+ a.get(i).bal);
						return;
					}
				}
			}
		
		System.err.println("Data NOT FOUND");
	}
	public  void show()
	{
		for(int i =0 ; i<a.size(); i++)
		{
			System.out.println(a.get(i).accountNo);
			System.out.println(a.get(i).name);
			System.out.println(a.get(i).bal);
		}
		
	}	
}	
/*
 * future for pass validation
 * public int checkValidPass(int pswd)
	{
		String s = pswd+"";
		if(s.length()<4)
		{
			System.out.println("Please Enter 3 digit pswd");
		}
		else
		{
		 	return pswd;
		}
	}
 * 
 * */	

