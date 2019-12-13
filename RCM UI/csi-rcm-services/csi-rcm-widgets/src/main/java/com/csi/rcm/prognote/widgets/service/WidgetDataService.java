package com.csi.rcm.prognote.widgets.service;

import com.csi.rcm.prognote.widgets.document.EncounterSummaryWidjet;
import com.csi.rcm.prognote.widgets.document.WidgetData;
import com.csi.rcm.prognote.widgets.util.FilterCriteria;

import java.util.List;

public interface WidgetDataService {
    void add(EncounterSummaryWidjet masterData);

    void edit(WidgetData masterData);

    void delete(String id,Class className);

    List<WidgetData> getAll(Class className);

    WidgetData getById(String id,Class className);

    List<WidgetData> getAllByField(Class className, String fieldName, String value);

    List<WidgetData> getAllByRegex(Class className, String fieldName, String value);

    List<WidgetData> searchByCriteria(Class  className, String fieldName, String fieldValue, FilterCriteria filterCriteria);

}
