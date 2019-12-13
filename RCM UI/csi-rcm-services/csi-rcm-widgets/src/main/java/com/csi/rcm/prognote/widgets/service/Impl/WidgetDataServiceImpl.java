package com.csi.rcm.prognote.widgets.service.Impl;

import com.csi.rcm.prognote.widgets.document.EncounterSummaryWidjet;
import com.csi.rcm.prognote.widgets.document.WidgetData;
import com.csi.rcm.prognote.widgets.service.WidgetDataService;
import com.csi.rcm.prognote.widgets.util.FilterCriteria;

import java.util.List;

public class WidgetDataServiceImpl implements WidgetDataService{
    @Override
    public void add(EncounterSummaryWidjet masterData) {

    }

    @Override
    public void edit(WidgetData masterData) {

    }

    @Override
    public void delete(String id, Class className) {

    }

    @Override
    public List<WidgetData> getAll(Class className) {
        return null;
    }

    @Override
    public WidgetData getById(String id, Class className) {
        return null;
    }

    @Override
    public List<WidgetData> getAllByField(Class className, String fieldName, String value) {
        return null;
    }

    @Override
    public List<WidgetData> getAllByRegex(Class className, String fieldName, String value) {
        return null;
    }

    @Override
    public List<WidgetData> searchByCriteria(Class className, String fieldName, String fieldValue, FilterCriteria filterCriteria) {
        return null;
    }
}
