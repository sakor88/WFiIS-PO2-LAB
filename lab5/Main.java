// Ten plik jest przykładem i pokazuje możliwą działanie jednej z możliwych implementacji.
// W dzisiejszym ćwiczeniu nie ma narzuconej wersji pliku Main.java - ten plik można utworzyć całkowicie po swojemu.
// Warto, aby znalazły się w nim również m.in. testy metody equals()



class Main {
	public static void main(String[] args) 
	{
		//BasicAccount basicAccount = new BasicAccount("Adam Abacki", 1234.56, "0000"); //error: BasicAccount is abstract; cannot be instantiated
		RegularAccount regularAccount = new RegularAccount("Adam Abacki", 1234.56, "0000");
		System.out.println(regularAccount);

		InterestAccount interestAccount = new InterestAccount("Bartosz Babacki", 600.00, "1234");
		System.out.println(interestAccount);

		CheckingAccount checkingAccount = new CheckingAccount("Cyprian Cacki", 200.05, "2580");
		System.out.println(checkingAccount);

		regularAccount.withdraw(800.55);
		System.out.println("Balance account 1 (regular): " + regularAccount.getBalance());
		regularAccount.deposit(200);
		System.out.println("Balance account 1 (regular): " + regularAccount.getBalance());
		regularAccount.monthlyUpdate(); //10 zł - fees, 10 zł - penalty
		System.out.println("Balance account 1 (regular): " + regularAccount.getBalance()); 

		interestAccount.withdraw(555);
		System.out.println("Balance account 2 (interest): " + interestAccount.getBalance());
		interestAccount.deposit(7.30);
		System.out.println("Balance account 2 (interest): " + interestAccount.getBalance());
		interestAccount.monthlyUpdate(); //5.23 zł - fees, 1.046 zł - interests
		System.out.println("Balance account 2 (interest): " + interestAccount.getBalance()); 

		
		checkingAccount.withdraw(10.05);
		System.out.println("Balance account 3 (checking): " + checkingAccount.getBalance());
		checkingAccount.deposit(1027.15);
		System.out.println("Balance account 3 (checking): " + checkingAccount.getBalance());
		checkingAccount.monthlyUpdate(); //11 zł - fees (10 zł + 2 transactions * 0.5 zł), 24.343 zł - interests
		System.out.println("Balance account 3 (checking): " + checkingAccount.getBalance());
	}
}

// Example output:
// type: regular account, owner: Adam Abacki, balance: 1234.56
// type: interest account, owner: Bartosz Babacki, balance: 600.0
// type: checking account, owner: Cyprian Cacki, balance: 200.05
// Balance account 1 (regular): 434.01
// Balance account 1 (regular): 634.01
// Balance account 1 (regular): 614.01
// Balance account 2 (interest): 45.0
// Balance account 2 (interest): 52.3
// Balance account 2 (interest): 48.116
// Balance account 3 (checking): 190.0
// Balance account 3 (checking): 1217.15
// Balance account 3 (checking): 1230.4930000000002