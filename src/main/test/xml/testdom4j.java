package xml;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.junit.Test;
import sys.entity.RbacUri;
import sys.service.UserUriService;
import sys.service.impl.UserUriServiceImpl;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Csun on 2015-07-02.
 */
public class testdom4j
{
    public void test1()
    {
        UserUriService userUriService = new UserUriServiceImpl();

        List<RbacUri> menus = null;
        try
        {
            menus = userUriService.selectMenuListByUserId(1);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("nav");

    }
}
