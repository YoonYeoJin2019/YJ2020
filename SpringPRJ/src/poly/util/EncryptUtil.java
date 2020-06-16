package poly.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;

public class EncryptUtil {

	final static String addMessage = "PolyDataAnalysis";
	
	final static byte[] ivBytes = {0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00};
	
	final static String key = "PolyTechnic12345";
	

	
	
	
	public static String encHashSHA256(String str) throws Exception{
		
		String res = "";
		String plantText = addMessage + str;
		
		try {
			MessageDigest sh = MessageDigest.getInstance("SHA-256");
			
			sh.update(plantText.getBytes());
			
			byte byteData[] = sh.digest();
			
			StringBuffer sb = new StringBuffer();
			
			for(int i = 0; i< byteData.length;i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1)); 
			}
			
			res = sb.toString();
		} catch (NoSuchAlgorithmException e){
			e.printStackTrace();
			
			res = "";
			
		}
		
		return res;
	}
	
	
	public static String encAES128CBC(String str)
			throws UnsupportedEncodingException,NoSuchAlgorithmException,
			InvalidKeyException, InvalidAlgorithmParameterException,IllegalBlockSizeException,BadPaddingException, NoSuchPaddingException{
		
			byte[] textBytes = str.getBytes("UTF-8");
			AlgorithmParameterSpec ivSpec = new IvParameterSpec(ivBytes);
			SecretKeySpec newKey = new SecretKeySpec(key.getBytes("UTF-8"),"AES");
			Cipher cipher = null;
			cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, newKey, ivSpec);
			
			return Base64.encodeBase64String(cipher.doFinal(textBytes));
			
		}
		
		public static String decAES128CBC(String str)
				throws UnsupportedEncodingException,NoSuchAlgorithmException,
				InvalidKeyException, InvalidAlgorithmParameterException,IllegalBlockSizeException,BadPaddingException, NoSuchPaddingException{
			
				byte[] textBytes = Base64.decodeBase64(str);
				AlgorithmParameterSpec ivSpec = new IvParameterSpec(ivBytes);
				SecretKeySpec newKey = new SecretKeySpec(key.getBytes("UTF-8"),"AES");
				Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
				cipher.init(Cipher.DECRYPT_MODE, newKey,ivSpec);
				return new String(cipher.doFinal(textBytes), "UTF-8");
				
			}
	
			
		public static String getNewPw() throws Exception {
			// 비밀번호 배열을 생성
			char[] charSet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
					's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

			// 비밀번호를 받기 위한 문자열 버퍼 생성
			// 비밀번호를 담는 틀 생성
			StringBuffer newKey = new StringBuffer();

			// 10번 반복
			for (int i = 0; i < 10; i++) {
				// 비밀번호 배열 길이*랜덤으로 생성된 숫자
				// random() 난수가 복잡하지 않기 떄문에 숫자를 더 복잡하게 해줌
				int idx = (int) (charSet.length * Math.random());
				// 문자열에다가 한글자씩 담는것
				newKey.append(charSet[idx]);
			}

			// 스트링 버퍼를 스트링형태로 바꿔서 반환해줌
			return newKey.toString();
		}
		
	
}
