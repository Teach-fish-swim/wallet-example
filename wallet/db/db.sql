CREATE DATABASE `wallet_db` /*!40100 DEFAULT CHARACTER SET utf8 */;

-- wallet_db.tb_wallet definition
-- �û�Ǯ��
CREATE TABLE `tb_wallet` (
                             `id` varchar(50) NOT NULL COMMENT '�û�Ψһ��',
                             `remaining_sum` decimal(20,2) NOT NULL COMMENT '���',
                             `create_date` date NOT NULL COMMENT '��������',
                             `update_date` date DEFAULT NULL COMMENT '��������',
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- wallet_db.tb_spend_record definition
-- �û��˺���ˮ
CREATE TABLE `tb_spend_record` (
                                   `id` varchar(50) NOT NULL COMMENT '�û�id',
                                   `desc` varchar(100) DEFAULT NULL COMMENT '�˻��䶯����',
                                   `create_date` date NOT NULL COMMENT '���ò�������',
                                   `remaining_sum` decimal(20,0) NOT NULL COMMENT '�˻����'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



INSERT INTO wallet_db.tb_wallet (id,remaining_sum,create_date,update_date) VALUES
                                                                               ('4rfsdsrtt543r436frbvcybaf',20000.00,'2023-05-12',NULL),
                                                                               ('aafsdsrtt543624cfrbvcybaf',60000.00,'2023-05-12',NULL),
                                                                               ('defsdsrtt543624cfrbvcybaf',10000.00,'2023-05-12',NULL),
                                                                               ('dffsdsrtt543624cfrbvcybaf',50000.00,'2023-05-12',NULL),
                                                                               ('f4fsdsrtt543624cfrbvcybaf',30000.00,'2023-05-12',NULL),
                                                                               ('jufsdsrtt543624cfrbvcybaf',40000.00,'2023-05-12',NULL);

INSERT INTO wallet_db.tb_spend_record (id,`desc`,create_date,remaining_sum) VALUES
                                                                                ('defsdsrtt543624cfrbvcybaf','��XXXX����40','2023-05-12',40000),
                                                                                ('4rfsdsrtt543r436frbvcybaf','��YYYY����60','2023-05-12',50000),
                                                                                ('f4fsdsrtt543624cfrbvcybaf','��ZZZZ����80','2023-05-12',60000);
