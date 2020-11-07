import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

public class Main {
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static void main(String[] args) throws Exception
    {
        CsvToBean csv = new CsvToBean();
        String csvFilename = "src/main/resources/final_transaction_table.csv";
        CSVReader csvReader = new CSVReader(new FileReader(csvFilename), ';');
        //Set column mapping strategy
        List list = csv.parse(setColumMapping(), csvReader);
        for (Object object : list) {
            Transaction employee = (Transaction) object;
            System.out.println(employee);
        }
    }
    @SuppressWarnings({"rawtypes", "unchecked"})
    private static ColumnPositionMappingStrategy setColumMapping()
    {
        ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
        strategy.setType(Transaction.class);
        String[] columns = new String[] {"timestamp","paymentDate","valueDate","bookingDate","amount","balance","currency","message","reference","accountBic","accountName","accountIban","archiveId","objectId","counterpartyAccountBic","counterpartyAccountName","counterpartyAccountIban","vientiselitekd","taplajikd"};
        strategy.setColumnMapping(columns);
        return strategy;
    }}
