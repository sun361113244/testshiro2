package sys.Util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Csun on 2015-07-08.
 */
public abstract class ExcelTools<T>
{
    private String localPath;

    private HSSFWorkbook workbook;

    public String getLocalPath()
    {
        return localPath;
    }

    public void setLocalPath(String localPath)
    {
        this.localPath = localPath;
    }

    public HSSFWorkbook getWorkbook()
    {
        return workbook;
    }

    public void setWorkbook(HSSFWorkbook workbook)
    {
        this.workbook = workbook;
    }

    public boolean writeFile()
    {
        FileOutputStream fileOut = null;
        try
        {
            fileOut = new FileOutputStream(localPath);
            workbook.write(fileOut);

            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
        finally
        {
            if (fileOut != null)
            {
                try
                {
                    fileOut.close();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    public abstract void InitWorkBook(ArrayList<T> monthList);
}
