
package com.joel.events.models;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;


@Parcel(Parcel.Serialization.BEAN)
public class Category
{

    @SerializedName("resource_uri")
    @Expose
    private String resourceUri;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("name_localized")
    @Expose
    private String nameLocalized;
    @SerializedName("short_name")
    @Expose
    private String shortName;
    @SerializedName("short_name_localized")
    @Expose
    private String shortNameLocalized;
    private final static long serialVersionUID = -4187791543980236194L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Category() {
    }

    /**
     * 
     * @param name
     * @param resourceUri
     * @param id
     * @param nameLocalized
     * @param shortName
     * @param shortNameLocalized
     */
    public Category(String resourceUri, String id, String name, String nameLocalized, String shortName, String shortNameLocalized) {
        super();
        this.resourceUri = resourceUri;
        this.id = id;
        this.name = name;
        this.nameLocalized = nameLocalized;
        this.shortName = shortName;
        this.shortNameLocalized = shortNameLocalized;
    }

    public String getResourceUri() {
        return resourceUri;
    }

    public void setResourceUri(String resourceUri) {
        this.resourceUri = resourceUri;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameLocalized() {
        return nameLocalized;
    }

    public void setNameLocalized(String nameLocalized) {
        this.nameLocalized = nameLocalized;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getShortNameLocalized() {
        return shortNameLocalized;
    }



    public void setShortNameLocalized(String shortNameLocalized) {
        this.shortNameLocalized = shortNameLocalized;
    }

}
