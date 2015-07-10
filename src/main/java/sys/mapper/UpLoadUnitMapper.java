package sys.mapper;

import org.apache.ibatis.annotations.Param;
import sys.entity.MonthlyStatistic;
import sys.entity.RbacDep;
import sys.entity.UpLoadUnit;
import sys.entity.VehMonthCount;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Csun on 2015-07-05.
 */
public interface UpLoadUnitMapper
{
    int selectMonthTotalOnStations(List<RbacDep> departments);

    int selectMonthNoneReCheckOnActiveUserStations(List<RbacDep> departments);

    ArrayList<VehMonthCount> selectVehMonthCountOnActiveUserStations(List<RbacDep> departments);

    ArrayList<UpLoadUnit> selectByTermsOnActiveUser(@Param("length") Integer length, @Param("start") Integer start, @Param("station_Id") Integer station_Id,
                                                    @Param("license_plate") String license_plate, @Param("axle_num") Integer axle_num, @Param("whole_weight_from") Integer whole_weight_from,
                                                    @Param("whole_weight_to") Integer whole_weight_to, @Param("recheck_wholeWeight_from") Integer recheck_wholeWeight_from,
                                                    @Param("recheck_wholeWeight_to") Integer recheck_wholeWeight_to, @Param("whole_over_from") Integer whole_over_from,
                                                    @Param("whole_over_to") Integer whole_over_to, @Param("whole_overrate_from") Integer whole_overrate_from,
                                                    @Param("whole_overrate_to") Integer whole_overrate_to, @Param("check_dt_from") String check_dt_from,
                                                    @Param("check_dt_to") String check_dt_to, @Param("recheck_dt_from") String recheck_dt_from, @Param("recheck_dt_to") String recheck_dt_to,
                                                    @Param("isover") Integer isover, @Param("vehowner_name") String vehowner_name, @Param("stations")List<RbacDep> stations);

    ArrayList<UpLoadUnit> selectByTermsAllOnActiveUser(@Param("station_Id") Integer station_Id,
                                                       @Param("license_plate") String license_plate, @Param("axle_num") Integer axle_num, @Param("whole_weight_from") Integer whole_weight_from,
                                                       @Param("whole_weight_to") Integer whole_weight_to, @Param("recheck_wholeWeight_from") Integer recheck_wholeWeight_from,
                                                       @Param("recheck_wholeWeight_to") Integer recheck_wholeWeight_to, @Param("whole_over_from") Integer whole_over_from,
                                                       @Param("whole_over_to") Integer whole_over_to, @Param("whole_overrate_from") Integer whole_overrate_from,
                                                       @Param("whole_overrate_to") Integer whole_overrate_to, @Param("check_dt_from") String check_dt_from,
                                                       @Param("check_dt_to") String check_dt_to, @Param("recheck_dt_from") String recheck_dt_from, @Param("recheck_dt_to") String recheck_dt_to,
                                                       @Param("isover") Integer isover, @Param("vehowner_name") String vehowner_name, @Param("stations")List<RbacDep> stations);


    int selectWhereCountOnActiveUser(@Param("station_Id")Integer station_id,
                                     @Param("license_plate")String license_plate, @Param("axle_num")Integer axle_num, @Param("whole_weight_from")Integer whole_weight_from,
                                     @Param("whole_weight_to")Integer whole_weight_to, @Param("recheck_wholeWeight_from")Integer recheck_wholeWeight_from,
                                     @Param("recheck_wholeWeight_to")Integer recheck_wholeWeight_to, @Param("whole_over_from")Integer whole_over_from,
                                     @Param("whole_over_to")Integer whole_over_to, @Param("whole_overrate_from")Integer whole_overrate_from,
                                     @Param("whole_overrate_to")Integer whole_overrate_to, @Param("check_dt_from")String check_dt_from,
                                     @Param("check_dt_to")String check_dt_to, @Param("recheck_dt_from")String recheck_dt_from, @Param("recheck_dt_to")String recheck_dt_to,
                                     @Param("isover")Integer isover, @Param("vehowner_name")String vehowner_name, @Param("stations")List<RbacDep> stations);

    ArrayList<MonthlyStatistic> selectStatisticBaseYearMonrh(@Param("year")Integer year ,@Param("month")Integer month, @Param("departments")List<RbacDep> departments);

    int selectIsExist(@Param("checkCode") String checkCode, @Param("wholeWeight") Integer wholeWeight, @Param("recheckWholeweight") Integer recheckWholeweight);

    int insertSelective( UpLoadUnit record);

    int deleteByCheckCode(@Param("checkCode") String checkCode);

}
