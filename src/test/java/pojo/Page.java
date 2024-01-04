package pojo;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Data
public class Page {
    private long id;
    private Style style;
    private String action;
    @JsonIgnore
    private List<Long> assetIds;
    private String category;
    @JsonIgnore
    private String isDynamic;
    private List<Title> titles;
    @JsonIgnore
    private long seq;

    @Data
    public static class Style {
        // You can add fields for the Style class if needed
    }

    @Data
    public static class Title {
        private long id;
        private String title;
        private List<String> tagIds;
        private String has4K;
        private String fourkProgramId;
        private String addonContent;
        private Object brandContent; // Change Object to the actual type if known
        private String isLive;
        private List<String> adsCountryRights;
        @JsonIgnore
        private int seriesId;
        private Object subscriptionPerCountry;
        private List<String> contentOwnership;
        private List<String> assetTypes;
        private String assetTypesPriority;
        private List<Media> media;
        private List<String> subscription;
        @JsonIgnore
        private TotalUsers totalUsers;
        private int programType;

        private ContinueWatching continueWatching;
        @JsonIgnore
        private double score;
        private boolean hasFrenchAudio;
        private String friendlyTitle;
        private int ageRating;
        private List<String> badges;
        private List<Image> images;
        @JsonIgnore
        private Products products;
        @JsonIgnore
        private Licence license;

        @Data
        public static class Media {
            private int duration;
            private String format;
            private List<String> assetTypes;
            private List<Release> releases;
            private String streamingUrl;
        }

        @Data
        public static class Release {
            private String url;
        }

        @Data
        public static class ContinueWatching {
            private Progress progress;
            private int tvSeasonNumber;
            private int tvSeasonEpisodeNumber;
        }

        @Data
        public static class Progress {
            private double percentage;
            private int playbackTime;
        }

        @Data
        public static class Image {
            private String url;
            private String type;
        }

        @Data
        public static class Products {
            private Product purchase;
            private Product rent;

            @Data
            public static class Product {
                @JsonProperty("priceProduct")
                private String priceProduct;
                private String newPrice;
                private String oldPrice;
                private String currency;

                @JsonProperty("googleProductId")
                private String googleProductId;

                @JsonProperty("appleProductId")
                private String appleProductId;
            }
        }

        @Data
        public static class Licence {
            private String type;
            private String state;
            private String tsStart;
            private String tsExpire;
        }

        @Data
        public static class TotalUsers {
            private int low;
            private int high;
        }
    }
}

