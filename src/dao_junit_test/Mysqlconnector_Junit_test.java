package dao_junit_test;
import 网上书城.*;
import static org.junit.Assert.assertEquals;
import dao.Mysqlconnector;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class Mysqlconnector_Junit_test.
 *
 * @author wuyuchun
 * @version  v1.0
 * @date 2020年7月2日
 */
public class Mysqlconnector_Junit_test {

	
/**
 * Test set login user info into mysql.
 */
@Test
public void test_set_LoginUser_Info_Into_Mysql() {
	int num=Mysqlconnector.set_LoginUser_Info_Into_Mysql("33445", "123456", "WYC", "男", 20, 1);
	assertEquals(1,num);
}

/**
 * Test check user id is exisit.
 */
@Test
public void test_check_userId_isExisit() {
	loginPage.jtId.setText("1231");
	try {
		boolean a=Mysqlconnector.check_userId_isExisit();
		assertEquals(a,false);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

/**
 * Test login user password is right.
 */
@Test
public void test_login_userPassword_isRight() {
	Login.loginId1.setText("123");
	int a=Mysqlconnector.login_userPassword_isRight();
	assertEquals(a,1);
}

/**
 * Test book info insert and search.
 */
@Test
public void test_book_Info_Insert_and_search() {
	try {
		int a=Mysqlconnector.book_Info_Insert_and_search();
		assertEquals(a,7);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

/**
 * Test que book.
 */
@Test
public void test_que_book() {
	try {
		Mysqlconnector.book_Info_Insert_and_search();

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	int a=Mysqlconnector.que_book();
	assertEquals(a,1);
}

/**
 * Test love book.
 */
public void test_love_book() {
	try {
		Mysqlconnector.book_Info_Insert_and_search();

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	int a=Mysqlconnector.love_book();
	assertEquals(a,2);
}

/**
 * Test tech book.
 */
@Test
public void test_tech_book()
{
	try {
		Mysqlconnector.book_Info_Insert_and_search();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	int a=Mysqlconnector.tech_book();
	assertEquals(a,4);
}

/**
 * Test personal offerlist search.
 */
@Test
public void test_personal_offerlist_search()
{
	int a =Mysqlconnector.personal_offerlist_search(0);
	Login.loginId1.setText("1231");
	assertEquals(a,5);
}

/**
 * Test adimin add book.
 */
@Test
public void test_adimin_add_book() {
	adminPage.jt.setText("009");
	adminPage.jt1.setText("星际探索");
	adminPage.jt2.setText("30");
	adminPage.jt3.setText("30");
	adminPage.jt4.setText("科幻");
	int a=Mysqlconnector.adimin_add_book();
	assertEquals(a,1);
}

/**
 * Test admin delete book.
 */
@Test
public void test_admin_delete_book() {
	adminPage.jtb.setText("星际探索");
	int a=Mysqlconnector.admin_delete_book();
	assertEquals(a,1);
}


}