package codechallenge.domain;

public enum Constants {
	
	PRICE_MIN(1),
	PRICE_MAX(20),
	SHIPPINGCOST_MIN(2),
	SHIPPINGCOST_MAX(5),
	RATING_MIN(1),
	RATING_MAX(5),
	BASKET_TOTALCOST_LIMIT(50);
	
	private final int value;
    
	Constants(int v) {
        value = v;
    }
	
    public int getValue() {
		return value;
	}

	public static Constants fromValue(int v) {
    	
        for (Constants constant: Constants.values()) {
            if (constant.getValue() == v ) {
                return constant;
            }
        }
        return null;
    }

    @Override
    public String toString(){
        return String.format("%s[%d]", name(), getValue());
    }
}