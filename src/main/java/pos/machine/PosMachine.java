package pos.machine;
import java.util.*;

public class PosMachine {

//    public static void main(String[] args) {
//        PosMachine posMachine = new PosMachine();
//        System.out.println(posMachine.printReceipt(ItemDataLoader.loadBarcodes()));
//    }

    private List<Item> convertToItems(List<String> barcodes) {
        LinkedList<Item> itemsWithDetail = new LinkedList<Item>();
        List<ItemInfo> itemsInfo = loadAllItemsInfo();
        barcodes = new ArrayList<>(new LinkedHashSet<>(barcodes));
        for (String barcode : barcodes) {
            Item itemDetail = new Item();
            for (ItemInfo itemInfoVal : itemsInfo) {
                if (barcode.equals(itemInfoVal.getBarcode())) {
                    itemDetail.setName(itemInfoVal.getName());
                    itemDetail.setUnitPrice(itemInfoVal.getPrice());
                    itemDetail.setQuantity(Collections.frequency(ItemDataLoader.loadBarcodes(), barcode));
                }
            }
            itemsWithDetail.add(itemDetail);
        }
        return itemsWithDetail;
    }

    private List<ItemInfo> loadAllItemsInfo(){
        return ItemDataLoader.loadAllItemInfos();
    }
}