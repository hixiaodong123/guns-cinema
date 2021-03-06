package com.stylefeng.guns.api.promo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PromoVo implements Serializable {
    private static final long serialVersionUID = -5779083239707809336L;
    private   String  cinemaAddress;
    private   Integer  cinemaId;			
    private   String  cinemaName;			
    private   String  description;		
    private   Date endTime;			
    private   String  imgAddress;			
    private   Integer  price;				
    private   Date  startTime;			
    private   Integer  status;				
    private   Integer  stock;				
    private   Integer  uuid;				

}
