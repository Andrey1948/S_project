package org.ferggx.SpringProject.dto.mapping;

public interface Mapper <F, T> {
    T map(F object);

    default T map(F fromObject, T toObject) {
        return toObject;
    }
}
