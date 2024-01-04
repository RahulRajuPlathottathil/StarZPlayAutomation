package utility;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class ExcelDB {
    private Fillo fillo;
    private Connection connection;
    private Recordset recordset;

    public static ExcelDB given() {
        return new ExcelDB();
    }

    public ExcelDB with(String filePath) {
        try {
            fillo = new Fillo();
            this.connection = fillo.getConnection(filePath);
        } catch (FilloException e) {
            e.printStackTrace();
        }
        return this;
    }

    public ExcelDB executeQuery(String query) {
        try {
            this.recordset = this.connection.executeQuery(query);
        } catch (FilloException e) {
            e.printStackTrace();
        }

        return this;
    }

    public Recordset getAsRecordSet() {
        this.connection.close();
        return this.recordset;
    }


}

