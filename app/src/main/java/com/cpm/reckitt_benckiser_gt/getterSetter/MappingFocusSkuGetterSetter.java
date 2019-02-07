
package com.cpm.reckitt_benckiser_gt.getterSetter;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MappingFocusSkuGetterSetter {

    @SerializedName("Mapping_Focus_Sku")
    @Expose
    private List<MappingFocusSku> mappingFocusSku = null;

    public List<MappingFocusSku> getMappingFocusSku() {
        return mappingFocusSku;
    }

    public void setMappingFocusSku(List<MappingFocusSku> mappingFocusSku) {
        this.mappingFocusSku = mappingFocusSku;
    }

}
