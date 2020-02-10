
package com.joel.events;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pagination implements Serializable
{

    @SerializedName("object_count")
    @Expose
    private Integer objectCount;
    @SerializedName("page_number")
    @Expose
    private Integer pageNumber;
    @SerializedName("page_size")
    @Expose
    private Integer pageSize;
    @SerializedName("page_count")
    @Expose
    private Integer pageCount;
    @SerializedName("has_more_items")
    @Expose
    private Boolean hasMoreItems;
    private final static long serialVersionUID = 2204714153920662217L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Pagination() {
    }

    /**
     * 
     * @param objectCount
     * @param pageCount
     * @param hasMoreItems
     * @param pageNumber
     * @param pageSize
     */
    public Pagination(Integer objectCount, Integer pageNumber, Integer pageSize, Integer pageCount, Boolean hasMoreItems) {
        super();
        this.objectCount = objectCount;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.pageCount = pageCount;
        this.hasMoreItems = hasMoreItems;
    }

    public Integer getObjectCount() {
        return objectCount;
    }

    public void setObjectCount(Integer objectCount) {
        this.objectCount = objectCount;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Boolean getHasMoreItems() {
        return hasMoreItems;
    }

    public void setHasMoreItems(Boolean hasMoreItems) {
        this.hasMoreItems = hasMoreItems;
    }

}
