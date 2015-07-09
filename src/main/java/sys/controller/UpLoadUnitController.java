package sys.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.servlet.ModelAndView;
import sys.Util.ExcelTools;
import sys.Util.ShanDongMonthExcelTools;
import sys.entity.ActiveUser;
import sys.entity.MonthlyStatistic;
import sys.entity.UpLoadUnit;
import sys.entity.VehMonthCount;
import sys.service.UpLoadElemService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by Csun on 2015-07-05.
 */
@Controller
@RequestMapping("/upLoadUnitController")
public class UpLoadUnitController
{
    @Resource
    private UpLoadElemService upLoadElemService;

    @RequestMapping("/selectHomePameStatisticItem")
    public ModelAndView selectHomePameStatisticItem()
    {
        Subject currentUser = SecurityUtils.getSubject();
        ActiveUser activeUser = (ActiveUser)currentUser.getPrincipal();

        ModelAndView mav = new ModelAndView("JsonView");

        int monthTotal = upLoadElemService.selectMonthTotalOnStations(activeUser.getDepartments());
        int monthNoneReCheck = upLoadElemService.selectMonthNoneReCheckOnActiveUserStations(activeUser.getDepartments());

        ArrayList<VehMonthCount> vehMonthCounts = upLoadElemService.selectVehMonthCountOnActiveUserStations(activeUser.getDepartments());
        mav.addObject("activeUser" ,activeUser.getUsername());
        mav.addObject("monthTotal" , monthTotal);
        mav.addObject("monthNoneReCheck" , monthNoneReCheck);
        mav.addObject("vehMonthCounts" , vehMonthCounts);

        return mav;
    }

    @RequestMapping("/selectByTerms")
    public ModelAndView selectByTerms(Integer draw, Integer length, Integer start ,Integer station_Id, String license_Plate, Integer axle_num, Integer whole_Weight_from,
                                      Integer whole_Weight_to, Integer recheck_wholeWeight_from, Integer recheck_wholeWeight_to, Integer whole_over_from,
                                      Integer whole_over_to,Integer whole_overrate_from, Integer whole_overrate_to, String check_DT_from, String check_DT_to,
                                      String recheck_DT_from, String recheck_DT_to, Integer isover, String vehowner_name)
    {
        Subject currentUser = SecurityUtils.getSubject();
        ActiveUser activeUser = (ActiveUser)currentUser.getPrincipal();

        ModelAndView mav = new ModelAndView("DataTablesServerSideView");

        ArrayList<UpLoadUnit> upLoadUnits = upLoadElemService.selectByTermsOnActiveUser(length, start, station_Id, license_Plate, axle_num, whole_Weight_from, whole_Weight_to,
                recheck_wholeWeight_from, recheck_wholeWeight_to, whole_over_from, whole_over_to, whole_overrate_from, whole_overrate_to, check_DT_from, check_DT_to,
                recheck_DT_from, recheck_DT_to, isover, vehowner_name ,activeUser.getDepartments());
        int upLoadUnitsWhereCount = upLoadElemService.selectWhereCountOnActiveUser(station_Id, license_Plate, axle_num, whole_Weight_from, whole_Weight_to,
                recheck_wholeWeight_from, recheck_wholeWeight_to, whole_over_from, whole_over_to, whole_overrate_from, whole_overrate_to, check_DT_from, check_DT_to,
                recheck_DT_from, recheck_DT_to, isover, vehowner_name, activeUser.getDepartments());

        mav.addObject("draw", draw);
        mav.addObject("records", upLoadUnits);
        mav.addObject("recordsTotal", upLoadUnitsWhereCount);
        mav.addObject("recordsFiltered", upLoadUnitsWhereCount);
        return mav;
    }
    private int getDayOfMonth()
    {
        Calendar aCalendar = Calendar.getInstance(Locale.CHINA);
        int day=aCalendar.getActualMaximum(Calendar.DATE);
        return day;
    }

    @RequestMapping("/selectStatisticBaseMonrh")
    public ModelAndView selectStatisticBaseMonrh(Integer draw , @RequestParam("month")Integer month)
    {
        Subject currentUser = SecurityUtils.getSubject();
        ActiveUser activeUser = (ActiveUser)currentUser.getPrincipal();

        ModelAndView mav = new ModelAndView("DataTablesAjaxView");

        int days = getDayOfMonth();
        ArrayList<MonthlyStatistic> monthList = new ArrayList<MonthlyStatistic>();

        ArrayList<MonthlyStatistic> tempMonthList = upLoadElemService.selectStatisticBaseMonrh(month , activeUser.getDepartments());
        for(int i = 0 ; i < days ; i++)
        {
            boolean isMonthExit = false;
            for(MonthlyStatistic tmp:tempMonthList)
            {
                if( (i + 1) == tmp.getDaily() )
                {
                    monthList.add(tmp);
                    isMonthExit = true;
                    break;
                }
            }
            if(!isMonthExit)
                monthList.add(new MonthlyStatistic(i + 1, 0, 0,0 ,0 , 0));
        }

        mav.addObject("draw", draw);
        mav.addObject("records", monthList);
        mav.addObject("recordsTotal", days);
        mav.addObject("recordsFiltered", days);
        return mav;
    }

    @RequestMapping("/exportsStatisticBaseMonrhExcel")
    public ModelAndView exportsStatisticBaseMonrhExcel(@RequestParam("month")Integer month)
    {
        Subject currentUser = SecurityUtils.getSubject();
        ActiveUser activeUser = (ActiveUser)currentUser.getPrincipal();

        ModelAndView mav = new ModelAndView("JsonView");

        int days = getDayOfMonth();
        ArrayList<MonthlyStatistic> monthList = new ArrayList<MonthlyStatistic>();

        ArrayList<MonthlyStatistic> tempMonthList = upLoadElemService.selectStatisticBaseMonrh(month , activeUser.getDepartments());
        for(int i = 0 ; i < days ; i++)
        {
            boolean isMonthExit = false;
            for(MonthlyStatistic tmp:tempMonthList)
            {
                if( (i + 1) == tmp.getDaily() )
                {
                    monthList.add(tmp);
                    isMonthExit = true;
                    break;
                }
            }
            if(!isMonthExit)
                monthList.add(new MonthlyStatistic(i + 1, 0, 0,0 ,0 , 0));
        }

        ExcelTools excelTools = new ShanDongMonthExcelTools();

        String path = ContextLoader.getCurrentWebApplicationContext().getServletContext().getContextPath() + "/static/file/monthStatistic.xls";
        excelTools.setLocalPath("D:\\apache-tomcat-7.0.56-windows-x64\\apache-tomcat-7.0.56\\webapps\\uploadpark\\static\\file\\monthStatistic.xls");
        excelTools.InitWorkBook(monthList);
        boolean res = excelTools.writeFile();
        if(res)
        {
            mav.addObject("excelExport" , 1);
            mav.addObject("path" , path);
        }
        else
        {
            mav.addObject("excelExport" , 2);
            mav.addObject("path" , "");
        }
        return mav;
    }
    public int selectIsExist(String checkCode, Integer wholeWeight, Integer recheckWholeweight)
    {
        return upLoadElemService.selectIsExist(checkCode,wholeWeight,recheckWholeweight);
    }
    public int insertUpLoadElem(UpLoadUnit elem)
    {
        return upLoadElemService.insertUpLoadElem(elem);
    }

    public void deleteByCheckCode(String checkCode )
    {
        upLoadElemService.deleteByCheckCode(checkCode);
    }
}
