package atm_package;

import org.junit.Assert;
import org.junit.Test;

public class AtmTest {

	@Test
	public void shouldSetupNewAtmWith120Bucks() {
		// arrange
		Atm underTest = new Atm(120.00);
		// act
		double balance = underTest.getBalance();
		// assert
		Assert.assertEquals(120.00, balance, 0.005);
	}

	@Test
	public void shouldDisplayBalance() {
		Atm underTest = new Atm(100);
		double balance = underTest.getBalance();
		Assert.assertEquals(balance, underTest.getBalance(), 0.005);
	}

	@Test
	public void shouldSetBalanceAs300() {
		Atm underTest = new Atm(50);
		underTest.setBalance(300.00);
		Assert.assertEquals(underTest.getBalance(), 300, 0.005);
	}

	@Test
	public void shouldDepositFiveBucks() {
		Atm underTest = new Atm(0);
		underTest.deposit(5);
		Assert.assertEquals(underTest.getBalance(), 5, 0.005);
	}

	@Test
	public void shouldAllowAccess() {
		Atm underTest = new Atm(0);
		Assert.assertEquals(true, underTest.allowAccess("1234"));
	}
	
	@Test public void shouldNotAllowAccess() {
		Atm underTest = new Atm(0);
		Assert.assertEquals(false, underTest.allowAccess("4321"));
	}

	@Test
	public void shouldGetPin() {
		Atm underTest = new Atm(0);
		String actualPin = underTest.getPin();
		Assert.assertEquals("1234", actualPin);
	}

	@Test
	public void shouldWithdrawFiveBucks() {
		// arrange
		Atm underTest = new Atm(0);
		// act
		double firstBalance = underTest.getBalance();
		underTest.withdraw(5);
		// assert
		Assert.assertEquals(firstBalance - 5, underTest.getBalance(), 0.005);
	}
	
	

}
