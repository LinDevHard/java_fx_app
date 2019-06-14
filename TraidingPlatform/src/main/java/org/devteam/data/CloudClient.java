package org.devteam.data;

import org.devteam.utils.Constants;
import pl.zankowski.iextrading4j.client.IEXCloudClient;
import pl.zankowski.iextrading4j.client.IEXCloudTokenBuilder;
import pl.zankowski.iextrading4j.client.IEXTradingApiVersion;
import pl.zankowski.iextrading4j.client.IEXTradingClient;

public class CloudClient {
    private static volatile IEXCloudClient instance = null;

    public static IEXCloudClient getInstance(){
        IEXCloudClient localInstance = instance;
        if (localInstance == null){
            synchronized (CloudClient.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = IEXTradingClient.create(IEXTradingApiVersion.IEX_CLOUD_V1_SANDBOX,new IEXCloudTokenBuilder()
                            .withPublishableToken(Constants.TP_TOKEN)
                            .withSecretToken(Constants.TS_TOKEN)
                    .build());
                }
            }
        }
        return instance;
    }
}
