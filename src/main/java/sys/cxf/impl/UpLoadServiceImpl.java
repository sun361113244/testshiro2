package sys.cxf.impl;

import com.alibaba.fastjson.JSON;
import sys.controller.UpLoadUnitController;
import sys.cxf.UpLoadService;
import sys.entity.UpLoadUnit;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.SOAPBinding;

@WebService(endpointInterface = "sys.cxf.UpLoadService", serviceName = "UpLoadService")
public class UpLoadServiceImpl implements UpLoadService
{
    @Resource
    private UpLoadUnitController upLoadUnitController;

    // return : -1 异常。-2 检测单号，重量，复检重量为空
    public int SendUpLoadParam( UpLoadUnit elem)
    {
        try
        {
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            // 检测此条记录是否存在
            if(elem.getCheckCode() !=  null && elem.getWholeWeight() != null && elem.getRecheckWholeweight() != null )
            {
                int count = upLoadUnitController.selectIsExist(elem.getCheckCode(),elem.getWholeWeight(),elem.getRecheckWholeweight());
                if(count > 0)
                {
                    System.out.println("存在数据");
                    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                    return 1;
                }
                else
                {
                    // 复检重量大于0，则此条记录为复检数据
                    if( elem.getRecheckWholeweight() > 0 )
                    {
                        upLoadUnitController.deleteByCheckCode(elem.getCheckCode());
                        System.out.println("复检数据");
                    }
                    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                    return upLoadUnitController.insertUpLoadElem(elem);
                }
            }
            else
            {
                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                return -2;
            }

        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
            System.out.println(JSON.toJSONString(elem));
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            return -1;
        }
    }
}
