package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void someItem_WithSellInAndQualityOverZero_decreaseByOneEach() {
        Item someItem = new Item("Some Item",4, 4);
        Item[] items = new Item[] { someItem };
        instantiateGildedRoseAndUpdateQuality(items);
        assertEquals(3, someItem.quality);
        assertEquals(3, someItem.sellIn);
    }

    @Test
    void someItems_WithSellInAndQualityOverZero_decreaseByOneEachForEachItem() {
        Item itemOne = new Item("ItemOne",4, 4);
        Item itemTwo = new Item("ItemTwo",3, 3);
        Item[] items = new Item[] { itemOne, itemTwo };
        instantiateGildedRoseAndUpdateQuality(items);
        assertEquals(3, itemOne.quality);
        assertEquals(3, itemOne.sellIn);
        assertEquals(2, itemTwo.quality);
        assertEquals(2, itemTwo.sellIn);
    }

    @Test
    void someItem_WithQualityZero_doesNotDecrease() {
        Item someItem = new Item("Some Item",1, 0);
        Item[] items = new Item[] { someItem };
        instantiateGildedRoseAndUpdateQuality(items);
        assertEquals(0, someItem.quality);
    }



    @Test
    void someItem_WithSellInZero_decreaseByTwo() {
        Item someItem = new Item("Some Item",0, 4);
        Item[] items = new Item[] { someItem };
        instantiateGildedRoseAndUpdateQuality(items);
        assertEquals(2, someItem.quality);
    }

    @Test
    void agedBrie_Under50_IncreaseQuality() {
        Item agedBrie = new Item("Aged Brie",0, 1);
        Item[] items = new Item[] { agedBrie };
        instantiateGildedRoseAndUpdateQuality(items);
        assertFalse(agedBrie.quality <= 1);
    }

    @Test
    void agedBrie_qualityAt50_doesNotIncreaseQuality() {
        Item agedBrie = new Item("Aged Brie",0, 50);
        Item[] items = new Item[] { agedBrie };
        instantiateGildedRoseAndUpdateQuality(items);
        assertEquals(50, agedBrie.quality);
    }
    @Test
    public void sufuras_withAnySellInAndQuality_remainsUnchanged() {
        Item sulfuras = new Item("Sulfuras, Hand of Ragnaros",0, 80);
        Item[] items = { sulfuras };
        instantiateGildedRoseAndUpdateQuality(items);
        assertEquals(80, sulfuras.quality);
    }

    @Test
    void backstagePass_SellInOver10Days_IncreaseQualityBy1() {
        Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert",20, 10);
        Item[] items = { backstagePass };
        instantiateGildedRoseAndUpdateQuality(items);
        assertEquals(11, backstagePass.quality);
    }

    @Test
    void backstagePass_SellInAt10Days_IncreaseQualityBy2() {
        Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert",10, 10);
        Item[] items = { backstagePass };
        instantiateGildedRoseAndUpdateQuality(items);
        assertEquals(12, backstagePass.quality);
    }

    @Test
    void backstagePass_SellInBetween5and10Days_IncreaseQualityBy2() {
        Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert",8, 10);
        Item[] items = { backstagePass };
        instantiateGildedRoseAndUpdateQuality(items);
        assertEquals(12, backstagePass.quality);
    }

    @Test
    void backstagePass_SellInAt5_IncreaseQualityBy3() {
        Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert",5, 10);
        Item[] items = { backstagePass };
        instantiateGildedRoseAndUpdateQuality(items);
        assertEquals(13, backstagePass.quality);
    }

    @Test
    void backstagePass_SellInUnder5_IncreaseQualityBy3() {
        Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert",3, 10);
        Item[] items = { backstagePass };
        instantiateGildedRoseAndUpdateQuality(items);
        assertEquals(13, backstagePass.quality);
    }

    @Test
    void backstagePass_SellInAt0_DropQualityTo0() {
        Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert",0, 10);
        Item[] items = { backstagePass };
        instantiateGildedRoseAndUpdateQuality(items);
        assertEquals(0, backstagePass.quality);
    }

    private static void instantiateGildedRoseAndUpdateQuality(Item[] items) {
        GildedRose target = new GildedRose(items);
        target.updateQuality();
    }

}
