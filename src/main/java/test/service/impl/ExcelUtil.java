package test.service.impl;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Excel文件操作工具类，包括读、写、合并等功能
 *

 */
public class ExcelUtil {
    private POIFSFileSystem fs;
    private HSSFWorkbook wb;
    private HSSFSheet sheet;
    private HSSFRow row;
//    public static void writeXlsx(String fileName,Map<Integer,List<String[]>> map) {
//        try {
//            XSSFWorkbook wb = new XSSFWorkbook();
//            for(int sheetnum=0;sheetnum<map.size();sheetnum++){
//                XSSFSheet sheet = wb.createSheet(""+sheetnum);
//                List<String[]> list = map.get(sheetnum);
//                for(int i=0;i<list.size();i++){
//                    XSSFRow row = sheet.createRow(i);
//                    String[] str = list.get(i);
//                    for(int j=0;j<str.length;j++){
//                        XSSFCell cell = row.createCell(j);
//                        cell.setCellValue(str[j]);
//                    }
//                }
//            }
//            FileOutputStream outputStream = new FileOutputStream(fileName);
//            wb.write(outputStream);
//            outputStream.close();
//        } catch (FileNotFoundException e) {
//            // TODO 自动生成的 catch 块
//            e.printStackTrace();
//        } catch (IOException e) {
//            // TODO 自动生成的 catch 块
//            e.printStackTrace();
//        }
//    }
public static void writeXlsx(String fileName,List<String> titles) {
    try {
        XSSFWorkbook wb = new XSSFWorkbook();

            XSSFSheet sheet = wb.createSheet(0+"");


                XSSFRow row = sheet.createRow(0);

                for(int j=0;j<titles.size();j++){
                    XSSFCell cell = row.createCell(j);
                    cell.setCellValue(titles.get(j));
                }


        FileOutputStream outputStream = new FileOutputStream(fileName);
        wb.write(outputStream);
        outputStream.close();
    } catch (FileNotFoundException e) {
        // TODO 自动生成的 catch 块
        e.printStackTrace();
    } catch (IOException e) {
        // TODO 自动生成的 catch 块
        e.printStackTrace();
    }
}
    //读取xlsx
    public static List<List<Object>> read2007Excel(File file)
            throws IOException {
        List<List<Object>> list = new LinkedList<List<Object>>();
        // 构造 XSSFWorkbook 对象，strPath 传入文件路径
        XSSFWorkbook xwb = new XSSFWorkbook(new FileInputStream(file));
        // 读取第一章表格内容
        XSSFSheet sheet = xwb.getSheetAt(0);
        Object value = null;
        XSSFRow row = null;
        XSSFCell cell = null;
        int counter = 0;
        int LastCellNum=0;
        for (int i = sheet.getFirstRowNum(); counter < sheet
                .getPhysicalNumberOfRows(); i++) {
            if(i==0){
                //跳过第一行
                row = sheet.getRow(i);
              LastCellNum= row.getLastCellNum();
                continue;
            }
            row = sheet.getRow(i);
            if (row == null) {
                break;
            }
            List<Object> linked = new LinkedList<Object>();
            for (int j = row.getFirstCellNum(); j <LastCellNum; j++) {
                cell = row.getCell(j);
                if (cell == null) {
                    value=null;//导入不能为空
                    linked.add(value);
                    //System.out.println(value);
                    continue;
                }
                //System.out.println(value);
                DecimalFormat df = new DecimalFormat("0");// 格式化 number String
                // 字符
                SimpleDateFormat sdf = new SimpleDateFormat(
                        "yyyy-MM-dd");// 格式化日期字符串
                DecimalFormat nf = new DecimalFormat("0");// 格式化数字
                switch (cell.getCellType()) {
                    case XSSFCell.CELL_TYPE_STRING:
                        //System.out.println(i + "行" + j + " 列 is String type");
                        value = cell.getStringCellValue();
                        break;
                    case XSSFCell.CELL_TYPE_NUMERIC:
                        //  System.out.println(i + "行" + j
                        //  + " 列 is Number type ; DateFormt:"
                        //  + cell.getCellStyle().getDataFormatString());
                        if ("@".equals(cell.getCellStyle().getDataFormatString())) {
                            value = df.format(cell.getNumericCellValue());
                        } else if ("General".equals(cell.getCellStyle()
                                .getDataFormatString())) {
                            value = nf.format(cell.getNumericCellValue());
                        } else {
                            value = sdf.format(HSSFDateUtil.getJavaDate(cell
                                    .getNumericCellValue()));
                        }
                        break;
                    case XSSFCell.CELL_TYPE_BOOLEAN:
                        value = cell.getBooleanCellValue();
                        break;
                    case XSSFCell.CELL_TYPE_BLANK://空格，空白
                        value = "";
                        break;
                    default:
                        value = cell.toString();
                }
                if (value == null || "".equals(value)) {
                    value=null;//导入不能为空
                }
                //System.out.println(value);
                linked.add(value);
            }
            list.add(linked);
        }
        return list;
    }


