package sys.entity;

/**
 * Created by Csun on 2015-07-05.
 */
public class MonthlyStatistic
{
    private Integer daily;

    private Integer firstCheckSum;

    private Integer reCheckSum;

    private Integer sumCheckSum;

    private Integer vehCount;

    private Integer staySum;

    public MonthlyStatistic()
    {

    }
    public MonthlyStatistic(Integer daily, Integer firstCheckSum , Integer reCheckSum , Integer sumCheckSum , Integer vehCount, Integer staySum)
    {
        this.daily = daily;
        this.firstCheckSum = firstCheckSum;
        this.reCheckSum = reCheckSum;
        this.sumCheckSum = sumCheckSum;
        this.vehCount = vehCount;
        this.staySum = staySum;
    }

    public Integer getDaily()
    {
        return daily;
    }

    public void setDaily(Integer daily)
    {
        this.daily = daily;
    }

    public Integer getFirstCheckSum()
    {
        return firstCheckSum;
    }

    public void setFirstCheckSum(Integer firstCheckSum)
    {
        this.firstCheckSum = firstCheckSum;
    }

    public Integer getReCheckSum()
    {
        return reCheckSum;
    }

    public void setReCheckSum(Integer reCheckSum)
    {
        this.reCheckSum = reCheckSum;
    }

    public Integer getSumCheckSum()
    {
        return sumCheckSum;
    }

    public void setSumCheckSum(Integer sumCheckSum)
    {
        this.sumCheckSum = sumCheckSum;
    }

    public Integer getVehCount()
    {
        return vehCount;
    }

    public void setVehCount(Integer vehCount)
    {
        this.vehCount = vehCount;
    }

    public Integer getStaySum()
    {
        return staySum;
    }

    public void setStaySum(Integer staySum)
    {
        this.staySum = staySum;
    }
}
