package com.emeraldhieu.app.photo;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Builder
@Getter
@Jacksonized
public class Photo {

    private final int id;
    private final int albumId;
    private final String title;
    private final String url;
    private final String thumbnailUrl;
}
