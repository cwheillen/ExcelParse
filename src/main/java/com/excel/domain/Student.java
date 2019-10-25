package com.excel.domain;

import com.excel.annotation.Excel;

import java.math.BigDecimal;
import java.util.Date;

@Excel(dateFormat = "yyyy-dd-mm")
public class Student {

        @Excel(name = "姓名", width = 30,validate = true)
        private String name;

        @Excel(name = "年龄", width = 60)
        private String age;

        @Excel(skip = true)
        private String password;

        @Excel(name = "xx",round = true,precision = 2)
        private Double xx;

        @Excel(name = "日期")
        private Date yy;

        @Excel(name = "锁定")
        private Boolean locked;

       /* @Excel(name = "金额")
        private BigDecimal db;*/

        @Excel(name = "地址")
        private String address;

        public String getAddress() {
                return address;
        }

        public void setAddress(String address) {
                this.address = address;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getAge() {
                return age;
        }

        public void setAge(String age) {
                this.age = age;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public Double getXx() {
                return xx;
        }

        public void setXx(Double xx) {
                this.xx = xx;
        }

        public Date getYy() {
                return yy;
        }

        public void setYy(Date yy) {
                this.yy = yy;
        }

        public Boolean getLocked() {
                return locked;
        }

        public void setLocked(Boolean locked) {
                this.locked = locked;
        }

}
