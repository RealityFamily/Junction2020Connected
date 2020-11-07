import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
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
            formatTimeToRFC3339(transaction);

            {
                /////////// DATA TESTING /////////

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd'T'HH:mm:ss'z'");
                /*Date date  = Date.parse(transaction.timestamp);
                transaction.timestamp = dateFormat.format(date);*/



                if (transaction.counterpartyAccountName.contains("Mankina Oy")&& transaction.accountName.contains("HYJNI Oy")) {


                    System.out.println(transaction);
                }

                //TODO: сортируем по дате, потом запихиваем все это в рекуррентную нейронную сеть. Походит на предсказание погоды.


                //////////////////////////////////
            }
        }



    }

    private static void formatTimeToRFC3339(Transaction transaction) {
        Pattern pattern = Pattern.compile("\\d\\d\\d\\d-\\d\\d-\\d\\d\\s\\d\\d:\\d\\d:\\d\\d");
        Matcher matcher = pattern.matcher(transaction.timestamp);
        matcher.find();
        String[] splited =  matcher.group(0).split(" ");
        transaction.timestamp = splited[0] + "T" + splited[1]+ "Z";
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
