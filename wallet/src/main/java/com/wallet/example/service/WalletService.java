package com.wallet.example.service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wallet.example.config.WalletThrow;
import com.wallet.example.entity.WalletEntity;
import com.wallet.example.mapper.WalletMapper;
import com.wallet.example.result.ResultBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WalletService {

    @Autowired
    private WalletMapper walletMapper;

    public Object getRemainingSum(String userId) {
        try {
            return ResultBody.success(walletMapper.selectById(userId));
        } catch (RuntimeException e) {
            //打印日志，记录日志
            return ResultBody.error("程序出现异常");
        }
    }

    @Transactional
    public Object spend(Map param) {
        try {
            String userId = param.get("userId") + "";
            double currentSpend = (Double.parseDouble(param.get("currentSpend") + ""));//todo 处理精度问题
            WalletEntity walletEntity = walletMapper.selectById(userId);
            if (currentSpend < walletEntity.getRemainingSum())
                throw new WalletThrow("您的余额不足");
            Map thirdSysData = thirdSysSpend(param);//第三方支付系统
            if (!(thirdSysData.get("code") + "").equals("200"))
                throw new WalletThrow("XXX支付平台出现问题");//具体根据返回的情况给用户反馈
            WalletEntity walletEntity1 = new WalletEntity();
            walletEntity1.setId(userId);
            walletEntity1.setUpdateDate(new Date().toString());
            walletEntity1.setRemainingSum(walletEntity.getRemainingSum() - currentSpend);
            if (walletMapper.updateById(walletEntity1) != 1)
                throw new RuntimeException();
            Map spendData = new HashMap();
            spendData.put("id", userId);
            spendData.put("create_date", new Date().toString());
            spendData.put("desc", String.format("您 购买%s 一共花了 %s 元", param.get("goods"), currentSpend + ""));
            if (walletMapper.addSpendRecord(spendData) != 1)
                throw new RuntimeException();
            return ResultBody.success("success");
        } catch (RuntimeException e) {
            //打印日志，记录日志
            if (e instanceof WalletThrow)
                return ResultBody.error(e.getMessage());
            return ResultBody.error("系统出现异常");
        }
    }

    private Map thirdSysRefund(Map param) {
        return new HashMap();
    }

    @Transactional
    public Object refund(Map param) {
        try {
            String userId = param.get("userId") + "";
            double refund = (Double.parseDouble(param.get("refund") + ""));//todo 处理精度问题
            WalletEntity walletEntity = walletMapper.selectById(userId);
            if (walletEntity == null)
                throw new WalletThrow("账户异常");
            Map thirdSysData = thirdSysRefund(param);//第三方支付系统
            if (!(thirdSysData.get("code") + "").equals("200"))
                throw new WalletThrow("XXX支付平台出现问题");//具体根据返回的情况给用户反馈
            WalletEntity walletEntity1 = new WalletEntity();
            walletEntity1.setId(userId);
            walletEntity1.setUpdateDate(new Date().toString());
            walletEntity1.setRemainingSum(walletEntity.getRemainingSum() + refund);
            if (walletMapper.updateById(walletEntity1) != 1)
                throw new RuntimeException();
            Map spendData = new HashMap();
            spendData.put("id", userId);
            spendData.put("create_date", new Date().toString());
            spendData.put("desc", String.format("您 此次退款 %s 元", refund + ""));
            if (walletMapper.addSpendRecord(spendData) != 1)
                throw new RuntimeException();
            return ResultBody.success("success");
        } catch (RuntimeException e) {
            //打印日志，记录日志
            if (e instanceof WalletThrow)
                return ResultBody.error(e.getMessage());
            return ResultBody.error("系统出现异常");
        }
    }

    private Map thirdSysSpend(Map param) {
        return new HashMap();
    }

    public Object getSpendDetail(String query) {
        JSONObject jsonObject = JSONObject.parseObject(query);
        Page<Object> objects = PageHelper.startPage(jsonObject.getInteger("startPage"), jsonObject.getInteger("limit"));//分页
        try {
            List<JSONObject> data = walletMapper.getSpendDetail(jsonObject);
            return ResultBody.success(data);
        } catch (RuntimeException e) {
            //记录日志
            return ResultBody.error("程序出现异常");
        }
    }

}
