package org.springtc.pages;

import org.openqa.selenium.By;

public class Homepage {
	
	public By MyAccount=By.xpath("//*[@id='top-links']/ul/li[2]/a");
	public By loginLabel=By.xpath("//a[text()='Login']");
	public By userName=By.id("input-email");
	public By password=By.id("input-password");
	public By SubmitButton=By.xpath("//input[@value='Login']");
	public By HomeButton=By.xpath("//ul[@class='breadcrumb']/li/a");
	public By ProdectNames=By.xpath("//div[@id='content']/div[@class='row']/div/div/div[@class='caption']/h4/a");
	public By ProdectPrice=By.xpath("//div[@id='content']/div[@class='row']/div/div/div[@class='caption']/p[2]");
	public By LaptopsANDnotebooks=By.xpath("//a[text()='Laptops & Notebooks']");
	public By AllLaptopsANDnotebooks=By.xpath("//a[text()='Show All Laptops & Notebooks']");
	public By SortBy=By.id("input-sort");
	public By MackBookPro=By.xpath("//*[@id='content']/div[4]/div[1]/div/div[1]/a");
	public By UnitPrice=By.xpath("//*[@id='content']/div/div[2]/ul[2]/li[1]/h2");
	public By QtyTextBox=By.id("input-quantity");
	public By btnAddToCart=By.id("button-cart");
	public By cartButtonOnTop=By.xpath("//*[@id='cart']/button");
	public By productNameInCart=By.xpath("//table[@class='table table-striped']/tbody/tr/td[2]");
	public By Quantitys=By.xpath("//table[@class='table table-striped']/tbody/tr/td[3]");
	public By productPriceInCart=By.xpath("//table[@class='table table-striped']/tbody/tr/td[4]");
	public By TotalPriceInCart=By.xpath("//*[@class='table table-bordered']/tbody/tr[2]/td[2]");
	

}
