// package com.stockholm.main_project.websocket;
// import javax.crypto.Cipher;
// import javax.crypto.spec.IvParameterSpec;
// import javax.crypto.spec.SecretKeySpec;
// import java.util.Base64;
// //AES256 암호화를 해제하는 함수입니다.
// public class AES256Util {
//     public static String decrypt(String key, String iv, String cipherText) throws Exception {
//         IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes("UTF-8"));
//         SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

//         Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
//         cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);

//         byte[] decodedBytes = Base64.getDecoder().decode(cipherText);
//         byte[] original = cipher.doFinal(decodedBytes);

//         return new String(original);
//     }
// }