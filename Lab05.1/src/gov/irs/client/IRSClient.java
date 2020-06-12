package gov.irs.client;

import com.javatunes.corp.Corporation;
import gov.irs.enumtype.IRS;

public class IRSClient {
    public static void main(String[] args) {
        IRS irs = IRS.getInstance();
        irs.register(new Corporation("Money House"));
        irs.collectTaxes();
    }
}
