package com.algorithm.practice.test;

import javax.ws.rs.InternalServerErrorException;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test1 {

    private static final Logger LOG = LoggerFactory.getLogger(Test1.class);

    public static void main(String[] args) throws Exception {
        try{throwException();}
        catch (Exception e){
            LOG.error("Caught throwable, returning generic internal server error; ID: {}", "abc", e);
        }
    }

    public static void throwException(){
        throw new InternalServerErrorException("I am throwing exception");
    }
}

