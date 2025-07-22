public class slayerInterface extends Widget {

    public static void Unpack(RSFont[] tda) {
        Widget rsInterface = addInterface('\ua028');
        addSprite('\ua029', 1, "Interfaces/SlayerInterface/IMAGE");
        addHoverButton('\ua02a', "Interfaces/SlayerInterface/IMAGE", 4, 16, 16, "Close window", 0, '\ua02b', 1);
        addHoveredButton('\ua02b', "Interfaces/SlayerInterface/IMAGE", 5, 16, 16, '\ua02c');
        addHoverButton('\ua02d', "", 0, 85, 20, "Buy", 0, '\ua02e', 1);
        addHoverButton('\ua02f', "", 0, 85, 20, "Learn", 0, '\ua030', 1);
        addHoverButton('\ua031', "", 0, 85, 20, "Assignment", 0, '\ua032', 1);
        addText('\ua033', "Slayer Points: ", tda, 3, 16750623);
        addTextButton('\ua034', "Slayer Experience                           50", "Buy Slayer Experience", 16750623, false, true, tda, 1, 400);
        addTextButton('\ua035', "Slayer\'s Respite                             25", "Buy Slayer\'s Respite", 16750623, false, true, tda, 1, 401);
        addTextButton('\ua036', "Slayer Darts                                     35", "Buy Slayer Darts", 16750623, false, true, tda, 1, 402);
        addTextButton('\ua037', "Broad Arrows                                    25", "Buy Broad Arrows", 16750623, false, true, tda, 1, 403);
        setChildren(11, rsInterface);
        rsInterface.child(0, '\ua029', 12, 10);
        rsInterface.child(1, '\ua02a', 473, 20);
        rsInterface.child(2, '\ua02b', 473, 20);
        rsInterface.child(3, '\ua02d', 21, 23);
        rsInterface.child(4, '\ua02f', 107, 23);
        rsInterface.child(5, '\ua031', 193, 23);
        rsInterface.child(6, '\ua033', 98, 74);
        rsInterface.child(7, '\ua034', 124, 128);
        rsInterface.child(8, '\ua035', 125, 160);
        rsInterface.child(9, '\ua036', 125, 190);
        rsInterface.child(10, '\ua037', 124, 220);
    }

    public static void Unpack2(RSFont[] tda) {
        Widget rsInterface = addInterface('\ua21c');
        addSprite('\ua21d', 2, "Interfaces/SlayerInterface/IMAGE");
        addHoverButton('\ua21e', "Interfaces/SlayerInterface/IMAGE", 4, 16, 16, "Close window", 0, '\ua21f', 1);
        addHoveredButton('\ua21f', "Interfaces/SlayerInterface/IMAGE", 5, 16, 16, '\ua220');
        addHoverButton('\ua221', "", 0, 85, 20, "Buy", 0, '\ua222', 1);
        addHoverButton('\ua223', "", 0, 85, 20, "Learn", 0, '\ua224', 1);
        addHoverButton('\ua225', "", 0, 85, 20, "Assignment", 0, '\ua226', 1);
        addText('\ua227', "Slayer Points: ", tda, 3, 16750623);
        setChildren(7, rsInterface);
        rsInterface.child(0, '\ua21d', 12, 10);
        rsInterface.child(1, '\ua21e', 473, 20);
        rsInterface.child(2, '\ua21f', 473, 20);
        rsInterface.child(3, '\ua221', 21, 23);
        rsInterface.child(4, '\ua223', 107, 23);
        rsInterface.child(5, '\ua225', 193, 23);
        rsInterface.child(6, '\ua227', 98, 74);
    }
    public static void Unpack3(RSFont[] tda) {
        Widget rsInterface = addInterface('\ua410');
        addSprite('\ua411', 3, "Interfaces/SlayerInterface/IMAGE");
        addHoverButton('\ua412', "Interfaces/SlayerInterface/IMAGE", 4, 16, 16, "Close window", 0, '\ua413', 1);
        addHoveredButton('\ua413', "Interfaces/SlayerInterface/IMAGE", 5, 16, 16, '\ua414');
        addHoverButton('\ua415', "", 0, 85, 20, "Buy", 0, '\ua416', 1);
        addHoverButton('\ua417', "", 0, 85, 20, "Learn", 0, '\ua418', 1);
        addHoverButton('\ua419', "", 0, 85, 20, "Assignment", 0, '\ua41a', 1);
        addText('\ua41b', "Slayer Points: ", tda, 3, 16750623);
        addTextButton('\ua41c', "Cancel Task", "Temporarily cancel your current slayer task", 16750623, false, true, tda, 1, 300);
        addTextButton('\ua41d', "Remove Task permanently", "Permanently remove this monster as a task", 16750623, false, true, tda, 1, 305);
        addText('\ua41e', "line 1", tda, 1, 16750623);
        addText('\ua41f', "line 2", tda, 1, 16750623);
        addText('\ua420', "line 3", tda, 1, 16750623);
        addText('\ua421', "line 4", tda, 1, 16750623);
        addButton('\ua422', 6, "Interfaces/SlayerInterface/IMAGE", "Delete removed slayer task");
        addButton('\ua423', 6, "Interfaces/SlayerInterface/IMAGE", "Delete removed slayer task");
        addButton('\ua424', 6, "Interfaces/SlayerInterface/IMAGE", "Delete removed slayer task");
        addButton('\ua425', 6, "Interfaces/SlayerInterface/IMAGE", "Delete removed slayer task");
        setChildren(17, rsInterface);
        rsInterface.child(0, '\ua411', 12, 10);
        rsInterface.child(1, '\ua412', 473, 20);
        rsInterface.child(2, '\ua413', 473, 20);
        rsInterface.child(3, '\ua415', 21, 23);
        rsInterface.child(4, '\ua417', 107, 23);
        rsInterface.child(5, '\ua419', 193, 23);
        rsInterface.child(6, '\ua41b', 98, 74);
        rsInterface.child(7, '\ua41c', 71, 127);
        rsInterface.child(8, '\ua41d', 71, 146);
        rsInterface.child(9, '\ua41e', 71, 216);
        rsInterface.child(10, '\ua41f', 71, 234);
        rsInterface.child(11, '\ua420', 71, 252);
        rsInterface.child(12, '\ua421', 71, 270);
        rsInterface.child(13, '\ua422', 303, 215);
        rsInterface.child(14, '\ua423', 303, 233);
        rsInterface.child(15, '\ua424', 303, 251);
        rsInterface.child(16, '\ua425', 303, 269);
    }

}
