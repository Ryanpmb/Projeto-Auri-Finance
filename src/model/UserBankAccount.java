package model;

import java.util.Date;

public class UserBankAccount {
    private int id;
    private String bankingInstitutionName;
    private String bankingInstitutionType;
    private int bankAgency;
    private int accountNumber;
    private Date created_at;
    private Date updated_at;

    public UserBankAccount() {
    }

    public int getId() {
        return id;
    }

    public String getBankingInstitutionName() {
        return bankingInstitutionName;
    }

    public void setBankingInstitutionName(String bankingInstitutionName) {
        this.bankingInstitutionName = bankingInstitutionName;
    }

    public String getBankingInstitutionType() {
        return bankingInstitutionType;
    }

    public void setBankingInstitutionType(String bankingInstitutionType) {
        this.bankingInstitutionType = bankingInstitutionType;
    }

    public int getBankAgency() {
        return bankAgency;
    }

    public void setBankAgency(int bankAgency) {
        this.bankAgency = bankAgency;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    
}
