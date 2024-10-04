package com.pawan.dreambuy.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Package {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
   private int pkid;
    private String pkg_src;
    private String pkg_destination;
    private String pkg_itenary;
    private String pkg_days;
    private String pkg_price;
    private String pkg_detailed;
    private String pkg_isaval;
    private String pkg_from_date;
    private String pkg_to_date;
    private String pkg_description;
    private int pkg_total_trips;
    private int pkg_user_purchased_so_far;
    private int pkg_purchased_so_far;

    public Package(int pkid, int pkg_purchased_so_far, int pkg_user_purchased_so_far, int pkg_total_trips, String pkg_description, String pkg_to_date, String pkg_from_date, String pkg_isaval, String pkg_detailed, String pkg_price, String pkg_days, String pkg_itenary, String pkg_destination, String pkg_src) {
        this.pkid = pkid;
        this.pkg_purchased_so_far = pkg_purchased_so_far;
        this.pkg_user_purchased_so_far = pkg_user_purchased_so_far;
        this.pkg_total_trips = pkg_total_trips;
        this.pkg_description = pkg_description;
        this.pkg_to_date = pkg_to_date;
        this.pkg_from_date = pkg_from_date;
        this.pkg_isaval = pkg_isaval;
        this.pkg_detailed = pkg_detailed;
        this.pkg_price = pkg_price;
        this.pkg_days = pkg_days;
        this.pkg_itenary = pkg_itenary;
        this.pkg_destination = pkg_destination;
        this.pkg_src = pkg_src;
    }

    public Package() {

    }

    public int getPkid() {
        return pkid;
    }

    public void setPkid(int pkid) {
        this.pkid = pkid;
    }

    public String getPkg_src() {
        return pkg_src;
    }

    public void setPkg_src(String pkg_src) {
        this.pkg_src = pkg_src;
    }

    public String getPkg_destination() {
        return pkg_destination;
    }

    public void setPkg_destination(String pkg_destination) {
        this.pkg_destination = pkg_destination;
    }

    public String getPkg_itenary() {
        return pkg_itenary;
    }

    public void setPkg_itenary(String pkg_itenary) {
        this.pkg_itenary = pkg_itenary;
    }

    public String getPkg_days() {
        return pkg_days;
    }

    public void setPkg_days(String pkg_days) {
        this.pkg_days = pkg_days;
    }

    public String getPkg_price() {
        return pkg_price;
    }

    public void setPkg_price(String pkg_price) {
        this.pkg_price = pkg_price;
    }

    public String getPkg_detailed() {
        return pkg_detailed;
    }

    public void setPkg_detailed(String pkg_detailed) {
        this.pkg_detailed = pkg_detailed;
    }

    public String getPkg_isaval() {
        return pkg_isaval;
    }

    public void setPkg_isaval(String pkg_isaval) {
        this.pkg_isaval = pkg_isaval;
    }

    public String getPkg_to_date() {
        return pkg_to_date;
    }

    public void setPkg_to_date(String pkg_to_date) {
        this.pkg_to_date = pkg_to_date;
    }

    public String getPkg_description() {
        return pkg_description;
    }

    public void setPkg_description(String pkg_description) {
        this.pkg_description = pkg_description;
    }

    public String getPkg_from_date() {
        return pkg_from_date;
    }

    public void setPkg_from_date(String pkg_from_date) {
        this.pkg_from_date = pkg_from_date;
    }

    public int getPkg_total_trips() {
        return pkg_total_trips;
    }

    public void setPkg_total_trips(int pkg_total_trips) {
        this.pkg_total_trips = pkg_total_trips;
    }

    public int getPkg_user_purchased_so_far() {
        return pkg_user_purchased_so_far;
    }

    public void setPkg_user_purchased_so_far(int pkg_user_purchased_so_far) {
        this.pkg_user_purchased_so_far = pkg_user_purchased_so_far;
    }

    public int getPkg_purchased_so_far() {
        return pkg_purchased_so_far;
    }

    public void setPkg_purchased_so_far(int pkg_purchased_so_far) {
        this.pkg_purchased_so_far = pkg_purchased_so_far;
    }
}
