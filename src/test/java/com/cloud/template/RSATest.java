package com.cloud.template;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.security.*;

/**
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/applicationContext.xml"})
public class RSATest {




    @Test
    public void testRSA() {
        try {
            KeyPairGenerator gen = KeyPairGenerator.getInstance("RSA");
            gen.initialize(2048);
            KeyPair pair = gen.generateKeyPair();
            //rsa生成一对公私钥
            PublicKey publicKey  = pair.getPublic();
            PrivateKey privateKey  = pair.getPrivate();
            //SHA1withRSA算法进行签名
            Signature sign = Signature.getInstance("SHA1withRSA");
            sign.initSign(privateKey);
            byte[] data = "channelId=1&clientId=100002&msgType=CONNECT".getBytes();
            //更新用于签名的数据
            sign.update(data);
            byte[] signature = sign.sign();
            Signature verifySign = Signature.getInstance("SHA1withRSA");
            verifySign.initVerify(publicKey);
            //用于验签的数据
            verifySign.update(data);
            boolean flag = verifySign.verify(signature);
            System.out.println(flag);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}