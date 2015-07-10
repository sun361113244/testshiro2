package poitest;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.Region;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.util.CellRangeAddress;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Csun on 2015-07-08.
 */
public class poitest
{
    public void test1()
    {
        HSSFWorkbook wb = new HSSFWorkbook();  //--->创建了一个excel文件
        HSSFSheet sheet = wb.createSheet("停车卸货场车辆管理月度汇总表");   //--->创建了一个工作簿

        sheet.setDefaultColumnWidth(15);

        //标题样式
        HSSFCellStyle captionStyle = wb.createCellStyle(); // 样式对象
        captionStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直
        captionStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平
        //设置标题字体格式
        Font captionFont = wb.createFont();
        // 四个参数分别是：起始行，起始列，结束行，结束列
        sheet.addMergedRegion(new CellRangeAddress(0 , 0 , 0 , 7));
        //设置字体样式
        captionFont.setFontHeightInPoints((short)20);   //--->设置字体大小
        captionFont.setFontName("宋体");   //---》设置字体，是什么类型例如：宋体
        captionFont.setBold(true);//--->设置是否是加粗
        captionStyle.setFont(captionFont);

        //备注样式
        HSSFCellStyle commentsStyle = wb.createCellStyle(); // 样式对象
        commentsStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直
        commentsStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
        //设置标题字体格式
        Font commentsFont = wb.createFont();
        // 四个参数分别是：起始行，起始列，结束行，结束列
        sheet.addMergedRegion(new CellRangeAddress(0 , 0 , 0 , 7));
        //设置字体样式
        commentsFont.setFontHeightInPoints((short)12);   //--->设置字体大小
        commentsFont.setFontName("宋体");   //---》设置字体，是什么类型例如：宋体
        commentsFont.setBold(false);//--->设置是否是加粗
        commentsStyle.setFont(commentsFont);

        //表格标题样式
        HSSFCellStyle tableTitleStyle = wb.createCellStyle(); // 样式对象
        tableTitleStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直
        tableTitleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        tableTitleStyle.setBorderBottom((short)1);
        tableTitleStyle.setBorderLeft((short)1);
        tableTitleStyle.setBorderRight((short)1);
        tableTitleStyle.setBorderTop((short)1);
        //设置标题字体格式
        Font tableTitleFont = wb.createFont();
        //设置字体样式
        tableTitleFont.setFontHeightInPoints((short)12);   //--->设置字体大小
        tableTitleFont.setFontName("宋体");   //---》设置字体，是什么类型例如：宋体
        tableTitleFont.setBold(true);//--->设置是否是加粗
        tableTitleStyle.setFont(tableTitleFont);

        //表格内容样式
        HSSFCellStyle tableContentStyle = wb.createCellStyle(); // 样式对象
        tableContentStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直
        tableContentStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        tableContentStyle.setBorderBottom((short)1);
        tableContentStyle.setBorderLeft((short)1);
        tableContentStyle.setBorderRight((short)1);
        tableContentStyle.setBorderTop((short)1);
        //设置标题字体格式
        Font tableContentFont = wb.createFont();
        //设置字体样式
        tableContentFont.setFontHeightInPoints((short)12);   //--->设置字体大小
        tableContentFont.setFontName("宋体");   //---》设置字体，是什么类型例如：宋体
        tableContentFont.setBold(false);//--->设置是否是加粗
        tableContentStyle.setFont(tableContentFont);

        //表格第一行
        HSSFRow row1 = sheet.createRow(0);   //--->创建一行
        row1.setHeightInPoints(30);
        HSSFCell cell1 = row1.createCell(0);   //--->创建一个单元格
        cell1.setCellStyle(captionStyle);
        cell1.setCellValue("停车卸货场车辆管理月度汇总表");

        //表格第二行
        HSSFRow row2 = sheet.createRow(1);   //--->创建一行

        //表格第三行
        HSSFRow row3 = sheet.createRow(2);   //--->创建一行
        HSSFCell cell3_1 = row3.createCell(0);   //--->创建一个单元格
        cell3_1.setCellStyle(commentsStyle);
        cell3_1.setCellValue("使用单位:__________ 车辆查扣单位_____________ 时间:_____年___月份");

        //表格第四行
        HSSFRow row4 = sheet.createRow(3);   //--->创建一行

        //表格第五行
        HSSFRow row5 = sheet.createRow(4);   //--->创建一行
        HSSFCell cell5_1 = row5.createCell(0);   //--->创建一个单元格
        cell5_1.setCellStyle(tableTitleStyle);
        cell5_1.setCellValue("日期");
        HSSFCell cell5_2 = row5.createCell(1);   //--->创建一个单元格
        cell5_2.setCellStyle(tableTitleStyle);
        cell5_2.setCellValue("初检(吨)");
        HSSFCell cell5_3 = row5.createCell(2);   //--->创建一个单元格
        cell5_3.setCellStyle(tableTitleStyle);
        cell5_3.setCellValue("复检(吨)");
        HSSFCell cell5_4 = row5.createCell(3);   //--->创建一个单元格
        cell5_4.setCellStyle(tableTitleStyle);
        cell5_4.setCellValue("总计(吨)");
        HSSFCell cell5_5 = row5.createCell(4);   //--->创建一个单元格
        cell5_5.setCellStyle(tableTitleStyle);
        cell5_5.setCellValue("扣车(台)");
        HSSFCell cell5_6 = row5.createCell(5);   //--->创建一个单元格
        cell5_6.setCellStyle(tableTitleStyle);
        cell5_6.setCellValue("天数(天)");
        HSSFCell cell5_7 = row5.createCell(6);   //--->创建一个单元格
        cell5_7.setCellStyle(tableTitleStyle);
        cell5_7.setCellValue("备注");

        FileOutputStream fileOut = null;
        try{
            fileOut = new FileOutputStream("d:\\workbook.xls");
            wb.write(fileOut);
            //fileOut.close();
            System.out.print("OK");
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            if(fileOut != null){
                try {
                    fileOut.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test2()
    {
        HSSFWorkbook wb = new HSSFWorkbook();  //--->创建了一个excel文件
        HSSFSheet sheet = wb.createSheet("停车卸货场车辆管理台账");   //--->创建了一个工作簿

        sheet.setDefaultColumnWidth(15);

        //标题样式
        HSSFCellStyle captionStyle = wb.createCellStyle(); // 样式对象
        captionStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直
        captionStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平
        //设置标题字体格式
        Font captionFont = wb.createFont();
        // 四个参数分别是：起始行，起始列，结束行，结束列
        sheet.addMergedRegion(new CellRangeAddress(0 , 0 , 0 , 7));
        //设置字体样式
        captionFont.setFontHeightInPoints((short)20);   //--->设置字体大小
        captionFont.setFontName("宋体");   //---》设置字体，是什么类型例如：宋体
        captionFont.setBold(true);//--->设置是否是加粗
        captionStyle.setFont(captionFont);

        //备注样式
        HSSFCellStyle commentsStyle = wb.createCellStyle(); // 样式对象
        commentsStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直
        commentsStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
        //设置标题字体格式
        Font commentsFont = wb.createFont();
        // 四个参数分别是：起始行，起始列，结束行，结束列
        sheet.addMergedRegion(new CellRangeAddress(0 , 0 , 0 , 7));
        //设置字体样式
        commentsFont.setFontHeightInPoints((short)12);   //--->设置字体大小
        commentsFont.setFontName("宋体");   //---》设置字体，是什么类型例如：宋体
        commentsFont.setBold(false);//--->设置是否是加粗
        commentsStyle.setFont(commentsFont);

        //表格标题样式
        HSSFCellStyle tableTitleStyle = wb.createCellStyle(); // 样式对象
        tableTitleStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直
        tableTitleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        tableTitleStyle.setBorderBottom((short)1);
        tableTitleStyle.setBorderLeft((short)1);
        tableTitleStyle.setBorderRight((short)1);
        tableTitleStyle.setBorderTop((short)1);
        //设置标题字体格式
        Font tableTitleFont = wb.createFont();
        //设置字体样式
        tableTitleFont.setFontHeightInPoints((short)12);   //--->设置字体大小
        tableTitleFont.setFontName("宋体");   //---》设置字体，是什么类型例如：宋体
        tableTitleFont.setBold(true);//--->设置是否是加粗
        tableTitleStyle.setFont(tableTitleFont);

        //表格内容样式
        HSSFCellStyle tableContentStyle = wb.createCellStyle(); // 样式对象
        tableContentStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直
        tableContentStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        tableContentStyle.setBorderBottom((short)1);
        tableContentStyle.setBorderLeft((short)1);
        tableContentStyle.setBorderRight((short)1);
        tableContentStyle.setBorderTop((short)1);
        //设置标题字体格式
        Font tableContentFont = wb.createFont();
        //设置字体样式
        tableContentFont.setFontHeightInPoints((short)12);   //--->设置字体大小
        tableContentFont.setFontName("宋体");   //---》设置字体，是什么类型例如：宋体
        tableContentFont.setBold(false);//--->设置是否是加粗
        tableContentStyle.setFont(tableContentFont);

        //表格第一行
        HSSFRow row1 = sheet.createRow(0);   //--->创建一行
        row1.setHeightInPoints(30);
        HSSFCell cell1 = row1.createCell(0);   //--->创建一个单元格
        cell1.setCellStyle(captionStyle);
        cell1.setCellValue("停 车 卸 货 场 车 辆 管 理 台 账");

        //表格第二行
        HSSFRow row2 = sheet.createRow(1);   //--->创建一行

        //表格第三行
        HSSFRow row3 = sheet.createRow(2);   //--->创建一行
        HSSFCell cell3_1 = row3.createCell(0);   //--->创建一个单元格
        cell3_1.setCellStyle(commentsStyle);
        cell3_1.setCellValue("使用单位:__________ 车辆查扣单位_____________ 时间:_____年___月份");

        //表格第四行
        HSSFRow row4 = sheet.createRow(3);   //--->创建一行

        //表格第五行
        HSSFRow row5 = sheet.createRow(4);   //--->创建一行
        HSSFCell cell5_1 = row5.createCell(0);   //--->创建一个单元格
        cell5_1.setCellStyle(tableTitleStyle);
        cell5_1.setCellValue("车号");
        HSSFCell cell5_2 = row5.createCell(1);   //--->创建一个单元格
        cell5_2.setCellStyle(tableTitleStyle);
        cell5_2.setCellValue("车型");
        HSSFCell cell5_3 = row5.createCell(2);   //--->创建一个单元格
        cell5_3.setCellStyle(tableTitleStyle);
        cell5_3.setCellValue("查扣时间");
        HSSFCell cell5_4 = row5.createCell(3);   //--->创建一个单元格
        cell5_4.setCellStyle(tableTitleStyle);
        cell5_4.setCellValue("放行时间");
        HSSFCell cell5_5 = row5.createCell(4);   //--->创建一个单元格
        cell5_5.setCellStyle(tableTitleStyle);
        cell5_5.setCellValue("期限(天)");
        HSSFCell cell5_6 = row5.createCell(5);   //--->创建一个单元格
        cell5_6.setCellStyle(tableTitleStyle);
        cell5_6.setCellValue("初检(吨)");
        HSSFCell cell5_7 = row5.createCell(6);   //--->创建一个单元格
        cell5_7.setCellStyle(tableTitleStyle);
        cell5_7.setCellValue("复检(吨)");
        HSSFCell cell5_8 = row5.createCell(7);   //--->创建一个单元格
        cell5_8.setCellStyle(tableTitleStyle);
        cell5_8.setCellValue("总计(吨)");
        HSSFCell cell5_9 = row5.createCell(8);   //--->创建一个单元格
        cell5_9.setCellStyle(tableTitleStyle);
        cell5_9.setCellValue("经手人");
        HSSFCell cell5_10 = row5.createCell(9);   //--->创建一个单元格
        cell5_10.setCellStyle(tableTitleStyle);
        cell5_10.setCellValue("备注");

        FileOutputStream fileOut = null;
        try{
            fileOut = new FileOutputStream("d:\\workbook.xls");
            wb.write(fileOut);
            //fileOut.close();
            System.out.print("OK");
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            if(fileOut != null){
                try {
                    fileOut.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

    }
}
