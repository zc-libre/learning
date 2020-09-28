package com.zc.javase.enums.collection;

import java.util.EnumSet;

/**
 * @author zhao.cheng
 * @date 2020/9/8 14:22
 */
public class Pizza {

   private PizzaStatus status;


   public boolean isDeliverable() {
       return getStatus() == PizzaStatus.READY;
   }

    public PizzaStatus getStatus() {
        return status;
    }

    public void setStatus(PizzaStatus status) {
        this.status = status;
    }

    public enum  PizzaStatus {

        ORDERED ,

        READY,

        DELIVERED;

    }
}
