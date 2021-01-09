package hongyan.backend.pojo;


import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 时间：2021/01/08
 * 作者：Walker
 * 简介：
 *          创建自行车实例用于数据记录，以便于在后台对数据进行更加灵活的操作。
 *          变量名和表列（字段）严格对应。
 *          完整的字段请参看数据库表Bicycle的数据。
 *          图片显示暂时关闭。
 *
 *          08新增自行车toString方法。
 *
 * todo: 需要完整的自行车实例字段。
 */
public class Bicycle {


    private String bicycleName;
    private String id;
    private String sellerName;
    private int price;
    private String brand;
    private String type;
    private int manufacture_time;
    Status status = Status.none;
    boolean isAvailable = true;
    Date createTime;
    Date updateTime;




    /**
     * status枚举字段记录自行车的状态
     */
    public enum Status {
        none,
        forSale,
        forRent,
        alreadySold,
        unexpiredRented,
        expiredRented;

        /**
         * convert函数提供字符串和Status之间的可靠转换。
         * 我们在每次和数据库交互的时候都需要使用这对重载函数进行类型适配。
         */
        public static Status convert(String str) {
            switch (str.indexOf(0)) {
                case 's':
                    return forSale;
                case 'r':
                    return forRent;
                case 'a':
                    return alreadySold;
                case 'u':
                    return unexpiredRented;
                case 'e':
                    return expiredRented;
                default:
                    return none;
            }
        }
        public static String convert(Status status) {
            switch (status) {
                case forSale:
                    return "s";
                case forRent:
                    return "r";
                case alreadySold:
                    return "a";
                case unexpiredRented:
                    return "u";
                case expiredRented:
                    return "e";
                default:
                    return "n";
            }
        }
    }



    /**
     * constructor.
     *  只为builder提供构造接口。
     *  禁止除Builder以外的其他成员调用该构造函数
    */
    protected Bicycle(String bicycleName,
                   String id,
                   String sellerName,
                   int price,
                   String brand,
                   String type,
                   int manufacture_time,
                   Status status,
                   boolean isAvailable,
                   Date createTime,
                   Date updateTime) {
        this.bicycleName = bicycleName;
        this.id = id;
        this.sellerName = sellerName;
        this.price = price;
        this.brand = brand;
        this.type = type;
        this.manufacture_time = manufacture_time;
        this.status = status;
        this.isAvailable = isAvailable;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }



    /**
     * Getter
     *
     */
    public String getBicycleName() {
        return bicycleName;
    }

    public String getId() {
        return id;
    }

    public String getSellerName() {
        return sellerName;
    }

    public int getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    public int getManufacture_time() {
        return manufacture_time;
    }

    public Status getStatus() {
        return status;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    @Override
    public String toString() {
        return  "("+
                bicycleName + ","+
                id  +","+
                sellerName  +","+
                price +","+
                brand +","+
                type +","+
                manufacture_time +","+
                status +","+
                isAvailable +","+
                createTime +","+
                updateTime +
                ')';
    }

    public static void main(String[] args) {
        Bicycle bicycle = new BicycleBuilder().build();
        System.out.println(bicycle);
    }
}

