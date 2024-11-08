package com.pluralsight.model.size;

import java.math.BigDecimal;
import java.util.HashMap;

public interface ISizeable {
    BigDecimal getPrice(Size size);

    void setSize(Size newSize);
}
