import java.util.Arrays;
public class ItemSearch {

    private final String itemSearchName;

    private final int[] itemSearchResults;

    private final int itemRange;

    private int itemSearchResultAmount;

    private final boolean hideUntradables;

    public ItemSearch(String itemSearchName, int itemRange, boolean hideUntradables) {
        this.itemSearchName = itemSearchName;
        this.itemRange = itemRange;
        this.hideUntradables = hideUntradables;
        itemSearchResults = searchForName();
    }

    public int[] searchForName() {
        int[] items = new int[itemRange];
        int position = 0;
        for (int itemId = 0; itemId < ItemDefinition.anInt203; itemId++) {
            ItemDefinition itemDefinitions = ItemDefinition.method198(itemId);
            if(position >= items.length)
                break;

            if(itemDefinitions == null)
                continue;


            String itemName = itemDefinitions.name;

            if(itemName == null)
                continue;

            if(itemName.toLowerCase().contains(itemSearchName.toLowerCase())) {
                if(Arrays.binarySearch(items, itemId) >= 0)
                    continue;
                items[position] = itemId;
                position++;
                itemSearchResultAmount++;
            }
        }
        return items;
    }

    public int[] getItemSearchResults() {
        return itemSearchResults;
    }

    public int getItemSearchResultAmount() {
        return itemSearchResultAmount;
    }

}