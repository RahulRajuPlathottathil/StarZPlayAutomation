package DataProviders;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

import utility.DirectoryLookUP;
import utility.ExcelDB;
import utility.QueryManager;

public class DataProviderHelper {

    @DataProvider
    public static Object[][] StarzPlayDataProvider() {
        Object[][] data = null;
        Hashtable<String, String> hashtable = null;
        try {

            Recordset recordset = ExcelDB.given().with(DirectoryLookUP.TEST_RUNNER).executeQuery(QueryManager.TestRunner_Query).getAsRecordSet();

            int counter = 0;
            data = new Object[recordset.getCount()][1];
            while (recordset.next()) {
                hashtable = new Hashtable<String, String>();

                for (String columnName : recordset.getFieldNames()) {
                    String fieldValue = recordset.getField(columnName);
                    hashtable.put(columnName, fieldValue);

                }
                data[counter][0] = hashtable;
                System.out.println(counter);
                counter++;
                System.out.println(hashtable);
            }

        } catch (FilloException e) {
            e.printStackTrace();
        }
        return data;

    }

    public static void main(String[] args) {
        StarzPlayDataProvider();

    }

}
