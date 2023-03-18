/*
 * Class: CMSC203 
 * Instructor: Professor Monshi
 * Description: A program which allows the user to both encrypt and decrypt strings via both the Caesar and the Bellaso methods
 * Due: 17 March 2023 — 23:59
 * Platform/compiler: Windows 10; Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Sohrab Hashemian
*/

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CryptoManagerTestStudent
{
	@BeforeEach
	public void setUp() throws Exception{}

	@AfterEach
	public void tearDown() throws Exception{}

	@Test
	public void testStringInBounds()
	{
		assertTrue(CryptoManager.isStringInBounds("AAAA"));
		assertFalse(CryptoManager.isStringInBounds("{{{{"));
	}

	@Test
	public void testEncryptCaesar()
	{
		assertEquals("WXYZ" , CryptoManager.caesarEncryption("ABCD" , 86));
	}
	
	@Test
	public void testEncryptBellaso()
	{
		assertEquals("The selected string is not in bounds, Try again." , CryptoManager.bellasoEncryption("XYZ}{" , "ASCII"));
	}

	@Test
	public void testDecryptCaesar()
	{
		assertEquals("CAESAR DECRYPTION" , CryptoManager.caesarDecryption("HFJXFW%IJHW^UYNTS" , 5));
	}
	
	@Test
	public void testDecryptBellaso()
	{
		assertEquals("FREE WORLD" , CryptoManager.bellasoDecryption("YWHW%+\"WOV" , "SECRET"));
	}
}
