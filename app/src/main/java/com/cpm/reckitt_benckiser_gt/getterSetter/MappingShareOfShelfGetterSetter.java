package com.cpm.reckitt_benckiser_gt.getterSetter;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MappingShareOfShelfGetterSetter {

    @SerializedName("mapping_Share_Of_Shelf")
    @Expose
    private List<MappingShareOfShelf> mappingShareOfShelf = null;

    public List<MappingShareOfShelf> getMappingShareOfShelf() {
        return mappingShareOfShelf;
    }

    public void setMappingShareOfShelf(List<MappingShareOfShelf> mappingShareOfShelf) {
        this.mappingShareOfShelf = mappingShareOfShelf;
    }

}
