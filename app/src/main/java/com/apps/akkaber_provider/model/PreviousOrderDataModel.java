package com.apps.akkaber_provider.model;

import java.io.Serializable;
import java.util.List;

public class PreviousOrderDataModel extends StatusResponse implements Serializable {
    private List<PreviousOrderModel> data;

    public List<PreviousOrderModel> getData() {
        return data;
    }
}
