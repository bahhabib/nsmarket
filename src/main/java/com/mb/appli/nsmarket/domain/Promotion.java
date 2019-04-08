package com.mb.appli.nsmarket.domain;

import java.math.BigDecimal;

public interface Promotion {
		BigDecimal apply(BigDecimal priceUnit,Long qty);
}
