package Service;

import Model.Item;

public class ItemCreator {
    private static final String SHIRT_NAME="Dry Aeroflow Ls Hz";
    private static final String FULL_SHIRT_NAME="MIZUNO DRY AEROFLOW LS HZ";
    private static final String SHIRT_PRICE="7 750 руб.";
    private static final String SHIRT_COLOUR="44";
    private static final String SHIRT_SIZE="S";
    private static final String SHORT_NAME="CORE 5.5 SHORT";
    private static final String SHORT_PRICE="3 950 руб.";
    private static final String SHORT_COLOUR="09";
    private static final String SHORT_SIZE="M";
    private static final String SHORT_SIZE_XL="XL";
    public static Item createShorts(){
        return new Item(SHORT_NAME,SHORT_PRICE,SHORT_COLOUR,SHORT_SIZE);
    }
    public static Item createXLShorts(){return new Item(SHORT_NAME,SHORT_PRICE,SHORT_COLOUR,SHORT_SIZE_XL);}
    public static Item createShirt(){
        return new Item(SHIRT_NAME,SHIRT_PRICE,SHIRT_COLOUR,SHIRT_SIZE);
    }
    public static Item createShirtWithFullName(){
        return new Item(FULL_SHIRT_NAME,SHIRT_PRICE,SHIRT_COLOUR,SHIRT_SIZE);
    }
}
