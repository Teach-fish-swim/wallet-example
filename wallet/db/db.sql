CREATE DATABASE `wallet_db` /*!40100 DEFAULT CHARACTER SET utf8 */;

-- wallet_db.tb_wallet definition
-- 用户钱包
CREATE TABLE `tb_wallet` (
                             `id` varchar(50) NOT NULL COMMENT '用户唯一键',
                             `remaining_sum` decimal(20,2) NOT NULL COMMENT '余额',
                             `create_date` date NOT NULL COMMENT '创建日期',
                             `update_date` date DEFAULT NULL COMMENT '更改日期',
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- wallet_db.tb_spend_record definition
-- 用户账号流水
CREATE TABLE `tb_spend_record` (
                                   `id` varchar(50) NOT NULL COMMENT '用户id',
                                   `desc` varchar(100) DEFAULT NULL COMMENT '账户变动详情',
                                   `create_date` date NOT NULL COMMENT '费用产生日期',
                                   `remaining_sum` decimal(20,0) NOT NULL COMMENT '账户余额'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



INSERT INTO wallet_db.tb_wallet (id,remaining_sum,create_date,update_date) VALUES
                                                                               ('4rfsdsrtt543r436frbvcybaf',20000.00,'2023-05-12',NULL),
                                                                               ('aafsdsrtt543624cfrbvcybaf',60000.00,'2023-05-12',NULL),
                                                                               ('defsdsrtt543624cfrbvcybaf',10000.00,'2023-05-12',NULL),
                                                                               ('dffsdsrtt543624cfrbvcybaf',50000.00,'2023-05-12',NULL),
                                                                               ('f4fsdsrtt543624cfrbvcybaf',30000.00,'2023-05-12',NULL),
                                                                               ('jufsdsrtt543624cfrbvcybaf',40000.00,'2023-05-12',NULL);

INSERT INTO wallet_db.tb_spend_record (id,`desc`,create_date,remaining_sum) VALUES
                                                                                ('defsdsrtt543624cfrbvcybaf','买XXXX花费40','2023-05-12',40000),
                                                                                ('4rfsdsrtt543r436frbvcybaf','买YYYY花费60','2023-05-12',50000),
                                                                                ('f4fsdsrtt543624cfrbvcybaf','买ZZZZ花费80','2023-05-12',60000);
