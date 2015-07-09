package sys.cxf;

import sys.entity.UpLoadUnit;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Created by Csun on 2015-05-26.
 */
@WebService
public interface UpLoadService
{
    public int SendUpLoadParam(@WebParam(name = "UpLoadUnit") UpLoadUnit elem);
}
