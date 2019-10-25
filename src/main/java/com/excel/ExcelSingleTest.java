package com.excel;

import com.excel.domain.Student;
import com.excel.domain.User;
import com.excel.util.ExcelDataFormatter;
import com.excel.util.ExcelParseUtilSingleton;
import com.google.gson.GsonBuilder;
import org.junit.Test;

import java.io.File;
import java.math.BigDecimal;
import java.util.*;

public class ExcelSingleTest {

    /**
     * 工具类使用单例模式
     */
    @Test
    public void write() throws Exception {
        System.out.println("======写Excel Start======");

        List<User> list = new ArrayList<User>();
        User u = new User();
        u.setAge("23");
        u.setName("aaa");
        u.setXx(0.23111D);
        u.setYy(new Date(2019 - 02 - 11));
        u.setLocked(false);
        u.setDb(new BigDecimal(123));
        u.setAddress("上海");
        list.add(u);

        u = new User();
        u.setAge("21");
        u.setName("bbb");
        u.setXx(13.2220D);
        u.setYy(new Date());
        u.setLocked(true);
        u.setDb(new BigDecimal(234));
        u.setAddress("上海");
        list.add(u);

        u = new User();
        u.setAge("13");
        u.setName("ccc");
        u.setXx(123.23D);
        u.setYy(new Date());
        u.setLocked(false);
        u.setDb(new BigDecimal(2344));
        u.setAddress("上海");
        list.add(u);

        u = new User();
        u.setAge("22");
        u.setName("ddd");
        u.setXx(123.0D);
        u.setYy(new Date());
        u.setLocked(true);
        u.setDb(new BigDecimal(908));
        u.setAddress("上海");
        list.add(u);

        ExcelDataFormatter edf = new ExcelDataFormatter();
        Map<String, String> map = new HashMap<String, String>();
        map.put("true", "是");
        map.put("false", "否");
        edf.set("locked", map);

        ExcelParseUtilSingleton excelParseUtil= ExcelParseUtilSingleton.getInstance();
        /*ExcelParseUtilSingleton excelParseUtil1=ExcelParseUtilSingleton.getInstance();
        System.out.println(excelParseUtil);
        System.out.println(excelParseUtil1);*/


        List<Student> students = new ArrayList<Student>();
        Student student = new Student();
        student.setAge("23");
        student.setName("aaa");
        student.setXx(0.23111D);
        student.setYy(new Date(2019 - 02 - 11));
        student.setLocked(false);
        //student.setDb(new BigDecimal(123));
        student.setAddress("上海");
        students.add(student);


        excelParseUtil.writeToFile(students, edf, "D:\\s.xlsx");

        System.out.println("======End======");
    }

    @Test
    public void read() throws Exception {
        System.out.println("读Excel");
        ExcelDataFormatter edf = new ExcelDataFormatter();
        Map<String, String> map = new HashMap<String, String>();
        map.put("是", "true");
        map.put("否", "false");
        edf.set("locked", map);

        ExcelParseUtilSingleton excelParseUtil= ExcelParseUtilSingleton.getInstance();

        List<Student> students=excelParseUtil.getExcelParseUtil(new Student()).readFromFile(edf,new File("D:\\s.xlsx"));

        for (Student student : students) {
            System.out.println(new GsonBuilder().create().toJson(student));
        }

        ExcelParseUtilSingleton excelParseUtil1= ExcelParseUtilSingleton.getInstance();
        ExcelParseUtilSingleton excelParseUtil2= ExcelParseUtilSingleton.getInstance();
        System.out.println(excelParseUtil1);
        System.out.println(excelParseUtil2);
    }


}
