package com.wallet.example.mapper;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wallet.example.entity.WalletEntity;

import java.util.List;
import java.util.Map;


/**
 *
 */
public interface WalletMapper extends BaseMapper<WalletEntity> {

    int addSpendRecord(Map spendData);

    List<JSONObject> getSpendDetail(JSONObject jsonObject);
}
