import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            Transaction transaction = (Transaction) object;

            Pattern pattern = Pattern.compile("\\d\\d\\d\\d-\\d\\d-\\d\\d\\s\\d\\d:\\d\\d:\\d\\d");
            Matcher matcher = pattern.matcher(transaction.timestamp);
            matcher.find();
            String[] splited =  matcher.group(0).split(" ");
            transaction.timestamp = splited[0] + "T" + splited[1];
            if(transaction.counterpartyAccountName.contains("Oy Hotel Studio")) {
                System.out.println(transaction);
            }
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
