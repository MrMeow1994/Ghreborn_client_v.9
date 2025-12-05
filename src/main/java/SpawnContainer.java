
import com.google.common.collect.Lists;

import java.util.List;

public class SpawnContainer extends Widget {

    private static final SpawnContainer INSTANCE = new SpawnContainer();
    public static final int INTERFACE_ID = 42214;
    private static final Sprite BG = new Sprite("spawner/bg");

    public static SpawnContainer get() {
        return INSTANCE;
    }

    private int containerInterfaceId;

    private SpawnContainer() {}

    private final int containerWidth = 132;
    private final int containerHeight = 23;
    private final int containerCount = containerWidth * containerHeight;

    public void load() {
        int interfaceId = INTERFACE_ID;
        int childId = 0;
        Widget inter = addInterface(interfaceId++);
        inter.totalChildren(5);

        addSprite(interfaceId, BG);
        inter.child(childId++, interfaceId++, 12, 18);

        addInputField(interfaceId, 50, 0xE68A00, "Search", 132, 23, false, true);
        get(interfaceId).inputFieldSendPacket = false;
        inter.child(childId++, interfaceId++, 17, 24);

        // Container
        Widget scrollable = addInterface(interfaceId++);
        scrollable.scrollMax = 6000;
        scrollable.width = 470;
        scrollable.height = 260;
        scrollable.invAutoScrollHeightOffset = 0;
        scrollable.totalChildren(1);
        containerInterfaceId = interfaceId;
        addItemContainerAutoScrollable(interfaceId, 14, 400, 1, 0, true, scrollable.id, "Spawn", "Spawn 5,000", "Spawn X");
        get(containerInterfaceId).hideInvStackSizes = true;
        scrollable.child(0, interfaceId++, 4, 4);

        inter.child(childId++, scrollable.id, 20, 58);

        inter.child(childId++, Widget.CLOSE_BUTTON_SMALL, 484, 28);
        inter.child(childId++, Widget.CLOSE_BUTTON_SMALL_HOVER, 484, 28);
        update("");
    }

    public void update(String message) {
        Widget container = get(containerInterfaceId);
        List<Integer> matches = Lists.newArrayList();
        try {
            for (int i = 0; i < 40000; i++) {
                ItemDefinition def = ItemDefinition.method198(i);
                if (def != null && def.name != null && def.name.length() > 0 && !def.name.contains("Dwarf remains")
                        && (message.length() == 0 || def.name.toLowerCase().contains(message))) {
                    matches.add(i + 1);
                    if (matches.size() >= containerCount - 1)
                        break;
                }
            }
        }catch (Exception e) {

        }


        for (int index = 0; index < matches.size(); index++) {
            container.inventoryItemId[index] = matches.get(index);
            container.inventoryAmounts[index] = 1;
        }

        for (int index = container.inventoryItemId.length - 1; index >= matches.size(); index--) {
            container.inventoryItemId[index] = 0;
            container.inventoryAmounts[index] = 0;
        }
    }
}
