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

/**
 * This is a utility class that encrypts and decrypts a phrase using two
 * different approaches. The first approach is called the Caesar Cipher and is a
 * simple �substitution cipher� where characters in a message are replaced by a
 * substitute character. The second approach, due to Giovan Battista Bellaso,
 * uses a key word, where each character in the word specifies the offset for
 * the corresponding character in the message, with the key word wrapping around
 * as needed.
 * 
 * @author Farnaz Eivazi
 * @version 7/16/2022
 */
public class CryptoManager {
	
	private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_RANGE and UPPER_RANGE characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean isStringInBounds (String plainText)
	{
		for (int q=0 ; q<plainText.length() ; q++)
		{
			if ((!(plainText.charAt(q) >= LOWER_RANGE)) || (!(plainText.charAt(q) <= UPPER_RANGE)))
			{
				return false;
			}
		}
		return true;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String caesarEncryption(String plainText, int key)
	{
		String failText = "The selected string is not in bounds, Try again.";
		if (!(isStringInBounds(plainText)))
		{
			return failText;
		}
		
		int step;
		
		String encryptedText = "";
		for (int q=0 ; q<plainText.length() ; q++)
		{
			step = (int)plainText.charAt(q)+key;
			while(step > UPPER_RANGE)
			{
				step -= RANGE;
			}
			encryptedText += (char)step;
		}
		return encryptedText;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String bellasoEncryption (String plainText, String bellasoStr)
	{
		String failText = "The selected string is not in bounds, Try again.";
		if (!(isStringInBounds(plainText)))
		{
			return failText;
		}
		
		while (bellasoStr.length()*2 <= plainText.length())
		{
			bellasoStr += bellasoStr;
		}
		for (int q=0 ; bellasoStr.length() < plainText.length() ; q++)
		{
			bellasoStr += bellasoStr.charAt(q);
		}
		
		int step;
		
		String encryptedText = "";
		for (int q=0 ; q<plainText.length() ; q++)
		{
		    step = (int)plainText.charAt(q)+(int)bellasoStr.charAt(q);
		    while (step > UPPER_RANGE)
		    {
		    	step -= RANGE;
		    }
			encryptedText += (char)step;
		}
		return encryptedText;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String caesarDecryption (String encryptedText, int key)
	{
		int step;
		
		String plainText = "";
		for (int q=0 ; q<encryptedText.length() ; q++)
		{
			step = (int)encryptedText.charAt(q)-key;
			while (step < LOWER_RANGE)
			{
				step += RANGE;
			}
			plainText += (char)step;
		}
		return plainText;
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String bellasoDecryption(String encryptedText, String bellasoStr)
	{
		while (bellasoStr.length()*2 <= encryptedText.length())
		{
			bellasoStr += bellasoStr;
		}
		for (int q=0 ; bellasoStr.length() < encryptedText.length() ; q++)
		{
			bellasoStr += bellasoStr.charAt(q);
		}
		
		int step;
		
		String plainText = "";
		for (int q=0 ; q<encryptedText.length() ; q++)
		{
			step = (int)encryptedText.charAt(q)-(int)bellasoStr.charAt(q);
			while (step < LOWER_RANGE)
			{
				step += RANGE;
			}
			plainText += (char)step;
		}
		return plainText;
	}
}
