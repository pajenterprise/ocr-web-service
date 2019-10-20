package com.jalasoft.ocrwebservice.service;

import com.jalasoft.ocrwebservice.database.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.security.Key;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;


public class TokenService {

    public static void  saveToken(User user1)  {
      //  PrivateKey privateKey = loadEcPrivateKeyFromConfiguration();
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("DevFund2");
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
        String token = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, signingKey)
                .setSubject("test")
                .claim("role","admin")
                .compact();
        Cache.getInstance().add(token);
    }


}
