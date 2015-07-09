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
    @Test
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










//        //样式1
//        HSSFCellStyle style = wb.createCellStyle(); // 样式对象
//        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直
//        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平
//        //设置标题字体格式
//        Font font = wb.createFont();
//        //设置字体样式
//        font.setFontHeightInPoints((short)20);   //--->设置字体大小
//        font.setFontName("Courier New");   //---》设置字体，是什么类型例如：宋体
//        font.setItalic(true);     //--->设置是否是加粗
//        style.setFont(font);     //--->将字体格式加入到style1中
//        //style1.setFillForegroundColor(IndexedColors.DARK_YELLOW.getIndex());
//        //style1.setFillPattern(CellStyle.SOLID_FOREGROUND);设置单元格颜色
//        style.setWrapText(true);   //设置是否能够换行，能够换行为true
//        style.setBorderBottom((short)1);   //设置下划线，参数是黑线的宽度
//        style.setBorderLeft((short)1);   //设置左边框
//        style.setBorderRight((short)1);   //设置有边框
//        style.setBorderTop((short)1);   //设置下边框
//        style.setDataFormat(format.getFormat("￥#,##0"));    //--->设置为单元格内容为货币格式
//
//        //表格第一行
//        HSSFRow row1 = sheet.createRow(0);   //--->创建一行
//        // 四个参数分别是：起始行，起始列，结束行，结束列
//        sheet.addMergedRegion(new Region(0, (short) 0, 0, (short) 15));
//        row1.setHeightInPoints(25);
//        HSSFCell cell1 = row1.createCell((short)0);   //--->创建一个单元格
//
//        cell1.setCellStyle(style);
//        cell1.setCellValue("总公司资金运用日报明细表（理财资金）");
//
//        //表格第二行
//        sheet.addMergedRegion(new Region(1,(short)0,1,(short)15));
//        HSSFRow row2 = sheet.createRow(1);
//        HSSFCell cell2 = row2.createCell((short)0);
//        cell2.setCellValue("报告日期："+new Date());
//        cell2.setCellStyle(style);
//
//        //表格第三行
//        sheet.addMergedRegion(new Region(2,(short)0,2,(short)15));
//        HSSFRow row3 = sheet.createRow(2);
//        HSSFCell cell3 = row3.createCell((short)0);
//        cell3.setCellValue("交易日期："+new Date());
//        cell3.setCellStyle(style);
//
//        //表格第四行
//        sheet.addMergedRegion(new Region(3, (short)0, 3, (short)2));
//        HSSFRow row4 = sheet.createRow(3);
//        row4.setHeightInPoints((short)75);
//        HSSFCell cell4 = row4.createCell((short)0);
//        HSSFCell cell4_0_1 = row4.createCell((short)1);
//        cell4_0_1.setCellStyle(style);
//        HSSFCell cell4_0_2 = row4.createCell((short)2);
//        cell4_0_2.setCellStyle(style);
//        cell4.setCellStyle(style);
//        cell4.setCellValue("代码/品种");
//
//        HSSFCell cell4_1 = row4.createCell((short)3);
//        cell4_1.setCellStyle(style);
//        cell4_1.setCellValue("投资类型");
//
//        FileOutputStream fileOut = null;
//        try{
//            fileOut = new FileOutputStream("d:\\workbook.xls");
//            wb.write(fileOut);
//            //fileOut.close();
//            System.out.print("OK");
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        finally{
//            if(fileOut != null){
//                try {
//                    fileOut.close();
//                } catch (IOException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//            }
//        }
    }
}
