# ShopProject_Master
## 商城服务器Api
配合App一起使用 App项目的地址<br>  
 
进入 [商城App](https://github.com/ArdWang/HappyShopJava_Master "悬停显示") 
<br>
数据库 
```
/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.21-log : Database - shop_db
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`shop_db` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `shop_db`;

/*Table structure for table `cartgoods_tb` */

DROP TABLE IF EXISTS `cartgoods_tb`;

CREATE TABLE `cartgoods_tb` (
  `cartid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `goodsid` int(11) DEFAULT NULL,
  `goodsdesc` varchar(255) DEFAULT NULL,
  `goodsicon` varchar(255) DEFAULT NULL,
  `goodsprice` float DEFAULT '0',
  `goodscount` int(11) DEFAULT NULL,
  `goodssku` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cartid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `cartgoods_tb` */

/*Table structure for table `categoryp_tb` */

DROP TABLE IF EXISTS `categoryp_tb`;

CREATE TABLE `categoryp_tb` (
  `categorypid` int(11) NOT NULL AUTO_INCREMENT COMMENT '分类父级id',
  `categorypname` varchar(45) DEFAULT NULL COMMENT '分类父级名',
  `categorypicon` varchar(255) DEFAULT NULL COMMENT '分类父级图片',
  `categorypnote` varchar(255) DEFAULT NULL COMMENT '分类父级备注',
  PRIMARY KEY (`categorypid`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `categoryp_tb` */

insert  into `categoryp_tb`(`categorypid`,`categorypname`,`categorypicon`,`categorypnote`) values (1,'学习资料',NULL,NULL),(2,'电脑办公',NULL,NULL),(3,'手机数码',NULL,NULL),(4,'男装',NULL,NULL),(5,'女装',NULL,NULL),(6,'家用电器',NULL,NULL),(7,'食品生鲜',NULL,NULL),(8,'酒水饮料',NULL,NULL),(9,'玩具乐器',NULL,NULL),(10,'汽车用品',NULL,NULL),(11,'家具家装',NULL,NULL),(12,'礼品鲜花',NULL,NULL),(13,'生活旅行',NULL,NULL),(14,'二手商品',NULL,NULL);

/*Table structure for table `categorys_tb` */

DROP TABLE IF EXISTS `categorys_tb`;

CREATE TABLE `categorys_tb` (
  `categorysid` int(11) NOT NULL AUTO_INCREMENT,
  `categorypid` int(11) DEFAULT NULL,
  `categorysname` varchar(45) DEFAULT NULL,
  `categorysicon` varchar(255) DEFAULT NULL,
  `categorysnote` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`categorysid`),
  KEY `categorypid` (`categorypid`),
  CONSTRAINT `categorys_tb_ibfk_1` FOREIGN KEY (`categorypid`) REFERENCES `categoryp_tb` (`categorypid`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `categorys_tb` */

insert  into `categorys_tb`(`categorysid`,`categorypid`,`categorysname`,`categorysicon`,`categorysnote`) values (1,2,'Apple','https://img13.360buyimg.com/n7/jfs/t2590/338/4222589387/237425/25e40fb/57b12ac6N61374a75.jpg',NULL),(2,2,'ThinkPad','https://img14.360buyimg.com/n7/jfs/t3556/223/2158676156/110226/59267230/584b5678Nbc9f1e70.jpg',NULL),(3,2,'惠普','https://img10.360buyimg.com/n7/jfs/t3157/231/5756125504/98807/97ab361d/588084a1N06efb01d.jpg',NULL),(4,2,'戴尔','https://img14.360buyimg.com/n7/jfs/t5971/255/1793524379/148460/f42e1432/59362fc2Nf55191b9.jpg',NULL),(5,2,'华硕','https://img12.360buyimg.com/n7/jfs/t5878/352/2479795637/201591/d23a1872/5931182fN31cfa389.jpg',NULL),(6,2,'神舟','https://img13.360buyimg.com/n7/jfs/t3052/126/5163722736/217313/f05d9003/5864c7dfNcfbc5e94.jpg',NULL),(7,2,'外星人','https://img11.360buyimg.com/n7/jfs/t4687/130/1245474410/58260/f12a15bd/58db17dbNf5371a02.jpg',NULL),(8,2,'微星','https://img12.360buyimg.com/n7/jfs/t6709/106/1129266372/226149/ab5f4641/594b8094Nb07793ab.jpg',NULL),(9,2,'宏基','https://img11.360buyimg.com/n7/jfs/t5737/312/4822081047/162369/70bbd1b2/5954b785N1787db72.jpg',NULL),(10,2,'雷神','https://img11.360buyimg.com/n7/jfs/t5671/2/2653805329/277901/cf0384f7/5932281fNeb08da02.jpg',NULL),(11,3,'Apple','https://img14.360buyimg.com/n7/jfs/t3268/124/2646283367/114153/f5704b88/57e4a358N9ccc6645.jpg',NULL),(12,3,'华为','https://img10.360buyimg.com/n7/jfs/t5890/341/1320350439/127171/2f9c4ddd/592535e0N2e102c09.jpg',NULL),(13,3,'小米','https://img14.360buyimg.com/n7/jfs/t5215/252/15502760/100416/cb06f1da/58f709adN45511018.jpg',NULL),(14,3,'魅族','https://img10.360buyimg.com/n7/jfs/t4366/71/2045605853/291379/56c87b03/58ca4dc5N1c303706.jpg',NULL),(15,3,'三星','https://img10.360buyimg.com/n7/jfs/t5905/106/1120548052/61075/6eafa3a5/592f8f7bN763e3d30.jpg',NULL),(16,3,'OPPO','https://img10.360buyimg.com/n7/jfs/t5785/24/2243796048/134801/923e11/592ea14fNec6d33c4.jpg',NULL),(17,3,'vivo','https://img11.360buyimg.com/n7/jfs/t5998/69/1052614141/116889/2f5ba58a/592f8ed9N49d8f07b.jpg',NULL),(18,3,'HTC','https://img13.360buyimg.com/n7/jfs/t5659/277/3541677944/291221/28bb44f8/593e10c9Nc3783014.jpg',NULL),(19,3,'摩托罗拉','https://img12.360buyimg.com/n7/jfs/t3109/185/1064081632/117451/2dba5e92/57c558e2N38a9e617.jpg',NULL),(20,3,'索尼','https://img10.360buyimg.com/n7/jfs/t5191/190/2535818793/70090/78c559f5/591ba9f0Nd3a41fcb.jpg',NULL);

/*Table structure for table `goodsinfo_tb` */

DROP TABLE IF EXISTS `goodsinfo_tb`;

CREATE TABLE `goodsinfo_tb` (
  `goodsid` int(11) NOT NULL AUTO_INCREMENT,
  `categorypid` int(11) DEFAULT NULL,
  `categorysid` int(11) DEFAULT NULL,
  `goodsdesc` varchar(255) DEFAULT NULL,
  `goodsdefaulticon` varchar(255) DEFAULT NULL,
  `goodsdefaultprice` float DEFAULT '0',
  `goodsbanner` varchar(2500) DEFAULT NULL,
  `goodsdetailone` varchar(255) DEFAULT NULL,
  `goodsdetailtwo` varchar(255) DEFAULT NULL,
  `goodssalescount` int(11) DEFAULT NULL,
  `goodsstockcount` int(11) DEFAULT NULL,
  `goodscode` varchar(45) DEFAULT NULL,
  `goodsdefaultsku` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`goodsid`),
  KEY `categorypid` (`categorypid`),
  KEY `categorysid` (`categorysid`),
  CONSTRAINT `goodsinfo_tb_ibfk_1` FOREIGN KEY (`categorypid`) REFERENCES `categoryp_tb` (`categorypid`),
  CONSTRAINT `goodsinfo_tb_ibfk_2` FOREIGN KEY (`categorysid`) REFERENCES `categorys_tb` (`categorysid`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `goodsinfo_tb` */

insert  into `goodsinfo_tb`(`goodsid`,`categorypid`,`categorysid`,`goodsdesc`,`goodsdefaulticon`,`goodsdefaultprice`,`goodsbanner`,`goodsdetailone`,`goodsdetailtwo`,`goodssalescount`,`goodsstockcount`,`goodscode`,`goodsdefaultsku`) values (1,2,1,'Apple MacBook Air 13.3英寸笔记本电脑 银色(Core i5 处理器/8GB内存/128GB SSD闪存 MMGF2CH/A)','https://img11.360buyimg.com/n7/jfs/t2968/143/2485546147/238650/70df281e/57b12a31N8f4f75a3.jpg',9989,'https://img11.360buyimg.com/n1/s450x450_jfs/t2968/143/2485546147/238650/70df281e/57b12a31N8f4f75a3.jpg,https://img13.360buyimg.com/n1/s450x450_jfs/t2632/157/4193453761/92922/2adb5ebc/57ad88f0Nb286ec7a.jpg,https://img11.360buyimg.com/n1/s450x450_jfs/t2977/86/2412624329/68019/dbe32c1f/57ad8846N64ac3c79.jpg','https://img20.360buyimg.com/vc/jfs/t3034/151/748569500/226790/d6cd86a2/57b15612N81dc489d.jpg','https://img20.360buyimg.com/vc/jfs/t2683/60/4222930118/169462/233c7678/57b15616N1e285f09.jpg',5000,10000,'10000000001','1.6GHz i5处理器,GB内存/128GB SSD,1件'),(2,2,1,'Apple MacBook Pro 13.3英寸笔记本电脑 银色(Core i5 处理器/8GB内存/128GB SSD闪存/Retina屏 MF839CH/A)','https://img13.360buyimg.com/n7/jfs/t2590/338/4222589387/237425/25e40fb/57b12ac6N61374a75.jpg',12320,'https://img13.360buyimg.com/n1/s450x450_jfs/t2590/338/4222589387/237425/25e40fb/57b12ac6N61374a75.jpg,https://img13.360buyimg.com/n1/s450x450_jfs/t2632/157/4193453761/92922/2adb5ebc/57ad88f0Nb286ec7a.jpg,https://img11.360buyimg.com/n1/s450x450_jfs/t2977/86/2412624329/68019/dbe32c1f/57ad8846N64ac3c79.jpg','https://img20.360buyimg.com/vc/jfs/t2218/160/1600609450/672652/12ef3837/56600724N28581935.jpg','https://img20.360buyimg.com/vc/jfs/t2305/205/1525153851/648458/79706530/56600727N1022ecd8.jpg',13530,800,'10000000002','13.3英寸/双核 i5/8G/128G闪存,1件'),(3,2,1,'Apple MacBook Pro 15.4英寸笔记本电脑 深空灰色（Multi-Touch Bar/Core i7/16GB/256GB MLH32CH/A）','https://img10.360buyimg.com/n7/jfs/t3499/165/739574790/179345/251c51d4/58126465Na27a9bf0.jpg',7889.99,'https://img13.360buyimg.com/n1/s450x450_jfs/t2590/338/4222589387/237425/25e40fb/57b12ac6N61374a75.jpg,https://img13.360buyimg.com/n1/s450x450_jfs/t2632/157/4193453761/92922/2adb5ebc/57ad88f0Nb286ec7a.jpg,https://img11.360buyimg.com/n1/s450x450_jfs/t2977/86/2412624329/68019/dbe32c1f/57ad8846N64ac3c79.jpg','https://img12.360buyimg.com/cms/jfs/t3760/42/740411238/146541/be42da9e/581266b4N7360a7e4.jpg','https://img13.360buyimg.com/cms/jfs/t3367/226/740508746/107595/414c65e6/581266b7Nea97b88f.jpg',1350,8200,'10000000003','银色,Core i5/8G内存/256G闪存,1件'),(4,2,1,'Apple 苹果 MacBook Air 13.3英寸笔记本电脑 MMGF2CH/A银色 Core i5/8G内存/128G闪存','https://img13.360buyimg.com/n1/jfs/t5821/151/4295371754/246251/29179c11/594a3eabNbf7fceec.jpg',7889.99,'https://img13.360buyimg.com/n1/jfs/t5821/151/4295371754/246251/29179c11/594a3eabNbf7fceec.jpg,https://img13.360buyimg.com/n1/jfs/t3157/218/9378001544/103166/c8bb88da/58d0e987Nb3a34bfa.jpg,https://img13.360buyimg.com/n1/jfs/t4639/313/514186457/88273/6d83eae9/58d0e988N0009a10c.jpg','https://img30.360buyimg.com/popWaterMark/jfs/t5746/329/4801800135/218275/4a67f0ef/5954a40fNf471b55d.jpg','https://img30.360buyimg.com/popWareDetail/jfs/t6532/96/2593310/189936/1c5b2d94/5937a66aN594f4851.jpg',2350,3400,'10000000005','MMGF2CH/A银色,Core i5/8G内存/128G闪存,1件'),(5,2,1,'Apple 苹果 MacBook Pro 笔记本电脑 16年新款 15英寸 Multi-Touch Bar 256G 深空灰色','https://img14.360buyimg.com/n5/s450x450_jfs/t3397/55/762020838/184157/7e507d32/58131c17Nb108ca54.jpg',7889.99,'https://img14.360buyimg.com/n5/s450x450_jfs/t3397/55/762020838/184157/7e507d32/58131c17Nb108ca54.jpg,https://img14.360buyimg.com/n5/s450x450_jfs/t3427/1/761535388/238533/b605b9f2/58130206Ncf90e695.jpg,https://img14.360buyimg.com/n5/s450x450_jfs/t3490/164/628752282/118644/88a1c360/58130288Ne2b8683e.jpg,https://img14.360buyimg.com/n5/s450x450_jfs/t3715/86/798415057/312693/b777b279/58131c16Ncba81f8b.jpg','https://img10.360buyimg.com/imgzone/jfs/t3082/24/2402653567/223529/1a6b04b/57e0d2f8N10eb5602.jpg','https://img30.360buyimg.com/popWaterMark/jfs/t6241/302/1026912919/130228/685bcc83/5949c952N88858337.jpg',150,900,'10000000006','13英寸 Core i5 8G内存 256G闪存,深空灰色,1件'),(6,2,1,'Apple MacBook Air 13.3英寸笔记本电脑 银色(Core i5 处理器/8GB内存/128GB SSD闪存 MMGF2CH/A)','https://img11.360buyimg.com/n7/jfs/t2968/143/2485546147/238650/70df281e/57b12a31N8f4f75a3.jpg',7889.99,'https://img11.360buyimg.com/n1/s450x450_jfs/t2968/143/2485546147/238650/70df281e/57b12a31N8f4f75a3.jpg,https://img13.360buyimg.com/n1/s450x450_jfs/t2632/157/4193453761/92922/2adb5ebc/57ad88f0Nb286ec7a.jpg,https://img11.360buyimg.com/n1/s450x450_jfs/t2977/86/2412624329/68019/dbe32c1f/57ad8846N64ac3c79.jpg','https://img20.360buyimg.com/vc/jfs/t3034/151/748569500/226790/d6cd86a2/57b15612N81dc489d.jpg','https://img20.360buyimg.com/vc/jfs/t2683/60/4222930118/169462/233c7678/57b15616N1e285f09.jpg',5000,10000,'10000000001','1.6GHz i5处理器,GB内存/128GB SSD,1件'),(7,2,1,'Apple 苹果 MacBook Air 13.3英寸笔记本电脑 MMGF2CH/A银色 Core i5/8G内存/128G闪存','https://img13.360buyimg.com/n1/jfs/t5821/151/4295371754/246251/29179c11/594a3eabNbf7fceec.jpg',7889.99,'https://img13.360buyimg.com/n1/jfs/t5821/151/4295371754/246251/29179c11/594a3eabNbf7fceec.jpg,https://img13.360buyimg.com/n1/jfs/t3157/218/9378001544/103166/c8bb88da/58d0e987Nb3a34bfa.jpg,https://img13.360buyimg.com/n1/jfs/t4639/313/514186457/88273/6d83eae9/58d0e988N0009a10c.jpg','https://img30.360buyimg.com/popWaterMark/jfs/t5746/329/4801800135/218275/4a67f0ef/5954a40fNf471b55d.jpg','https://img30.360buyimg.com/popWareDetail/jfs/t6532/96/2593310/189936/1c5b2d94/5937a66aN594f4851.jpg',2350,3400,'10000000005','MMGF2CH/A银色,Core i5/8G内存/128G闪存,1件'),(8,2,1,'国行Apple/苹果 MacBook Pro MF839CH/A 13.3英寸 商务笔记本电脑','https://img.alicdn.com/imgextra/i3/1669409267/TB2bMSccXXXXXbVXXXXXXXXXXXX_!!1669409267.jpg_430x430q90.jpg',7889.99,'https://img.alicdn.com/imgextra/i3/1669409267/TB2bMSccXXXXXbVXXXXXXXXXXXX_!!1669409267.jpg_430x430q90.jpg,https://img.alicdn.com/imgextra/i2/1669409267/TB2WUa4qpXXXXaQXpXXXXXXXXXX_!!1669409267.jpg_430x430q90.jpg,https://img.alicdn.com/imgextra/i2/1669409267/TB2ZnUysXXXXXXOXXXXXXXXXXXX_!!1669409267.jpg_430x430q90.jpg','https://gdp.alicdn.com/imgextra/i1/1669409267/TB25Yfnmr_0UKFjy1XaXXbKfXXa_!!1669409267.jpg','https://img.alicdn.com/imgextra/i4/1669409267/TB28SC_vdFopuFjSZFHXXbSlXXa_!!1669409267.jpg',1660,1200,'10000000007','8G 128G,银白色,1件'),(9,3,11,'Apple iPhone 6s Plus (A1699) 32G 金色 移动联通电信4G手机','https://img14.360buyimg.com/n1/s450x450_jfs/t3268/124/2646283367/114153/f5704b88/57e4a358N9ccc6645.jpg',7889.99,'https://img14.360buyimg.com/n1/s450x450_jfs/t3268/124/2646283367/114153/f5704b88/57e4a358N9ccc6645.jpg,https://img14.360buyimg.com/n1/s450x450_jfs/t3055/170/2635484631/101619/8000b30/57e4a359N218a4200.jpg,https://img12.360buyimg.com/n1/s450x450_jfs/t3274/10/2586151054/109903/711d3edd/57e4a35aNc4a0b203.jpg','https://img30.360buyimg.com/jgsq-productsoa/jfs/t6337/310/2148869366/61744/dca36a9c/595dda76N64984138.jpg','https://img30.360buyimg.com/jgsq-productsoa/jfs/t6175/244/140312464/88326/30e3b943/593a4888N3187bea7.jpg',9890,1200,'10000000010','金色,32GB,1件'),(10,3,11,'Apple iPhone 7 Plus (A1661) 32G 亮黑色 移动联通电信4G手机','https://img14.360buyimg.com/n1/s450x450_jfs/t3064/188/1693292264/115570/e891640b/57d11bfaN2e8acade.jpg',7889.99,'https://img14.360buyimg.com/n1/s450x450_jfs/t3064/188/1693292264/115570/e891640b/57d11bfaN2e8acade.jpg,https://img14.360buyimg.com/n1/s450x450_jfs/t3202/139/1655646299/94486/f66e4dae/57d11bfbN147f8c9a.jpg,https://img14.360buyimg.com/n1/s450x450_jfs/t2998/150/2060445093/29614/e9c3eab5/57d11bfbN5a03e02d.jpg','https://img30.360buyimg.com/jgsq-productsoa/jfs/t6337/310/2148869366/61744/dca36a9c/595dda76N64984138.jpg','https://img30.360buyimg.com/jgsq-productsoa/jfs/t6175/244/140312464/88326/30e3b943/593a4888N3187bea7.jpg',12313,12566,'10000000011','亮黑色,32GB,1件'),(11,3,11,'苹果 Apple iPhone 6 4G手机 灰色 公开全网通(32G)标配','https://img14.360buyimg.com/n1/s450x450_jfs/t5581/37/6255093126/256134/d8ae5c1d/59688753N177cfc26.jpg',7889.99,'https://img14.360buyimg.com/n1/s450x450_jfs/t5581/37/6255093126/256134/d8ae5c1d/59688753N177cfc26.jpg,https://img14.360buyimg.com/n1/s450x450_jfs/t5593/357/6209896656/70558/1cc69840/59688755Nd4a0c527.jpg,https://img14.360buyimg.com/n1/s450x450_jfs/t5848/309/6166315010/59102/2a85c081/59688756Ndce52d99.jpg','https://img30.360buyimg.com/popWaterMark/jfs/t3016/136/650115357/171206/c66b2965/57ad8acaN57ed9319.jpg','https://img30.360buyimg.com/popWaterMark/jfs/t2935/12/2469495182/65696/a31dc72e/57ad8acaNef46eb26.jpg',56667,8434,'10000000012','灰色,32GB,1件'),(12,2,2,'联想（ThinkPad）E460（20ETA063CD）14英寸笔记本电脑（i7-6498DU 8G 1T 2G独显 Win10）','https://img14.360buyimg.com/n1/s450x450_jfs/t5446/184/2581563799/286954/9ebfad09/591bddbcNc724d048.jpg',7889.99,'https://img14.360buyimg.com/n1/s450x450_jfs/t5446/184/2581563799/286954/9ebfad09/591bddbcNc724d048.jpg,https://img14.360buyimg.com/n1/s450x450_jfs/t5209/149/1168851360/329572/9bdcbaa5/590c421eN49bc2d11.jpg,https://img14.360buyimg.com/n1/s450x450_jfs/t5437/240/2545062154/189407/7ab57b0b/591bddc2N6c52f1ad.jpg,https://img14.360buyimg.com/n1/s450x450_jfs/t5326/216/1147917773/304909/e711dfc6/590c421fNc5def6a7.jpg','https://img20.360buyimg.com/vc/jfs/t5563/279/850602969/1094377/272f0258/5907fc23N3a312831.jpg','https://img20.360buyimg.com/vc/jfs/t5563/279/850602969/1094377/272f0258/5907fc23N3a312831.jpg',56667,8434,'10000000015','【i7豪华版】8G 1T,1件'),(13,2,2,'ThinkPad New S2（20GU0000CD）13.3英寸轻薄笔记本电脑（i5-6200U 4G 240GB SSD FHD IPS Win10 银色）','https://img12.360buyimg.com/n1/s450x450_jfs/t3439/192/665209614/82997/ce6c3ad8/58107973Na856a8e1.jpg',7889.99,'https://img12.360buyimg.com/n1/s450x450_jfs/t3439/192/665209614/82997/ce6c3ad8/58107973Na856a8e1.jpg,https://img12.360buyimg.com/n1/s450x450_jfs/t3313/27/610873927/76897/44bc7560/58107978N6e64b6ce.jpg,https://img12.360buyimg.com/n1/s450x450_jfs/t3766/313/640498039/58537/b7e06633/5810797dN0ec052bd.jpg,https://img12.360buyimg.com/n1/s450x450_jfs/t3379/29/613387717/62645/cad23f55/58107982Neca08199.jpg','https://img20.360buyimg.com/vc/jfs/t3172/316/316003976/446142/2e681194/57b168fcNfc72b6c2.jpg','https://img20.360buyimg.com/vc/jfs/t3172/316/316003976/446142/2e681194/57b168fcNfc72b6c2.jpg',53453,5623,'10000000016','【轻薄特价】180打开i5标配,1件'),(14,2,2,'联想（ThinkPad）黑侠E570 GTX（1NCD）游戏笔记本（i5-7200U 4G 500G+128G SSD GTX950M 2G独显 FHD Win10）','https://img13.360buyimg.com/n1/s450x450_jfs/t3589/5/1216566713/222593/43da0a93/5822ed83N8f0984b9.jpg',7889.99,'https://img13.360buyimg.com/n1/s450x450_jfs/t3589/5/1216566713/222593/43da0a93/5822ed83N8f0984b9.jpg,https://img13.360buyimg.com/n1/s450x450_jfs/t3514/49/1286403745/215402/2c20d256/5822ed87N71a050ee.jpg,https://img13.360buyimg.com/n1/s450x450_jfs/t3406/2/1342234371/410922/dbedf7f8/5822ed8bN792d72cd.jpg,https://img13.360buyimg.com/n1/s450x450_jfs/t3496/362/1334197333/221885/678bc709/5822ed93Nd409d7f0.jpg','https://img20.360buyimg.com/vc/jfs/t3850/230/1078650780/1998827/c8083d77/5822d122N3d828e6d.jpg','https://img20.360buyimg.com/vc/jfs/t3850/230/1078650780/1998827/c8083d77/5822d122N3d828e6d.jpg',32423,7345,'10000000017','【黑侠游戏本特价款】GTX950,1件'),(15,2,2,'ThinkPad X1 Carbon 2017（20HRA007CD）14英寸轻薄笔记本电脑（i5-7200U 8G 256GSSD FHD Win10）','https://img11.360buyimg.com/n1/s450x450_jfs/t4804/97/1759098535/205293/61ec47d0/58f428f6N5b35ea21.jpg',7889.99,'https://img11.360buyimg.com/n1/s450x450_jfs/t4804/97/1759098535/205293/61ec47d0/58f428f6N5b35ea21.jpg,https://img11.360buyimg.com/n1/s450x450_jfs/t4753/151/1078896686/306158/d1133be7/58ec5f8aN9074a72b.jpg,https://img11.360buyimg.com/n1/s450x450_jfs/t5065/111/1077695223/143927/6b0de1f/58ec5f90N0954eca1.jpg,https://img11.360buyimg.com/n1/s450x450_jfs/t4618/299/2175767160/96803/f14f7185/58ec5f94Nc2fbb336.jpg','https://img20.360buyimg.com/vc/jfs/t3850/230/1078650780/1998827/c8083d77/5822d122N3d828e6d.jpg','https://img20.360buyimg.com/vc/jfs/t3850/230/1078650780/1998827/c8083d77/5822d122N3d828e6d.jpg',9894,10000,'10000000018','2017新X1 8G 256G,1件');

/*Table structure for table `goodssku_tb` */

DROP TABLE IF EXISTS `goodssku_tb`;

CREATE TABLE `goodssku_tb` (
  `goodsskuid` int(11) NOT NULL AUTO_INCREMENT,
  `goodsid` int(11) DEFAULT NULL,
  `goodsskutitle` varchar(45) DEFAULT NULL,
  `goodsskucontent` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`goodsskuid`),
  KEY `goodsid` (`goodsid`),
  CONSTRAINT `goodssku_tb_ibfk_1` FOREIGN KEY (`goodsid`) REFERENCES `goodsinfo_tb` (`goodsid`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

/*Data for the table `goodssku_tb` */

insert  into `goodssku_tb`(`goodsskuid`,`goodsid`,`goodsskutitle`,`goodsskucontent`) values (1,1,'版本','1.6GHz i5处理器,2017年i5处理器升级版,i7处理器 定制版'),(2,1,'配置','8GB内存/128GB SSD,8GB内存/256GB SSD'),(3,2,'配置','13.3英寸/双核 i5/8G/128G闪存,15.4英寸/四核 i7/16G/256G闪存,15.4英寸/四核 i7/16G/512G闪存'),(4,3,'颜色','银色,深空灰色'),(5,3,'配置','Core i5/8G内存/256G闪存,256G闪存/Multi-Touch Bar,512G闪存/Multi-Touch Bar'),(6,4,'颜色','MMGF2CH/A银色,2017款 MQD32CH/A,MMGG2CH/A银色,2017款 MQD42CH/A'),(7,4,'版本','Core i5/8G内存/128G闪存,Core i5/8G内存/256G闪存'),(8,5,'颜色','13英寸 Core i5 8G内存 256G闪存,MMGG2CH/A银色,13英寸Multi-Touch Bar 256G,15英寸 Multi-Touch Bar 512G'),(9,5,'版本','银色,深空灰色'),(10,6,'版本','1.6GHz i5处理器,2017年i5处理器升级版,i7处理器 定制版'),(11,6,'配置','8GB内存/128GB SSD,8GB内存/256GB SSD'),(12,7,'颜色','MMGF2CH/A银色,2017款 MQD32CH/A,MMGG2CH/A银色,2017款 MQD42CH/A'),(13,7,'版本','Core i5/8G内存/128G闪存,Core i5/8G内存/256G闪存'),(14,8,'颜色','银白色'),(15,8,'版本','8G 128G,16GB 256G'),(16,9,'颜色','金色,银色,深空灰,玫瑰金'),(17,9,'版本','32GB,128GB'),(18,10,'颜色','亮黑色,金色,银色,深空灰,玫瑰金'),(19,10,'版本','32GB,128GB,256GB'),(20,11,'颜色','灰色,金色'),(21,12,'颜色','【i7豪华版】8G 1T,【i7基础版】4G 500G,【i7顶配版】8G 256GSSD,【爆款】180开合i5 4G 500G,【高配款】180开合i5 8G 500G'),(22,13,'颜色','【轻薄特价】180打开i5标配,【180打开 触控】i5 8G 180G,【180打开背光键盘】i5 8G 256G,【碳纤维360度窄边框】180G,【黑色180开合】i7极速'),(23,14,'颜色','【黑侠游戏本特价款】GTX950,【黑侠游戏本高配款】GTX950,【黑侠游戏本顶配款】GTX950,【黑侠游戏i7殿堂款】GTX950'),(24,15,'颜色','2017新X1 8G 256G,2017新X1 i7 8G 256G,2017新X1 i7 8G 512G,经典款 8G 180G');

/*Table structure for table `message_tb` */

DROP TABLE IF EXISTS `message_tb`;

CREATE TABLE `message_tb` (
  `msgid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `msgtype` int(11) DEFAULT NULL,
  `msgtitle` varchar(200) DEFAULT NULL,
  `msgcon` varchar(500) DEFAULT NULL,
  `msgimg` varchar(500) DEFAULT 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524660914659&di=f0d055d97b9d931cf0778d2427a69adb&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01460b57e4a6fa0000012e7ed75e83.png%401280w_1l_2o_100sh.png',
  `msgtime` datetime DEFAULT NULL,
  `msgread` int(11) DEFAULT '0',
  PRIMARY KEY (`msgid`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8;

/*Data for the table `message_tb` */

insert  into `message_tb`(`msgid`,`userid`,`msgtype`,`msgtitle`,`msgcon`,`msgimg`,`msgtime`,`msgread`) values (42,1,1,'订单待支付','订单编号为81已经成功下单，等待你的支付','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524634520520&di=d2f91c9eb61eed84c962f78a9caf85d0&imgtype=0&src=http%3A%2F%2Fwww.qqzhi.com%2Fuploadpic%2F2015-01-27%2F121838355.jpg','2018-04-29 12:41:52',0),(43,1,0,'用户登录成功','我的天空a你已经成功登录','http://p6yij445k.bkt.clouddn.com/icon_20180428223813','2018-04-29 14:21:51',0),(44,1,0,'用户登录成功','我的天空a你已经成功登录','http://p6yij445k.bkt.clouddn.com/icon_20180428223813','2018-04-30 11:22:55',0),(45,1,0,'用户登录成功','我的天空a你已经成功登录','http://p6yij445k.bkt.clouddn.com/icon_20180428223813','2018-04-30 11:24:35',0),(46,1,0,'用户登录成功','我的天空a你已经成功登录','http://p6yij445k.bkt.clouddn.com/icon_20180428223813','2018-04-30 11:34:01',0),(47,1,0,'用户登录成功','我的天空a你已经成功登录','http://p6yij445k.bkt.clouddn.com/icon_20180428223813','2018-04-30 11:58:54',0),(48,1,0,'用户登录成功','我的天空a你已经成功登录','http://p6yij445k.bkt.clouddn.com/icon_20180428223813','2018-04-30 14:25:17',0),(49,1,0,'用户登录成功','我的天空a你已经成功登录','http://p6yij445k.bkt.clouddn.com/icon_20180428223813','2018-04-30 14:25:50',0),(50,1,0,'用户登录成功','我的天空a你已经成功登录','http://p6yij445k.bkt.clouddn.com/icon_20180428223813','2018-04-30 14:27:20',1),(51,1,1,'订单待支付','订单编号为83已经成功下单，等待你的支付','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524634520520&di=d2f91c9eb61eed84c962f78a9caf85d0&imgtype=0&src=http%3A%2F%2Fwww.qqzhi.com%2Fuploadpic%2F2015-01-27%2F121838355.jpg','2018-04-30 14:29:02',0),(52,1,2,'订单购买成功','订单编号为83订单已经付款。请你等待收货','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524634520520&di=d2f91c9eb61eed84c962f78a9caf85d0&imgtype=0&src=http%3A%2F%2Fwww.qqzhi.com%2Fuploadpic%2F2015-01-27%2F121838355.jpg','2018-04-30 14:32:53',0),(53,1,0,'用户登录成功','我的天空a你已经成功登录','http://p6yij445k.bkt.clouddn.com/icon_20180428223813','2018-04-30 14:35:21',0),(54,1,4,'订单取消成功','订单编号为82订单已经成功取消','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524634520520&di=d2f91c9eb61eed84c962f78a9caf85d0&imgtype=0&src=http%3A%2F%2Fwww.qqzhi.com%2Fuploadpic%2F2015-01-27%2F121838355.jpg','2018-04-30 14:36:31',0),(55,1,3,'订单收货成功','订单编号为83订单已经成功收货。感谢你的购买','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524634520520&di=d2f91c9eb61eed84c962f78a9caf85d0&imgtype=0&src=http%3A%2F%2Fwww.qqzhi.com%2Fuploadpic%2F2015-01-27%2F121838355.jpg','2018-04-30 14:36:42',0),(56,1,0,'用户登录成功','我的天空a你已经成功登录','http://p6yij445k.bkt.clouddn.com/icon_20180428223813','2018-04-30 14:38:42',0),(57,1,0,'用户登录成功','我的天空a你已经成功登录','http://p6yij445k.bkt.clouddn.com/icon_20180428223813','2018-04-30 14:41:24',0),(58,1,0,'用户登录成功','我的天空a你已经成功登录','http://p6yij445k.bkt.clouddn.com/icon_20180428223813','2018-04-30 14:46:25',0),(59,1,1,'订单待支付','订单编号为84已经成功下单，等待你的支付','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524634520520&di=d2f91c9eb61eed84c962f78a9caf85d0&imgtype=0&src=http%3A%2F%2Fwww.qqzhi.com%2Fuploadpic%2F2015-01-27%2F121838355.jpg','2018-04-30 14:47:36',0),(60,1,1,'订单待支付','订单编号为85已经成功下单，等待你的支付','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524634520520&di=d2f91c9eb61eed84c962f78a9caf85d0&imgtype=0&src=http%3A%2F%2Fwww.qqzhi.com%2Fuploadpic%2F2015-01-27%2F121838355.jpg','2018-04-30 14:51:33',0),(61,1,1,'订单待支付','订单编号为86已经成功下单，等待你的支付','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524634520520&di=d2f91c9eb61eed84c962f78a9caf85d0&imgtype=0&src=http%3A%2F%2Fwww.qqzhi.com%2Fuploadpic%2F2015-01-27%2F121838355.jpg','2018-04-30 14:58:11',0),(62,1,0,'用户登录成功','我的天空a你已经成功登录','http://p6yij445k.bkt.clouddn.com/icon_20180428223813','2018-04-30 15:02:12',0),(63,1,1,'订单待支付','订单编号为88已经成功下单，等待你的支付','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524634520520&di=d2f91c9eb61eed84c962f78a9caf85d0&imgtype=0&src=http%3A%2F%2Fwww.qqzhi.com%2Fuploadpic%2F2015-01-27%2F121838355.jpg','2018-04-30 15:02:49',0),(64,1,1,'订单待支付','订单编号为89已经成功下单，等待你的支付','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524634520520&di=d2f91c9eb61eed84c962f78a9caf85d0&imgtype=0&src=http%3A%2F%2Fwww.qqzhi.com%2Fuploadpic%2F2015-01-27%2F121838355.jpg','2018-04-30 15:04:03',0),(65,1,2,'订单购买成功','订单编号为89订单已经付款。请你等待收货','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524634520520&di=d2f91c9eb61eed84c962f78a9caf85d0&imgtype=0&src=http%3A%2F%2Fwww.qqzhi.com%2Fuploadpic%2F2015-01-27%2F121838355.jpg','2018-04-30 15:04:38',0),(66,1,1,'订单待支付','订单编号为90已经成功下单，等待你的支付','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524634520520&di=d2f91c9eb61eed84c962f78a9caf85d0&imgtype=0&src=http%3A%2F%2Fwww.qqzhi.com%2Fuploadpic%2F2015-01-27%2F121838355.jpg','2018-05-01 11:27:15',0),(67,1,2,'订单购买成功','订单编号为90订单已经付款。请你等待收货','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524634520520&di=d2f91c9eb61eed84c962f78a9caf85d0&imgtype=0&src=http%3A%2F%2Fwww.qqzhi.com%2Fuploadpic%2F2015-01-27%2F121838355.jpg','2018-05-01 11:30:51',0);

/*Table structure for table `ordergoods_tb` */

DROP TABLE IF EXISTS `ordergoods_tb`;

CREATE TABLE `ordergoods_tb` (
  `ordergoodsid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `goodsid` int(11) DEFAULT NULL,
  `orderinfoid` int(11) DEFAULT NULL,
  `goodsdesc` varchar(255) DEFAULT NULL,
  `goodsicon` varchar(255) DEFAULT NULL,
  `goodsprice` float DEFAULT '0',
  `goodscount` int(11) DEFAULT NULL,
  `goodssku` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ordergoodsid`)
) ENGINE=InnoDB AUTO_INCREMENT=134 DEFAULT CHARSET=utf8;

/*Data for the table `ordergoods_tb` */

insert  into `ordergoods_tb`(`ordergoodsid`,`userid`,`goodsid`,`orderinfoid`,`goodsdesc`,`goodsicon`,`goodsprice`,`goodscount`,`goodssku`) values (123,1,9,81,'Apple iPhone 6s Plus (A1699) 32G 金色 移动联通电信4G手机','https://img14.360buyimg.com/n1/s450x450_jfs/t3268/124/2646283367/114153/f5704b88/57e4a358N9ccc6645.jpg',7889.99,2,'金色,128GB'),(124,1,9,82,'Apple iPhone 6s Plus (A1699) 32G 金色 移动联通电信4G手机','https://img14.360buyimg.com/n1/s450x450_jfs/t3268/124/2646283367/114153/f5704b88/57e4a358N9ccc6645.jpg',7889.99,1,'金色,32GB'),(125,1,9,82,'Apple iPhone 6s Plus (A1699) 32G 金色 移动联通电信4G手机','https://img14.360buyimg.com/n1/s450x450_jfs/t3268/124/2646283367/114153/f5704b88/57e4a358N9ccc6645.jpg',7889.99,1,'金色,32GB'),(126,1,1,83,'Apple MacBook Air 13.3英寸笔记本电脑 银色(Core i5 处理器/8GB内存/128GB SSD闪存 MMGF2CH/A)','https://img11.360buyimg.com/n7/jfs/t2968/143/2485546147/238650/70df281e/57b12a31N8f4f75a3.jpg',9989,1,'1.6GHz i5处理器,8GB内存/128GB SSD'),(127,1,9,84,'Apple iPhone 6s Plus (A1699) 32G 金色 移动联通电信4G手机','https://img14.360buyimg.com/n1/s450x450_jfs/t3268/124/2646283367/114153/f5704b88/57e4a358N9ccc6645.jpg',7889.99,1,'金色,32GB'),(128,1,9,85,'Apple iPhone 6s Plus (A1699) 32G 金色 移动联通电信4G手机','https://img14.360buyimg.com/n1/s450x450_jfs/t3268/124/2646283367/114153/f5704b88/57e4a358N9ccc6645.jpg',7889.99,1,'金色,32GB'),(129,1,9,86,'Apple iPhone 6s Plus (A1699) 32G 金色 移动联通电信4G手机','https://img14.360buyimg.com/n1/s450x450_jfs/t3268/124/2646283367/114153/f5704b88/57e4a358N9ccc6645.jpg',7889.99,1,'金色,32GB'),(130,1,11,87,'苹果 Apple iPhone 6 4G手机 灰色 公开全网通(32G)标配','https://img14.360buyimg.com/n1/s450x450_jfs/t5581/37/6255093126/256134/d8ae5c1d/59688753N177cfc26.jpg',7889.99,1,'金色'),(131,1,11,88,'苹果 Apple iPhone 6 4G手机 灰色 公开全网通(32G)标配','https://img14.360buyimg.com/n1/s450x450_jfs/t5581/37/6255093126/256134/d8ae5c1d/59688753N177cfc26.jpg',7889.99,1,'金色'),(132,1,9,89,'Apple iPhone 6s Plus (A1699) 32G 金色 移动联通电信4G手机','https://img14.360buyimg.com/n1/s450x450_jfs/t3268/124/2646283367/114153/f5704b88/57e4a358N9ccc6645.jpg',7889.99,1,'金色,32GB'),(133,1,1,90,'Apple MacBook Air 13.3英寸笔记本电脑 银色(Core i5 处理器/8GB内存/128GB SSD闪存 MMGF2CH/A)','https://img11.360buyimg.com/n7/jfs/t2968/143/2485546147/238650/70df281e/57b12a31N8f4f75a3.jpg',9989,2,'1.6GHz i5处理器,8GB内存/256GB SSD');

/*Table structure for table `orderinfo_tb` */

DROP TABLE IF EXISTS `orderinfo_tb`;

CREATE TABLE `orderinfo_tb` (
  `orderinfoid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `shipid` int(11) DEFAULT NULL,
  `paytype` int(11) DEFAULT NULL,
  `totalprice` float DEFAULT '0',
  `orderstatus` int(11) DEFAULT NULL,
  PRIMARY KEY (`orderinfoid`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8;

/*Data for the table `orderinfo_tb` */

insert  into `orderinfo_tb`(`orderinfoid`,`userid`,`shipid`,`paytype`,`totalprice`,`orderstatus`) values (81,1,16,0,15780,1),(82,1,16,0,15780,4),(83,1,16,0,9989,3),(84,1,16,0,7889.99,1),(85,1,16,0,7889.99,1),(86,1,16,0,7889.99,1),(87,1,16,0,7889.99,1),(88,1,16,0,7889.99,1),(89,1,16,0,7889.99,2),(90,1,17,0,19978,2);

/*Table structure for table `shipaddress_tb` */

DROP TABLE IF EXISTS `shipaddress_tb`;

CREATE TABLE `shipaddress_tb` (
  `shipid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `shipusername` varchar(45) DEFAULT NULL,
  `shipusermobile` varchar(45) DEFAULT NULL,
  `shipaddress` varchar(255) DEFAULT NULL,
  `shipisdefault` int(11) DEFAULT NULL,
  PRIMARY KEY (`shipid`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

/*Data for the table `shipaddress_tb` */

insert  into `shipaddress_tb`(`shipid`,`userid`,`shipusername`,`shipusermobile`,`shipaddress`,`shipisdefault`) values (16,1,'ceshi','123456799','hdhdbd',0),(17,1,'admin','123456789123','广东省深圳市',1);

/*Table structure for table `user_tb` */

DROP TABLE IF EXISTS `user_tb`;

CREATE TABLE `user_tb` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT '123',
  `password` varchar(50) DEFAULT NULL,
  `pushid` varchar(500) DEFAULT NULL,
  `userimg` varchar(150) DEFAULT '123',
  `age` int(11) DEFAULT '18',
  `sex` int(11) DEFAULT '0',
  `phone` varchar(50) DEFAULT '123123',
  `email` varchar(50) DEFAULT '123@123.com',
  `sign` varchar(225) DEFAULT 'none',
  `note` varchar(225) DEFAULT 'none',
  `admin` int(11) DEFAULT '0',
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `user_tb` */

insert  into `user_tb`(`userid`,`username`,`password`,`pushid`,`userimg`,`age`,`sex`,`phone`,`email`,`sign`,`note`,`admin`) values (1,'我的天空a','123','1a0018970a8b42fe125','http://p6yij445k.bkt.clouddn.com/icon_20180428223813',18,0,'123456','123@123.com','我的天空飞吧','none',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

```
 
