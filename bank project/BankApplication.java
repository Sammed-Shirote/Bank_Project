

import java.io.IOException;

public class BankApplication {

	public static void main(String[] args) throws IOException 
	{
		ICICBANK ic = new ICICBANK();
		for(;;)
		{
			
					System.out.println("Enter 1.ca 2.ra 3.Withdrow 4.deposit 5.Change Pswd 6. Check bal 7.Exit 9 show");
					switch(ic.sc.nextInt())
					{
						case 9 : 
							ic.show();
							break;
						case 1:
							ic.addAccount();
							break;
						case 2:
							ic.removeAccount();
							break;
						case 3:
							ic.withdrow();
							break;
						case 4:
							ic.deposit();
							break;
						case 5:
							ic.changePswd();
							break;
						case 6:
							ic.checkBal();;
							break;
						case 7:
							System.out.println("thank you ");
							return;
					}
			}
			
			
	}
		

}