package com.bitcamp.myapp.controller;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.RSAPublicKeySpec;
import javax.crypto.Cipher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Rsa {
	
    public static String RSA_WEB_KEY = "_RSA_WEB_Key_"; // ����Ű session key
    public static String RSA_INSTANCE = "RSA"; // rsa transformation

    /**
     * ��ȣȭ
     * 
     * @param privateKey
     * @param securedValue
     * @return
     * @throws Exception
     */
    public String decryptRsa(PrivateKey privateKey, String securedValue) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/NOPADDING");
        byte[] encryptedBytes = hexToByteArray(securedValue);
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        String decryptedValue = new String(decryptedBytes, "utf-8"); // ���� ���ڵ� ����.
        return decryptedValue;
    }
 
    /**
     * 16�� ���ڿ��� byte �迭�� ��ȯ�Ѵ�.
     * 
     * @param hex
     * @return
     */
    public static byte[] hexToByteArray(String hex) {
        if (hex == null || hex.length() % 2 != 0) { return new byte[] {}; }
 
        byte[] bytes = new byte[hex.length() / 2];
        for (int i = 0; i < hex.length(); i += 2) {
            byte value = (byte) Integer.parseInt(hex.substring(i, i + 2), 16);
            bytes[(int) Math.floor(i / 2)] = value;
        }
        return bytes;
    }
 
    /**
     * rsa ����Ű, ����Ű ����
     * 
     * @param request
     */
    public void initRsa(HttpServletRequest request) {
        HttpSession session = request.getSession();
 
        KeyPairGenerator generator;
        try {
            generator = KeyPairGenerator.getInstance(Rsa.RSA_INSTANCE);
            generator.initialize(1024);
 
            KeyPair keyPair = generator.genKeyPair();
            KeyFactory keyFactory = KeyFactory.getInstance(Rsa.RSA_INSTANCE);
            PublicKey publicKey = keyPair.getPublic();
            PrivateKey privateKey = keyPair.getPrivate();
 
            session.setAttribute(Rsa.RSA_WEB_KEY, privateKey); // session�� RSA ����Ű�� ���ǿ� ����
 
            RSAPublicKeySpec publicSpec = (RSAPublicKeySpec) keyFactory.getKeySpec(publicKey, RSAPublicKeySpec.class);
            String publicKeyModulus = publicSpec.getModulus().toString(16);
            String publicKeyExponent = publicSpec.getPublicExponent().toString(16);
            //System.out.println(publicKeyModulus);
            //System.out.println(publicKeyExponent);
            request.setAttribute("RSAModulus", publicKeyModulus); // rsa modulus �� request �� �߰�
            request.setAttribute("RSAExponent", publicKeyExponent); // rsa exponent �� request �� �߰�
        } catch (Exception e) {
           	System.out.println("initRsa���� ����");
            e.printStackTrace();
        }
    }
}