      //读取xls
    public Map<Integer, ArrayList<String>> readExcelContent(InputStream is) {
        Map<Integer, ArrayList<String>> content = new HashMap<Integer, ArrayList<String>>();
        String str = "";
        try {
            fs = new POIFSFileSystem(is);
            wb = new HSSFWorkbook(fs);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sheet = wb.getSheetAt(0);
        // 得到总行数
        int rowNum = sheet.getLastRowNum();
        row = sheet.getRow(0);
        int colNum = row.getPhysicalNumberOfCells();
        // 正文内容应该从第二行开始,第一行为表头的标题
        for (int i = 1; i <= rowNum; i++) {
            row = sheet.getRow(i);
            int j = 0;
            ArrayList<String> onerow=new ArrayList<String>();
            while (j < colNum) {
                // 每个单元格的数据内容用"-"分割开，以后需要时用String类的replace()方法还原数据
                // 也可以将每个单元格的数据设置到一个javabean的属性中，此时需要新建一个javabean
                // str += getStringCellValue(row.getCell((short) j)).trim() +
                // "-";
              //  str += getCellFormatValue(row.getCell((short) j)).trim() + "-";
   onerow.add(getCellFormatValue(row.getCell((short) j)).trim());
                j++;
            }
            content.put(i, onerow);
        }
        return content;
    }
    private String getCellFormatValue(HSSFCell cell) {
        String cellvalue = "";
        if (cell != null) {
            // 判断当前Cell的Type
            switch (cell.getCellType()) {
                // 如果当前Cell的Type为NUMERIC
                case HSSFCell.CELL_TYPE_NUMERIC:
                case HSSFCell.CELL_TYPE_FORMULA: {
                    // 判断当前的cell是否为Date
                    if (HSSFDateUtil.isCellDateFormatted(cell)) {
                        // 如果是Date类型则，转化为Data格式

                        //方法1：这样子的data格式是带时分秒的：2011-10-12 0:00:00
                        //cellvalue = cell.getDateCellValue().toLocaleString();

                        //方法2：这样子的data格式是不带带时分秒的：2011-10-12
                        Date date = cell.getDateCellValue();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        cellvalue = sdf.format(date);

                    }
                    // 如果是纯数字
                    else {
                        // 取得当前Cell的数值
                        cellvalue = String.valueOf(cell.getNumericCellValue());
                    }
                    break;
                }
                // 如果当前Cell的Type为STRIN
                case HSSFCell.CELL_TYPE_STRING:
                    // 取得当前的Cell字符串
                    cellvalue = cell.getRichStringCellValue().getString();
                    break;
                // 默认的Cell值
                default:
                    cellvalue = " ";
            }
        } else {
            cellvalue = "";
        }
        return cellvalue;

    }

    //测试
    public static void main(String[] args) {
        try {
            // 对读取Excel表格标题测试
            InputStream is = new FileInputStream("d:\\test.xls");
             ExcelUtil excelReader=new ExcelUtil();
            File f=new File("d:\\information_basic.xlsx");
            try {
                List<List<Object>>m=read2007Excel(f);
                for(List<Object> a:m){
                    for(Object v :a){
                        System.out.println((String)v);
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }

            // 对读取Excel表格内容测试
            Map<Integer, ArrayList<String>> map = excelReader.readExcelContent(is);
            System.out.println("获得Excel表格的内容:");
            for (int i = 1; i <= map.size(); i++) {
               for(String e:map.get(i)){
                   System.out.print(e);
               }
                System.out.println();
            }

        } catch (FileNotFoundException e) {
            System.out.println("未找到指定路径的文件!");
            e.printStackTrace();
        }
    }
}