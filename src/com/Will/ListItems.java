package com.Will;

import java.io.BufferedReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.io.FileReader;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;



public class ListItems {
    private static final String itemRegex = "(\\d+)\\s((\\w+\\s)+)at\\s(\\d+.\\d+)";

    private static Set<String> itemsNoTax = null;

    static {
        itemsNoTax = new HashSet<String>();
        itemsNoTax.add("book");
        itemsNoTax.add("imported book");
        itemsNoTax.add("chocolate bar");
        itemsNoTax.add("imported box of chocolate");
        itemsNoTax.add("imported bottle of perfume");
        itemsNoTax.add("packet of headache pills");
        itemsNoTax.add("pills");


    }

    public static void getfromFile(String filename) {
        List<Items> items = new ArrayList();
        try {
            BufferedReader in = new BufferedReader(new FileReader(filename));
            String str;
            while ((str = in.readLine()) != null) {
                if (correctInput(str)) {
                    Items item = new Items();
                    item = setItems(str);
                    items.add(item);
                }
            }

            in.close();
        }
        catch (IOException e) {
            System.out.println("error:" + e);
        }

        finalOutput(items);
    }


    public static boolean correctInput(String order) {

        Items item = new Items();
        Matcher m = parse(order);
        item.setName(m.group(2).trim());
        item.setItemNum(Integer.valueOf(m.group(1)));
        item.setPrice(new BigDecimal(m.group(4).trim()));

        //checks to see if the item is imported
        if (item.getName().contains("imported"))
            item.setImported(true);
        else
            item.setImported(false);

        // checks to see if the item is exempted from taxes
        if (itemsNoTax.contains(item.getName()))
            item.setSalesTaxToApply(false);
        else
            item.setSalesTaxToApply(true);

        return item;
    }

}
