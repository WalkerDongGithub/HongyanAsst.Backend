drop table if exists bicycle;
create table bicycle(

    # 基本信息
    bicycle_name varchar(30) not null,
    id varchar(20) primary key,         # 为每一个自行车分配一个id

    # 展示给买家的数据
    seller_name varchar(30) not null,   # 卖家信息
    price int(11),                      # 价格，按整数表示，单位为分
    image mediumblob,                   # 为用户展示的图片，最大16M
    brand varchar(30),                  # 产品品牌
    type varchar(30),                   # 产品类型
    manufacture_time year,              # 出厂年份

    # 系统信息
    status varchar(1) not null,         # 自行车的出售/出租状态
    is_available int(1) default 1,      # 产品是否审核通过
    create_time datetime
        default current_timestamp,      # 发布时间
    update_time datetime
        default current_timestamp on update
            current_timestamp           # 最近更新时间
    # lease_date datetime,                # 租赁时间
    # dead_line datetime                  # 到期时间
);
describe bicycle;
# status状态 's'在售 'l'在租未到期 'd'在租到期
