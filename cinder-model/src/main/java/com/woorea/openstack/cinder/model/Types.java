package com.woorea.openstack.cinder.model;

import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;

public class Types {

    @JsonProperty("volume_types")
    private List<Type> volumeTypes;

    public List<Type> getVolumeTypes() {
        return volumeTypes;
    }

    public void setVolumeTypes(List<Type> volumeTypes) {
        this.volumeTypes = volumeTypes;
    }
    
    public class Type {
        
        @JsonProperty("extra_specs")
        private Specs extraSpecs;
        private String id;
        private String name;

        public Specs getExtraSpecs() {
            return extraSpecs;
        }

        public void setExtraSpecs(Specs extraSpecs) {
            this.extraSpecs = extraSpecs;
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
    }
}