package sys.service.impl;

import org.springframework.stereotype.Service;
import sys.entity.MonthlyStatistic;
import sys.entity.RbacDep;
import sys.entity.UpLoadUnit;
import sys.entity.VehMonthCount;
import sys.mapper.UpLoadUnitMapper;
import sys.service.UpLoadElemService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Csun on 2015-07-05.
 */
@Service
public class UpLoadElemServiceImpl implements UpLoadElemService
{
    @Resource(name = "upLoadUnitMapper")
    private UpLoadUnitMapper upLoadUnitMapper;

    @Override
    public int selectMonthTotalOnStations(List<RbacDep> departments)
    {
        return upLoadUnitMapper.selectMonthTotalOnStations(departments);
    }

    @Override
    public int selectMonthNoneReCheckOnActiveUserStations(List<RbacDep> departments)
    {
        return upLoadUnitMapper.selectMonthNoneReCheckOnActiveUserStations(departments);
    }

    @Override
    public ArrayList<VehMonthCount> selectVehMonthCountOnActiveUserStations(List<RbacDep> departments)
    {
        return upLoadUnitMapper.selectVehMonthCountOnActiveUserStations(departments);
    }

    @Override
    public ArrayList<UpLoadUnit> selectByTermsOnActiveUser(Integer length, Integer start, Integer station_id, String license_plate, Integer axle_num,
                                                           Integer whole_weight_from, Integer whole_weight_to, Integer recheck_wholeWeight_from, Integer recheck_wholeWeight_to,
                                                           Integer whole_over_from, Integer whole_over_to, Integer whole_overrate_from, Integer whole_overrate_to,
                                                           String check_dt_from, String check_dt_to, String recheck_dt_from, String recheck_dt_to, Integer isover, String vehowner_name,
                                                           List<RbacDep> stations)
    {
        return upLoadUnitMapper.selectByTermsOnActiveUser(length, start, station_id, license_plate, axle_num, whole_weight_from, whole_weight_to,
                recheck_wholeWeight_from, recheck_wholeWeight_to, whole_over_from, whole_over_to, whole_overrate_from, whole_overrate_to, check_dt_from, check_dt_to,
                recheck_dt_from, recheck_dt_to, isover, vehowner_name, stations);
    }

    @Override
    public ArrayList<UpLoadUnit> selectByTermsAllOnActiveUser(Integer station_id, String license_plate, Integer axle_num,
                                                              Integer whole_weight_from, Integer whole_weight_to, Integer recheck_wholeWeight_from, Integer recheck_wholeWeight_to,
                                                              Integer whole_over_from, Integer whole_over_to, Integer whole_overrate_from, Integer whole_overrate_to,
                                                              String check_dt_from, String check_dt_to, String recheck_dt_from, String recheck_dt_to, Integer isover, String vehowner_name,
                                                              List<RbacDep> stations)
    {
        return upLoadUnitMapper.selectByTermsAllOnActiveUser(station_id, license_plate, axle_num, whole_weight_from, whole_weight_to,
                recheck_wholeWeight_from, recheck_wholeWeight_to, whole_over_from, whole_over_to, whole_overrate_from, whole_overrate_to, check_dt_from, check_dt_to,
                recheck_dt_from, recheck_dt_to, isover, vehowner_name, stations);
    }

    @Override
    public int selectWhereCountOnActiveUser(Integer station_id, String license_plate, Integer axle_num, Integer whole_weight_from,
                                            Integer whole_weight_to, Integer recheck_wholeWeight_from, Integer recheck_wholeWeight_to,
                                            Integer whole_over_from, Integer whole_over_to, Integer whole_overrate_from, Integer whole_overrate_to,
                                            String check_dt_from, String check_dt_to, String recheck_dt_from, String recheck_dt_to, Integer isover, String vehowner_name,
                                            List<RbacDep> stations)
    {
        return upLoadUnitMapper.selectWhereCountOnActiveUser(station_id,license_plate,axle_num,whole_weight_from,whole_weight_to,
                recheck_wholeWeight_from,recheck_wholeWeight_to,whole_over_from,whole_over_to,whole_overrate_from,whole_overrate_to,check_dt_from,check_dt_to,
                recheck_dt_from,recheck_dt_to,isover,vehowner_name,stations);
    }

    @Override
    public ArrayList<MonthlyStatistic> selectStatisticBaseYearMonrh(Integer year , Integer month, List<RbacDep> departments)
    {
        return upLoadUnitMapper.selectStatisticBaseYearMonrh(year, month, departments);
    }

    @Override
    public int selectIsExist(String checkCode, Integer wholeWeight, Integer recheckWholeweight)
    {
        return upLoadUnitMapper.selectIsExist(checkCode,wholeWeight,recheckWholeweight);
    }

    @Override
    public int insertUpLoadElem(UpLoadUnit upLoadUnit)
    {
        return upLoadUnitMapper.insertSelective(upLoadUnit);
    }

    @Override
    public int deleteByCheckCode(String checkCode)
    {
        return upLoadUnitMapper.deleteByCheckCode(checkCode);
    }
}
