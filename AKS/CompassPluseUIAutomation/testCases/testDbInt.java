package testCases;



import org.testng.annotations.Test;



import testSetup.dataBaseValidationWithUiOfferContext;



public class testDbInt {



	//public static void main(String[] args) {



	@Test  

	public void dbtest() {

		ClassLoader.getSystemClassLoader().setClassAssertionStatus("oracle.jdbc.driver", false);

		dataBaseValidationWithUiOfferContext d=new dataBaseValidationWithUiOfferContext();

		//ClassLoader.getSystemClassLoader().setPackageAssertionStatus("oracle.jdbc.driver", false);

		//d.dbValidationOfferContextWithUi("07415982219","UP",UiOldDevice,UiNewDevice);

		d.TestdbValidationOfferContextWithUi("07415982219","UP","SAMSUNG GALAXY S8 G950F LTE","APPLE IPHONE 11 64GB Black");





	}



}