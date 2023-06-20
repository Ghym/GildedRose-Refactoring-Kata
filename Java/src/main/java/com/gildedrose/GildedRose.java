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

        switch (item.name) {
            case "Sulfuras, Hand of Ragnaros":
                break;
            case "Aged Brie":
                item.sellIn = item.sellIn - 1;
                increaseItemQuality(item);
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                if (item.sellIn <= 0) {
                    item.quality = 0;
                } else {
                    int qualityIncrease = 1;
                    if (item.sellIn < 6) {
                        qualityIncrease = 3;
                    } else if (item.sellIn < 11) {
                        qualityIncrease = 2;
                    }
                    increaseItemQuality(item, qualityIncrease);
                }
                break;
            default:
                decreaseItemQuality(item);

                item.sellIn = item.sellIn - 1;
                if (item.sellIn < 0) {
                    decreaseItemQuality(item);
                }
                break;
        }
        });
    }

    void increaseItemQuality(Item item) {
        increaseItemQuality(item, 1);
    }
    void increaseItemQuality(Item item, int qualityIncrease) {

        item.quality += qualityIncrease;
        if (item.quality > MAX_QUALITY) {
            item.quality = MAX_QUALITY;
        }
    }

    void decreaseItemQuality(Item item) {
        decreaseItemQuality(item, 1);
    }
    void decreaseItemQuality(Item item, int qualityDecrease) {
        if (item.name.toLowerCase().contains("conjured")) {
            qualityDecrease = qualityDecrease * 2;
        }
        item.quality -= qualityDecrease;
        if (item.quality < 0) {
            item.quality = 0;
        }
    }
}
