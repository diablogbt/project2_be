package app.bootproj.pojo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * Product
 */
@Entity
@Table(name="fanlist")
public class FanList implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    Integer productid;
    String productname;
    Integer airflow;
    Integer soundmaxspeed;
    Integer fansweepdiameter;
    Integer height;
    Integer modelyear;
    String accessories;
    String mountinglocation;
    String application;
    String usetype;
    String manufacturer;
    String series;
    String model;
    Double powermax;
    Double powermin;
    Integer operatingvoltagemax;
    Integer operatingvoltagemin;
    Integer fanspeedmax;
    Integer fanspeedmin;
    Integer firm;
    Integer global;

    String imagelocation;

    @Override
    public String toString() {
        return "FanList [accessories=" + accessories + ", airflow=" + airflow + ", application=" + application
                + ", fanspeedmax=" + fanspeedmax + ", fanspeedmin=" + fanspeedmin + ", fansweepdiameter="
                + fansweepdiameter + ", firm=" + firm + ", global=" + global + ", height=" + height + ", imagelocation="
                + imagelocation + ", manufacturer=" + manufacturer + ", model=" + model + ", modelyear=" + modelyear
                + ", mountinglocation=" + mountinglocation + ", operatingvoltagemax=" + operatingvoltagemax
                + ", operatingvoltagemin=" + operatingvoltagemin + ", powermax=" + powermax + ", powermin=" + powermin
                + ", productid=" + productid + ", productname=" + productname + ", series=" + series
                + ", soundmaxspeed=" + soundmaxspeed + ", usetype=" + usetype + "]";
    }

    public FanList(String productname) {
        this.productname = productname;
    }

    public FanList() {
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public Integer getAirflow() {
        return airflow;
    }

    public void setAirflow(Integer airflow) {
        this.airflow = airflow;
    }

    public Integer getSoundmaxspeed() {
        return soundmaxspeed;
    }

    public void setSoundmaxspeed(Integer soundmaxspeed) {
        this.soundmaxspeed = soundmaxspeed;
    }

    public Integer getFansweepdiameter() {
        return fansweepdiameter;
    }

    public void setFansweepdiameter(Integer fansweepdiameter) {
        this.fansweepdiameter = fansweepdiameter;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getModelyear() {
        return modelyear;
    }

    public void setModelyear(Integer modelyear) {
        this.modelyear = modelyear;
    }

    public String getAccessories() {
        return accessories;
    }

    public void setAccessories(String accessories) {
        this.accessories = accessories;
    }

    public String getMountinglocation() {
        return mountinglocation;
    }

    public void setMountinglocation(String mountinglocation) {
        this.mountinglocation = mountinglocation;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getUsetype() {
        return usetype;
    }

    public void setUsetype(String usetype) {
        this.usetype = usetype;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getPowermax() {
        return powermax;
    }

    public void setPowermax(Double powermax) {
        this.powermax = powermax;
    }

    public Double getPowermin() {
        return powermin;
    }

    public void setPowermin(Double powermin) {
        this.powermin = powermin;
    }

    public Integer getOperatingvoltagemax() {
        return operatingvoltagemax;
    }

    public void setOperatingvoltagemax(Integer operatingvoltagemax) {
        this.operatingvoltagemax = operatingvoltagemax;
    }

    public Integer getOperatingvoltagemin() {
        return operatingvoltagemin;
    }

    public void setOperatingvoltagemin(Integer operatingvoltagemin) {
        this.operatingvoltagemin = operatingvoltagemin;
    }

    public Integer getFanspeedmax() {
        return fanspeedmax;
    }

    public void setFanspeedmax(Integer fanspeedmax) {
        this.fanspeedmax = fanspeedmax;
    }

    public Integer getFanspeedmin() {
        return fanspeedmin;
    }

    public void setFanspeedmin(Integer fanspeedmin) {
        this.fanspeedmin = fanspeedmin;
    }

    public Integer getFirm() {
        return firm;
    }

    public void setFirm(Integer firm) {
        this.firm = firm;
    }

    public Integer getGlobal() {
        return global;
    }

    public void setGlobal(Integer global) {
        this.global = global;
    }

    public String getImagelocation() {
        return imagelocation;
    }

    public void setImagelocation(String imagelocation) {
        this.imagelocation = imagelocation;
    }

    
}