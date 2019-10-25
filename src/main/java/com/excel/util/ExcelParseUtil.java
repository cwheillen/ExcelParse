/*
package com.excel.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.excel.annotation.Excel;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
*/


/**
 * Excel导入导出工具类
 */
//public class ExcelParseUtil<E> {



    /*private E e;
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private int etimes = 0;

    public ExcelParseUtil(E e) {
        this.e = e;
    }

    @SuppressWarnings("unchecked")
    public E get() throws InstantiationException, IllegalAccessException {
        return (E) e.getClass().newInstance();
    }*/

    /**
     * 将数据写入到EXCEL文档
     *
     * @param list     数据集合
     * @param edf      数据格式化，比如有些数字代表的状态，像是0:女，1：男，或者0：正常，1：锁定，变成可读的文字
     *                 该字段仅仅针对Boolean,Integer两种类型作处理
     * @param filePath 文件路径
     * @throws Exception
     */
   /* public static <T> void writeToFile(List<T> list, ExcelDataFormatter edf, String filePath) throws Exception {
        // 创建并获取工作簿对象
        Workbook wb = getWorkBook(list, edf);
        // 写入到文件
        FileOutputStream out = new FileOutputStream(filePath);
        wb.write(out);
        out.close();
    }*/

    /**
     * 获得Workbook对象
     *
     * @param list 数据集合
     * @return Workbook
     * @throws Exception
     */
    /*public static <T> Workbook getWorkBook(List<T> list, ExcelDataFormatter edf) throws Exception {
        // 创建工作簿
        Workbook wb = new SXSSFWorkbook();

        if (list == null || list.size() == 0)
            return wb;

        // 创建一个工作表sheet
        Sheet sheet = wb.createSheet();
        // 声明行
        Row row = sheet.createRow(0);
        // 声明单元格
        Cell cell = null;

        CreationHelper createHelper = wb.getCreationHelper();

        Field[] fields = ReflectUtils.getClassFieldsAndSuperClassFields(list.get(0).getClass());

        XSSFCellStyle titleStyle = (XSSFCellStyle) wb.createCellStyle();
        titleStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        // 设置前景色
        titleStyle.setFillForegroundColor(new XSSFColor(new java.awt.Color(159, 213, 183)));
        titleStyle.setAlignment(HorizontalAlignment.CENTER);

        Font font = wb.createFont();
        font.setColor(HSSFColor.BLACK.index);
        font.setBold(true);
        // 设置字体
        titleStyle.setFont(font);

        int columnIndex = 0;
        Excel excel = null;
        for (Field field : fields) {
            field.setAccessible(true);
            excel = field.getAnnotation(Excel.class);
            if (excel == null || excel.skip() == true) {
                continue;
            }
            // 列宽注意乘256
            sheet.setColumnWidth(columnIndex, excel.width() * 256);
            // 写入标题
            cell = row.createCell(columnIndex);
            cell.setCellStyle(titleStyle);
            cell.setCellValue(excel.name());

            columnIndex++;
        }

        int rowIndex = 1;

        CellStyle cs = wb.createCellStyle();

        for (T t : list) {
            row = sheet.createRow(rowIndex);
            columnIndex = 0;
            Object object = null;
            for (Field field : fields) {

                field.setAccessible(true);

                excel = field.getAnnotation(Excel.class);

                // 忽略标记skip的字段
                if (excel == null || excel.skip() == true) {
                    continue;
                }

                // 数据
                cell = row.createCell(columnIndex);

                object = field.get(t);
                // 如果数据为空，跳过
                if (object == null)
                    continue;

                // 处理日期类型
                *//*if (object instanceof Date) {
                    cs.setDataFormat(createHelper.createDataFormat().getFormat("yyyy-MM-dd HH:mm:ss"));
                    cell.setCellStyle(cs);
                    cell.setCellValue((Date) field.get(t));
                } *//*

                //属性是日期时的处理方式
                if(object instanceof Date){
                    cs.setDataFormat(createHelper.createDataFormat().getFormat(excel.dateFormat()));
                    cell.setCellStyle(cs);
                    cell.setCellValue((Date) field.get(t));
                }
                else if (object instanceof Double || object instanceof Float) {
                    //cell.setCellValue((Double) field.get(t));
                    cell.setCellValue(field.get(t).toString());
                    if (excel.precision() != -1) {
                        cell.setCellValue(new BigDecimal(field.get(t).toString()).setScale(excel.precision(), excel.round() == true ? BigDecimal.ROUND_HALF_UP : BigDecimal.ROUND_FLOOR).toString());
                    }
                } else if (object instanceof Boolean) {
                    Boolean bool = (Boolean) field.get(t);
                    if (edf == null) {
                        cell.setCellValue(bool);
                    } else {
                        Map<String, String> map = edf.get(field.getName());
                        if (map == null) {
                            cell.setCellValue(bool);
                        } else {
                            cell.setCellValue(map.get(bool.toString().toLowerCase()));
                        }
                    }

                } else if (object instanceof Integer) {

                    Integer intValue = (Integer) field.get(t);

                    if (edf == null) {
                        cell.setCellValue(intValue);
                    } else {
                        Map<String, String> map = edf.get(field.getName());
                        if (map == null) {
                            cell.setCellValue(intValue);
                        } else {
                            cell.setCellValue(map.get(intValue.toString()));
                        }
                    }
                } else {
                    cell.setCellValue(field.get(t).toString());
                }

                columnIndex++;
            }

            rowIndex++;
        }

        return wb;
    }*/


    /**
     * 从文件读取数据，最好是所有的单元格都是文本格式，日期格式要求yyyy-MM-dd HH:mm:ss,布尔类型0：是，1：否
     *
     * @param edf  数据格式化
     * @param file Excel文件，支持xlsx后缀，xls的没写，基本一样
     * @return
     * @throws Exception
     */
    /*public List<E> readFromFile(ExcelDataFormatter edf, File file) throws Exception {
        Field[] fields = ReflectUtils.getClassFieldsAndSuperClassFields(e.getClass());

        Map<String, String> textToKey = new HashMap<String, String>();

        Excel excel = null;
        for (Field field : fields) {
            excel = field.getAnnotation(Excel.class);
            if (excel == null || excel.skip() == true) {
                continue;
            }
            textToKey.put(excel.name(), field.getName());
        }

        InputStream is = new FileInputStream(file);

        Workbook wb = new XSSFWorkbook(is);

        Sheet sheet = wb.getSheetAt(0);
        Row title = sheet.getRow(0);
        // 标题数组，后面用到，根据索引去标题名称，通过标题名称去字段名称用到 textToKey
        String[] titles = new String[title.getPhysicalNumberOfCells()];
        for (int i = 0; i < title.getPhysicalNumberOfCells(); i++) {
            titles[i] = title.getCell(i).getStringCellValue();
        }

        List<E> list = new ArrayList<E>();

        E e = null;

        int rowIndex = 0;
        int columnCount = titles.length;
        Cell cell = null;
        Row row = null;

        for (Iterator<Row> it = sheet.rowIterator(); it.hasNext(); ) {
            row = it.next();
            if (rowIndex++ == 0) {
                continue;
            }

            if (row == null) {
                break;
            }

            e = get();

            for (int i = 0; i < columnCount; i++) {
                cell = row.getCell(i);
                etimes = 0;
                readCellContent(textToKey.get(titles[i]), fields, cell, e, edf);
            }
            list.add(e);
        }
        return list;
    }*/

    /**
     * 从单元格读取数据，根据不同的数据类型，使用不同的方式读取
     * 有时候POI自作聪明，经常和我们期待的数据格式不一样，会报异常，
     * 我们这里采取强硬的方式
     * 使用各种方法，直到尝试到读到数据为止，然后根据Bean的数据类型，进行相应的转换
     * 如果尝试完了（总共7次），还是不能得到数据，那么抛个异常出来
     *
     * @param key    当前单元格对应的Bean字段
     * @param fields Bean所有的字段数组
     * @param cell   单元格对象
     * @param e
     * @throws Exception
     */
    /*public void readCellContent(String key, Field[] fields, Cell cell, E e, ExcelDataFormatter edf) throws Exception {

        Object object = null;
        try {
            switch (cell.getCellType()) {
                case XSSFCell.CELL_TYPE_BOOLEAN:
                    object = cell.getBooleanCellValue();
                    break;
                case XSSFCell.CELL_TYPE_NUMERIC:
                    object = cell.getNumericCellValue();
                    if (HSSFDateUtil.isCellDateFormatted(cell)) {
                        object = DateUtil.getJavaDate(cell.getNumericCellValue());
                    }
                    break;
                case XSSFCell.CELL_TYPE_STRING:
                    object = cell.getStringCellValue();
                    break;
                case XSSFCell.CELL_TYPE_ERROR:
                    object = cell.getErrorCellValue();
                    break;
                case XSSFCell.CELL_TYPE_BLANK:
                    object = null;
                    break;
                case XSSFCell.CELL_TYPE_FORMULA:
                    object = cell.getCellFormula();
                    break;
                default:
                    object = null;
                    break;
            }

            if (object == null)
                return;

            for (Field field : fields) {
                field.setAccessible(true);
                if (field.getName().equals(key)) {
                    Boolean bool = true;
                    Map<String, String> map = null;
                    if (edf == null) {
                        bool = false;
                    } else {
                        map = edf.get(field.getName());
                        if (map == null) {
                            bool = false;
                        }
                    }

                    if (field.getType().equals(Date.class)) {
                        if (object.getClass().equals(Date.class)) {
                            field.set(e, object);
                        } else {
                            field.set(e, sdf.parse(object.toString()));
                        }
                    } else if (field.getType().equals(String.class)) {
                        if (object.getClass().equals(String.class)) {
                            field.set(e, object);
                        } else {
                            field.set(e, object.toString());
                        }
                    } else if (field.getType().equals(Long.class)) {
                        if (object.getClass().equals(Long.class)) {
                            field.set(e, object);
                        } else {
                            field.set(e, Long.parseLong(object.toString()));
                        }
                    } else if (field.getType().equals(Integer.class)) {
                        if (object.getClass().equals(Integer.class)) {
                            field.set(e, object);
                        } else {
                            // 检查是否需要转换
                            if (bool) {
                                field.set(e, map.get(object.toString()) != null ? Integer.parseInt(map.get(object.toString())) : Integer.parseInt(object.toString()));
                            } else {
                                field.set(e, Integer.parseInt(object.toString()));
                            }

                        }
                    } else if (field.getType().equals(BigDecimal.class)) {
                        if (object.getClass().equals(BigDecimal.class)) {
                            field.set(e, object);
                        } else {
                            field.set(e, BigDecimal.valueOf(Double.parseDouble(object.toString())));
                        }
                    } else if (field.getType().equals(Boolean.class)) {
                        if (object.getClass().equals(Boolean.class)) {
                            field.set(e, object);
                        } else {
                            // 检查是否需要转换
                            if (bool) {
                                field.set(e, map.get(object.toString()) != null ? Boolean.parseBoolean(map.get(object.toString())) : Boolean.parseBoolean(object.toString()));
                            } else {
                                field.set(e, Boolean.parseBoolean(object.toString()));
                            }
                        }
                    } else if (field.getType().equals(Float.class)) {
                        if (object.getClass().equals(Float.class)) {
                            field.set(e, object);
                        } else {
                            field.set(e, Float.parseFloat(object.toString()));
                        }
                    } else if (field.getType().equals(Double.class)) {
                        if (object.getClass().equals(Double.class)) {
                            field.set(e, object);
                        } else {
                            field.set(e, Double.parseDouble(object.toString()));
                        }

                    }

                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            // 如果还是读到的数据格式还是不对，只能放弃了
            if (etimes > 7) {
                throw ex;
            }
            etimes++;
            if (object == null) {
                readCellContent(key, fields, cell, e, edf);
            }
        }
    }*/

    /**
     * 将EXCEL中A,B,C,D,E列映射成0,1,2,3
     * @param column
     */
    /*public static int getExcelColumn(String column) {

        column = column.toUpperCase();

        // 从-1开始计算,字母从1开始运算。这种总数下来算数正好相同。
        int count = -1;

        char[] cs = column.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            count += (cs[i] - 64) * Math.pow(26, cs.length - 1 - i);
        }
        return count;
    }
*/
//}
