package com.stylefeng.guns.rest.common.persistence.model;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Mr.Xu
 * @since 2019-09-03
 */
@TableName("mtime_promo")
public class MtimePromo extends Model<MtimePromo> {
    private   String  cinemaName;
    private   String  cinemaAddress;
    private   String  imgAddress;
    private   Integer  stock;
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "uuid", type = IdType.AUTO)
    private Integer uuid;
    /**
     * 秒杀活动影院id
     */
    @TableField("cinema_id")
    private Integer cinemaId;
    /**
     * 秒杀价格
     */
    private BigDecimal price;
    /**
     * 秒杀开始时间
     */
    @TableField("start_time")
    private Date startTime;
    /**
     * 秒杀结束时间
     */
    @TableField("end_time")
    private Date endTime;
    /**
     * 秒杀活动状态
     */
    private Integer status;
    /**
     * 活动描述
     */
    private String description;

    @Override
    public String toString() {
        return "MtimePromo{" +
                "cinemaName='" + cinemaName + '\'' +
                ", cinemaAddress='" + cinemaAddress + '\'' +
                ", imgAddress='" + imgAddress + '\'' +
                ", stock=" + stock +
                ", uuid=" + uuid +
                ", cinemaId=" + cinemaId +
                ", price=" + price +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", status=" + status +
                ", description='" + description + '\'' +
                '}';
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getCinemaAddress() {
        return cinemaAddress;
    }

    public void setCinemaAddress(String cinemaAddress) {
        this.cinemaAddress = cinemaAddress;
    }

    public String getImgAddress() {
        return imgAddress;
    }

    public void setImgAddress(String imgAddress) {
        this.imgAddress = imgAddress;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public Integer getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Integer cinemaId) {
        this.cinemaId = cinemaId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    protected Serializable pkVal() {
        return this.uuid;
    }

}
