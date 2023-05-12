package com.wallet.example.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * spend entity
 */
@TableName("tb_wallet")
public class WalletEntity {
    private static final long serialVersionUID = 1L;

    @TableId("id")
    String id;
    @TableId("remaining_sum")
    Double remainingSum;
    @TableId("createDate")
    String createDate;
    @TableId("update_date")
    String updateDate;

    public WalletEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getRemainingSum() {
        return remainingSum;
    }

    public void setRemainingSum(Double remainingSum) {
        this.remainingSum = remainingSum;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }
}
