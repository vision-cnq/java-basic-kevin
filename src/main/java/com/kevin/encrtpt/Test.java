package com.kevin.encrtpt;

public class Test {

	public static void main(String[] args) {
        int xorNum = 12345;
        String res = "I am the text to be encoded and decoded.";
        String key = "我是密钥key";
        System.out.println("-------------------------BASE64--------------------------");
        String base64_encodedStr = BASE64Util.getInstance().encode(res);
        System.out.println("加密：" + base64_encodedStr);
        System.out.println("解密：" + BASE64Util.getInstance().decode(base64_encodedStr));
        System.out.println("-------------------------MD5--------------------------");
        String md5_encodedStr = MD5Util.getInstance().encode(res);
        System.out.println("无密码加密：" + md5_encodedStr);
        System.out.println("有密码加密：" + MD5Util.getInstance().encode(md5_encodedStr, key));
        System.out.println("-------------------------SHA1--------------------------");
        String sha1_encodedStr = SHA1Util.getInstance().encode(res);
        System.out.println("无密码加密：" + sha1_encodedStr);
        System.out.println("有密码加密：" + SHA1Util.getInstance().encode(sha1_encodedStr, key));
        System.out.println("-------------------------AES--------------------------");
        String aes_encodedStr = AESUtil.getInstance().encode(res, key);
        System.out.println("加密：" + aes_encodedStr);
        System.out.println("解密：" + AESUtil.getInstance().decode(aes_encodedStr, key));
        System.out.println("-------------------------DES--------------------------");
        String des_encodedStr = DESUtil.getInstance().encode(res, key);
        System.out.println("加密：" + des_encodedStr);
        System.out.println("解密：" + DESUtil.getInstance().decode(des_encodedStr, key));
        System.out.println("-------------------------XOR--------------------------");
        String xor_encodedStr = XORUtil.getInstance().encode(res, key);
        System.out.println("文本加密：" + xor_encodedStr);
        System.out.println("文本解密：" + XORUtil.getInstance().decode(xor_encodedStr, key));
        int xor_encodedNum = XORUtil.getInstance().code(xorNum, key);
        System.out.println("数字加密：" + xor_encodedNum);
        System.out.println("数字解密：" + XORUtil.getInstance().code(xor_encodedNum, key));
    }

}
