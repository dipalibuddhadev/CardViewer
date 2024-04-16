package com.cardviewer.model;

import com.google.gson.annotations.SerializedName;

public class CardListResponse {

    @SerializedName("credit_card_type")
    private String cardType;

    @SerializedName("credit_card_number")
    private String cardNumber;

    @SerializedName("credit_card_expiry_date")
    private String expiryDate;

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
}