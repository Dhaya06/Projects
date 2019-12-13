package com.csi.vidaplus.rcm.masterdata.util.exception;

import com.csi.vidaplus.rcm.masterdata.document.MasterData;

import java.util.List;

/**
 * Class to handle Data Not Found Exception
 *
 * @version 1.0 12 Jan 2018
 * @author Firstname Lastname
 */
public class DataNotFoundException extends RuntimeException {
    private List<MasterData> masterDataList;
    private MasterData masterData;
    private String type;

    public DataNotFoundException(List<MasterData> masterDataList,String type) {
        super("Data Not Found for the type: " + type);
        this.masterDataList = masterDataList;
        this.type=type;
    }

    public DataNotFoundException(MasterData masterData,String type) {
        super("Data Not Found for the type: " + type);
        this.masterData = masterData;
        this.type=type;
    }
}