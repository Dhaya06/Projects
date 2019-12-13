package com.csi.rcm.prognote.widgets.util;

/**
 * Enums for the filter criteria
 *
 * <ul>
 * <li>Filter Criteria None = 0</li>
 * <li>Filter Criteria REGEX = 1</li>
 * <li>Filter Criteria Equal = 2</li>
 * <li>Filter Criteria GreaterThan = 3</li>
 * <li>Filter Criteria LessThan = 4</li>
 * <li>Filter Criteria GreaterThanOrEqual = 5</li>
 * <li>Filter Criteria LessThanOrEqual = 6</li>
 * <li>Filter Criteria NotEqual = 7</li>
 * <li>Sort by = 8</li>
 * </ul>
 *
 * @version 1.0 12 Jan 2018
 * @author Firstname Lastname
 */
public enum FilterCriteria {
    NONE(0), REGEX(1), EQUAL(2), GREATERTHAN(3), LESSTHAN(4),
    GREATERTHANOREQUAL(5), LESSTHANOREQUAL(6), NOTEQUAL(7), SORTBY(8);

    private int code;

    /**
     * Sets the filter criteria code
     *
     * @param code
     */
    private FilterCriteria(int code) {
        this.code = code;
    }

    /**
     * Returns the filter criteria enum for the given code
     *
     * @param code
     * @return FilterCriteria
     */
    public FilterCriteria getEnum(int code) {
        FilterCriteria[] values = FilterCriteria.values();
        if (code <= 0 || code >= values.length) {
            return NONE;
        } else {
            return values[code];
        }
    }

    /**
     * Returns the filter criteria code
     *
     * @return code
     */
    public int getCode() {
        return code;
    }
}
