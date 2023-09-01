package com.driver;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception

        super(name, balance, 5000);
        this.tradeLicenseId = tradeLicenseId;
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception

        if(tradeLicenseId.isEmpty()){
            throw  new Exception("Valid License can not be generated");
        }
        StringBuilder newtradelicenseId = new StringBuilder();
        newtradelicenseId.append(tradeLicenseId.charAt(0));
        for(int i=1; i<tradeLicenseId.length()-1; i++){
            char ch = tradeLicenseId.charAt(i);
            if(tradeLicenseId.charAt(i) == tradeLicenseId.charAt(i-1)){
                newtradelicenseId.append(getNewChar(ch));
            }
            else{
                newtradelicenseId.append(ch);
            }
        }
        tradeLicenseId = newtradelicenseId.toString();
    }

    private char getNewChar(char ch) {
        for(char i ='A' ; i<='Z'; i++){
            if(i != ch)return i;
        }
        return 'A';//default value
    }

}
