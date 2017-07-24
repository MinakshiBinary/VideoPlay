package com.binaryic.videoplay.model;

/**
 * Created by minakshi on 27/6/17.
 */

public class VideoModel {
    private String description;
    private String name;
    private String url;
    private String video_Type;//other or Youtube

    public String getVideo_Type() {
        return video_Type;
    }

    public void setVideo_Type(String video_Type) {
        this.video_Type = video_Type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
