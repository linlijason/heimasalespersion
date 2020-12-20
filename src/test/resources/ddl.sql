
CREATE TABLE IF NOT EXISTS  `take_money` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) unsigned NOT NULL,
  `money` decimal(18,3) NOT NULL,
  `create_at` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


CREATE TABLE IF NOT EXISTS  `take_money_payment` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `take_money_id` int(11) NOT NULL,
  `pay_type` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `account` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `pay_seq_no` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `status` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `create_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


insert take_money(user_id,money,create_at) values(2,100.11,'2020-12-12 19:02:01')