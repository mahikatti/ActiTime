package testPack;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class General {
	
	@BeforeSuite
	public void Brforesuite()
	{
		System.out.println("beforeSuite");
	}
	@BeforeTest
	public void BrforeTest()
	{
		System.out.println("beforeTest");
	}
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("beforeclass");
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("before method");
	}
	@Test
	public void test()
	{
		System.out.println("test");
	}
	
	@Test
	public void test1()
	{
		System.out.println("test123");
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("after method");
	}
	@AfterClass
	public void afterClass()
	{
		System.out.println("after class");
	}
	@AfterTest
	public void afterTest()
	{
		System.out.println("after test");
	}
	
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("after Suite");
	}
}
