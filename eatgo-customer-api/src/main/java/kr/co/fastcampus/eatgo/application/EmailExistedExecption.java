package kr.co.fastcampus.eatgo.application;

public class EmailExistedExecption extends RuntimeException {

    EmailExistedExecption(String email){
        super("Email is already registered: " + email);
    }
}
