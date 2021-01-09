package hongyan.backend.pojo;


import java.util.Date;

/**
 * 时间：2021/01/07
 * 作者：Walker
 * 简介：
 *              自行车实例的构造器，考虑到自行车的参数较多，使用原生构造器会造成代码冗长难以阅读
 *              故采用构造器模式构造实例。
 *
 * todo: 尝试对为初始化过的变量做出标记。
 *
 *
 */
public class BicycleBuilder {

    private String bicycleName;
    private String id;
    private String sellerName;
    private int price;
    //private ArrayList<Byte> image;
    private String brand;
    private String type;
    private int manufactureTime;
    Bicycle.Status status = Bicycle.Status.none;
    boolean isAvailable = true;
    Date createTime;
    Date updateTime;


    public BicycleBuilder() {
    }


    /**
     * setter用于构造Bicycle
     */
    public BicycleBuilder setBicycleName(String bicycleName) {
        this.bicycleName = bicycleName;
        return this;
    }

    public BicycleBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public BicycleBuilder setSellerName(String sellerName) {
        this.sellerName = sellerName; return this;
    }

    public BicycleBuilder setPrice(int price) {
        this.price = price; return this;
    }

    public BicycleBuilder setBrand(String brand) {
        this.brand = brand; return this;
    }

    public BicycleBuilder setType(String type) {
        this.type = type; return this;
    }

    public BicycleBuilder setManufactureTime(int manufactureTime) {
        this.manufactureTime = manufactureTime; return this;
    }

    public BicycleBuilder setStatus(Bicycle.Status status) {
        this.status = status; return this;
    }

    public BicycleBuilder setAvailable(boolean available) {
        isAvailable = available; return this;
    }

    public BicycleBuilder setCreateTime(Date createTime) {
        this.createTime = createTime; return this;
    }

    public BicycleBuilder setUpdateTime(Date updateTime) {
        this.updateTime = updateTime; return this;
    }



    /**
     * 构造器最终构造出自行车实例的返回函数。
     * 使用方法
     * new BicycleBuilder().setValue().....build();
     * @return
     */
    public Bicycle build() {
        return new Bicycle(
                bicycleName,
                id,
                sellerName,
                price,
                brand,
                type,
                manufactureTime,
                status,
                isAvailable,
                createTime,
                updateTime);
    }
}
