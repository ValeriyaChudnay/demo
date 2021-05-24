package com.expert.service;

import com.expert.dao.ExpertDao;
import com.expert.entity.Expert;
import com.expert.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.List;
import java.util.Random;

public class ExpertServiceImpl implements ExpertService{

    private ExpertDao expertDao;
    private Random random;
    private static int workload = 12;

    @Autowired
    public ExpertServiceImpl(ExpertDao expertDao) {
        this.expertDao = expertDao;
    }

    @Override
    public List<Expert> findAll() {
        return expertDao.findAll();
    }

    @Override
    public Expert getExpertByEmailAndPassword(String email, String password) {
        Expert expert = expertDao.getExpertByEmail(email);
        if(checkPassword(password,expert.getPassword())){
            return expert;
        }else {
            return null;
        }
    }

    @Override
    public Expert createExpert(String email, String password, String score,String name, String organizationCode) {
        password=hashPassword(password);
        Expert expert=expertDao.createExpert(email,password,score,name,organizationCode);
        return expert;
    }

    @Override
    public List<Expert> getExpertsByProjectId(int id) {
        return expertDao.getExpertsByProjectId(id);
    }

    @Override
    public List<Expert> getExpertsByOrganization(String organizationCode) {
        return expertDao.getExpertsByOrganization(organizationCode) ;
    }


    public static String hashPassword(String password) {
        String salt = BCrypt.gensalt(workload);
        String hashed_password = BCrypt.hashpw(password, salt);
        return(hashed_password);
    }
    public static boolean checkPassword(String userPassword, String hashFromDB) {
        boolean password_verified;

        if(null == hashFromDB || !hashFromDB.startsWith("$2a$"))
            throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");

        password_verified = BCrypt.checkpw(userPassword, hashFromDB);

        return(password_verified);
    }
}
