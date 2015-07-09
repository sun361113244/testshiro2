package sys.service;

import sys.entity.MonthlyStatistic;
import sys.entity.RbacDep;
import sys.entity.UpLoadUnit;
import sys.entity.VehMonthCount;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Csun on 2015-07-05.
 */
public interface UpLoadElemService
{
    int selectMonthTotalOnStations(List<RbacDep> departments);

    int selectMonthNoneReCheckOnActiveUserStations(List<RbacDep> departments);

    ArrayList<VehMonthCount> selectVehMonthCountOnActiveUserStations(List<RbacDep> departments);

    ArrayList<UpLoadUnit> selectByTermsOnActiveUser(Integer length, Integer start, Integer station_id, String license_plate, Integer axle_num,
                                                    Integer whole_weight_from, Integer whole_weight_to, Integer recheck_wholeWeight_from,
                                                    Integer recheck_wholeWeight_to, Integer whole_over_from, Integer whole_over_to, Integer whole_overrate_from,
                                                    Integer whole_overrate_to, String check_dt_from, String check_dt_to, String recheck_dt_from, String recheck_dt_to,
                                                    Integer isover, String vehowner_name, List<RbacDep> stations);

    int selectWhereCountOnActiveUser(Integer station_id, String license_plate, Integer axle_num, Integer whole_weight_from, Integer whole_weight_to,
                                     Integer recheck_wholeWeight_from, Integer recheck_wholeWeight_to, Integer whole_over_from, Integer whole_over_to,
                                     Integer whole_overrate_from, Integer whole_overrate_to, String check_dt_from, String check_dt_to, String recheck_dt_from,
                                     String recheck_dt_to, Integer isover, String vehowner_name, List<RbacDep> stations);

    ArrayList<MonthlyStatistic> selectStatisticBaseMonrh(Integer month, List<RbacDep> departments);

    int selectIsExist(String checkCode, Integer wholeWeight, Integer recheckWholeweight);

    int insertUpLoadElem(UpLoadUnit upLoadUnit);

    int deleteByCheckCode(String checkCode);
}
