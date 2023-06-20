package com.gildedrose;

import java.util.Arrays;

class GildedRose {
    Item[] items;

    public static int MAX_QUALITY = 50;



    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Arrays.asList(items).stream().forEach(item -> {

            if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                return;
            }

            item.sellIn = item.sellIn - 1;

            if (item.name.equals("Aged Brie")) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
                return;
            }

            if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.quality > 0) {
                        item.quality = item.quality - 1;
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.sellIn < 11) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }
                    }
                }
            }

            if (item.sellIn < 0) {
                    if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.quality > 0) {
                                item.quality = item.quality - 1;
                        }
                    } else {
                        item.quality = item.quality - item.quality;
                    }

            }
        });
    }
}
